/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "gen_banco",
        schema = "public")
public class GenBanco {
    private long codBanco;
    private String numRuc;

    public GenBanco() {
    }

    public GenBanco(long codBanco, String numRuc) {
        this.codBanco = codBanco;
        this.numRuc = numRuc;
    }

    @Id
    @Column(name = "cod_banco", precision = 3, scale = 0)
    public long getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(long codBanco) {
        this.codBanco = codBanco;
    }

    @Column(name = "num_ruc", length = 15)
    public String getNumRuc() {
        return numRuc;
    }

    public void setNumRuc(String numRuc) {
        this.numRuc = numRuc;
    }

}
