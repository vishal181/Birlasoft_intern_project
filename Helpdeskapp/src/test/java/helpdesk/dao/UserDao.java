package helpdesk.dao;

import org.springframework.stereotype.Component;

import helpdesk.model.User;

@Component
public interface UserDao {
	
    public boolean ifExists(String email, String password);
    
    public User getId(String email);
    
    public User getRole(int id);
    
}
