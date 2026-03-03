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
@Table(name = "tmp_sgf_prod_finan",
        schema = "public")
public class SgfProductoFinanciero implements Serializable{
    private long id;//    id integer
    private String codTipoId;//cod_tipo_id character(1),
    private String numId;//num_id character varying(20) NOT NULL,
    private Date fecNacimiento;//fec_nacimiento date,
    private String stsSexo;//sts_sexo character(1),
    private long codProducto;//cod_producto numeric(2,0) NOT NULL,
    private long codCuenta;//cod_cuenta numeric(20,0) NOT NULL,
    private long codValSaldo;//cod_val_saldo numeric(2,0),
    private long codProvincia;//cod_provincia numeric(3,0),
    private long codCanton;//cod_canton numeric(4,0),
    private String codParroquia;//cod_parroquia character varying,
    private String stsTipoCuenta;//sts_tipo_cuenta character varying(1),
    private String codTipoProducto;//cod_tipo_producto character varying(2),
    private Date fecApertura;//fec_apertura date,
    private long codStsCuenta;//cod_sts_cuenta numeric(2,0),
    private Date fecUltMovimiento;//fec_ult_movimiento date,
    private Date fecCierre;//fec_cierre date,
    private long codCausalesCierre;//cod_causales_cierre numeric(2,0),
    private long codOficina;//cod_oficina numeric(2,0) NOT NULL,
    private String codTipoPersona;//cod_tipo_persona character(1),
    private String codCuentaContable; //cod_cuenta_contable character varying,
    private long numPlazo;//num_plazo numeric,
    private Date fecVencimiento;//fec_vencimiento date,
    
    private String stsCliente;

    public SgfProductoFinanciero() {
    }

    public SgfProductoFinanciero(long id, String codTipoId, String numId, Date fecNacimiento, String stsSexo, long codProducto, long codCuenta, long codValSaldo, long codProvincia, long codCanton, String codParroquia, String stsTipoCuenta, String codTipoProducto, Date fecApertura, long codStsCuenta, Date fecUltMovimiento, Date fecCierre, long codCausalesCierre, long codOficina, String codTipoPersona, String codCuentaContable, long numPlazo, Date fecVencimiento, String stsCliente) {
        this.id = id;
        this.codTipoId = codTipoId;
        this.numId = numId;
        this.fecNacimiento = fecNacimiento;
        this.stsSexo = stsSexo;
        this.codProducto = codProducto;
        this.codCuenta = codCuenta;
        this.codValSaldo = codValSaldo;
        this.codProvincia = codProvincia;
        this.codCanton = codCanton;
        this.codParroquia = codParroquia;
        this.stsTipoCuenta = stsTipoCuenta;
        this.codTipoProducto = codTipoProducto;
        this.fecApertura = fecApertura;
        this.codStsCuenta = codStsCuenta;
        this.fecUltMovimiento = fecUltMovimiento;
        this.fecCierre = fecCierre;
        this.codCausalesCierre = codCausalesCierre;
        this.codOficina = codOficina;
        this.codTipoPersona = codTipoPersona;
        this.codCuentaContable = codCuentaContable;
        this.numPlazo = numPlazo;
        this.fecVencimiento = fecVencimiento;
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

    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Column(name = "sts_sexo", length = 1)
    public String getStsSexo() {
        return stsSexo;
    }

    public void setStsSexo(String stsSexo) {
        this.stsSexo = stsSexo;
    }

    @Column(name = "cod_producto", precision = 2, scale = 0)
    public long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(long codProducto) {
        this.codProducto = codProducto;
    }

    @Column(name = "cod_cuenta", precision = 20, scale = 0)
    public long getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(long codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Column(name = "cod_val_saldo", precision = 2, scale = 0)
    public long getCodValSaldo() {
        return codValSaldo;
    }

    public void setCodValSaldo(long codValSaldo) {
        this.codValSaldo = codValSaldo;
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

    @Column(name = "sts_tipo_cuenta", length = 1)
    public String getStsTipoCuenta() {
        return stsTipoCuenta;
    }

    public void setStsTipoCuenta(String stsTipoCuenta) {
        this.stsTipoCuenta = stsTipoCuenta;
    }

    @Column(name = "cod_tipo_producto", length = 2)
    public String getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(String codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    @Column(name = "fec_apertura")
    @Temporal(TemporalType.DATE)
    public Date getFecApertura() {
        return fecApertura;
    }

    public void setFecApertura(Date fecApertura) {
        this.fecApertura = fecApertura;
    }

    @Column(name = "cod_sts_cuenta", precision = 2, scale = 0)
    public long getCodStsCuenta() {
        return codStsCuenta;
    }

    public void setCodStsCuenta(long codStsCuenta) {
        this.codStsCuenta = codStsCuenta;
    }

    @Column(name = "fec_ult_movimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecUltMovimiento() {
        return fecUltMovimiento;
    }

    public void setFecUltMovimiento(Date fecUltMovimiento) {
        this.fecUltMovimiento = fecUltMovimiento;
    }

    @Column(name = "fec_cierre")
    @Temporal(TemporalType.DATE)
    public Date getFecCierre() {
        return fecCierre;
    }

    public void setFecCierre(Date fecCierre) {
        this.fecCierre = fecCierre;
    }

    @Column(name = "cod_causales_cierre", precision = 2, scale = 0)
    public long getCodCausalesCierre() {
        return codCausalesCierre;
    }

    public void setCodCausalesCierre(long codCausalesCierre) {
        this.codCausalesCierre = codCausalesCierre;
    }

    @Column(name = "cod_oficina", precision = 2, scale = 0)
    public long getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(long codOficina) {
        this.codOficina = codOficina;
    }

    @Column(name = "cod_tipo_persona", length = 1)
    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }
    
    @Column(name = "cod_cuenta_contable")
    public String getCodCuentaContable() {
        return codCuentaContable;
    }

    public void setCodCuentaContable(String codCuentaContable) {
        this.codCuentaContable = codCuentaContable;
    }

    @Column(name = "num_plazo")
    public long getNumPlazo() {
        return numPlazo;
    }

    public void setNumPlazo(long numPlazo) {
        this.numPlazo = numPlazo;
    }

    @Column(name = "fec_vencimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }
    
    @Column(name = "sts_cliente", length = 2)
    public String getStsCliente() {
        return stsCliente;
    }

    public void setStsCliente(String stsCliente) {
        this.stsCliente = stsCliente;
    }
}
