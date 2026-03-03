/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author josesanchez
 */
@Entity
@Table(name = "gen_usuario",
        schema = "public")
public class GenUsuario implements Serializable {
    
    private GenUsuarioId id;
    private long codPerfil;
    private String codUsuario;
    private String nomUsuario;
    private String codPassword;
    private String dirEmail;
    private char stsUsuario;
    private Date fecRegistro;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fecUsrmod;

    public GenUsuario() {
    }
    
    public GenUsuario(GenUsuarioId id) {
        this.id = id;
    }
    
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "idUsuario", column = @Column(name = "id_usuario", nullable = false)),
        @AttributeOverride(name = "codEmpresa", column = @Column(name = "cod_empresa", nullable = false)),
    })
    
    @Id
    public GenUsuarioId getId() {
        return id;
    }

    public void setId(GenUsuarioId id) {
        this.id = id;
    }

    @Column(name = "cod_perfil", precision = 10, scale = 0)
    public long getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(long codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Column(name = "cod_usuario", length = 50)
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Column(name = "nom_usuario", length = 100)
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Column(name = "cod_password", length = 100)
    public String getCodPassword() {
        return codPassword;
    }

    public void setCodPassword(String codPassword) {
        this.codPassword = codPassword;
    }

    @Column(name = "dir_email", length = 100)
    public String getDirEmail() {
        return dirEmail;
    }

    public void setDirEmail(String dirEmail) {
        this.dirEmail = dirEmail;
    }

    @Column(name = "sts_usuario", length = 1)
    public char getStsUsuario() {
        return stsUsuario;
    }

    public void setStsUsuario(char stsUsuario) {
        this.stsUsuario = stsUsuario;
    }

    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    @Column(name = "fec_usrmod")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecUsrmod() {
        return fecUsrmod;
    }

    public void setFecUsrmod(Date fecUsrmod) {
        this.fecUsrmod = fecUsrmod;
    }
    
//    private String codUsuario;
//    private String codLocal;
//    private String nomUsuario;
//    private String codPassword;
//    private Character stsUsuario;
////    private Long codOficina;
//
//    public GenUsuario() {
//    }
//
//    public GenUsuario(String codUsuario) {
//        this.codUsuario = codUsuario;
//    }
//
//    public GenUsuario(String codUsuario, String nomUsuario, Character stsUsuario) {
//        this.codUsuario = codUsuario;
//        this.nomUsuario = nomUsuario;
//        this.stsUsuario = stsUsuario;
//    }
//
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
//    @Column(name = "cod_usuario")
//    public String getCodUsuario() {
//        return codUsuario;
//    }
//
//    public void setCodUsuario(String codUsuario) {
//        this.codUsuario = codUsuario;
//    }
//
//    @Column(name = "cod_local")
//    public String getCodLocal() {
//        return codLocal;
//    }
//
//    public void setCodLocal(String codLocal) {
//        this.codLocal = codLocal;
//    }
//
//    @Basic(optional = false)
//    @Column(name = "nom_usuario")
//    public String getNomUsuario() {
//        return nomUsuario;
//    }
//
//    public void setNomUsuario(String nomUsuario) {
//        this.nomUsuario = nomUsuario;
//    }
//
//    @Column(name = "cod_password")
//    public String getCodPassword() {
//        return codPassword;
//    }
//
//    public void setCodPassword(String codPassword) {
//        this.codPassword = codPassword;
//    }
//
//    @Basic(optional = false)
//    @Column(name = "sts_usuario")
//    public Character getStsUsuario() {
//        return stsUsuario;
//    }
//
//    public void setStsUsuario(Character stsUsuario) {
//        this.stsUsuario = stsUsuario;
//    }
//
////    @Column(name = "cod_oficina")
////    public Long getCodOficina() {
////        return codOficina;
////    }
////
////    public void setCodOficina(Long codOficina) {
////        this.codOficina = codOficina;
////    }
//
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof GenUsuario)) {
//            return false;
//        }
//        GenUsuario other = (GenUsuario) object;
//        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.asotec.riesgos.entity.GenUsuario[ codUsuario=" + codUsuario + " ]";
//    }
    
}
