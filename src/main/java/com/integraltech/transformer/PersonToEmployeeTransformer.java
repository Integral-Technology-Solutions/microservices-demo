package com.integraltech.transformer;

import com.integraltech.model.Employee;
import com.integraltech.model.Person;
import org.springframework.stereotype.Component;

/**
 * Created by jqueen on 3/06/2016.
 */
@Component
public class PersonToEmployeeTransformer {

    public Employee transform(Person person){
        Employee employee = new Employee();
        employee.setEmployeeId(person.getID());
        employee.setFirstName(person.getFIRST_NAME());
        employee.setLastName(person.getLAST_NAME());

        return employee;
    }
}
