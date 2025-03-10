package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInterviewProgram4 {

    static List<Employee1> employees = Arrays.asList(
            new Employee1(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
            new Employee1(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
            new Employee1(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
            new Employee1(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
            new Employee1(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
            new Employee1(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
            new Employee1(7, "Harry", 30, "Research", "Kochi", 21000, "Male"),
            new Employee1(8, "ankit", 31, "Research", "West Bengal", 25000, "Male")
    );

    public static void main(String[] args) {

        /**
        * @IMPORTANT
        * Find list of employees whose name starts with alphabet A
        * */

        List<Employee1> startWithAlphabetA = employees.stream().filter(employees -> employees.getName().toUpperCase(Locale.ROOT).startsWith("A")).collect(Collectors.toList());
        System.out.println("FIND LIST OF EMPLOYEES WHOSE NAME STARTS WITH ALPHABET A: "+startWithAlphabetA);

        /**
         * @Important
         * Group The employees By Department Names
         * */

        Map<String, List<Employee1>> groupByDept = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartNames));
        System.out.println("GROUP THE EMPLOYEES BY DEPARTMENT NAMES: "+groupByDept);

        /**
         * @Important
         * Find the total count of employees using stream
         * */

        Long count = employees.stream().count();
        System.out.println("FIND THE TOTAL COUNT OF EMPLOYEES USING STREAM: "+count);

        /**
         * @Important
         * Find the max age of employees
         * */

        Employee1 maxAge = employees.stream().max(Comparator.comparing(Employee1::getAge)).get();
        System.out.println("FIND THE MAX AGE OF EMPLOYEES: "+maxAge);

        int maxAGe = employees.stream().mapToInt(Employee1::getAge).max().getAsInt();
        System.out.println("FIND THE MAX AGE OF EMPLOYEES 1:"+maxAGe);

        /**
         * @Important
         * Find all department names
         * */

        List<String> departmentNames = employees.stream().map(Employee1::getDepartNames).collect(Collectors.toList());
        System.out.println("FIND ALL DEPARTMENT NAMES: "+departmentNames);

        /**
         * @Important
         * Find the count of employee in each department
         * */

        Map<String,Long> employeeCount = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartNames,Collectors.counting()));
        System.out.println("FIND THE COUNT OF EMPLOYEE IN EACH DEPARTMENT: "+employeeCount);

        /**
         * @Important
         * Find the list of employees whose age is less than 30
         * */

        List<Employee1> employee1List = employees.stream().filter(employees -> employees.getAge() < 30).collect(Collectors.toList());
        System.out.println("FIND THE LIST OF EMPLOYEES WHOSE AGE IS LESS THAN 30: "+employee1List);

        /**
         * @important
         * Find the employee who has second-lowest salary
         * */

        Employee1 secondLowest = employees.stream().sorted(Comparator.comparing(Employee1::getSalary)).skip(1).findFirst().get();
        System.out.println("FIND THE EMPLOYEE WHO HAS SECOND-LOWEST SALARY: "+secondLowest);


        /**
         * @important
         * Find the employee who has second-highest salary
         * */

        Employee1 secondHighest = employees.stream().sorted((a,b) -> (int) (b.getSalary() - a.getSalary())).skip(1).findFirst().get();
        System.out.println("FIND THE EMPLOYEE WHO HAS SECOND-HIGHEST SALARY: "+secondHighest);

        /**
         * @Important
         * Find the list of employee and sort them by their salary
         * */

        List<Employee1> employeeSal = employees.stream().sorted(Comparator.comparing(Employee1::getSalary)).collect(Collectors.toList());
        System.out.println("FIND THE LIST OF EMPLOYEE AND SORT THEM BY THEIR SALARY: "+employeeSal);

        /**
         * @Important
         * Find the highest salary in each department
         * */

        Map<String, Optional<Employee1>> highestSalaryEachDept = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartNames,Collectors.maxBy(Comparator.comparing(Employee1::getSalary))));
        System.out.println("FIND THE HIGHEST SALARY IN EACH DEPARTMENT: "+highestSalaryEachDept);

        /**
         * @Important
         * Find the average salary in all departments
         * */

        Map<String,Double> averageSal = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartNames,Collectors.averagingDouble(Employee1::getSalary)));
        System.out.println("FIND THE AVERAGE SALARY IN ALL DEPARTMENTS: "+averageSal);

        /**
         * @Important
         * Find the Employee who stays in Delhi and sort them by their names
         * */

        List<Employee1> employee1List1 = employees.stream()
                .filter(emp -> emp.getAddress().equalsIgnoreCase("Bangalore"))
                .sorted(Comparator.comparing(Employee1::getName))
                .collect(Collectors.toList());

        System.out.println("FIND THE EMPLOYEE WHO STAYS IN DELHI AND SORT THEM BY THEIR NAMES: "+employee1List1);

        /**
         * @Important
         * Find the average age of male and female employee
         * */

        Map<String,Double> averageAge = employees.stream().collect(Collectors.groupingBy(Employee1::getGender,Collectors.averagingDouble(Employee1::getAge)));
        System.out.println("FIND THE AVERAGE AGE OF MALE AND FEMALE EMPLOYEE: "+averageAge);

        /**
         * @Important
         * Find the department who is having maximum number of employee
         * */

        Map<String, Long> maximumNumber = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartNames,Collectors.counting()));
        System.out.println("FIND THE DEPARTMENT WHO IS HAVING MAXIMUM NUMBER OF EMPLOYEE: "+maximumNumber);
    }
}
class Employee1 {

    private int id;
    private String name;
    private int age;
    private String departNames;
    private String address;
    private double salary;

    private String gender;

    public Employee1(int id, String name, int age, String departNames, String address, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.departNames = departNames;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartNames() {
        return departNames;
    }

    public void setDepartNames(String departNames) {
        this.departNames = departNames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", departNames='" + departNames + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
