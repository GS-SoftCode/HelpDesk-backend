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
@Table(name = "sgt_ticket_estado",
        schema = "public")
public class SgtTicketEstado implements Serializable{
    
    @Id
    @Column(name = "cod_estado", precision = 2, scale = 0)
    private long codEstado;
    @Column(name = "txt_estado", length = 50)
    private String txtEstado;

    public SgtTicketEstado() {
    }

    public SgtTicketEstado(long codEstado, String txtEstado) {
        this.codEstado = codEstado;
        this.txtEstado = txtEstado;
    }
    
    public long getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(long codEstado) {
        this.codEstado = codEstado;
    }

    public String getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(String txtEstado) {
        this.txtEstado = txtEstado;
    }
    
    
}
