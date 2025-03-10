package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInterviewProgram3 {

    public List<Employee> getEmployeeList(){

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }

    public static void main(String[] args) {

        StreamInterviewProgram3 streamInterviewProgram3 = new StreamInterviewProgram3();
        List<Employee> employeeList = streamInterviewProgram3.getEmployeeList();
        streamInterviewProgram3.countMaleAndFemale(employeeList);
        streamInterviewProgram3.printTheNames(employeeList);
        streamInterviewProgram3.averageAge(employeeList);
        streamInterviewProgram3.namesOfEmployeeWhoJoined(employeeList);
        streamInterviewProgram3.numberOfEmployeeOfEachDepartment(employeeList);

        streamInterviewProgram3.averageSalaryOfEachDept(employeeList);
        streamInterviewProgram3.oldestEmployee(employeeList);
        streamInterviewProgram3.totalSalary(employeeList);
        streamInterviewProgram3.listDownEmployee(employeeList);
        streamInterviewProgram3.findHighestExperienced(employeeList);
    }

    /**
     * Find out the count of male and female employees present in the organization?
     * */

    private void countMaleAndFemale(List<Employee> employeeList){

        Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println("FIND OUT THE COUNT OF MALE AND FEMALE EMPLOYEES PRESENT IN THE ORGANIZATION");
        System.out.println(map);
    }

    /**
     * Write a program to print the names of all departments in the organization.
     * */

    private void printTheNames(List<Employee> employeeList){

        List<String> stringList = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("PRINT THE NAMES OF ALL DEPARTMENTS IN THE ORGANIZATION");
        System.out.println(stringList);
    }

    /**
     * Find the average age of Male and Female Employees.
     * @stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)))
     * @Important
     * */

    private void averageAge(List<Employee> employeeList){

        Map<String,Double> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.println("FIND THE AVERAGE AGE OF MALE AND FEMALE EMPLOYEES");
        System.out.println(map);
    }

    /**
     * Get the Names of employees who joined after 2015.
     * */

    private void namesOfEmployeeWhoJoined(List<Employee> employeeList){

        List<String> stringList = employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println("GET THE NAMES OF EMPLOYEES WHO JOINED AFTER 2015");
        System.out.println(stringList);
    }

    /**
     * Count the number of employees in each department.
     * */

    private void numberOfEmployeeOfEachDepartment(List<Employee> employeeList){

        Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println("COUNT THE NUMBER OF EMPLOYEES IN EACH DEPARTMENT");
        System.out.println(map);
    }

    /**
     * Find out the average salary of each department.
     * */

    private void averageSalaryOfEachDept(List<Employee> employeeList){

        Map<String,Double> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("FIND OUT THE AVERAGE SALARY OF EACH DEPARTMENT");
        System.out.println(map);
    }

    /**
     * Find out the oldest employee, his/her age and department?
     * */

    private void oldestEmployee(List<Employee> employeeList){

        Employee v = employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println("FIND OUT THE OLDEST EMPLOYEE, HIS/HER AGE AND DEPARTMENT");
        System.out.println(v);
    }

    /**
     * Find out the average and total salary of the organization.
     * */

    private void totalSalary(List<Employee> employeeList){

        DoubleSummaryStatistics d = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("FIND OUT THE AVERAGE AND TOTAL SALARY OF THE ORGANIZATION.");
        System.out.println("AVERAGE: "+d.getAverage()+" TOTAL: "+d.getSum());
    }

    /**
     * List down the employees of each department.
     * */

    private void listDownEmployee(List<Employee> employeeList){

        Map<String,List<Employee>> listMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("LIST DOWN THE EMPLOYEES OF EACH DEPARTMENT");
        System.out.println(listMap);
    }

    /**
     * Find out the highest experienced employees in the organization
     * */

    private void findHighestExperienced(List<Employee> employeeList){

        Employee employee = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get();
        System.out.println("FIND OUT THE HIGHEST EXPERIENCED EMPLOYEES IN THE ORGANIZATION");
        System.out.println(employee);
    }
}

class Employee {

        private int id;
        private String name;
        private int age;
        private String gender;
        private String department;
        private int yearOfJoining;
        private double salary;

        public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public String getGender() {
            return gender;
        }
        public String getDepartment() {
            return department;
        }
        public int getYearOfJoining() {
            return yearOfJoining;
        }
        public double getSalary() {
            return salary;
        }
        @Override
        public String toString() {
            return "Id : "+id
                    +", Name : "+name
                    +", age : "+age
                    +", Gender : "+gender
                    +", Department : "+department
                    +", Year Of Joining : "+yearOfJoining
                    +", Salary : "+salary;
        }
}
