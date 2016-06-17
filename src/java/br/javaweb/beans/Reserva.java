/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.beans;

/**
 *
 * @author Douglas
 */
public class Reserva {
    private String nomeMotorista;
    private String startDate;
    private String endDate;
    private String carro;
    

    public Reserva(String startDate, String endDate, String carro, String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carro = carro;
       
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }
    
    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCarro () {
        return carro;
    }
}
