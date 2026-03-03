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
@Table(name = "scg_tmp_saldos",
        schema = "public")
public class ScgTmpSaldos implements Serializable {

    private ScgTmpSaldosId id;
    private Long numNivel;
    private String nomCuenta;
    private Long valSaldoAnt;
    private Long valDebitos;
    private Long valCreditos;
    private Long numDA;
    private Long codOficina;
    private Character stsMovimiento;

    public ScgTmpSaldos() {
    }

    public ScgTmpSaldos(ScgTmpSaldosId id) {
        this.id = id;
    }

    public ScgTmpSaldos(String codUsr, Long codReporte, String codCuenta, Long codMoneda) {
        this.id = new ScgTmpSaldosId(codUsr, codReporte, codCuenta, codMoneda);
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "codUsr", column = @Column(name = "cod_usr", unique = false, nullable = false, precision = 10, scale = 0)),
        @AttributeOverride(name = "codReporte", column = @Column(name = "cod_reporte", nullable = false, precision = 10, scale = 0)),
        @AttributeOverride(name = "codCuenta", column = @Column(name = "cod_cuenta", unique = false, nullable = false, precision = 10, scale = 0)),
        @AttributeOverride(name = "codMoneda", column = @Column(name = "cod_moneda", nullable = false, precision = 10, scale = 0))
    })

    @Id
    public ScgTmpSaldosId getScgTmpSaldosPK() {
        return id;
    }

    public void setScgTmpSaldosPK(ScgTmpSaldosId id) {
        this.id = id;
    }

    @Column(name = "num_nivel", precision = 2, scale = 0)
    public Long getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(Long numNivel) {
        this.numNivel = numNivel;
    }

    @Column(name = "nom_cuenta", length = 50)
    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }

    @Column(name = "val_saldo_ant", precision = 18, scale = 2)
    public Long getValSaldoAnt() {
        return valSaldoAnt;
    }

    public void setValSaldoAnt(Long valSaldoAnt) {
        this.valSaldoAnt = valSaldoAnt;
    }

    @Column(name = "val_debitos", precision = 18, scale = 2)
    public Long getValDebitos() {
        return valDebitos;
    }

    public void setValDebitos(Long valDebitos) {
        this.valDebitos = valDebitos;
    }

    @Column(name = "val_creditos", precision = 18, scale = 2)
    public Long getValCreditos() {
        return valCreditos;
    }

    public void setValCreditos(Long valCreditos) {
        this.valCreditos = valCreditos;
    }

    @Column(name = "num_d_a", precision = 1, scale = 0)
    public Long getNumDA() {
        return numDA;
    }

    public void setNumDA(Long numDA) {
        this.numDA = numDA;
    }

    @Column(name = "cod_oficina", precision = 2, scale = 0)
    public Long getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(Long codOficina) {
        this.codOficina = codOficina;
    }

    @Column(name = "sts_movimiento")
    public Character getStsMovimiento() {
        return stsMovimiento;
    }

    public void setStsMovimiento(Character stsMovimiento) {
        this.stsMovimiento = stsMovimiento;
    }

}
