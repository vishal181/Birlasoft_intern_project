package helpdesk.serv;

import helpdesk.dao.UserDaoImpl;

public class UserS {

    
    public static boolean isLogin(String email, String password){
        
        
        UserDaoImpl ui = new UserDaoImpl();
        ui.connect();
        boolean idn1 = ui.getId(email, password);
        
        return idn1;
    }
    
    public static int getId(String email) {
        
        UserDaoImpl ui = new UserDaoImpl();
        ui.connect();

        int id = ui.getId(email);

        return id;
        
    }

    public static String getRole(int id) {
        
        UserDaoImpl ui = new UserDaoImpl();
        ui.connect();
        String role = ui.getRole(id);

        return role;
    }
    
}
