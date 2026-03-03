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
 * @author ASOTEC
 */
@Embeddable
public class GenUsuarioId implements Serializable{

    @Column(name = "id_usuario")
    private long idUsuario;
    @Column(name = "cod_empresa")
    private long codEmpresa;

    public GenUsuarioId() {
    }

    public GenUsuarioId(long idUsuario, long codEmpresa) {
        this.idUsuario = idUsuario;
        this.codEmpresa = codEmpresa;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }    
    
}
