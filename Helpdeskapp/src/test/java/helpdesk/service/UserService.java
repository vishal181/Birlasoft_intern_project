package helpdesk.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import helpdesk.AppConfig;
import helpdesk.dao.UserDao;
import helpdesk.model.User;

@Component("userservice")
public class UserService {
	private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	private static UserDao userDao = context.getBean("userDao", UserDao.class);
	
	public boolean ifExists(String email, String password) {
		boolean a = userDao.ifExists(email, password);
		
		return a;
	}
    

    public User getId(String email) {
    	
    	User id = userDao.getId(email);
		
    	return id;
		
    }
    

    public User getRole(int id) {
    	
    	User role = userDao.getRole(id);
		
    	return role;
    }

}
