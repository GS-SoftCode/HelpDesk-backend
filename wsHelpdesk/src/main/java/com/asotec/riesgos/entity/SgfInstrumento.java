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
@Table(name = "sgf_instrumento",
        schema = "public")
public class SgfInstrumento implements Serializable{
    private long codInstrumento;
    private String codTipoInstrumento;

    public SgfInstrumento() {
    }

    public SgfInstrumento(long codInstrumento, String codTipoInstrumento) {
        this.codInstrumento = codInstrumento;
        this.codTipoInstrumento = codTipoInstrumento;
    }

    @Id
    @Column(name = "cod_instrumento", precision = 2, scale = 0)
    public long getCodInstrumento() {
        return codInstrumento;
    }

    public void setCodInstrumento(long codInstrumento) {
        this.codInstrumento = codInstrumento;
    }

    @Column(name = "cod_tipo_instrumento", length = 3)
    public String getCodTipoInstrumento() {
        return codTipoInstrumento;
    }

    public void setCodTipoInstrumento(String codTipoInstrumento) {
        this.codTipoInstrumento = codTipoInstrumento;
    }

}
