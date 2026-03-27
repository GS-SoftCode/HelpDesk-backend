/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "sgt_cliente",
        schema = "public")
public class SgtCliente implements Serializable{
    @Id
    @Column(name = "cod_cliente", precision = 10, scale = 0) 
    private long codCliente;
    @Column(name = "cod_empresa", precision = 10, scale = 0)
    private long codEmpresa;
    @Column(name = "nom_cliente_rep", length = 150)
    private String nomClienteRep;
    @Column(name = "ape_cliente_rep", length = 150)
    private String apeClienteRep;
    @Column(name = "dir_email", length = 100)
    private String dirEmail;
    @Column(name = "sts_cliente", length = 1, columnDefinition = "DEFAULT 'A'")
    private String stsCliente;
    @Column(name = "num_id", length = 20)
    private String numId;
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fecRegistro;
    @Column(name = "num_celular", length = 20)
    private String numCelular;
    @Column(name = "nom_cliente", length = 150)
    private String nomCliente;

    public SgtCliente() {
    }

    public SgtCliente(long codCliente, long codEmpresa, String nomClienteRep, String apeClienteRep, String dirEmail, String stsCliente, String numId, Date fecRegistro, String numCelular, String nomCliente) {
        this.codCliente = codCliente;
        this.codEmpresa = codEmpresa;
        this.nomClienteRep = nomClienteRep;
        this.apeClienteRep = apeClienteRep;
        this.dirEmail = dirEmail;
        this.stsCliente = stsCliente;
        this.numId = numId;
        this.fecRegistro = fecRegistro;
        this.numCelular = numCelular;
        this.nomCliente = nomCliente;
    }
    
    @PrePersist
    protected void onCreate() {
        fecRegistro = new Date();
    }
    
    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomClienteRep() {
        return nomClienteRep;
    }

    public void setNomClienteRep(String nomClienteRep) {
        this.nomClienteRep = nomClienteRep;
    }

    public String getApeClienteRep() {
        return apeClienteRep;
    }

    public void setApeClienteRep(String apeClienteRep) {
        this.apeClienteRep = apeClienteRep;
    }

    public String getDirEmail() {
        return dirEmail;
    }

    public void setDirEmail(String dirEmail) {
        this.dirEmail = dirEmail;
    }

    public String getStsCliente() {
        return stsCliente;
    }

    public void setStsCliente(String stsCliente) {
        this.stsCliente = stsCliente;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }
}
