/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IUsuarioDao;
import com.asotec.riesgos.entity.GenUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion de servicios de l usuario
 *
 * @author josesanchez
 */
@Service
@Transactional
public class UsuarioService extends GenericService<GenUsuario> implements IUsuarioService {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IUsuarioDao dao;

    /**
     * Constructor
     */
    public UsuarioService() {
        super();
    }

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    @Override
    public GenUsuario findByUsername(GenUsuario obj) {
        return dao.findByUsername(obj);
    }

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    @Override
    public GenUsuario findByUsernamePass(GenUsuario obj) {
        return dao.findByUsername(obj);
    }
    
    @Override
    public List<GenUsuario> findByCodEmpresa(long codEmpresa) {
        return dao.findByCodEmpresa(codEmpresa);
    }
}
