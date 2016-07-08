package com.integraltech.enricher;

import com.integraltech.model.Employee;
import org.springframework.stereotype.Component;

/**
 * Created by jqueen on 3/06/2016.
 */
@Component
public class EmployeeEnricher {

    public Employee enrich(Employee employee){
        employee.setOrganisation("IntegralTech");

        return employee;
    }
}
