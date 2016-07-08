package com.integraltech.endpoint;

import com.integraltech.model.Employee;
import com.integraltech.model.Position;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jqueen on 2/06/2016.
 */
@Path("/")
@Api(value="Get Employee API", description = "Provides endpoints to get employee details")
public class RestEndpoint {

    @GET
    @Path("employee/")
    @ApiOperation(value = "Get all employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No employees found"),
            @ApiResponse(code = 500, message = "Internal error") })
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getAllEmployees(){return null;}

    @GET
    @Path("employee/{employeeId}")
    @ApiOperation(value = "Get employee details", notes = "The first and last names are optional parameters", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Invalid Employee ID supplied"),
            @ApiResponse(code = 500, message = "Internal error") })
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@ApiParam(value = "The ID of the employee", required = true)
                                    @PathParam("employeeId") String employeeId)
    {return null;}

    @GET
    @Path("position/")
    @ApiOperation(value = "Get all positions", response = Position.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No positions found"),
            @ApiResponse(code = 500, message = "Internal error") })
    @Produces(MediaType.APPLICATION_JSON)
    public Position getAllPositions(){return null;}

    @GET
    @Path("position/{positionId}")
    @ApiOperation(value = "Get employee details", notes = "The first and last names are optional parameters", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Invalid Employee ID supplied"),
            @ApiResponse(code = 500, message = "Internal error") })
    @Produces(MediaType.APPLICATION_JSON)
    public Position getPosition(@ApiParam(value = "The ID of the position", required = true)
                                    @PathParam("positionId") String positionId)
    {return null;}


}