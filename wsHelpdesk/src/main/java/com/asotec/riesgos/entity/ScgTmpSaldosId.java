/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author josesanchez
 */
@Embeddable
public class ScgTmpSaldosId implements Serializable {

    private String codUsr;
    private Long codReporte;
    private String codCuenta;
    private Long codMoneda;
    public ScgTmpSaldosId() {
    }

    public ScgTmpSaldosId(String codUsr, Long codReporte, String codCuenta, Long codMoneda) {
        this.codUsr = codUsr;
        this.codReporte = codReporte;
        this.codCuenta = codCuenta;
        this.codMoneda = codMoneda;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_usr", nullable = false, length = 8)
    public String getCodUsr() {
        return codUsr;
    }

    public void setCodUsr(String codUsr) {
        this.codUsr = codUsr;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_reporte", nullable = false)
    public Long getCodReporte() {
        return codReporte;
    }

    public void setCodReporte(Long codReporte) {
        this.codReporte = codReporte;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_cuenta", nullable = false, length = 20)
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_moneda", nullable = false)
    public Long getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(Long codMoneda) {
        this.codMoneda = codMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codReporte);
        hash = 67 * hash + Objects.hashCode(this.codMoneda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScgTmpSaldosId other = (ScgTmpSaldosId) obj;
        if (!Objects.equals(this.codReporte, other.codReporte)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "com.asotec.riesgos.entity.ScgTmpSaldosPK[ codUsr=" + codUsr + ", codReporte=" + codReporte + ", codCuenta=" + codCuenta + ", codMoneda=" + codMoneda + " ]";
    }

}
