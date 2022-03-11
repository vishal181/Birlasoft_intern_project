package helpdesk.dao;

public interface UserDao {

    public boolean getId(String email, String password);
    public int getId(String email);
    public String getRole(int id);
    
}

