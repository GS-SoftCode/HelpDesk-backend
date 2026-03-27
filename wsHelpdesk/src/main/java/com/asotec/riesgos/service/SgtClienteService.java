/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtClienteDao;
import com.asotec.riesgos.entity.SgtCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SgtClienteService extends GenericService<SgtCliente> implements ISgtClienteService{ 
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtClienteDao dao;

    /**
     * Constructor
     */
    public SgtClienteService() {
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
