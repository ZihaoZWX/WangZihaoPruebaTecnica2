package com.mycompany.wangzihaopruebatecnica2.servlets;

import com.mycompany.wangzihaopruebatecnica2.logic.Controller;
import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import java.io.IOException;
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
@WebServlet(name = "SvDateFilter", urlPatterns = {"/SvDateFilter"})
public class SvDateFilter extends HttpServlet {

    Controller controller=new Controller();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        String date=request.getParameter("date");
        String state=request.getParameter("state");
        List<Turn> listTurn=controller.findAllTurns().stream().filter(turn->turn.getTurnDate().toString().equals(date)).toList();
        List<Turn> secondFilter=listTurn.stream().filter(turn->turn.getTurnState().equals(state)).toList();
        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("filterList", secondFilter);
        response.sendRedirect("seeAppointment.jsp");
        
    }

}
