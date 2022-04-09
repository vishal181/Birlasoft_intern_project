package helpdesk.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import helpdesk.AppConfig;
import helpdesk.dao.TicketDao;
import helpdesk.model.Ticket;

@Component("ticketservice")
public class TicketService {
	private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	private static TicketDao ticketDao = context.getBean("ticketDao", TicketDao.class);
	
	public int createTicket(int id, String category, String title, String descr){
		int b = ticketDao.createTicket(id, category, title, descr);
		
		return b;
	}
    
    public List<Ticket> openTickets( String category){
    	List<Ticket> openTickets = ticketDao.openTickets(category);
    	
    	return openTickets;
	}
    
    public List<Ticket> openTickets(int id){
    	List<Ticket> openTickets = ticketDao.openTickets(id);
    	
    	return openTickets;
	}
    
    public List<Ticket> closedTickets(int id){
    	List<Ticket> closedTickets = ticketDao.closedTickets(id);
    	
    	return closedTickets;
	}
    
    public Ticket viewTicket(int id){
    	Ticket viewTicket = ticketDao.viewTicket(id);
    	
    	return viewTicket;
	}
    
    public List<Ticket> allTickets(int id){
    	List<Ticket> allTickets = ticketDao.allTickets(id);
    	
    	return allTickets;
    }
	
    public List<Ticket> showAllTickets(){
    	List<Ticket> showAllTickets = ticketDao.showAllTickets();
    	
    	return showAllTickets;
    }
    
    public List<Ticket> byCategory(String category){
    	List<Ticket> byCategory = ticketDao.byCategory(category);
    	
    	return byCategory;
    }
    
    public List<Ticket> closedTickets(int id, String category){
    	List<Ticket> closedTickets = ticketDao.closedTickets(id, category);
    	
    	return closedTickets;
    }
    
    public void setFeedback(int id,String feedback) {
    	ticketDao.setFeedback(id, feedback);
    }
    
    public void setSolution(int id,String solution) {
    	ticketDao.setSolution(id, solution);
    }
    
    public void closeStatus(int id) {
    	ticketDao.closeStatus(id);
    }

}
