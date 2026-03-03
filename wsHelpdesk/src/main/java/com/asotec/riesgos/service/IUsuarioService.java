/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.GenUsuario;
import java.util.List;

/**
 * Interfaz con los servicios de l usuario
 *
 * @author josesanchez
 */
public interface IUsuarioService extends IGenericService<GenUsuario> {

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    public GenUsuario findByUsername(GenUsuario obj);

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    public GenUsuario findByUsernamePass(GenUsuario obj);
    
    public List<GenUsuario> findByCodEmpresa(long codEmpresa);
}
