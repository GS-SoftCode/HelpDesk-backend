/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "scg_cuenta",
        schema = "public")
public class ScgCuenta implements Serializable{
    private String codCuenta;
    private long numDA;
    private String nomCuenta;// character varying(50),

    public ScgCuenta() {
    }

    public ScgCuenta(String codCuenta, long numDA, String nomCuenta) {
        this.codCuenta = codCuenta;
        this.numDA = numDA;
        this.nomCuenta = nomCuenta;
    }

    @Id
    @Column(name = "cod_cuenta", length = 20)
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Column(name = "num_d_a", precision = 1, scale = 0)
    public long getNumDA() {
        return numDA;
    }

    public void setNumDA(long numDA) {
        this.numDA = numDA;
    }
    @Column(name = "nom_cuenta", length = 50)
    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }
}
