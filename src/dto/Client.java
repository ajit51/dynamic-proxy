package dto;

import proxy.EmployeeSalaryInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(101);
        itEmployee.setName("Abhilas");
        itEmployee.setSalary(30000);

        EmployeeSalaryInvocationHandler employeeHandler = new EmployeeSalaryInvocationHandler(itEmployee);

        IEmployee employee = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[]{IEmployee.class}, employeeHandler);

        employee.giveHike(6000);

        System.out.println(employee.getSalary());

    }
}
