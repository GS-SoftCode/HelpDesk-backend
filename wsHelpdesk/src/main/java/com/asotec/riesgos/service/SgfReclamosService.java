/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfReclamosDao;
import com.asotec.riesgos.entity.SgfReclamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class SgfReclamosService extends GenericService<SgfReclamos> implements ISgfReclamosService{
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgfReclamosDao dao;

    /**
     * Constructor
     */
    public SgfReclamosService() {
        super();
    }

    @Override
    public int createRegistry(SgfReclamos objReclamos) {
        return dao.createRegistry(objReclamos);
    }
}
