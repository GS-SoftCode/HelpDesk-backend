/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.ScgSaldos;
import java.util.List;

/**
 *
 * @author josesanchez
 */
public interface IScgSaldoService extends IGenericService<ScgSaldos> {
    
    public List<ScgSaldos> findByFecha();

    public List<Object> findbyDateL02(String[] fechaFormat);

    public List<ScgSaldos> findAllL02(String[] fechaFormat);
}
