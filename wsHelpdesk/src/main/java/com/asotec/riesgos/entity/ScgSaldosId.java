/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
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
public class ScgSaldosId implements Serializable {

    private String codCuenta;
    private long codAaa;
    private long codMes;
    private long codMoneda;

    public ScgSaldosId() {
    }

    public ScgSaldosId(String codCuenta, long codAaa, long codMes, long codMoneda) {
        this.codCuenta = codCuenta;
        this.codAaa = codAaa;
        this.codMes = codMes;
        this.codMoneda = codMoneda;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_cuenta", length = 20)
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_aaa", precision = 4, scale = 0)
    public long getCodAaa() {
        return codAaa;
    }

    public void setCodAaa(long codAaa) {
        this.codAaa = codAaa;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_mes", precision = 2, scale = 0)
    public long getCodMes() {
        return codMes;
    }

    public void setCodMes(long codMes) {
        this.codMes = codMes;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_moneda", precision = 2, scale = 0)
    public long getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(long codMoneda) {
        this.codMoneda = codMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCuenta != null ? codCuenta.hashCode() : 0);
        hash += (int) codAaa;
        hash += (int) codMes;
        hash += (int) codMoneda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScgSaldosId)) {
            return false;
        }
        ScgSaldosId other = (ScgSaldosId) object;
        if ((this.codCuenta == null && other.codCuenta != null) || (this.codCuenta != null && !this.codCuenta.equals(other.codCuenta))) {
            return false;
        }
        if (this.codAaa != other.codAaa) {
            return false;
        }
        if (this.codMes != other.codMes) {
            return false;
        }
        if (this.codMoneda != other.codMoneda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScgSaldosId{" + "codCuenta=" + codCuenta + ", codAaa=" + codAaa + ", codMes=" + codMes + ", codMoneda=" + codMoneda + '}';
    }

  

}
