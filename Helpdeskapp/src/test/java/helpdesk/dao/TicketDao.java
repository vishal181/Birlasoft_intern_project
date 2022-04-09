package helpdesk.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import helpdesk.model.Ticket;

@Component
public interface TicketDao {
	
    public int createTicket(int id, String category, String title, String descr);
    
    public List<Ticket> openTickets( String category);
    
    public List<Ticket> openTickets(int id);
    
    public List<Ticket> closedTickets(int id);
    
    public Ticket viewTicket(int id);
    
    public List<Ticket> allTickets(int id);
    
    public List<Ticket> showAllTickets();
   
    public List<Ticket> byCategory(String category);
    
    public List<Ticket> closedTickets(int id, String category);
    
    public void setFeedback(int id,String feedback);
    
    public void setSolution(int id,String solution);
    
    public void closeStatus(int id);

    
}
