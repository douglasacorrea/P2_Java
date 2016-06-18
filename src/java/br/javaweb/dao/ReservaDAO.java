/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.dao;

import br.javaweb.beans.Reserva;
import br.javaweb.util.JavaWebException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;

/**
 *
 *  @author Douglas
 */
public class ReservaDAO {

  
    private final String INSERT_RESERVA = "INSERT INTO RESERVA(STARTDATE, ENDDATE, CARRO, NOMEMOTORISTA, IDUSUARIO) VALUES (?,?,?,?,?)";

  
    
    public Reserva setUserReserva (String startDate, String endDate, String carro, String nomeMotorista, int idUsuario) throws JavaWebException, SQLException {

        PreparedStatement prepStmt = null;
        ResultSet insert = null;
        Reserva usrs = new Reserva(startDate, endDate, carro, nomeMotorista);
        Connection conn = null;
        
        try 
        {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_RESERVA);
            prepStmt.setString(1, startDate);
            prepStmt.setString(2, endDate);
            prepStmt.setString(3, carro);
            prepStmt.setString(4, nomeMotorista);
            prepStmt.setInt(5, idUsuario);
            prepStmt.execute();
            usrs.setStartDate(startDate);
            usrs.setEndDate(endDate);
            usrs.setCarro(carro);
            
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
