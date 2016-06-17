/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.dao;

import br.javaweb.beans.Usuario;
import br.javaweb.util.JavaWebException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *  @author Douglas
 */
public class UsuarioDAO {

    private final String SELECT_USUARIO = "SELECT LOGIN, PASSWORD FROM USUARIO WHERE LOGIN = ? AND PASSWORD = ?";
    
    public boolean getLoginPassword(String login, String password) throws JavaWebException {

        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet userBD = null;
        Usuario usrs = new Usuario(login, password);
        
        try {
            conn = GerenciadorConexoes.getConexao();

            prepStmt = conn.prepareStatement(SELECT_USUARIO);
            prepStmt.setString(1, login);
            prepStmt.setString(2, password);
            userBD = prepStmt.executeQuery();

            if (userBD.next()) {
                if (usrs.getLogin().equals(login) && usrs.getPassword().equals(password)) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException E) {
            return false;
        }
        
        return false;
    }
    
    private final String INSERT_USUARIO = "INSERT INTO USUARIO(LOGIN, PASSWORD) VALUES (?,?)";
  
    
    public Usuario setUserPassword(String login, String password) throws JavaWebException, SQLException {

        PreparedStatement prepStmt = null;
        ResultSet insert = null;
        Usuario usrs = new Usuario(login, password);
        Connection conn = null;
        
        try 
        {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_USUARIO);
            prepStmt.setString(1, login);
            prepStmt.setString(2, password);
            prepStmt.execute();
            usrs.setLogin(login);
            usrs.setPassword(password);
        } 
        catch (SQLException E) {
            String msg = "Erro" + E.getMessage();
            JavaWebException ge = new JavaWebException(msg, E);
            throw ge;
        } 
        finally 
        {
            GerenciadorConexoes.closeAll(conn, prepStmt, insert);
        }
        
        return usrs;
    }
}
