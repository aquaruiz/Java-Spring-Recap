package com.mm.homeworks.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mm.homeworks.model.entity.User;
import com.mm.homeworks.model.entity.UserType;

@Repository
public class UserJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserType(UserType.values()[rs.getInt("user_type")]);

            return user;
        }
    }
	
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }
}
