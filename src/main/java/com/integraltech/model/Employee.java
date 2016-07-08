package com.integraltech.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jqueen on 2/06/2016.
 */
@ApiModel(value="Employee", description="The canonical model for employees")
public class Employee {

    @ApiModelProperty(name="Employee ID", value = "The employees ID", required=true)
    String employeeId;

    @ApiModelProperty(name="First Name", value = "Last name of the employee")
    String firstName;

    @ApiModelProperty(name="Last Name",value = "Last name of the employee")
    String lastName;

    @ApiModelProperty(name="Email Address",value = "The email address of the employee")
    String emailAddress;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
