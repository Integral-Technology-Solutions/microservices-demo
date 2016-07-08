package com.integraltech.service;

import com.integraltech.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by jqueen on 3/06/2016.
 */
@Component
public class PersonService {

    private JdbcTemplate jdbcTemplate;

    static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Person> getAllPersons(){
        String sqlStatement = "SELECT  * \n" +
                "FROM company.person";

        try {
            List<Person> persons = jdbcTemplate.query(sqlStatement, new BeanPropertyRowMapper(Person.class));
            return persons;
        } catch (IncorrectResultSizeDataAccessException e) {
            LOG.info("NotFoundException");
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            LOG.info("BadRequestException");
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } catch (DataAccessException e) {
            e.printStackTrace();
            LOG.info("InternalServerErrorException");
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Person getPersonById(String id) throws WebApplicationException {
        String sqlStatement = "SELECT  * \n" +
                "FROM company.person \n" +
                "WHERE id = ?";

        try {
            Person person =
                    (Person) jdbcTemplate.queryForObject(sqlStatement, new BeanPropertyRowMapper(Person.class), id);
            return person;
        } catch (IncorrectResultSizeDataAccessException e) {
            LOG.info("NotFoundException for employeeId: " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            LOG.info("BadRequestException for employeeId: " + id);
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } catch (DataAccessException e) {
            e.printStackTrace();
            LOG.info("InternalServerErrorException for employeeId: " + id);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}