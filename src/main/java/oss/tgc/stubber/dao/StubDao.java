package oss.tgc.stubber.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import oss.tgc.stubber.model.StubInstance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rajeevguru on 10/07/15.
 */
@Component
public class StubDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public StubInstance createStub(StubInstance stub) {


        KeyHolder holder = new GeneratedKeyHolder();



        int row = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(JdbcQueries.addStub,
                    new String[] {"ID"});
            ps.setString(1,stub.getName());
            ps.setString(2,stub.getDescription());
            ps.setString(3,stub.getUrlPath());
            ps.setString(4,stub.getHttpMethod());
            ps.setString(5,stub.getResponseHeaders());
            ps.setString(6,stub.getResponse());
            return ps;
        },holder);





        if (row > 0) {
            stub.setId(holder.getKey().longValue());
        }


        return stub;


    }


    public List<StubInstance> search(String httpMethod, String urlPath) {



            List<StubInstance> results =     jdbcTemplate.query(JdbcQueries.searcStub, new Object[]{httpMethod, urlPath}, new RowMapper<StubInstance>() {
                @Override
                public StubInstance mapRow(ResultSet resultSet, int i) throws SQLException {
                    StubInstance stubInstance = new StubInstance();
                    stubInstance.setId(resultSet.getLong(1));
                    stubInstance.setName(resultSet.getString(2));
                    stubInstance.setDescription(resultSet.getString(3));
                    stubInstance.setUrlPath(resultSet.getString(4));
                    stubInstance.setHttpMethod(resultSet.getString(5));
                    stubInstance.setResponseHeaders(resultSet.getString(6));
                    stubInstance.setResponse(resultSet.getString(7));
                    return stubInstance;

                }
            });


        return results;

    }

    public int deleteStub(Long id) {
        int rows = jdbcTemplate.update(JdbcQueries.deleteStub, new Object[]{id});
        return rows;

    }

    public List<StubInstance> getAll() {

        List<StubInstance> stubInstanceList = jdbcTemplate.query(JdbcQueries.getStubList, new BeanPropertyRowMapper(StubInstance.class));
        return stubInstanceList;

    }

}
