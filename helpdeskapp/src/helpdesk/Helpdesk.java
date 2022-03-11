package helpdesk;

import java.util.Scanner;

import helpdesk.serv.TicketS;
import helpdesk.serv.UserS;

/**
 * Helpdesk
 */
public class Helpdesk {

    public static void main(String[] args){
        
        Scanner sc= new Scanner(System.in); 
        System.out.println("HelpDesk");
        
        System.out.print("email: ");  
        String email= sc.nextLine();  
        System.out.print("pass: ");  
        String password= sc.nextLine();


        //UserDaoImpl ui = new UserDaoImpl();
        //boolean idn = ui.getId(email, password);

        boolean idn = UserS.isLogin(email, password);
        
        if (!idn) {
            System.out.println("error ");
        } 
        else {
            System.out.println("loggedin");

            //int id1 = ui.getId(email);
            int id1 = UserS.getId(email);
            //System.out.println(id1);

            //String role1 = ui.getRole(id1);

            String role1 = UserS.getRole(id1);

            System.out.println(role1);

            if (role1.equals("user")) {

                System.out.println("1.Create Ticket ");
                System.out.println("2.View Open Tickets");  
                System.out.println("3.View Ticket History");
                System.out.print("Enter your option:  ");     
                int key = sc.nextInt();
                
                Scanner sa = new Scanner(System.in);
                switch (key) {
                    case 1:

                    
                    String catg = "";
                    
                    System.out.println("Ticket Creation");
                    
                    System.out.println("Select Category");
                    System.out.println("1.Software");
                    System.out.println("2.Hardware");
                    System.out.println("3.Network");
                    
                    int cat = sa.nextInt();
                    
                    if(cat == 1){
                        catg = "Software";
                        
                    }
                    else if(cat == 2){
                        catg = "Hardware";
                    }
                    else if(cat == 3){
                        catg = "Network";
                    }
                    
                        Scanner s6 = new Scanner(System.in);
                    
                        System.out.print("title:");
                        String title = s6.nextLine();

                        System.out.print("Detials: ");
                        String descr = s6.nextLine();

                        //TicketDaoImpl ti = new TicketDaoImpl();

                        String status = "open";

                        //String title = "hey test 2";
                        //String descr = "someting";

                        TicketS.CreateTicket(id1, catg, title, descr, status );

                        //System.out.println(ct);
                        s6.close();
                        
                        break;
                        
                        
                    case 2: 
                        
                        //TicketDaoImpl to = new TicketDaoImpl();
                        
                        TicketS.OpenTickets(id1);
                        
                        System.out.println("ticket id to edit: ");
                        int tid = sa.nextInt();

                        

                        TicketS.ViewTicket(tid);

                        System.out.println("1.Feedback");
                        System.out.println("2.Close Status");

                        int et = sa.nextInt();

                        Scanner s1 = new Scanner(System.in);

                        switch (et) {
                            case 1:
                                System.out.println("Feedback: ");
                                String feedback = s1.nextLine();

                                TicketS.setFeedback(tid, feedback);

                                break;
                        
                            case 2:

                                TicketS.CloseStatus(tid);

                                break;
                        }



                        break;
                    

                    case 3: //history tickets

                    //TicketDaoImpl tl = new TicketDaoImpl();
                        
                    TicketS.ClosedTickets(id1);


                        break;
                }
                sa.close();
            }
                
            else {
                System.out.println("Admin");

                Scanner se = new Scanner(System.in);

                System.out.println("1.View All Tickets");
                System.out.println("2.Tickets by category");
                System.out.println("3.Ticket History");
                
                int k3 = se.nextInt();

                switch (k3) {
                    case 1:

                        Scanner s2 = new Scanner(System.in);
                    
                        System.out.println("All tickets");

                        TicketS.AllTickets();

                        System.out.println("Ticketid: ");
                        int ticid = s2.nextInt();

                        TicketS.ViewTicket(ticid);

                        System.out.println("1.Soln: ");
                        System.out.println("2.Close Status");

                        int k4 = s2.nextInt();

                        if (k4 == 1) {
                                Scanner s3 = new Scanner(System.in);
                                System.out.println("Solution: ");
                                String soln = s3.nextLine();

                                TicketS.setSoln(ticid, soln);

                                s3.close();
                        }
                                
                        
                        else{
                                TicketS.CloseStatus(ticid);
                                
                        }

                        s2.close();

                        break;


                    case 2:
                        
                        String catg = "";
                        Scanner s7 = new Scanner(System.in);
                        System.out.println("Select Category");
                        System.out.println("1.Software");
                        System.out.println("2.Hardware");
                        System.out.println("3.Network");

                        int k5 = s7.nextInt();

                        if(k5== 1){
                            catg = "Software";
                        }else if(k5 == 2){
                            catg = "Hardware";
                        }else if(k5 == 3){
                            catg = "Network";
                        }

                        TicketS.ByCatg(catg);

                        s7.close();

                        break;
                
                    case 3:
                        
                        System.out.println("user id: ");

                        int hid = se.nextInt();

                        TicketS.ClosedTickets(hid);

                        

                        break;

                    
                }
            
                se.close();



            }

        }

        sc.close();

    }
    
}