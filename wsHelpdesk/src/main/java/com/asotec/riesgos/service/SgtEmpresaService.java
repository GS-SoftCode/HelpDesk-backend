/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtEmpresaDao;
import com.asotec.riesgos.entity.SgtEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SgtEmpresaService extends GenericService<SgtEmpresa> implements ISgtEmpresaService{ 
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtEmpresaDao dao;

    /**
     * Constructor
     */
    public SgtEmpresaService() {
        super();
    }
    
    /**
     * Inicializa el DAO del servicio genérico después de inyección
     */
    @javax.annotation.PostConstruct
    public void init() {
        setDao(this.dao);
    }
}
