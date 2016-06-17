/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;

import br.javaweb.beans.Reserva;
import br.javaweb.dao.ReservaDAO;
import br.javaweb.util.JavaWebException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
public class ReservaNova extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contexto = req.getContextPath();
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String carro = req.getParameter("carro");
        String nomeMotorista = req.getParameter("nomeMotorista");
        String mensagem = null;

       // Reserva objReserva = new Reserva(startDate, endDate, carro, nomeMotorista);
// 
       try {
            Reserva newReserva = new ReservaDAO().setUserReserva(startDate, endDate, carro, nomeMotorista);
            mensagem = "Reserva Realizada!";
            resp.sendRedirect(contexto + "/jsp/ReservaSucesso.jsp");
        } catch (JavaWebException ex) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/index.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaNova.class.getName()).log(Level.SEVERE, null, ex);
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/index.jsp");
        } 
    }
}