package helpdesk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import helpdesk.model.Ticket;


@Component("ticketDao")
public class TicketDaoImpl implements TicketDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	/**ticket creation by user with category selection, title and description
     * @return - true if ticket created successfully
     * @param - id of the user
     * @param - selected category
     * @param - user input for title
     * @param - user input for description
     * 
     */
	
	public int createTicket(int id, String category, String title, String descr) {
		
		String query = "insert into tickets (userid, category, title, descr) values (?,?,?,?)";
		
		int r = this.jdbcTemplate.update(query, id, category, title, descr);
		
		return r;
	}
	
	/**get all open tickets with status = open, with specific category and ticket id
     * @param - category
     */
	
	public List<Ticket> openTickets(String category) {
		
		String query = "SELECT t.ticketid, t.userid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status='open' and t.category = ?";
		
		List<Ticket> openTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setUserid(rs.getString(2));
				ticket.setTitle(rs.getString(3));
				ticket.setDescr(rs.getString(4));
				ticket.setFeedback(rs.getString(5));
				ticket.setSolution(rs.getString(6));
				ticket.setStatus(rs.getString(7));
		
				
				return ticket;
			}
		}, category);
		
		return openTickets;
	}
	
	/**get all open tickets with status = open, of a user with user id 
     * @param - user id
     */

	public List<Ticket> openTickets(int id) {
		
		String query = "SELECT t.ticketid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status='open' and t.userid = ?";
		
		List<Ticket> openTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setTitle(rs.getString(2));
				ticket.setDescr(rs.getString(3));
				ticket.setFeedback(rs.getString(4));
				ticket.setSolution(rs.getString(5));
				ticket.setStatus(rs.getString(6));
		
				
				return ticket;
			}
		}, id);
		
		return openTickets;
	}
	
	/**get all closed tickets with status = closed, os a user with user id 
     * @param - user id
     */
	
	public List<Ticket> closedTickets(int id) {
		
		String query = "SELECT t.ticketid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status='closed' and t.userid = ?";
		
		List<Ticket> closeTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setTitle(rs.getString(2));
				ticket.setDescr(rs.getString(3));
				ticket.setFeedback(rs.getString(4));
				ticket.setSolution(rs.getString(5));
				ticket.setStatus(rs.getString(6));
		
				
				return ticket;
			}
		}, id);
		
		return closeTickets;
	}
	
	/**get a ticket with ticket id 
     * @param - ticket id
     */
	
	public Ticket viewTicket(int id) {
		
		String query = "SELECT t.ticketid, t.userid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.ticketid = ?";
		
		Ticket viewTicket = this.jdbcTemplate.queryForObject(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setUserid(rs.getString(2));
				ticket.setTitle(rs.getString(3));
				ticket.setDescr(rs.getString(4));
				ticket.setFeedback(rs.getString(5));
				ticket.setSolution(rs.getString(6));
				ticket.setStatus(rs.getString(7));
		
				
				return ticket;
			}
		}, id);
		
		return viewTicket;
	}
	
	
	/**get all the open tickets of a user with user id 
     * @param - user id
     */
	public List<Ticket> allTickets(int id) {
		//SELECT tickets.ticketid, tickets.title, tickets.descr,ticketstatus.status FROM tickets RIGHT JOIN ticketstatus ON tickets.ticketid= ticketstatus.ticketid Where userid =" + id + " and status='Open'
		String query = "SELECT t.ticketid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status='open' and t.userid = ?";
		
		List<Ticket> allTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setTitle(rs.getString(2));
				ticket.setDescr(rs.getString(3));
				ticket.setFeedback(rs.getString(4));
				ticket.setSolution(rs.getString(5));
				ticket.setStatus(rs.getString(6));
				
				
		
				
				return ticket;
			}
		}, id);
		
		return allTickets;
		
	}
	
	//show all tickets of all users 
	public List<Ticket> showAllTickets() {
		String query = "SELECT t.ticketid, t.userid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status = 'closed'";
		
		List<Ticket> showAllTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setUserid(rs.getString(2));
				ticket.setTitle(rs.getString(3));
				ticket.setDescr(rs.getString(4));
				ticket.setFeedback(rs.getString(5));
				ticket.setSolution(rs.getString(6));
				ticket.setStatus(rs.getString(7));
		
				
				return ticket;
			}
		});
		return showAllTickets;
	}
	
	
	/**get all tickets of a specific category 
     * @param - selected category
     */
	public List<Ticket> byCategory(String category) {
		//SELECT tickets.ticketid,tickets.userid,tickets.category, tickets.title, tickets.descr,ticketstatus.status FROM tickets RIGHT JOIN ticketstatus ON tickets.ticketid= ticketstatus.ticketid Where category ='" + category + "' and status='Open'
		
		String query = "SELECT t.ticketid, t.userid, t.title , t.descr, f.feedback, s.solution, t.category, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and status = 'open' and category=?";
		
		List<Ticket> byCategory = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setUserid(rs.getString(2));
				ticket.setTitle(rs.getString(3));
				ticket.setDescr(rs.getString(4));
				ticket.setFeedback(rs.getString(5));
				ticket.setSolution(rs.getString(6));
				ticket.setCategory(rs.getString(7));
				ticket.setStatus(rs.getString(8));
		
				
				return ticket;
			}
		}, category);
		
		return byCategory;
	}
	
	
	// closed tickets with respect to category of the ticket
	public List<Ticket> closedTickets(int id, String category) {
		String query = "SELECT t.ticketid, t.title , t.descr, f.feedback, s.solution, ts.status from tickets t, ticketfeedback f, ticketsolution s, ticketstatus ts where t.ticketid = f.ticketid and t.ticketid = s.ticketid and t.ticketid = ts.ticketid and ts.status='closed' and t.category=?";
		
		List<Ticket> closeTickets = this.jdbcTemplate.query(query,new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ticket ticket = new Ticket();
				
				ticket.setTicketid(rs.getInt(1));
				ticket.setTitle(rs.getString(2));
				ticket.setDescr(rs.getString(3));
				ticket.setFeedback(rs.getString(4));
				ticket.setSolution(rs.getString(5));
				ticket.setStatus(rs.getString(6));
		
				
				return ticket;
			}
		}, id, category);
		
		return closeTickets;
	}
	
	
	/**set the feedback of a ticket with ticket id by the user 
     * @param - ticket id, 
     * @param - user feedback
     */
	public void setFeedback(int id, String feedback) {
		String query = "update ticketfeedback set feedback = ? where ticketid = ?";
		
		this.jdbcTemplate.update(query, feedback, id);
		
	}
	
	 /**set the solution of a ticket with ticket id by the IT support 
     * @param - ticket id, 
     * @param - user solution
     */
	public void setSolution(int id, String solution) {
		String query = "update ticketsolution set solution = ? where ticketid = ?";
		
		this.jdbcTemplate.update(query, solution, id);
		
	}
	
	/**set the status of the ticket to closed 
     * @param - ticket id
     */
	public void closeStatus(int id) {
		String query = "update ticketstatus set status = 'closed' where ticketid = ? ";
		
		this.jdbcTemplate.update(query, id);
	}


}
