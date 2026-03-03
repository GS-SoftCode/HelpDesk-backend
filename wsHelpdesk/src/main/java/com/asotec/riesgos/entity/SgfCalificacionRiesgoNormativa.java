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
@Table(name = "sgf_calificacion_riesgo_normativa",
        schema = "public")
public class SgfCalificacionRiesgoNormativa implements java.io.Serializable{
    
    private long codCalifRiesgoNormativa;
    private String califRiesgoNormativa;

    public SgfCalificacionRiesgoNormativa() {
    }

    public SgfCalificacionRiesgoNormativa(long codCalifRiesgoNormativa, String califRiesgoNormativa) {
        this.codCalifRiesgoNormativa = codCalifRiesgoNormativa;
        this.califRiesgoNormativa = califRiesgoNormativa;
    }

    @Id
    @Column(name = "cod_calif_riesgo_normativa", precision = 1, scale = 0)
    public long getCodCalifRiesgoNormativa() {
        return codCalifRiesgoNormativa;
    }

    public void setCodCalifRiesgoNormativa(long codCalifRiesgoNormativa) {
        this.codCalifRiesgoNormativa = codCalifRiesgoNormativa;
    }

    @Column(name = "calif_riesgo_normativa", length = 100)
    public String getCalifRiesgoNormativa() {
        return califRiesgoNormativa;
    }

    public void setCalifRiesgoNormativa(String califRiesgoNormativa) {
        this.califRiesgoNormativa = califRiesgoNormativa;
    }

}
