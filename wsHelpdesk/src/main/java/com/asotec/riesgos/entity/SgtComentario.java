/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASOTEC
 */
@Entity
@Table(name = "sgt_ticket_detalle",
        schema = "public")
public class SgtComentario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_detalle") 
    private long codDetalle;
    @Column(name = "cod_ticket") 
    private int ticket;
    @Column(name = "txt_comentario", length = 1000)
    private String txtComentario;
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fecCreacion;
    @Column(name = "cod_usuario", length = 50)
    private String codUsuario;
    @Column(name = "cod_cliente", precision = 10, scale = 0) 
    private long codCliente;
    @Column(name = "cod_tecnico", length = 20)
    private String codTecnico;
    @Column(name = "cod_empresa", precision = 10, scale = 0)
    private long codEmpresa;

    public SgtComentario() {
    }

    public SgtComentario(long codDetalle, int ticket, String txtComentario, Date fecCreacion, String codUsuario, long codCliente, String codTecnico, long codEmpresa) {
        this.codDetalle = codDetalle;
        this.ticket = ticket;
        this.txtComentario = txtComentario;
        this.fecCreacion = fecCreacion;
        this.codUsuario = codUsuario;
        this.codCliente = codCliente;
        this.codTecnico = codTecnico;
        this.codEmpresa = codEmpresa;
    }
    
    @PrePersist
    protected void onCreate() {
        fecCreacion = new Date();
    }

    public long getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(long codDetalle) {
        this.codDetalle = codDetalle;
    }
    
    public String getTxtComentario() {
        return txtComentario;
    }

    public void setTxtComentario(String txtComentario) {
        this.txtComentario = txtComentario;
    }
    
    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
    
    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }
    
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(String codTecnico) {
        this.codTecnico = codTecnico;
    }
    
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
}
