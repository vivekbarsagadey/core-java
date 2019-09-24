package com.bnb.gj.general.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by vivek_000 on 29/04/2014.
 */
public class EmployeePredicateTest {

    public static <T> int sum(List<T> list, Function<T, Integer> mapper){
       int sum = 0;
        for (T t : list){
            sum = sum + mapper.apply(t);
        }
        return sum;
    }



    public static <T> T find(List<T> list, Predicate<T> matchFunction) {
        T temp = null;
        for (T t : list) {
            if (matchFunction.test(t)) {
                temp = t;
            }
        }
        return temp;
    }

    /*public static Employee find(List<Employee> employees, Predicate<Employee> matchFunction) {
        Employee mEmployee = null;
        for (Employee employee : employees) {
            if (matchFunction.test(employee)) {
                mEmployee = employee;
            }
        }
        return mEmployee;
    }*/

    public static void main(String[] args) {
        Predicate<Employee> employeePredicate = emp -> emp.getAge() > 30;

        List<Employee> employees = Arrays.asList(new Employee("Sonu", 110000, 33), new Employee("Monu", 90000, 30), new Employee("Pintu", 50000, 27));
        Employee employee = find(employees, emp -> emp.getAge() > 30);
        System.out.println("Emp is " + employee);
        employee = find(employees, emp -> emp.getName().toLowerCase().contains("s"));
        System.out.println("Emp is " + employee);
        employee = find(employees, emp -> emp.getSalary() > 100000);
        System.out.println("Emp is " + employee);


        Function<Employee, Integer> mapper = emp -> emp.getAge();
        System.out.println("Emp is " + sum(employees,mapper));

    }
}
