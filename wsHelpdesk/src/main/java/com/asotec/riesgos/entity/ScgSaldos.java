/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josesanchez
 */
@Entity
@Table(name = "scg_saldos",
        schema = "public")
public class ScgSaldos implements Serializable {

    private ScgSaldosId id;
    private long valDebitos;
    private long valCreditos;

    public ScgSaldos() {
    }

    public ScgSaldos(ScgSaldosId id) {
        this.id = id;
    }

    public ScgSaldos(String codCuenta, long codAaa, long codMes, long codMoneda) {
        this.id = new ScgSaldosId(codCuenta, codAaa, codMes, codMoneda);
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "cod_cuenta", column = @Column(name = "cod_cuenta", unique = false, nullable = false, precision = 18, scale = 2)),
        @AttributeOverride(name = "cod_aaa", column = @Column(name = "cod_aaa", nullable = false, precision = 4, scale = 0)),
        @AttributeOverride(name = "cod_mes", column = @Column(name = "cod_mes", unique = false, nullable = false, precision = 2, scale = 0)),
        @AttributeOverride(name = "cod_moneda", column = @Column(name = "cod_moneda", nullable = false, precision = 2, scale = 0))
    })

    @Id

    public ScgSaldosId getId() {
        return id;
    }

    public void setId(ScgSaldosId id) {
        this.id = id;
    }

    @Column(name = "val_debitos", precision = 18, scale = 2)
    public long getValDebitos() {
        return valDebitos;
    }

    public void setValDebitos(long valDebitos) {
        this.valDebitos = valDebitos;
    }

    @Column(name = "val_creditos", precision = 18, scale = 2)
    public long getValCreditos() {
        return valCreditos;
    }

    public void setValCreditos(long valCreditos) {
        this.valCreditos = valCreditos;
    }

    @Override
    public String toString() {
        return "ScgSaldos{" + "id=" + id + ", valDebitos=" + valDebitos + ", valCreditos=" + valCreditos + '}';
    }
    

}
