/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class SgfReclamosId implements Serializable{
    private long numReclamo;
    private long codSocio;

    public SgfReclamosId() {
    }

    public SgfReclamosId(long numReclamo, long codSocio) {
        this.numReclamo = numReclamo;
        this.codSocio = codSocio;
    }

    @Column(name = "num_reclamo", precision = 5, scale = 0)
    public long getNumReclamo() {
        return numReclamo;
    }

    public void setNumReclamo(long numReclamo) {
        this.numReclamo = numReclamo;
    }

    @Column(name = "cod_socio", precision = 10, scale = 0)
    public long getCodSocio() {
        return codSocio;
    }

    public void setCodSocio(long codSocio) {
        this.codSocio = codSocio;
    }

    @Override
    public String toString() {
        return "SgfReclamosId: - NumReclamo:" + numReclamo + " - CodSocio:" + codSocio;
    }
}
