/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Embeddable
public class SgfInversionesId implements Serializable{
    private String numDeposito;
    private long codBanco;
    private Date fecDeposito;
    private Date fecCompra;

    public SgfInversionesId() {
    }

    public SgfInversionesId(String numDeposito, long codBanco, Date fecDeposito, Date fecCompra) {
        this.numDeposito = numDeposito;
        this.codBanco = codBanco;
        this.fecDeposito = fecDeposito;
        this.fecCompra = fecCompra;
    }

    @Column(name = "num_deposito", length = 25)
    public String getNumDeposito() {
        return numDeposito;
    }

    public void setNumDeposito(String numDeposito) {
        this.numDeposito = numDeposito;
    }

    @Column(name = "cod_banco", precision = 2, scale = 0)
    public long getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(long codBanco) {
        this.codBanco = codBanco;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "fec_deposito")
    @Temporal(TemporalType.DATE)
    public Date getFecDeposito() {
        return fecDeposito;
    }

    public void setFecDeposito(Date fecDeposito) {
        this.fecDeposito = fecDeposito;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "fec_compra")
    @Temporal(TemporalType.DATE)
    public Date getFecCompra() {
        return fecCompra;
    }

    public void setFecCompra(Date fecCompra) {
        this.fecCompra = fecCompra;
    }

}
