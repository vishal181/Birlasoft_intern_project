package helpdesk.dao;

import java.sql.*;

public class TicketDaoImpl implements TicketDao{

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
    public boolean CreateTicket(int id, String catg, String title, String descr, String status) {
        boolean ct = false;

        String query = "insert into tickets (userid, category, title, descr,status) values ("+"'" + id +"',"+"'" + catg +"',"+"'" + title +"',"+"'"+descr+"',"+"'"+status+"')";


        try {
            Statement st = con.createStatement();
            int kk = st.executeUpdate(query);

            if(kk == 0){
             ct = true;
            }
    
            //System.out.println(id.isEmpty());
    
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }

        return ct;
        
    }


    public void OpenTickets(int id) {

        String query = "select ticketid, title, descr, soln, feedback from tickets where userid =" +id +" and status = 'open'";

        try {
        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ticketid: " + rs.getString(1));
                System.out.println("title: " + rs.getString(2));
                System.out.println("decr: " + rs.getString(3));
                System.out.println("soln: " + rs.getString(4));
                System.out.println("feedback: " + rs.getString(5));
                System.out.println("------------------");
            }
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }

    public void ClosedTickets(int id) {

        String query = "select ticketid,title,descr,soln,feedback from tickets where userid ="+id+" and status = 'closed'" ;

        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ticketid: " + rs.getString(1));
                System.out.println("title: " + rs.getString(2));
                System.out.println("decr: " + rs.getString(3));
                System.out.println("soln: " + rs.getString(4));
                System.out.println("feedback: " + rs.getString(5));
                System.out.println("------------------");
            }
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }

    public void ViewTicket(int id) {

        String query = "select ticketid,userid,title,descr,soln,feedback from tickets where ticketid ="+ id;

        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ticketid: " + rs.getString(1));
                System.out.println("userid: " + rs.getString(2));
                System.out.println("title: " + rs.getString(3));
                System.out.println("decr: " + rs.getString(4));
                System.out.println("soln: " + rs.getString(5));
                System.out.println("feedback: " + rs.getString(6));
                System.out.println("------------------");
            }
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }

    public void setFeedback(int id, String feedback) {

        String query = "update tickets set feedback = '" + feedback +"' where ticketid = " + id;

        try {
            
            Statement st = con.createStatement();
            st.executeUpdate(query);

            //rs.next();
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }

    public void setSoln(int id, String soln) {

        String query = "update tickets set feedback = '" + soln +"' where ticketid = " + id;

        try {
            
            Statement st = con.createStatement();
            st.executeUpdate(query);

            //rs.next();
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }


    public void CloseStatus(int id) {

        String query = "update tickets set status = 'closed' where ticketid = " + id;

        try {
            
            Statement st = con.createStatement();
            st.executeUpdate(query);

            //rs.next();
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }

    public void AllTickets() {

        String query = "select ticketid,userid,category,title,descr,soln,feedback from tickets where status = 'open'";

        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ticketid: " + rs.getString(1));
                System.out.println("userid: " + rs.getString(2));
                System.out.println("category: " + rs.getString(3));
                System.out.println("title: " + rs.getString(4));
                System.out.println("decr: " + rs.getString(5));
                System.out.println("soln: " + rs.getString(6));
                System.out.println("feedback: " + rs.getString(7));
                System.out.println("------------------");
            }
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }


    public void ByCatg(String catg) {

        String query = "select ticketid,userid,category,title,descr,soln,feedback from tickets where status = 'open' and  category='"+ catg + "'";

        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ticketid: " + rs.getString(1));
                System.out.println("userid: " + rs.getString(2));
                System.out.println("category: " + rs.getString(3));
                System.out.println("title: " + rs.getString(4));
                System.out.println("decr: " + rs.getString(5));
                System.out.println("soln: " + rs.getString(6));
                System.out.println("feedback: " + rs.getString(7));
                System.out.println("------------------");
            }
    
            st.close();
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);    
            
        }
        
    }
    
}
