package helpdesk.dao;

public interface TicketDao {

    public boolean CreateTicket(int id, String catg,String title, String descr, String status);
    public void OpenTickets(int id);
    public void ClosedTickets(int id);
    public void ViewTicket(int id);
    public void setFeedback(int id,String feedback);
    public void setSoln(int id,String soln);
    public void CloseStatus(int id);
    public void AllTickets();
    public void ByCatg(String catg);
    
}
