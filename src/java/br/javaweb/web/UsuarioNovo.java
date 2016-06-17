/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.web;

import br.javaweb.beans.Usuario;
import br.javaweb.dao.UsuarioDAO;
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
public class UsuarioNovo extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contexto = req.getContextPath();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String mensagem = null;

        Usuario objLogin = new Usuario(login, password);

        try {
            Usuario newUsr = new UsuarioDAO().setUserPassword(login, password);
            mensagem = "Usuário cadastrado!";
            resp.sendRedirect(contexto + "/jsp/RegistroSucesso.jsp");
        } catch (JavaWebException ex) {
            Logger.getLogger(UsuarioNovo.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/LoginCadastro.jsp");
            rd.forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioNovo.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("erro", mensagem);
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/LoginCadastro.jsp");
            rd.forward(req, resp);
        }
    }
}
