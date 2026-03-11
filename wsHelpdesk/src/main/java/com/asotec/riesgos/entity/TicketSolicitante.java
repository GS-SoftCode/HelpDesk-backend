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

    /* Campos que no se registran en BD */
    private String img1;
    private String img2;

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

    /* Getters y Setters para campos que no se registran en BD */
    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
     
}