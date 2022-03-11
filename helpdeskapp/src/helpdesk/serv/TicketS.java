package helpdesk.serv;

import helpdesk.dao.TicketDaoImpl;

public class TicketS {

    public static boolean CreateTicket(int id, String catg, String title, String descr, String status){
        
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        boolean ct = ti.CreateTicket(id, catg, title, descr, status );

        return ct;
    }

    public static void OpenTickets(int id){

        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.OpenTickets(id);

    }
    public static void ClosedTickets(int id){
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.ClosedTickets(id);

    }

    public static void ViewTicket(int id){

        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.ViewTicket(id);

    }

    public static void setFeedback(int id, String feedback) {
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.setFeedback(id, feedback);
    }

    public static void setSoln(int id, String soln) {
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.setSoln(id, soln);
    }

    public static void CloseStatus(int id) {
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.CloseStatus(id);
    }

    public static void AllTickets() {
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.AllTickets();
        
    }

    public static void ByCatg(String catg) {
        TicketDaoImpl ti = new TicketDaoImpl();
        ti.connect();
        ti.ByCatg(catg);
        
    }
    
}
