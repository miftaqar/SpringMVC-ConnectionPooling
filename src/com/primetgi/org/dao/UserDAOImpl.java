package com.primetgi.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.primetgi.org.model.Users;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;

	public UserDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Users> list() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM tblPerson";

		List<Users> listUser = jdbcTemplate.query(sql, new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Users users = new Users();
				users.setId(rs.getInt("ID"));
				users.setName(rs.getString("Name"));
				users.setEmailId(rs.getString("EmailId"));
				return users;
			}

		});
		return listUser;
	}

}
