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
@Table(name = "sgf_tipo_emisor_depositario",
        schema = "public")
public class SgfTipoEmisorDepositario implements java.io.Serializable{
    private long codTipoEmisorDepositario;
    private String tipoEmisorDepositario;

    public SgfTipoEmisorDepositario() {
    }

    public SgfTipoEmisorDepositario(long codTipoEmisorDepositario, String tipoEmisorDepositario) {
        this.codTipoEmisorDepositario = codTipoEmisorDepositario;
        this.tipoEmisorDepositario = tipoEmisorDepositario;
    }

    @Id
    @Column(name = "cod_tipo_emisor_depositario", precision = 2, scale = 0)
    public long getCodTipoEmisorDepositario() {
        return codTipoEmisorDepositario;
    }

    public void setCodTipoEmisorDepositario(long codTipoEmisorDepositario) {
        this.codTipoEmisorDepositario = codTipoEmisorDepositario;
    }

    @Column(name = "tipo_emisor_depositario", length = 2)
    public String getTipoEmisorDepositario() {
        return tipoEmisorDepositario;
    }

    public void setTipoEmisorDepositario(String tipoEmisorDepositario) {
        this.tipoEmisorDepositario = tipoEmisorDepositario;
    }
}
