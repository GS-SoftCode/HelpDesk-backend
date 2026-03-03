/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfProductoFinancieroDao;
import com.asotec.riesgos.entity.SgfProductoFinanciero;
import java.sql.Date;
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
public class SgfProductoFinancieroService extends GenericService<SgfProductoFinanciero> implements ISgfProductoFinancieroService {
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgfProductoFinancieroDao dao;

    /**
     * Constructor
     */
    public SgfProductoFinancieroService() {
        super();
    }

    @Override
    public int deleteAll() {
        return dao.deleteAll();
    }

    @Override
    public int generacionBCE01(Date fecha1, Date fecha2){
        return dao.generacionBCE01(fecha1, fecha2);
    }
}
