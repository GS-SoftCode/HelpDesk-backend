/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgfProductoFinanciero;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface ISgfProductoFinancieroService extends IGenericService<SgfProductoFinanciero>{
    public int deleteAll();
    public int generacionBCE01(Date fecha1, Date fecha2);
}
