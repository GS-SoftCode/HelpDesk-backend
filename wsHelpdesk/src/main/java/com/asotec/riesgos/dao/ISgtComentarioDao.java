/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtComentario;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISgtComentarioDao extends IGenericDao<SgtComentario> {
    public List<SgtComentario> findbyCodTicketEmpresa(int codTicket, long codEmpresa);
    public int createComentario(SgtComentario comentarioJson);
    //public int deleteComentario(SgtComentario comentarioJson);
    public int updateComentario(SgtComentario comentarioJson);
}
