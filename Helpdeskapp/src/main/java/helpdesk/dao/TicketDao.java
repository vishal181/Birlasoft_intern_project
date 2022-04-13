package helpdesk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import helpdesk.model.Ticket;

@Component
public interface TicketDao {
	//create tickets by user with user id by category and title, description and return true if successfully created
    public int createTicket(int id, String category, String title, String descr);
    
    //get all open tickets with status = open, with specific category and ticket id
    public List<Ticket> openTickets( String category);
    
    //get all open tickets with status = open, of a user with user id
    public List<Ticket> openTickets(int id);
    
    //get all closed tickets with status = closed, os a user with user id
    public List<Ticket> closedTickets(int id);
    
    //get a ticket with ticket id
    public Ticket viewTicket(int id);
    
    //get all the open tickets of a user with user id
    public List<Ticket> allTickets(int id);
    
    //get all the tickets created by users
    public List<Ticket> showAllTickets();
   
    //get all tickets of a specific category
    public List<Ticket> byCategory(String category);
    
    //get all the closed tickets in a specific category by a user with user id
    public List<Ticket> closedTickets(int id, String category);
    
    //set the feedback of a ticket with ticket id by the IT support
    public void setFeedback(int id,String feedback);
    
    //set the solution of a ticket with ticket id by the user
    public void setSolution(int id,String solution);
    
    //set the status of the ticket to closed
    public void closeStatus(int id);

    
}
