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
 * @author ASOTEC
 */
@Entity
@Table(name = "sgt_tecnico",
        schema = "public")
public class SgtTecnico implements Serializable{
    
    @Id
    @Column(name = "cod_tecnico", length = 20)
    private String codTecnico;
    @Column(name = "nom_tecnico", length = 50)
    private String nomTecnico;

    public SgtTecnico() {
    }

    public SgtTecnico(String codTecnico, String nomTecnico) {
        this.codTecnico = codTecnico;
        this.nomTecnico = nomTecnico;
    }
    
    public String getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(String codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }
    
    
}
