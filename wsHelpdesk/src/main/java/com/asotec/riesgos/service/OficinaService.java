/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IOficinaDao;
import com.asotec.riesgos.entity.GenOficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion de servicios de la oficina
 *
 * @author edwin
 */
@Service
@Transactional
public class OficinaService extends GenericService<GenOficina> implements IOficinaService {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IOficinaDao dao;

    /**
     * Constructor
     */
    public OficinaService() {
        super();
    }

}
