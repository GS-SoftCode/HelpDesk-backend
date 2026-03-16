/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASOTEC
 */
@Entity
@Table(name = "sgt_ticket",
        schema = "public")
public class SgtTicket implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ticket")
    private long codTicket;
    @Column(name = "cod_empresa", precision = 10, scale = 0)
    private long codEmpresa;
    @Column(name = "txt_titulo", length = 100)
    private String txtTitulo;
    @Column(name = "txt_desc", length = 2000)
    private String txtDesc;
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fecCreacion;
    @Column(name = "cod_cliente", length = 20)
    private String codCliente;
    @Column(name = "cod_tecnico", length = 20)
    private String codTecnico;
    @Column(name = "cod_estado", precision = 2, scale = 0)
    private long codEstado;
    @Column(name = "tfno_cliente", length = 10)
    private String tfnoCliente;
    @Column(name = "type_remote", length = 30)
    private String typeRemote;
    @Column(name = "cod_remote", length = 20)
    private String codRemote;
    @Column(name = "pass_remote", length = 20)
    private String passRemote;

    public SgtTicket() {}
    public SgtTicket(long codTicket, String txtTitulo, String txtDesc, Date fecCreacion, String codCliente, String codTecnico, long codEstado, long codEmpresa) {
        this.codTicket = codTicket;
        this.txtTitulo = txtTitulo;
        this.txtDesc = txtDesc;
        this.fecCreacion = fecCreacion;
        this.codCliente = codCliente;
        this.codTecnico = codTecnico;
        this.codEstado = codEstado;
        this.codEmpresa = codEmpresa;
        this.tfnoCliente = tfnoCliente;
        this.typeRemote = typeRemote;
        this.codRemote = codRemote;
        this.passRemote = passRemote;
    }
    
    public long getCodTicket() {
        return codTicket;
    }

    public void setCodTicket(long codTicket) {
        this.codTicket = codTicket;
    }

    public String getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(String txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public String getTxtDesc() {
        return txtDesc;
    }

    public void setTxtDesc(String txtDesc) {
        this.txtDesc = txtDesc;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }
    
    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(String codTecnico) {
        this.codTecnico = codTecnico;
    }

    public long getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(long codEstado) {
        this.codEstado = codEstado;
    }
    
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getTfnoCliente() {
        return tfnoCliente;
    }

    public void setTfnoCliente(String tfnoCliente) {
        this.tfnoCliente = tfnoCliente;
    }

    public String getTypeRemote() {
        return typeRemote;
    }

    public void setTypeRemote(String typeRemote) {
        this.typeRemote = typeRemote;
    }

    public String getCodRemote() {
        return codRemote;
    }

    public void setCodRemote(String codRemote) {
        this.codRemote = codRemote;
    }

    public String getPassRemote() {
        return passRemote;
    }

    public void setPassRemote(String passRemote) {
        this.passRemote = passRemote;
    }
    
}