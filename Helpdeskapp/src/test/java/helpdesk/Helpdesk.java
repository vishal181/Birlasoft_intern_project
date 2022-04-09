package helpdesk;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import helpdesk.model.Ticket;
import helpdesk.model.User;
import helpdesk.service.TicketService;
import helpdesk.service.UserService;


@Component
public class Helpdesk {

	public static Scanner sc = new Scanner(System.in);
	public static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	public static void main(String[] args) {
		Helpdesk hd = context.getBean(Helpdesk.class);
		System.out.println("----------------");
        System.out.println("Helpdesk Portal");
        System.out.println("----------------");
		hd.login();
		
				
	}
	

	public void login() {
		
		UserService userservice = context.getBean("userservice", UserService.class);
		boolean a = userservice.ifExists("admin@hd.com","admin");
		System.out.println("login");
		System.out.println(a);
		
		User id = userservice.getId("admin@hd.com");
		System.out.println(id.getId());
		
		User role = userservice.getRole(id.getId());
		System.out.println(role.getRole());
			
		
	}
	
	public void userDash(int id) {
		System.out.println("userdash");
		
		TicketService ticketservice = context.getBean("ticketservice", TicketService.class);

		
		//int b = ticketservice.createTicket(1, "Network", "Test Sprg", "test descr");
		
		//System.out.println(b);
		
		
		List<Ticket> openTickets = ticketservice.openTickets(1);
		
		for(Ticket u:openTickets) {
			System.out.println(u);
			
		}
		
		List<Ticket> openTicketsByCategory = ticketservice.openTickets("Network");
		
		for(Ticket u:openTicketsByCategory) {
			System.out.println(u);
			
		}
		
		System.out.println("closed tickets");
		
		List<Ticket> closedTickets = ticketservice.closedTickets(3);
		
		for(Ticket u:closedTickets) {
			System.out.println(u);
			
		}
		
		System.out.println();
		
		Ticket viewTicket = ticketservice.viewTicket(32);
		
		System.out.println(viewTicket);
		
		System.out.println("all tickets by id");
		
		List<Ticket> allTickets = ticketservice.allTickets(1);
		
		for(Ticket u:allTickets) {
			System.out.println(u);
			
		}
		
		System.out.println("show All tickets");
		
		List<Ticket> showAllTickets = ticketservice.showAllTickets();
		
		for(Ticket u:showAllTickets) {
			System.out.println(u);
			
		}
		
		System.out.println("by Category");
		
		List<Ticket> byCategory = ticketservice.byCategory("Network");
		
		for(Ticket u:byCategory) {
			System.out.println(u);
			
		}
		
		System.out.println("closed tickets by category");
		
		List<Ticket> closedTicketsByCategory = ticketservice.closedTickets(3, "Network");
		
		for(Ticket u:closedTicketsByCategory) {
			System.out.println(u);
			
		}
		
		//ticketservice.setFeedback(30, "thanks");
		
		//ticketservice.setSolution(30, "soln");
		
		//ticketservice.closeStatus(30);
		
		
		
	}
	
	public void ITDash(int id) {
		
	}
	
	public void adminDash(int id) {
		
	}

}
