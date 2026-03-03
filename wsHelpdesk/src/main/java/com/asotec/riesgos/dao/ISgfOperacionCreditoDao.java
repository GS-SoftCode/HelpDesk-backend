/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfOperacionCredito;
import java.sql.Date;

/**
 *
 * @author User
 */
public interface ISgfOperacionCreditoDao extends IGenericDao<SgfOperacionCredito> {
    public int deleteAll();
    public int generacionBCE02(Date fecha1, Date fecha2);
}
