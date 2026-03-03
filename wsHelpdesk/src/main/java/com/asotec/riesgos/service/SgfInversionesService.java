/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfInversionesDao;
import com.asotec.riesgos.entity.SgfInversiones;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class SgfInversionesService extends GenericService<SgfInversiones> implements ISgfInversionesService{
    
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgfInversionesDao dao;

    /**
     * Constructor
     */
    public SgfInversionesService() {
        super();
    }

    @Override
    public int insertRegistry(SgfInversiones objInver) {
        return dao.insertRegistry(objInver);
    }

    @Override
    public List<Object> findbyDateI01(String fecha) {
        return dao.findbyDateI01(fecha);
    }

    @Override
    public List<Object> findbyDateI02(String fecha) {
        return dao.findbyDateI02(fecha);
    }

    @Override
    public SgfInversiones findOneById(SgfInversiones inversionJson) {
        return dao.findOneById(inversionJson);
    }

    @Override
    public List<SgfInversiones> findAllI01(String fecha) {
        return dao.findAllI01(fecha);
    }

    @Override
    public List<SgfInversiones> findAllI02(String fecha) {
        return dao.findAllI02(fecha);
    }



}
