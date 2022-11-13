package proxy;

import dto.IEmployee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employeeTarget) {
        this.employeeTarget = employeeTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //pre processing
        if (method.getName().equals("giveHike")){
            double hikeValue = (double) args[0];
            if (hikeValue <= 0.0){
                throw new RuntimeException("hike amount is not valid");
            }
        }

        //making actual call to my service layer
        Object returnValue = method.invoke(employeeTarget, args);

        //post processing
        System.out.println("executing method : "+ method.getName()+ " for employee id: "+employeeTarget.getId());

        return returnValue;
    }
}
