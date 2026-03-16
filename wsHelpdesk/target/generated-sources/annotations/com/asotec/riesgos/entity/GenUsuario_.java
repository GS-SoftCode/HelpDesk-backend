package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.GenUsuarioId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-03-16T09:41:53")
@StaticMetamodel(GenUsuario.class)
public class GenUsuario_ { 

    public static volatile SingularAttribute<GenUsuario, Date> fecRegistro;
    public static volatile SingularAttribute<GenUsuario, String> codUsuario;
    public static volatile SingularAttribute<GenUsuario, String> dirEmail;
    public static volatile SingularAttribute<GenUsuario, Long> codPerfil;
    public static volatile SingularAttribute<GenUsuario, Character> stsUsuario;
    public static volatile SingularAttribute<GenUsuario, String> nomUsuario;
    public static volatile SingularAttribute<GenUsuario, String> codPassword;
    public static volatile SingularAttribute<GenUsuario, GenUsuarioId> id;
    public static volatile SingularAttribute<GenUsuario, Date> fecUsrmod;

}