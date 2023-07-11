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
public class loginverification extends HttpServlet {
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    String email=request.getParameter("userEmail");
    String password = request.getParameter("psw");
    
    Connection con = null;
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/confession","root","Chekri#999");
            String sqlcheck = "select * from userdetails where Email='"+email+"'and password='"+password+"'";
            Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery(sqlcheck);
        boolean  status = false;
        while(rs.next()) {
        status=true;
    }
        if(status==true) {
            out.print("Welcome To DashBoard");
            out.print("<!DOCTYPE html><html><a href='confess.html'>click here</a></html>");
        }
        else {
            out.print("Incorrect Details Please Enter Again");
        }
    } catch(Exception e) {
        out.print(e);
    } finally {
        try {
            
            
        }catch(Exception e1) {
            out.print(e1);
        }
    }
} 
}