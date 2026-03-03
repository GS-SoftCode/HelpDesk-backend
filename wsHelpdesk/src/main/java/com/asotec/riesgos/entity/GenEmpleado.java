/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author josesanchez
 */
@Entity
@Table(name = "gen_empleado",
        schema = "public")
public class GenEmpleado implements Serializable {
    
    private Long codEmpleado;
    private String nomEmpleado;
    private String codTipoId;
    private String numId;
    private Long numAfiliacionIess;
    private String stsSexo;
    private String stsEstadoCivil;
    private Date fecNacimiento;
    private String txtDireccion;
    private Long numTelefono;
    private String codCargoActual;
    private Long codAgencia;
    private String codTipoRelacion;
    private String codTipoPago;
    private Long codBanco;
    private String numCuenta;
    private String codTipoCuenta;
    private Long codProyecto;
    private Long codFinanciera;
    private Long codPartida;
    private String codCuentaGasto;
    private String codCuentaBanco;
    private String stsEmpleado;
    private String codGrupo;
    private BigDecimal valSueldoBasico;
    private Long codHorario;
    private byte[] imgFoto;
    private Character stsCalHExtras;
    private Character stsControlAsistencia;
    private Long codOficina;
    private Date fecEntrada;
    private GenDepartamento codDepartamento;

    public GenEmpleado() {
    }

    public GenEmpleado(Long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public GenEmpleado(Long codEmpleado, String codTipoRelacion) {
        this.codEmpleado = codEmpleado;
        this.codTipoRelacion = codTipoRelacion;
    }

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_empleado")
    public Long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    @Column(name = "nom_empleado")
    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    @Column(name = "cod_tipo_id")
    public String getCodTipoId() {
        return codTipoId;
    }

    public void setCodTipoId(String codTipoId) {
        this.codTipoId = codTipoId;
    }

    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "num_afiliacion_iess")
    public Long getNumAfiliacionIess() {
        return numAfiliacionIess;
    }

    public void setNumAfiliacionIess(Long numAfiliacionIess) {
        this.numAfiliacionIess = numAfiliacionIess;
    }

    @Column(name = "sts_sexo")
    public String getStsSexo() {
        return stsSexo;
    }

    public void setStsSexo(String stsSexo) {
        this.stsSexo = stsSexo;
    }

    @Column(name = "sts_estado_civil")
    public String getStsEstadoCivil() {
        return stsEstadoCivil;
    }

    public void setStsEstadoCivil(String stsEstadoCivil) {
        this.stsEstadoCivil = stsEstadoCivil;
    }

    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Column(name = "txt_direccion")
    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    @Column(name = "num_telefono")
    public Long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Long numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Column(name = "cod_cargo_actual")
    public String getCodCargoActual() {
        return codCargoActual;
    }

    public void setCodCargoActual(String codCargoActual) {
        this.codCargoActual = codCargoActual;
    }

    @Column(name = "cod_agencia")
    public Long getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(Long codAgencia) {
        this.codAgencia = codAgencia;
    }

    @Basic(optional = false)
    @Column(name = "cod_tipo_relacion")
    public String getCodTipoRelacion() {
        return codTipoRelacion;
    }

    public void setCodTipoRelacion(String codTipoRelacion) {
        this.codTipoRelacion = codTipoRelacion;
    }

    @Column(name = "cod_tipo_pago")
    public String getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(String codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    @Column(name = "cod_banco")
    public Long getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Long codBanco) {
        this.codBanco = codBanco;
    }

    @Column(name = "num_cuenta")
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Column(name = "cod_tipo_cuenta")
    public String getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(String codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    @Column(name = "cod_proyecto")
    public Long getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Long codProyecto) {
        this.codProyecto = codProyecto;
    }

    @Column(name = "cod_financiera")
    public Long getCodFinanciera() {
        return codFinanciera;
    }

    public void setCodFinanciera(Long codFinanciera) {
        this.codFinanciera = codFinanciera;
    }

    @Column(name = "cod_partida")
    public Long getCodPartida() {
        return codPartida;
    }

    public void setCodPartida(Long codPartida) {
        this.codPartida = codPartida;
    }

    @Column(name = "cod_cuenta_gasto")
    public String getCodCuentaGasto() {
        return codCuentaGasto;
    }

    public void setCodCuentaGasto(String codCuentaGasto) {
        this.codCuentaGasto = codCuentaGasto;
    }

    @Column(name = "cod_cuenta_banco")
    public String getCodCuentaBanco() {
        return codCuentaBanco;
    }

    public void setCodCuentaBanco(String codCuentaBanco) {
        this.codCuentaBanco = codCuentaBanco;
    }

    @Column(name = "sts_empleado")
    public String getStsEmpleado() {
        return stsEmpleado;
    }

    public void setStsEmpleado(String stsEmpleado) {
        this.stsEmpleado = stsEmpleado;
    }

    @Column(name = "cod_grupo")
    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    @Column(name = "val_sueldo_basico")
    public BigDecimal getValSueldoBasico() {
        return valSueldoBasico;
    }

    public void setValSueldoBasico(BigDecimal valSueldoBasico) {
        this.valSueldoBasico = valSueldoBasico;
    }

    @Column(name = "cod_horario")
    public Long getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(Long codHorario) {
        this.codHorario = codHorario;
    }

    @Lob
    @Column(name = "img_foto")
    public byte[] getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(byte[] imgFoto) {
        this.imgFoto = imgFoto;
    }

    @Column(name = "sts_cal_h_extras")
    public Character getStsCalHExtras() {
        return stsCalHExtras;
    }

    public void setStsCalHExtras(Character stsCalHExtras) {
        this.stsCalHExtras = stsCalHExtras;
    }

    @Column(name = "sts_control_asistencia")
    public Character getStsControlAsistencia() {
        return stsControlAsistencia;
    }

    public void setStsControlAsistencia(Character stsControlAsistencia) {
        this.stsControlAsistencia = stsControlAsistencia;
    }

    @Column(name = "cod_oficina")
    public Long getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(Long codOficina) {
        this.codOficina = codOficina;
    }

    @Column(name = "fec_entrada")
    @Temporal(TemporalType.DATE)
    public Date getFecEntrada() {
        return fecEntrada;
    }

    public void setFecEntrada(Date fecEntrada) {
        this.fecEntrada = fecEntrada;
    }

    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne(fetch = FetchType.EAGER)
    public GenDepartamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(GenDepartamento codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpleado != null ? codEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenEmpleado)) {
            return false;
        }
        GenEmpleado other = (GenEmpleado) object;
        if ((this.codEmpleado == null && other.codEmpleado != null) || (this.codEmpleado != null && !this.codEmpleado.equals(other.codEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asotec.riesgos.entity.GenEmpleado[ codEmpleado=" + codEmpleado + " ]";
    }
    
}
