package com.mycompany.wangzihaopruebatecnica2.servlets;

import com.mycompany.wangzihaopruebatecnica2.logic.Controller;
import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import com.mycompany.wangzihaopruebatecnica2.logic.TurnIdGenerator;
import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import java.io.IOException;
import java.time.LocalDate;
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
@WebServlet(name = "SvTurn", urlPatterns = {"/SvTurn"})
public class SvTurn extends HttpServlet {

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
        List<Turn> turnList=new ArrayList<>(controller.findAllTurns());
        HttpSession mySession = request.getSession();
        mySession.setAttribute("turnList", turnList);
        response.sendRedirect("seeAppointment.jsp");
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
        TurnIdGenerator tig=new TurnIdGenerator();
        String id=tig.turnIdGenerator();
        String turnDate=request.getParameter("date");
        LocalDate date=LocalDate.parse(turnDate);
        String procedure=request.getParameter("procedure");
        String province=request.getParameter("province");
        String office=request.getParameter("office");
        String postalCode=request.getParameter("postalCode");
        String description=request.getParameter("description");
        String state="on hold";
        
        HttpSession mySession = request.getSession();
        Users user = (Users) mySession.getAttribute("user");
        
        Turn turn=new Turn(id,date,procedure,province,office,postalCode,description,state,user);
        controller.createTurn(turn);
        user.getTurn().add(turn);
        controller.editUser(user);
        response.sendRedirect("index.jsp");
    }

}
