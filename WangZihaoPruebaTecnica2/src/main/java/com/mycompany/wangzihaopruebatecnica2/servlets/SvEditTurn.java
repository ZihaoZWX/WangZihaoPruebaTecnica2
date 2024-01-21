package com.mycompany.wangzihaopruebatecnica2.servlets;

import com.mycompany.wangzihaopruebatecnica2.logic.Controller;
import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import java.io.IOException;
import java.time.LocalDate;
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
@WebServlet(name = "SvEditTurn", urlPatterns = {"/SvEditTurn"})
public class SvEditTurn extends HttpServlet {
    
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
        
        String userId=request.getParameter("userId");
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String phoneNumber=request.getParameter("phoneNumber");
        String gmail=request.getParameter("gmail");
        String turnId=request.getParameter("turnId");
        String turnDate=request.getParameter("date");
        String procedure=request.getParameter("procedure");
        String province=request.getParameter("province");
        String postCode=request.getParameter("postCode");
        String description=request.getParameter("description");
        String state=request.getParameter("state");
        Turn turn=controller.findTurn(turnId);
        turn.getUsers().setId(userId);
        turn.getUsers().setName(name);
        turn.getUsers().setSurname(surname);
        turn.getUsers().setPhoneNumber(phoneNumber);
        turn.getUsers().setGmail(gmail);
        LocalDate date=LocalDate.parse(turnDate);
        turn.setTurnProcedure(procedure);
        turn.setProvince(province);
        turn.setTurnDate(date);
        turn.setPostalCode(postCode);
        turn.setDescription(description);
        turn.setTurnState(state);
        controller.editTurn(turn);
        List<Turn> turnList=controller.findAllTurns();
        HttpSession mySession = request.getSession();
        mySession.setAttribute("turnList", turnList);
        response.sendRedirect("seeAppointment.jsp");
    }

}
