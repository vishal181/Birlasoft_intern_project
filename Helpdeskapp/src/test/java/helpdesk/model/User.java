package helpdesk.model;

public class User {
	private int id;
    private String name;
    private String email;
    private String password;
    private String role;
 
    public int getId() {
    	
    	//returns the id of the user 
        return id;
    }
    public String getRole() {
    	
    	//returns the role of the user
        return role;
    }
    public void setRole(String role) {
    	
    	//sets the role of the user
        this.role = role;
    }
    public String getPassword() {
    	
    	//returns the password of the user
        return password;
    }
    public void setPassword(String password) {
    	
    	//sets the password for the user
        this.password = password;
    }
    public String getEmail() {
    	
    	//returns the email of the user
        return email;
    }
    public void setEmail(String email) {
    	
    	//set the email of the user
        this.email = email;
    }
    public String getName() {
    	
    	//returns the name of the user
        return name;
    }
    public void setName(String name) {
    	
    	//sets the name of the user
        this.name = name;
    }
    public void setId(int id) {
    	
    	//set the id of a user
        this.id = id;
    }
}
