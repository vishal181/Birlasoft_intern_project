package helpdesk.model;

public class Ticket {
    private int ticketid;
    private String userid;
    private String title;
    private String descr;
    private String soln;
    private String feedback;
    private String status;
    
    public int getTicketid() {
        return ticketid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public String getSoln() {
        return soln;
    }
    public void setSoln(String soln) {
        this.soln = soln;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    } 
}
