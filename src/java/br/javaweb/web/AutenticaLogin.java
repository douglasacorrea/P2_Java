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
import static java.lang.System.out;
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
public class AutenticaLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contexto = req.getContextPath();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String mensagem = null;

        Usuario objLogin = new Usuario(login, password);
// 
        try {
                
            int idUsuario = new UsuarioDAO().consultarUsuarioPorLoginSenha(login, password);
            if (idUsuario > 0) {
                HttpSession sessao = req.getSession();
                sessao.setAttribute("login", login);
                sessao.setAttribute("idusuario", idUsuario);
                sessao.setAttribute("logado", objLogin);
                resp.sendRedirect(contexto + "/jsp/Index2.jsp");
            } else {
                            
                 resp.sendRedirect(contexto + "/jsp/LoginFalha.jsp");
            }
        } catch (JavaWebException ex) {
            Logger.getLogger(AutenticaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
