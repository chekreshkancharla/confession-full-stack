/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author tharu
 */
public class backend extends HttpServlet {

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
   
    String usermail = request.getParameter("email");
    String userpassword = request.getParameter("psw");
    
    
    Connection con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/confession","root","Chekri#999");
          String insert = "insert into userdetails(email,password)values(?,?)";
          PreparedStatement ps = con.prepareStatement(insert);
 
          ps.setString(1,usermail);
          ps.setString(2,userpassword);
          
          int status = ps.executeUpdate();
          if(status>0) {
              
              out.print("have registered successfully");
             out.print ("<!DOCTYPE html><html><a href='login.html'>click here</a></html>");
             
          }
          else {
              out.print("ERROR OCCURED");
          }
    } catch(Exception e) {
        out.print(e);
    }
    finally {
        try {
            
        }catch(Exception e1) {
            out.print(e1);
        }
    }
}
}