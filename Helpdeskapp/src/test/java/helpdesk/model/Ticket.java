package helpdesk.model;

public class Ticket {
	private int ticketid;
    private String userid;
    private String title;
	private String descr;
    private String solution;
    private String feedback;
    private String status;
    private String category;
    
    public Ticket() {
    	
    }
    
    public String getCategory() {
    	return category;
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public int getTicketid() {
    	
    	//returns ticket id of the ticket
        return ticketid;
    }
    public String getStatus() {
    	
    	//returns the status (open/ closed) of the ticket
        return status;
    }
    public void setStatus(String status) {
    	
    	//set the status to open/closed of the ticket
        this.status = status;
    }
    public String getFeedback() {
    	
    	//return the feedback of a ticket
        return feedback;
    }
    public void setFeedback(String feedback) {
    	
    	//set the feedback/ updates the feedback of a ticket
        this.feedback = feedback;
    }
    public String getSolution() {
    	
    	//returns the solution provided of the ticket
        return solution;
    }
    public void setSolution(String solution) {
    	
    	//sets/ updates the solution of the ticket
        this.solution = solution;
    }
    public String getDescr() {
    	
    	//returns the descriptions of the tickets
        return descr;
    }
    public void setDescr(String descr) {
    	
    	//sets the description of a ticket
        this.descr = descr;
    }
    public String getTitle() {
    	
    	//returns the title of a ticket
        return title;
    }
    public void setTitle(String title) {
    	
    	//sets the title of a ticket
        this.title = title;
    }
    public String getUserid() {
    	
    	//returns the user id of the of the user created the ticket
        return userid;
    }
    public void setUserid(String userid) {
    	
    	//set a unique user id to the ticket created by the user 
        this.userid = userid;
    }
    public void setTicketid(int ticketid) {
    	
    	//sets a unique ticket id for a ticket
        this.ticketid = ticketid;
    }
    
	public Ticket(int ticketid, String userid, String title, String descr, String solution, String feedback,
			String status) {
		super();
		this.ticketid = ticketid;
		this.userid = userid;
		this.title = title;
		this.descr = descr;
		this.solution = solution;
		this.feedback = feedback;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Ticket [ticketid=" + ticketid + ", userid=" + userid + ", title=" + title + ", descr=" + descr
				+ ", solution=" + solution + ", feedback=" + feedback + ", status=" + status + ", category=" + category + "]";
	}
	
	
}
