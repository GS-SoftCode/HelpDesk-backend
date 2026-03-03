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
@Table(name = "gen_empresa",
        schema = "public")
public class SgtEmpresa implements Serializable{
    @Id
    @Column(name = "cod_empresa", precision = 10, scale = 0) 
    private long codEmpresa;
    @Column(name = "nom_empresa", length = 150)
    private String nomEmpresa;
    @Column(name = "nom_abreviado", length = 100)
    private String nomAbreviado;
    @Column(name = "num_ruc", length = 20)
    private String nomRuc;
    @Column(name = "dir_email", length = 100)
    private String dirEmail;
    @Column(name = "sts_empresa", length = 1, columnDefinition = "DEFAULT 'A'")
    private String stsEmpresa;
    @Column(name = "sts_soporte", length = 1, columnDefinition = "DEFAULT 'A'")
    private String stsSoporte;
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fecRegistro;
    @Column(name = "fec_usrmod")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fecUsrmod;
    @Column(name = "ruta_reporte", length = 100)
    private String rutaReporte;

    public SgtEmpresa() {
    }

    public SgtEmpresa(long codEmpresa, String nomEmpresa, String nomAbreviado, String nomRuc, String dirEmail, String stsEmpresa, String stsSoporte, Date fecRegistro, Date fecUsrmod, String rutaReporte) {
        this.codEmpresa = codEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.nomAbreviado = nomAbreviado;
        this.nomRuc = nomRuc;
        this.dirEmail = dirEmail;
        this.stsEmpresa = stsEmpresa;
        this.stsSoporte = stsSoporte;
        this.fecRegistro = fecRegistro;
        this.fecUsrmod = fecUsrmod;
        this.rutaReporte = rutaReporte;
    }
    
    @PrePersist
    protected void onCreate() {
        fecRegistro = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        fecUsrmod = new Date();
    }
    
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNomAbreviado() {
        return nomAbreviado;
    }

    public void setNomAbreviado(String nomAbreviado) {
        this.nomAbreviado = nomAbreviado;
    }

    public String getNomRuc() {
        return nomRuc;
    }

    public void setNomRuc(String nomRuc) {
        this.nomRuc = nomRuc;
    }

    public String getDirEmail() {
        return dirEmail;
    }

    public void setDirEmail(String dirEmail) {
        this.dirEmail = dirEmail;
    }

    public String getStsEmpresa() {
        return stsEmpresa;
    }

    public void setStsEmpresa(String stsEmpresa) {
        this.stsEmpresa = stsEmpresa;
    }

    public String getStsSoporte() {
        return stsSoporte;
    }

    public void setStsSoporte(String stsSoporte) {
        this.stsSoporte = stsSoporte;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecUsrmod() {
        return fecUsrmod;
    }

    public void setFecUsrmod(Date fecUsrmod) {
        this.fecUsrmod = fecUsrmod;
    }

    public String getRutaReporte() {
        return rutaReporte;
    }

    public void setRutaReporte(String rutaReporte) {
        this.rutaReporte = rutaReporte;
    }
    
}
