package com.integraltech.service;

import com.integraltech.model.Position;
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
public class PositionService {

    private JdbcTemplate jdbcTemplate;

    static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Position> getAllPositions(){
        String sqlStatement = "SELECT  * \n" +
                "FROM company.position";

        try {
            List<Position> positions = jdbcTemplate.query(sqlStatement, new BeanPropertyRowMapper(Position.class));
            return positions;
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

    public Position getPositionById(String id) throws WebApplicationException {
        String sqlStatement = "SELECT  * \n" +
                "FROM company.position \n" +
                "WHERE id = ?";

        try {
            Position position =
                    (Position) jdbcTemplate.queryForObject(sqlStatement, new BeanPropertyRowMapper(Position.class), id);
            return position;
        } catch (IncorrectResultSizeDataAccessException e) {
            LOG.info("NotFoundException for positionId: " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            LOG.info("BadRequestException for positionId: " + id);
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } catch (DataAccessException e) {
            e.printStackTrace();
            LOG.info("InternalServerErrorException for positionId: " + id);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}