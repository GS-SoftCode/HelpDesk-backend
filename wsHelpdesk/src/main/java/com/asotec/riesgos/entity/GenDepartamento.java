/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author josesanchez
 */
@Entity
@Table(name = "gen_departamento",
        schema = "public")
public class GenDepartamento implements Serializable {

    private Long codDepartamento;
    private String nomDepartamento;

    public GenDepartamento() {
    }

    public GenDepartamento(Long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_departamento")
    public Long getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Column(name = "nom_departamento")
    public String getNomDepartamento() {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartamento != null ? codDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenDepartamento)) {
            return false;
        }
        GenDepartamento other = (GenDepartamento) object;
        if ((this.codDepartamento == null && other.codDepartamento != null) || (this.codDepartamento != null && !this.codDepartamento.equals(other.codDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asotec.riesgos.entity.GenDepartamento[ codDepartamento=" + codDepartamento + " ]";
    }

}
