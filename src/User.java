/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Azizi
 */
public class User 
{
    protected String name;
    protected String address;
    protected String phone;
    protected String email;
    protected String idNum;
    
    public User()
    {
        name = "";
        address = "";
        phone = "";
        email = "";
        idNum = "";
    }
    
    public User(String name, String address, String phone, String email, String idNum)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idNum = idNum;
    }
    
    @Override
    public String toString()
    {
        String print = name + ", " + address + ", " + phone + ", " + email + ", " + idNum;
        
        return print;
    }
}
