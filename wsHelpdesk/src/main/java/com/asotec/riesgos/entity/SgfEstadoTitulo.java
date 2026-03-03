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
@Table(name = "sgf_estado_titulo")
public class SgfEstadoTitulo implements Serializable{
    private long codStsTitulo;
    private String stsTitulo;

    public SgfEstadoTitulo() {
    }

    public SgfEstadoTitulo(long codStsTitulo, String stsTitulo) {
        this.codStsTitulo = codStsTitulo;
        this.stsTitulo = stsTitulo;
    }

    @Id
    @Column(name = "cod_sts_titulo", precision = 2, scale = 0)
    public long getCodStsTitulo() {
        return codStsTitulo;
    }

    public void setCodStsTitulo(long codStsTitulo) {
        this.codStsTitulo = codStsTitulo;
    }

    @Column(name = "sts_titulo", length = 2)
    public String getStsTitulo() {
        return stsTitulo;
    }

    public void setStsTitulo(String stsTitulo) {
        this.stsTitulo = stsTitulo;
    }
    
}
