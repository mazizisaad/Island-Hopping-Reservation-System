/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Azizi
 */
public class Customer extends User
{
    protected String date;
    protected String time;
    protected int numOfPack;
    protected String seat;
    protected String boat;
    
    public Customer()
    {
        super();
        date = "";
        time = "";
        numOfPack = 0;
    }
    
    public Customer(String name, String address, String phone, String email, String idNum, String date, String time, int numOfPack)
    {
        super(name, address, phone, email, idNum);
        this.date = date;
        this.time = time;
        this.numOfPack = numOfPack;
    }
    
    public Customer(String name, String address, String phone, String email, String idNum, String date, String time, String seat, String boat)
    {
        super(name, address, phone, email, idNum);
        this.date = date;
        this.time = time;
        this.seat = seat;
        this.boat = boat;
    }
    
    public double calcPrice()
    {
        double total = numOfPack * 20;
        return total;
    }
    
    public String ticketDetail()
    {
        String display = "<html>"
                        + "<h3>Ticket Details</h3>"
                        + "<table>"
                            + "<tr>"
                                + "<td>Name: <td>"
                                + "<td>" + name + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>IC Number: <td>"
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
                            + "<tr>"
                                + "<td>Date: <td>"
                                + "<td>" + date + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Time: <td>"
                                + "<td>" + time + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Seat Number: <td>"
                                + "<td>" + seat + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Boat Series Number: <td>"
                                + "<td>" + boat + "</td>"
                            + "</tr>"
                        + "</table>"
                    + "</html>";
        return display;
    }
    
    @Override
    public String toString()
    {
        String print = "<html>"
                        + "<h3>Your Booking Summary</h3>"
                        + "<table>"
                            + "<tr>"
                                + "<td>Name: <td>"
                                + "<td>" + name + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Contact: <td>"
                                + "<td>" + phone + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Date: <td>"
                                + "<td>" + date + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Time: <td>"
                                + "<td>" + time + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Number Of Packs: <td>"
                                + "<td>" + numOfPack + "</td>"
                            + "</tr>"
                            + "<tr>"
                                + "<td>Total Price: <td>"
                                + "<td>RM " + calcPrice() + "</td>"
                            + "</tr>"
                        + "</table>"
                    + "</html>";
        return print;
    }
}
