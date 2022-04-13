package helpdesk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import helpdesk.model.User;


@Component("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	/*get the id of the user when the user logins in with his email and password
     * @returns - true if user id found
     * @param - get email and password from user input
     */

	public boolean ifExists(String email, String password) {
		
		String query = "select id from user where email=? and password=?";
		
		boolean exist;
		try {
			exist = this.jdbcTemplate.queryForObject(query, boolean.class , email, password);
		} catch (DataAccessException e) {
			return false;
		}
		
		return exist;
	}
	
	
	/* get the id of the user after login with respect to the email used 
     * @return - user id
     * @param - email from user input
     */
	public User getId(String email) {
		
		String query = "select id from user where email=?";
		
		//RowMapper<User> rowMapper = new RowMapperImpl();
		
		User user = this.jdbcTemplate.queryForObject(query, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				
				user.setId(rs.getInt(1));
				
				return user;
			}
		}, email);
		
		return user;
	}
	
	/*get the role viz. User, Admin, IT team with respect to the id of the logged in user
     * @return - role of the user
     * @param - id of the user
     */

	public User getRole(int id) {
		
		String query = "select role from user where id=?";
		
		//RowMapper<User> rowMapper = new RowMapperImpl();
		
		User role = this.jdbcTemplate.queryForObject(query,new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				
				user.setRole(rs.getString(1));
				
				return user;
			}
		}, id);
		
		return role;
	}

}
