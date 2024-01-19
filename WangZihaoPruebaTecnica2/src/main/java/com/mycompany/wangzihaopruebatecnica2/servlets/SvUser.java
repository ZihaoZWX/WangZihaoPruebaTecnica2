package com.mycompany.wangzihaopruebatecnica2.servlets;

import com.mycompany.wangzihaopruebatecnica2.logic.Controller;
import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zihao Wang
 */
@WebServlet(name = "SvUser", urlPatterns = {"/SvUser"})
public class SvUser extends HttpServlet {

    Controller controller=new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        processRequest(request, response);
        
        List<Users> usersList=controller.findAllUser();
        HttpSession mySesion=request.getSession();
        mySesion.setAttribute("usersList", usersList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
        
        List<Turn>turn=new ArrayList<>();
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String phoneNumber=request.getParameter("phoneNumber");
        String gmail=request.getParameter("gmail");
        Users user=new Users(id,name,surname,phoneNumber,gmail,turn);
        if(controller.findUser(id)==null){
            controller.createUser(user);
        }
        HttpSession mySesion=request.getSession();
        mySesion.setAttribute("user", user);
        response.sendRedirect("createAppointment.jsp");
    }

}
