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
import javax.persistence.Basic;
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
@Table(name = "sgf_inversiones",
        schema = "public")
public class SgfInversiones implements Serializable{
    private SgfInversionesId id;
    private long numPlazo;
    private long codInstrumentoInv;
    private long codPais;
    private double valNominal;
    private double valCompra;
    private String clasifEmisorDepositario;
    private long codTipoEmisorDepositarioInv; 
    private Date fecVencimiento;
    private long codCalificacionRiesgoInv;
    private long codCalificadoraRiesgoInv;
    private Date fecUltimaCalificacion;
    private String codCuentaContable;
    private double valLibros;
    private long codStsTituloInv;
    private double valTasaInteresNominal;
    private double valInteresGenerado;
    private long codCalifRiesgoNormativaInv;
    private double valProvisionConstituida;

    public SgfInversiones() {
    }

    public SgfInversiones(SgfInversionesId id) {
        this.id = id;
    }

    public SgfInversiones(String numDeposito, long codBanco, Date fecDeposito, Date fecCompra) {
        this.id = new SgfInversionesId(numDeposito, codBanco, fecDeposito, fecCompra);
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "num_deposito", column = @Column(name = "num_deposito", unique = false, nullable = false)),
        @AttributeOverride(name = "cod_banco", column = @Column(name = "cod_banco", nullable = false, precision = 2, scale = 0)),
        @AttributeOverride(name = "fec_deposito", column = @Column(name = "fec_deposito", nullable = false)),
        @AttributeOverride(name = "fec_compra", column = @Column(name = "fec_compra", nullable = false)),
    })

    @Id
    public SgfInversionesId getId() {
        return id;
    }

    public void setId(SgfInversionesId id) {
        this.id = id;
    }

    @Column(name = "num_plazo", precision = 4, scale = 0)
    public long getNumPlazo() {
        return numPlazo;
    }

    public void setNumPlazo(long numPlazo) {
        this.numPlazo = numPlazo;
    }

    @Column(name = "cod_instrumento_inv", precision = 2, scale = 0)
    public long getCodInstrumentoInv() {
        return codInstrumentoInv;
    }

    public void setCodInstrumentoInv(long codInstrumentoInv) {
        this.codInstrumentoInv = codInstrumentoInv;
    }

    @Column(name = "cod_pais", precision = 2, scale = 0)
    public long getCodPais() {
        return codPais;
    }

    public void setCodPais(long codPais) {
        this.codPais = codPais;
    }

    @Column(name = "val_nominal", precision = 18, scale = 2)
    public double getValNominal() {
        return valNominal;
    }

    public void setValNominal(double valNominal) {
        this.valNominal = valNominal;
    }

    @Column(name = "val_compra", precision = 18, scale = 2)
    public double getValCompra() {
        return valCompra;
    }

    public void setValCompra(double valCompra) {
        this.valCompra = valCompra;
    }

    @Column(name = "clasif_emisor_depositario", length = 2)
    public String getClasifEmisorDepositario() {
        return clasifEmisorDepositario;
    }

    public void setClasifEmisorDepositario(String clasifEmisorDepositario) {
        this.clasifEmisorDepositario = clasifEmisorDepositario;
    }

    @Column(name = "cod_tipo_emisor_depositario_inv", precision = 2, scale = 0)
    public long getCodTipoEmisorDepositarioInv() {
        return codTipoEmisorDepositarioInv;
    }

    public void setCodTipoEmisorDepositarioInv(long codTipoEmisorDepositarioInv) {
        this.codTipoEmisorDepositarioInv = codTipoEmisorDepositarioInv;
    }

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "fec_vencimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    @Column(name = "cod_calificacion_riesgo_inv", precision = 2, scale = 0)
    public long getCodCalificacionRiesgoInv() {
        return codCalificacionRiesgoInv;
    }

    public void setCodCalificacionRiesgoInv(long codCalificacionRiesgoInv) {
        this.codCalificacionRiesgoInv = codCalificacionRiesgoInv;
    }

    @Column(name = "cod_calificadora_riesgo_inv", precision = 3, scale = 0)
    public long getCodCalificadoraRiesgoInv() {
        return codCalificadoraRiesgoInv;
    }

    public void setCodCalificadoraRiesgoInv(long codCalificadoraRiesgoInv) {
        this.codCalificadoraRiesgoInv = codCalificadoraRiesgoInv;
    }

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "fec_ultima_calificacion")
    @Temporal(TemporalType.DATE)
    public Date getFecUltimaCalificacion() {
        return fecUltimaCalificacion;
    }

    public void setFecUltimaCalificacion(Date fecUltimaCalificacion) {
        this.fecUltimaCalificacion = fecUltimaCalificacion;
    }

    @Column(name = "cod_cuenta_contable", length = 25)
    public String getCodCuentaContable() {
        return codCuentaContable;
    }

    public void setCodCuentaContable(String codCuentaContable) {
        this.codCuentaContable = codCuentaContable;
    }

    @Column(name = "val_libros", precision = 15, scale = 2)
    public double getValLibros() {
        return valLibros;
    }

    public void setValLibros(double valLibros) {
        this.valLibros = valLibros;
    }

    @Column(name = "cod_sts_titulo_inv", precision = 2, scale = 0)
    public long getCodStsTituloInv() {
        return codStsTituloInv;
    }

    public void setCodStsTituloInv(long codStsTituloInv) {
        this.codStsTituloInv = codStsTituloInv;
    }


    @Column(name = "val_tasa_interes_nominal", precision = 18, scale = 5)
    public double getValTasaInteresNominal() {
        return valTasaInteresNominal;
    }

    public void setValTasaInteresNominal(double valTasaInteresNominal) {
        this.valTasaInteresNominal = valTasaInteresNominal;
    }

    @Column(name = "val_interes_generado", precision = 15, scale = 2)
    public double getValInteresGenerado() {
        return valInteresGenerado;
    }

    public void setValInteresGenerado(double valInteresGenerado) {
        this.valInteresGenerado = valInteresGenerado;
    }

    @Column(name = "cod_calif_riesgo_normativa_inv", precision = 2, scale = 0)
    public long getCodCalifRiesgoNormativaInv() {
        return codCalifRiesgoNormativaInv;
    }

    public void setCodCalifRiesgoNormativaInv(long codCalifRiesgoNormativaInv) {
        this.codCalifRiesgoNormativaInv = codCalifRiesgoNormativaInv;
    }

    @Column(name = "val_provision_constituida", precision = 15, scale = 2)
    public double getValProvisionConstituida() {
        return valProvisionConstituida;
    }

    public void setValProvisionConstituida(double valProvisionConstituida) {
        this.valProvisionConstituida = valProvisionConstituida;
    }




}
