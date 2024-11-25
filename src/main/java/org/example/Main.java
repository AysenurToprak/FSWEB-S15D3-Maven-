package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer,Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;


    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();


        employees.add(new Employee(1, "aaa", "bb"));
        employees.add(new Employee(1, "aaa", "bb"));
        employees.add(new Employee(2, "cc", "ss"));
        employees.add(new Employee(2, "cc", "ss"));
        employees.add(new Employee(3, "aysenur", "toprak"));
        employees.add(new Employee(3, "aysenur", "toprak"));
        employees.add(new Employee(4, "kedim", "toprak"));

        List<Employee> list = Main.removeDuplicates(employees);
        System.out.println(list);
        Map<Integer, Employee> map = Main.findUniques(employees);
        System.out.println(map);
        List<Employee> list1= Main.findDuplicates(employees);
        System.out.println(list1);


    }

    public static List<Employee> findDuplicates (List<Employee> employees) {

        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }
            else{
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicatedEmployees;

    }

    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null");
                continue;
            }
            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);
            }

        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> dublicates = findDuplicates(employees);
        Map<Integer,Employee> uniques = findUniques(employees);

        List <Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(dublicates);
        return onlyUnique;
    }
}