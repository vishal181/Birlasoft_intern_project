package helpdesk.dao;

import org.springframework.stereotype.Component;

import helpdesk.model.User;

@Component
public interface UserDao {
	
	//get the user id associated with the login email and password
    public boolean ifExists(String email, String password);
    
    //get the user id associated with the email
    public User getId(String email);
    
    //get the role of the user associated with the user id
    public User getRole(int id);
    
}
