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
	public static UserService userservice = context.getBean("userservice", UserService.class);
	public static TicketService ticketservice = context.getBean("ticketservice", TicketService.class);

	//Main class
	public static void main(String[] args) {
		Helpdesk hd = context.getBean(Helpdesk.class);
		System.out.println("----------------");
        System.out.println("Helpdesk Portal");
        System.out.println("----------------");
		hd.login();
		
				
	}
	
	
	/**user authentication  using email and password
     * user gets logged in based on the role of the user from getRole
     * there are 3 roles namely user, admin and IT support
     * 
     */
	public void login() {
		
		
    	try {
    	System.out.println("-----------------");
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Exit ");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("Enter your choice: ");
        System.out.println("-----------------");
        int option = sc.nextInt();
        if(option==1)
        {
        System.out.println("");
        System.out.println("Email:");  
        String email= sc.next(); 
        System.out.println("Password:");  
        String password= sc.next();
        boolean idn = userservice.ifExists(email, password);
        
        //re-attempt login is login fails 
        if (!idn) {
        	System.out.println("");
        	System.out.println("----------------");
            System.out.println("Failed to login ");
            System.out.println("----------------");
            login();
        } 
        //role based login if authentication successful
        else {
        	
        	User id1 = userservice.getId(email);
        	
        	User role = userservice.getRole(id1.getId());
        	
        	String role1 = role.getRole();
        	
        	System.out.println("");
        	System.out.println("----------------------------------");
            System.out.println("logged In  Role: "+ role1 +" ID: "+id1.getId());
            System.out.println("----------------------------------");
            if (role1.equals("user")) {
            	userDash(id1.getId());
            }
            else if (role1.equals("IT Support")) {
            	ITDash(id1.getId());
            }
            else {
            	adminDash(id1.getId());
            }
        }
        }
        else if(option==2) {
        	sc.close();
        	System.exit(0);
        }
        else {
        	System.out.println("");
        	System.out.println("Please enter a valid choice");
        	login();
        }
    	}
    	catch(Exception e) {
    	    System.out.println("Please enter a valid input");
    	    login();
    	}
    }
		
	/**user specific user dashboard to create and track tickets
     * user get logged into the system with this user id tagged to the email and password provided
     * category selection , title and description of the ticket
     * providing feedback for tickets and closing open tickets if problem solved
     * and logout of the system
     * 
     */

	
	public void userDash(int id1) {
		
    	try {
    	System.out.println("");
    	System.out.println("********************");
    	System.out.println("  User Dashboard");
    	System.out.println("********************");
    	
        System.out.println("1.Create Ticket ");
        System.out.println("2.View Open Tickets");  
        System.out.println("3.Ticket History");
        System.out.println("4.Logout");
        System.out.println("");
        System.out.println("Please Enter Your Choice");
        int key = sc.nextInt();
        
        switch (key) {
            case 1:
            /**
             * ticket creation and category selection
             * viz. Software ,Hardware, Network
             */
            	
            String category = "";
            System.out.println("");
            System.out.println("Ticket Creation");
            System.out.println("Select Category");
            System.out.println("0.Go Back");
            System.out.println("1.Software");
            System.out.println("2.Hardware");
            System.out.println("3.Network");
            System.out.println("");
            System.out.println("Please Enter Your Choice");
            Scanner se = new Scanner(System.in);
            
            int cat = sc.nextInt();
            if(cat == 0){
                userDash(id1);
            }
            else if(cat == 1){
                category = "Software";
            }
            else if(cat == 2){
                category = "Hardware";
            }
            else if(cat == 3){
                category = "Network";
            }
            
            /*
             * Title and Description of the ticket
             */
                System.out.println("");
                System.out.println("Title:");
                String title = se.nextLine();
                System.out.println("Detials: ");
                String descr = se.nextLine();
                
                int b = ticketservice.createTicket(id1, category, title, descr);
                //ts.createTicket(id1, category, title, descr);
                System.out.println("");
                System.out.println("----------------------------");
                System.out.println("Ticket Created Successfully ");
                System.out.println("----------------------------");
                userDash(id1);
                break;
                
                
            case 2: 
            	
            	/**
            	 * view all open tickets of the user - tickets with status Open
            	 * provide feedback for the solution provided 
            	 * close the ticket if the issue is resolved - updates the ticket status to Closed
            	 */
            	System.out.println("");
            	
            	
            	List<Ticket> openTickets = ticketservice.openTickets(id1);
            	
            	String leftAlignFormat = "| %-8s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
                
                System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
                System.out.format("| TicketId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
                System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        		
        		for(Ticket u:openTickets) {
        			//System.out.println(u);
        			System.out.format(leftAlignFormat, u.getTicketid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus());
                	
                	System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        			
        		}
            	
                System.out.println("");
                System.out.println("**** Press 0 to Exit ****");
                System.out.println("OR Enter Ticket ID To Edit: ");
                int tid = sc.nextInt();
                if(tid==0)
                {
                  userDash(id1);	
                }

                Ticket viewTicket = ticketservice.viewTicket(tid);
                
                System.out.println("1.Feedback");
                System.out.println("2.Close Ticket");
                System.out.println("3.Go Back");
                System.out.println("------------------");
                System.out.println("Enter Your Option: ");
                int et = sc.nextInt();

                switch (et) {
                
                    case 1:
                    	//update ticket feedback for the ticket
                    	System.out.println("");
                        System.out.println("Enter Your Feedback: ");
                        String feedback = sc.next();
                        
                        ticketservice.setFeedback(tid, feedback);
                        
                        break;
                
                    case 2:
                    	//update ticket status to closed
                    	System.out.println("");
                    	System.out.println("----------------------------");
                        System.out.println("Ticket Closed Successfully");
                        System.out.println("----------------------------");
                        
                        ticketservice.closeStatus(tid);
                        
                        break;
                    case 3:
                    	// back to dashboard
                    	userDash(id1);
                }
                userDash(id1);
                break;
            

            case 3:
            	//view ticket history - tickets with status = Closed
            	
            	List<Ticket> closedTickets = ticketservice.closedTickets(id1);
        		
            	String leftAlignFormat1 = "| %-8s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
                
                System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
                System.out.format("| TicketId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
                System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            	
        		for(Ticket u:closedTickets) {
        			//System.out.println(u);
        			
        			System.out.format(leftAlignFormat1, u.getTicketid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus());
                	
                	System.out.format("+----------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        			
        		}
            	
                userDash(id1);
                    break;
            case 4:
            	//user logout
            	System.out.println("-----------------------");
                System.out.println("Logged Out Successfully");
                System.out.println("-----------------------");
            	System.out.println("");
            	login();
            default:
                System.out.println("Enter Valid Option");
                userDash(id1);
            	
        }
    	}
    	catch(Exception e) {
    	    System.out.println("Please Enter A Valid Input");
    	    userDash(id1);
    	}
	
	}
	
	/**
	 * user role and category specific IT support dashboard - userid and category
	 * category of IT supports teams include Software, Hardware and Network.
	 * IT team can view category wise open tickets and provide solution for the tickets
	 * can close the ticket when the user confirms the issue is resolved - updating ticket status to Closed
	 * and logout
	 */
	
	public void ITDash(int id1) {

		
	    try {
    	System.out.println("");
    	System.out.println("********************");
    	System.out.println("   IT Dashboard");
    	System.out.println("********************");
    	System.out.println("");
        System.out.println("1.View Tickets");
        System.out.println("2.Ticket History");
        System.out.println("3.Logout");
        System.out.println("");
        System.out.println("Please Enter Your Choice");
        int k3 = sc.nextInt();
        String category ="";
        
        //IT support category wise login
        if(id1==4)
        {
        	category="Software";
        }
        else if(id1==5) {
        	category="Hardware";
        }
        else if(id1==6){
        	category="Network";
        }

        switch (k3) {
            case 1:   //Open tickets and update tickets with ticket id           	
            	
            	List<Ticket> openTicketsByCategory = ticketservice.openTickets(category);
        		
            	String leftAlignFormat = "| %-8s | %-6s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
                
                System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
                System.out.format("| TicketId | UserId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
                System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            	
        		for(Ticket u:openTicketsByCategory) {
        			//System.out.println(u);
        			
        			System.out.format(leftAlignFormat, u.getTicketid(), u.getUserid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus());
                	
                	System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        			
        		}
        		
                System.out.println("**** Press 0 to Exit ****");
                System.out.println("Or Enter Ticket ID To Edit: ");
                int ticid = sc.nextInt();
                if(ticid==0)
                {
                  ITDash(id1);	
                }
                
                Ticket viewTicket = ticketservice.viewTicket(ticid);
                
                System.out.println("1.Provide Solution: ");
                System.out.println("2.Close Status");
                System.out.println("3.Go Back");

                int k4 = sc.nextInt();
                if (k4 == 1) {
                		//Update Solution for the ticket
                        System.out.println("Solution: ");
                        String solution = sc.next();

                        ticketservice.setSolution(ticid, solution);
                        
                        ITDash(id1);
                }
                else if(k4 == 2){
                		//Set Ticket Status to closed

                	ticketservice.closeStatus(ticid);
                        
                        ITDash(id1);
                }
                else {
                	ITDash(id1);
                }
                break;
        
            case 2:  
            	//Ticket History of the user in specific category
            	
            	List<Ticket> closedTicketsByCategory = ticketservice.closedTickets(id1, category);
        		
            	String leftAlignFormat2 = "| %-8s | %-6s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
                
                System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
                System.out.format("| TicketId | UserId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
                System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            	
        		for(Ticket u:closedTicketsByCategory) {
        			//System.out.println(u);
        			
        			System.out.format(leftAlignFormat2, u.getTicketid(), u.getUserid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus() );
                	
                	System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        			
        		}
            	
                ITDash(id1);
                break;
            case 3:
            	System.out.println("-----------------------");
                System.out.println("Logged Out Successfully");
                System.out.println("-----------------------");
            	System.out.println("");
            	login();
            default:
                System.out.println("Enter Valid Option");
                ITDash(id1);
        }
	    }
	    catch(Exception e) {
    	    System.out.println("Please Enter A Valid Input");
    	    ITDash(id1);
    	}
	}

	
    /**user specific Admin dashboard for management of tickets
     * can view all users open tickets and tickets history
     * with ticket id and user id
     */
	
	public void adminDash(int id1) {
		
    	try {
    	System.out.println("");
    	System.out.println("********************");
    	System.out.println("  Admin Dashboard");
    	System.out.println("********************");
    	System.out.println("1. Show ticket history ");
    	System.out.println("2. Tickets by Category with open status");
    	System.out.println("3. Logout ");
        System.out.println("");
        System.out.println("Please Enter Your Choice");
        int key = sc.nextInt();
        if (key==1) {
        	//show all tickets with status closed
        	List<Ticket> showAllTickets = ticketservice.showAllTickets();
    		
        	String leftAlignFormat = "| %-8s | %-6s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
            
            System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            System.out.format("| TicketId | UserId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
            System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
        	
    		for(Ticket u:showAllTickets) {
    			//System.out.println(u);
    			
    			System.out.format(leftAlignFormat, u.getTicketid(), u.getUserid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus() );
            	
            	System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
    			
    			
    		}
        	
             adminDash(id1);
        }
        else if (key==2) {
        	//view all open tickets by category
            String category = "";
            System.out.println("Select Category");
            System.out.println("0.Go Back");
            System.out.println("1.Software");
            System.out.println("2.Hardware");
            System.out.println("3.Network");
            int k5 = sc.nextInt();
            if(k5==0) {
            	ITDash(id1);
            }else if(k5== 1){
                category = "Software";
            }else if(k5 == 2){
                category = "Hardware";
            }else if(k5 == 3){
                category = "Network";
            }
            
            List<Ticket> byCategory = ticketservice.byCategory(category);
    		
            String leftAlignFormat = "| %-8s | %-6s | %-21s | %-21s | %-20s | %-20s | %-10s |%n";
            
            System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            System.out.format("| TicketId | UserId |         Title         |      Description      |       feedback       |       Solution       |   Status   |%n");
            System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
            
    		for(Ticket u:byCategory) {
    			//System.out.println(u);
    			
    			System.out.format(leftAlignFormat, u.getTicketid(), u.getUserid(), u.getTitle(), u.getDescr(), u.getFeedback(), u.getSolution(), u.getStatus() );
            	
            	System.out.format("+----------+--------+-----------------------+-----------------------+----------------------+----------------------+------------+%n");
    			
    		}
    		
            adminDash(id1);	
       }
        else if (key == 3){
        	
        	login();
        }
        else {
        	System.out.println("enter valid option");
        }
    	}
    	catch(Exception e) {
    	    System.out.println("Please Enter A Valid Input");
    	    adminDash(id1);
    	}
	}
	
		

}
