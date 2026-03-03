/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

/**
 *
 * @author ASOTEC
 */
public class TicketSolicitante {
    
    private SgtTicketSolicitante solicitante;
    private SgtTicket ticket;

    public TicketSolicitante() {
    }

    public SgtTicketSolicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(SgtTicketSolicitante solicitante) {
        this.solicitante = solicitante;
    }

    public SgtTicket getTicket() {
        return ticket;
    }

    public void setTicket(SgtTicket ticket) {
        this.ticket = ticket;
    }
    
    
}
