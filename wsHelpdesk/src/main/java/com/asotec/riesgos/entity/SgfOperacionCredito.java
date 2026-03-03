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
@Table(name = "tmp_sgf_oper_credito",
        schema = "public")
public class SgfOperacionCredito implements Serializable{
    private long id;//id integer NOT NULL DEFAULT nextval('tmp_sgf_oper_credito_id_seq'::regclass),
    private String codTipoId;//cod_tipo_id character(1),
    private String numId;// character varying(20) NOT NULL,
    private String stsSexo;// character(1),
    private Date fecNacimiento;//fec_nacimiento date,
    private long codCuenta;//cod_cuenta numeric(20,0) NOT NULL,
    private Date fecPrestamo;//fec_prestamo date,
    private Date fecVencimiento;//fec_vencimiento date,
    private String codTipoCreditoHomologado;//cod_tipo_credito_homologado character varying(2),
    private String stsOperacion;//sts_operacion character(1),
    private long codProvincia;//cod_provincia numeric(3,0),
    private long codCanton;//cod_canton numeric(4,0),
    private String codParroquia;//cod_parroquia character varying,
    private long codValSaldo;//cod_val_saldo numeric,
    private long codOficina;//cod_oficina numeric(2,0) NOT NULL,
    private long codTipoCredito;//cod_tipo_credito
    private long numDias;// num_dias
    private String codCuentaContable;//cod_cuenta_contable character varying,

    private String stsCliente;

    public SgfOperacionCredito() {
    }

    public SgfOperacionCredito(long id, String codTipoId, String numId, String stsSexo, Date fecNacimiento, long codCuenta, Date fecPrestamo, Date fecVencimiento, String codTipoCreditoHomologado, String stsOperacion, long codProvincia, long codCanton, String codParroquia, long codValSaldo, long codOficina, long codTipoCredito, long numDias, String codCuentaContable, String stsCliente) {
        this.id = id;
        this.codTipoId = codTipoId;
        this.numId = numId;
        this.stsSexo = stsSexo;
        this.fecNacimiento = fecNacimiento;
        this.codCuenta = codCuenta;
        this.fecPrestamo = fecPrestamo;
        this.fecVencimiento = fecVencimiento;
        this.codTipoCreditoHomologado = codTipoCreditoHomologado;
        this.stsOperacion = stsOperacion;
        this.codProvincia = codProvincia;
        this.codCanton = codCanton;
        this.codParroquia = codParroquia;
        this.codValSaldo = codValSaldo;
        this.codOficina = codOficina;
        this.codTipoCredito = codTipoCredito;
        this.numDias = numDias;
        this.codCuentaContable = codCuentaContable;
        this.stsCliente = stsCliente;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "cod_tipo_id", length = 1)
    public String getCodTipoId() {
        return codTipoId;
    }

    public void setCodTipoId(String codTipoId) {
        this.codTipoId = codTipoId;
    }

    @Column(name = "num_id", length = 20)
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "sts_sexo", length = 1)
    public String getStsSexo() {
        return stsSexo;
    }

    public void setStsSexo(String stsSexo) {
        this.stsSexo = stsSexo;
    }

    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Column(name = "cod_cuenta", precision = 20, scale = 0)
    public long getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(long codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Column(name = "fec_prestamo")
    @Temporal(TemporalType.DATE)
    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrestamo) {
        this.fecPrestamo = fecPrestamo;
    }

    @Column(name = "fec_vencimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    @Column(name = "cod_tipo_credito_homologado", length = 2)
    public String getCodTipoCreditoHomologado() {
        return codTipoCreditoHomologado;
    }

    public void setCodTipoCreditoHomologado(String codTipoCreditoHomologado) {
        this.codTipoCreditoHomologado = codTipoCreditoHomologado;
    }

    @Column(name = "sts_operacion", length = 1)
    public String getStsOperacion() {
        return stsOperacion;
    }

    public void setStsOperacion(String stsOperacion) {
        this.stsOperacion = stsOperacion;
    }

    @Column(name = "cod_provincia", precision = 3, scale = 0)
    public long getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }

    @Column(name = "cod_canton", precision = 4, scale = 0)
    public long getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(long codCanton) {
        this.codCanton = codCanton;
    }

    @Column(name = "cod_parroquia")
    public String getCodParroquia() {
        return codParroquia;
    }

    public void setCodParroquia(String codParroquia) {
        this.codParroquia = codParroquia;
    }

    @Column(name = "cod_val_saldo")
    public long getCodValSaldo() {
        return codValSaldo;
    }

    public void setCodValSaldo(long codValSaldo) {
        this.codValSaldo = codValSaldo;
    }

    @Column(name = "cod_oficina", precision = 2, scale = 0)
    public long getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(long codOficina) {
        this.codOficina = codOficina;
    }

    @Column(name = "cod_cuenta_contable")
    public String getCodCuentaContable() {
        return codCuentaContable;
    }

    public void setCodCuentaContable(String codCuentaContable) {
        this.codCuentaContable = codCuentaContable;
    }

    @Column(name = "cod_tipo_credito", precision = 2, scale = 0)
    public long getCodTipoCredito() {
        return codTipoCredito;
    }

    public void setCodTipoCredito(long codTipoCredito) {
        this.codTipoCredito = codTipoCredito;
    }

    @Column(name = "num_dias")
    public long getNumDias() {
        return numDias;
    }

    public void setNumDias(long numDias) {
        this.numDias = numDias;
    }
    
    @Column(name = "sts_cliente", length = 2)
    public String getStsCliente() {
        return stsCliente;
    }

    public void setStsCliente(String stsCliente) {
        this.stsCliente = stsCliente;
    }

}
