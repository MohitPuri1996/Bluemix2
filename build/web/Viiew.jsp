<%-- 
    Document   : Viiew
    Created on : 3 May, 2017, 5:50:20 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Users Details</h1><hr>
        <table>
            <tr><th>Name</th><th>Phone</th><th>Order</th><th>Quantity</th></tr>
        <%
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
       System.out.println(1);
        Connection con=DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_f9b3274f8687ca9","b3fca2f4a5d900","46be442e");
         System.out.println(2);
        //String query="insert into fc2 values('"+name+"','"+phone+"','"+order+"','"+quantity+"')";
       String q="Select * from fc2";
        Statement ps=con.createStatement();
         System.out.println(3);
         
        ResultSet rs=ps.executeQuery(q);
        while(rs.next()){
        %>
            <tr><td><%=rs.getString("name")%></td>
             <td><%=rs.getString("phone")%></td>
              <td><%=rs.getString("order")%></td>
              <td><%=rs.getString("quantity")%></td></tr>
        
        
        
        
        
        
        <%
        }
        con.close();
        // doGet(request,response);
        }catch(Exception e){
        e.printStackTrace();System.err.println(e.toString());
        
        }
        
        
        
        
        %>
        
        
        
        
        
    </body>
</html>
