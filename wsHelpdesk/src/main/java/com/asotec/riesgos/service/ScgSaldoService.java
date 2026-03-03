/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.asotec.riesgos.dao.IScgSaldoDao;
import com.asotec.riesgos.entity.ScgSaldos;
import java.util.List;

/**
 *
 * @author josesanchez
 */
@Service
public class ScgSaldoService extends GenericService<ScgSaldos> implements IScgSaldoService{

   /**
     * Resuelve la dependencia
     */
    @Autowired
    private IScgSaldoDao dao;

    /**
     * Constructor
     */
    public ScgSaldoService() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public List<ScgSaldos> findByFecha() {
        return dao.findByFecha();
    }

    @Override
    public List<Object> findbyDateL02(String[] fechaFormat) {
        return dao.findbyDateL02(fechaFormat) ;
    }

    @Override
    public List<ScgSaldos> findAllL02(String[] fechaFormat) {
        return dao.findAllL02(fechaFormat);
    }
}
