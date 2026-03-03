/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "sgf_reclamos",
        schema = "public")
public class SgfReclamos implements Serializable{
    private SgfReclamosId id;
    private String canalReclamo;
    private Date fecReclamo;
    private String tipoTransaccion;
    private String concepto; 
    private String stsReclamo; 
    private Date fecRespuestaReclamo;
    private String tipoResolucionReclamo;
    private double valRestituido;
    private double valInteresRestituido;
    private double valTotalRestituido;

    public SgfReclamos() {
    }

    public SgfReclamos(SgfReclamosId id) {
        this.id = id;
    }

    public SgfReclamos(long numReclamo, long codSocio) {
        this.id = new SgfReclamosId(numReclamo, codSocio);
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "numReclamo", column = @Column(name = "num_reclamo", unique = false, nullable = false)),
        @AttributeOverride(name = "codSocio", column = @Column(name = "cod_socio", nullable = false)),
    })

    @Id
    public SgfReclamosId getId() {
        return id;
    }

    public void setId(SgfReclamosId id) {
        this.id = id;
    }

    @Column(name = "canal_reclamo", length = 25)
    public String getCanalReclamo() {
        return canalReclamo;
    }

    public void setCanalReclamo(String canalReclamo) {
        this.canalReclamo = canalReclamo;
    }

    @Column(name = "fec_reclamo")
    @Temporal(TemporalType.DATE)
    public Date getFecReclamo() {
        return fecReclamo;
    }

    public void setFecReclamo(Date fecReclamo) {
        this.fecReclamo = fecReclamo;
    }

    @Column(name = "tipo_transaccion", length = 1)
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Column(name = "concepto", length = 50)
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Column(name = "sts_reclamo", length = 1)
    public String getStsReclamo() {
        return stsReclamo;
    }

    public void setStsReclamo(String stsReclamo) {
        this.stsReclamo = stsReclamo;
    }

    @Column(name = "fec_respuesta_reclamo")
    @Temporal(TemporalType.DATE)
    public Date getFecRespuestaReclamo() {
        return fecRespuestaReclamo;
    }

    public void setFecRespuestaReclamo(Date fecRespuestaReclamo) {
        this.fecRespuestaReclamo = fecRespuestaReclamo;
    }

    @Column(name = "tipo_resolucion_reclamo", length = 25)
    public String getTipoResolucionReclamo() {
        return tipoResolucionReclamo;
    }

    public void setTipoResolucionReclamo(String tipoResolucionReclamo) {
        this.tipoResolucionReclamo = tipoResolucionReclamo;
    }

    @Column(name = "val_restituido", precision = 15, scale = 2)
    public double getValRestituido() {
        return valRestituido;
    }

    public void setValRestituido(double valRestituido) {
        this.valRestituido = valRestituido;
    }


    @Column(name = "val_interes_restituido", precision = 15, scale = 2)
    public double getValInteresRestituido() {
        return valInteresRestituido;
    }

    public void setValInteresRestituido(double valInteresRestituido) {
        this.valInteresRestituido = valInteresRestituido;
    }

    @Column(name = "val_total_restituido", precision = 15, scale = 2)
    public double getValTotalRestituido() {
        return valTotalRestituido;
    }

    public void setValTotalRestituido(double valTotalRestituido) {
        this.valTotalRestituido = valTotalRestituido;
    }

}
