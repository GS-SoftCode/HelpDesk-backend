/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ASOTEC
 */

@Entity
@Table(name = "sgt_ticket_solicitante",
        schema = "public")
public class SgtTicketSolicitante implements Serializable{
    
    private long codEmpresa;
    private long codCliente;
    private long codTicket;
    private String nomSolicitante;
    private String apeSolicitante;
    private String emailSolicitante;
    private String telSolicitante;

    public SgtTicketSolicitante() {
    }

    @Column(name="cod_empresa")
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name="cod_cliente")
    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    @Id
    @Column(name="cod_ticket")
    public long getCodTicket() {
        return codTicket;
    }

    public void setCodTicket(long codTicket) {
        this.codTicket = codTicket;
    }

    @Column(name="nom_solicitante")
    public String getNomSolicitante() {
        return nomSolicitante;
    }

    public void setNomSolicitante(String nomSolicitante) {
        this.nomSolicitante = nomSolicitante;
    }

    @Column(name="ape_solicitante")
    public String getApeSolicitante() {
        return apeSolicitante;
    }

    public void setApeSolicitante(String apeSolicitante) {
        this.apeSolicitante = apeSolicitante;
    }

    @Column(name="email_solicitante")
    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    @Column(name="tel_solicitante")
    public String getTelSolicitante() {
        return telSolicitante;
    }

    public void setTelSolicitante(String telSolicitante) {
        this.telSolicitante = telSolicitante;
    }

    
}
