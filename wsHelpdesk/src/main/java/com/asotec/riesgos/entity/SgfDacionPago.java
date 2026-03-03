/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "sgf_dacion_pago",
        schema = "public")
public class SgfDacionPago implements Serializable{
    //Revisar clave rpimaria compusta: numOperacion, tipoIdentificacionSujeto, idSujeto, codBienTitulo
    private String numOperacion;
    private String tipoIdentificacionSujeto; 
    private String idSujeto;
    private String codBienTitulo;
    private long codTipoBien; 
    private String nombreEmisor;
    private Date fecEmision;
    private Date fecVencimiento;
    private double valNominal;
    private Date fecContabilizacion;
    private double valLibros;
    private double valUltimoAvaluo;
    private double valProvisionConstituida;
    private Date fecRealizacion;
    private double valRealizacion; 
    private String codEstado;

    public SgfDacionPago() {
    }

    public SgfDacionPago(String numOperacion, String tipoIdentificacionSujeto, String idSujeto, String codBienTitulo, long codTipoBien, String nombreEmisor, Date fecEmision, Date fecVencimiento, double valNominal, Date fecContabilizacion, double valLibros, double valUltimoAvaluo, double valProvisionConstituida, Date fecRealizacion, double valRealizacion, String codEstado) {
        this.numOperacion = numOperacion;
        this.tipoIdentificacionSujeto = tipoIdentificacionSujeto;
        this.idSujeto = idSujeto;
        this.codBienTitulo = codBienTitulo;
        this.codTipoBien = codTipoBien;
        this.nombreEmisor = nombreEmisor;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.valNominal = valNominal;
        this.fecContabilizacion = fecContabilizacion;
        this.valLibros = valLibros;
        this.valUltimoAvaluo = valUltimoAvaluo;
        this.valProvisionConstituida = valProvisionConstituida;
        this.fecRealizacion = fecRealizacion;
        this.valRealizacion = valRealizacion;
        this.codEstado = codEstado;
    }


    @Id
    @Column(name = "num_operacion", length = 32)
    public String getNumOperacion() {
        return numOperacion;
    }

    public void setNumOperacion(String numOperacion) {
        this.numOperacion = numOperacion;
    }

    @Column(name = "tipo_identificacion_sujeto", length = 1)
    public String getTipoIdentificacionSujeto() {
        return tipoIdentificacionSujeto;
    }

    public void setTipoIdentificacionSujeto(String tipoIdentificacionSujeto) {
        this.tipoIdentificacionSujeto = tipoIdentificacionSujeto;
    }

    @Column(name = "id_sujeto", length = 15)
    public String getIdSujeto() {
        return idSujeto;
    }

    public void setIdSujeto(String idSujeto) {
        this.idSujeto = idSujeto;
    }

    @Column(name = "cod_bien_titulo", length = 20)
    public String getCodBienTitulo() {
        return codBienTitulo;
    }

    public void setCodBienTitulo(String codBienTitulo) {
        this.codBienTitulo = codBienTitulo;
    }

    @Column(name = "cod_tipo_bien", precision = 3, scale = 0)
    public long getCodTipoBien() {
        return codTipoBien;
    }

    public void setCodTipoBien(long codTipoBien) {
        this.codTipoBien = codTipoBien;
    }

    @Column(name = "nombre_emisor", length = 40)
    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    @Column(name = "fec_emision")
    @Temporal(TemporalType.DATE)
    public Date getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(Date fecEmision) {
        this.fecEmision = fecEmision;
    }

    @Column(name = "fec_vencimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    @Column(name = "val_nominal", precision = 15, scale = 2)
    public double getValNominal() {
        return valNominal;
    }

    public void setValNominal(double valNominal) {
        this.valNominal = valNominal;
    }

    @Column(name = "fec_contabilizacion")
    @Temporal(TemporalType.DATE)
    public Date getFecContabilizacion() {
        return fecContabilizacion;
    }

    public void setFecContabilizacion(Date fecContabilizacion) {
        this.fecContabilizacion = fecContabilizacion;
    }

    @Column(name = "val_libros", precision = 15, scale = 2)
    public double getValLibros() {
        return valLibros;
    }

    public void setValLibros(double valLibros) {
        this.valLibros = valLibros;
    }

    @Column(name = "val_ultimo_avaluo", precision = 15, scale = 2)
    public double getValUltimoAvaluo() {
        return valUltimoAvaluo;
    }

    public void setValUltimoAvaluo(double valUltimoAvaluo) {
        this.valUltimoAvaluo = valUltimoAvaluo;
    }

    @Column(name = "val_provision_constituida", precision = 15, scale = 2)
    public double getValProvisionConstituida() {
        return valProvisionConstituida;
    }

    public void setValProvisionConstituida(double valProvisionConstituida) {
        this.valProvisionConstituida = valProvisionConstituida;
    }

    @Column(name = "fec_realizacion")
    @Temporal(TemporalType.DATE)
    public Date getFecRealizacion() {
        return fecRealizacion;
    }

    public void setFecRealizacion(Date fecRealizacion) {
        this.fecRealizacion = fecRealizacion;
    }

    @Column(name = "val_realizacion", precision = 15, scale = 2)
    public double getValRealizacion() {
        return valRealizacion;
    }

    public void setValRealizacion(double valRealizacion) {
        this.valRealizacion = valRealizacion;
    }

    @Column(name = "cod_estado", length = 1)
    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }
    
}
