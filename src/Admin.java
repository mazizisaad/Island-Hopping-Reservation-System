
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Azizi
 */
public class Admin extends User
{
    protected String username;
    protected String password;
    String adminID;
    
    public Admin()
    {
        super();
        username = null;
        password = null;
    }
    
    public Admin(String name, String address, String phone, String email, String idNum)
    {
        super(name, address, phone, email, idNum);
    }
    
    public Admin (String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        String print = "<html>"
                        + "<table>"
                            + "<tr>"
                                + "<td>Name: <td>"
                                + "<td>" + name + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Admin ID: <td>"
                                + "<td>" + idNum + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Contact: <td>"
                                + "<td>" + phone + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Address: <td>"
                                + "<td>" + address + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Email: <td>"
                                + "<td>" + email + "</td>"
                            + "</tr>"
                        + "</table>"
                    + "</html>";;
        
        return print;
    }
    
    public boolean adminLogin()
    {
        boolean status = false;
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/islandhopping","root","")) 
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'");

                if(rs.next())
                {
                    adminID = rs.getString(1);
                    status = true;
                    createCache(adminID);
                    goAdminPanel();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid User!");
                    status = false;
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
         
        return status;
    }
    
    public void createCache(String adminID)
    {
        try(PrintWriter cache = new PrintWriter(new BufferedWriter( new FileWriter("log.txt"))))
        {
            cache.println(adminID);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(loginMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean clearLog()
    {
        try(PrintWriter cache = new PrintWriter(new BufferedWriter( new FileWriter("log.txt"))))
        {
            cache.println("");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(loginMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public void goAdminPanel()
    {        
        adminPanel admin = new adminPanel();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
    }
    
    public String avaiBoat()
    {
        String boatSeries;
        StringBuilder boat = new StringBuilder();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/islandhopping","root","")) 
            {
                int count = 1;
                Statement stmt = con.createStatement();
                
                ResultSet rs = stmt.executeQuery("SELECT DISTINCT boatSeries FROM boat");
                
                boat.append("<html><table><tr><td> No </td><td> Boat Series </td></tr>");
                boat.append("<tr><td> -- </td><td> ----------- </td></tr>");
                
                while(rs.next())
                {
                    boatSeries = rs.getString(1);
                    
                    boat.append("<tr><td>");
                    boat.append(count).append(". </td>");
                    boat.append("<td>").append(boatSeries).append("</td></tr>");
                    count++;
                }
                boat.append("</html>");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        
        String list = boat.toString();
        return list;
    }
    
    String date = "", month = "", year = "", time = "", boatSeries = "", boatID = "";
    
    public boolean manageBoat(String date, String month, String year, String time, String boatSeries)
    {
        String newDate = date + " " + month + " " + year;
        boolean status = false;
        
        if(date.equalsIgnoreCase("Date") || month.equalsIgnoreCase("Month") || year.equalsIgnoreCase("Year") || time.equalsIgnoreCase("Hour") || boatSeries.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, month);
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/islandhopping","root","")) 
                {
                    Statement stmt = con.createStatement();

                    ResultSet rs = stmt.executeQuery("SELECT * FROM boat WHERE boatDate = '" + newDate + "' AND boatTime = '" + time + "'");

                    if (rs.next())
                    {
                        JOptionPane.showMessageDialog(null, "The Time and Date is Already Available!");
                    }
                    else
                    {
                        String sql = "INSERT INTO boat(boatSeries, boatTime, boatDate) VALUES (?, ?, ?)";
                        PreparedStatement query = con.prepareStatement(sql);
                        query.setString(1, boatSeries);
                        query.setString(2, time);
                        query.setString(3, newDate);

                        query.execute();

                        Statement stmt1 = con.createStatement();

                        ResultSet rs1 = stmt1.executeQuery("SELECT * FROM boat WHERE boatDate = '" + newDate + "' AND boatTime = '" + time + "'");

                        if (rs1.next())
                        {   
                            boatID = rs1.getString(1);

                            String sql1 = "INSERT INTO seat(boatID, A1, A2, B1, B2, C1, C2, D1, D2, E1, E2, F1, F2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement query1 = con.prepareStatement(sql1);
                            query1.setString(1, boatID);
                            query1.setString(2, "0");
                            query1.setString(3, "0");
                            query1.setString(4, "0");
                            query1.setString(5, "0");
                            query1.setString(6, "0");
                            query1.setString(7, "0");
                            query1.setString(8, "0");
                            query1.setString(9, "0");
                            query1.setString(10, "0");
                            query1.setString(11, "0");
                            query1.setString(12, "0");
                            query1.setString(13, "0");

                            query1.execute();
                            JOptionPane.showMessageDialog(null, "Process Successful!");
                            status = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Process Unsuccessful!");
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        
        return status;
    }
    
    public String custList(String boatID)
    {
        String seat = null, custID = null, name = null, phone = null, time = null;
        StringBuilder detail = new StringBuilder();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/islandhopping","root","")) 
            {
                Statement stmt = con.createStatement();
                
                ResultSet rs = stmt.executeQuery("SELECT * FROM reservation WHERE boatID = '" + boatID  + "'");
                
                detail.append("<html><h3>Booking List</h3><table><tr><td> No. </td><td> Cust ID </td><td> Cust Name </td><td> Cust Contact </td><td> Seat Selection </td></tr> ");
                detail.append("<tr><td> --- </td><td> ------- </td><td> --------- </td><td> ------------ </td><td> -------------- </td></tr> ");
                
                int bil =1;
                while(rs.next())
                {
                    seat = rs.getString(2);
                    custID = rs.getString(5);
 
                    Statement stmt1 = con.createStatement();
                
                    ResultSet rs1 = stmt1.executeQuery("SELECT * FROM customer WHERE custID = '" + custID + "'");
                    
                    while(rs1.next())
                    {
                        name = rs1.getString(3);
                        phone = rs1.getString(5);
                    }
                    
                    detail.append("<tr><td>").append(bil).append(". </td>");
                    detail.append("<td>").append(custID).append("</td>");
                    detail.append("<td>").append(name).append("</td>");
                    detail.append("<td>").append(phone).append("</td>");
                    detail.append("<td>").append(seat).append("</td>");
                    detail.append("</tr>");
                    
                    bil++;
                }
                
                detail.append("</html>");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        
        String list = detail.toString();
        return list;
    }
    
    public String boatList(String date, String month, String year)
    {
        String boatID, boatSeries, time, newDate;
        String list = null;
        StringBuilder boat = new StringBuilder();
        newDate = date + " " + month + " " +year;
        
        if(date.equalsIgnoreCase("Date") || month.equalsIgnoreCase("Month") || year.equalsIgnoreCase("Year"))
        {
            JOptionPane.showMessageDialog(null, "Please Pick Date!");
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/islandhopping","root","")) 
                {
                    Statement stmt = con.createStatement();

                    ResultSet rs = stmt.executeQuery("SELECT * FROM boat WHERE boatDate = '" + newDate + "' ORDER BY boatTime");

                    int count = 1;

                    boat.append("<html><h3>List Boat For ").append(newDate).append("</h3><table><tr><td> No. </td><td> Boat ID </td><td> Boat Series </td><td> Time </td></tr>");
                   boat.append("<tr><td> --- </td><td> ------- </td><td> ----------- </td><td> ---- </td></tr>");
                    while(rs.next())
                    {
                        boatID = rs.getString(1);
                        boatSeries = rs.getString(2);
                        time = rs.getString(3);

                        boat.append("<tr>");
                        boat.append("<td>").append(count).append(". </td>");
                        boat.append("<td>").append(boatID).append("</td>");
                        boat.append("<td>").append(boatSeries).append("</td>");
                        boat.append("<td>").append(time).append("</td>");
                        boat.append("</tr>");
                        count++;

                    }
                    boat.append("</table></html>");
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }

            list = boat.toString();   
        }
        return list;
    }
}
