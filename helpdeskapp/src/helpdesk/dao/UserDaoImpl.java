package helpdesk.dao;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    
    String url = "jdbc:mysql://localhost:3306/helpdesk";
    String uname = "root";
    String pass = "admin";

    Connection con = null;
    
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    @Override
    public boolean getId(String email, String password) {
        String id = "";

        String query = "select id from user where email="+"'" + email+"'"+" and password="+"'"+password+"'";
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next()){
            id = rs.getString("id");
            }

            //System.out.println(id.isEmpty());

            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
        if (id.isEmpty()) {
            return false;
        } else {
            return true;       
        }
    }

    public int getId(String email){
        int id = 0;

        String queryid = "select id from user where email="+"'" + email + "'";


        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryid);

            if(rs.next()){
            id = rs.getInt("id");
            }

            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);        
        }
        
        return id;
    }

    public String getRole(int id){
        String role = "";

        String queryid = "select role from user where id="+"'" + id + "'";


        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryid);

            if(rs.next()){
            role = rs.getString("role");
            }

            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);        
        }
        
        return role;
    }
       
}



