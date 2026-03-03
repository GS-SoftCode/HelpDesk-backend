package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ScgSaldos;
import java.util.List;

/**
 *
 * @author josesanchez
 */
public interface IScgSaldoDao extends IGenericDao<ScgSaldos>{
    
    /**
     *
     * @return
     */
    public List<ScgSaldos> findByFecha();

    public List<Object> findbyDateL02(String[] fechaFormat);

    public List<ScgSaldos> findAllL02(String[] fechaFormat);
}
