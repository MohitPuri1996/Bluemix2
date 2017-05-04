<%-- 
    Document   : index
    Created on : 30 Apr, 2017, 9:26:01 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>TODO write content</div>
        <form action="DataBase" method="post">
        <input type="text" name="name" placeholder="name">
        <input type="text" name="phone" placeholder="phone">
        <input type="text" name="order" placeholder="order">
        <input type="text" name="quantity" placeholder="quantity">
        <input type="submit" value="submit"></form>
        <br><hr>
        
       <a href="Viiew.jsp">click here to view data</a> 
        <%
                      
            
        if(request.getAttribute("username")!=null){
        %>
        
        <h1><%=request.getAttribute("username")%></h1>
       
        
        <%
}
        %>
    </body>
</html>
