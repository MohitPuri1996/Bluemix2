package DataBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(urlPatterns = {"/DataBase"})
public class DataBase extends HttpServlet {
int flag=0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataBase</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DataBase at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
     if(flag==1){
         
         RequestDispatcher res=request.getRequestDispatcher("/index.jsp");
        request.setAttribute("username", "hi this is the confirmation");
        
         res.forward(request,response);
         
         
         
   // out.print("mohit puri u r welcome");
    
    //out.print("<br><hr><a href='View.java'>click here to view database data </a>");
     }
     else if(flag==2){
      RequestDispatcher res=request.getRequestDispatcher("/index.jsp");
        request.setAttribute("uername", "hi this is the failre");
        
         res.forward(request,response);}
        
        
    
    else{
out.print(44);
}
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("mohit");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
         String phone=request.getParameter("phone");
          String order=request.getParameter("order");
           String quantity=request.getParameter("quantity");
          
         
        try{
        Class.forName("com.mysql.jdbc.Driver");
       System.out.println(1);
        Connection con=DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/ad_f9b3274f8687ca9","b3fca2f4a5d900","46be442e");
         System.out.println(2);
        String query="insert into fc2 values('"+name+"','"+phone+"','"+order+"','"+quantity+"')";
        PreparedStatement ps=con.prepareStatement(query);
         System.out.println(3);
        ps.executeUpdate();
        flag=1;
        con.close();
         doGet(request,response);
        }catch(Exception e){
        e.printStackTrace();System.err.println(e.toString());
        flag=2;
        doGet(request,response);
        }
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
