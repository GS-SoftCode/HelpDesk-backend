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
@Table(name = "gen_pais",
        schema = "public")
public class GenPais implements Serializable{

    private long codPais;
    private String nomAbrevPais;

    public GenPais() {
    }

    public GenPais(long codPais, String nomAbrevPais) {
        this.codPais = codPais;
        this.nomAbrevPais = nomAbrevPais;
    }

    @Id
    @Column(name = "cod_pais", precision = 3, scale = 0)
    public long getCodPais() {
        return codPais;
    }

    public void setCodPais(long codPais) {
        this.codPais = codPais;
    }

    @Column(name = "nom_abrev_pais", length = 3)
    public String getNomAbrevPais() {
        return nomAbrevPais;
    }

    public void setNomAbrevPais(String nomAbrevPais) {
        this.nomAbrevPais = nomAbrevPais;
    }
}
