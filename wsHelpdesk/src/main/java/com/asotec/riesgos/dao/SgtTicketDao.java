/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtTicket;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtTicketDao extends GenericDao<SgtTicket> implements ISgtTicketDao{
    /**
     * Constructor general
     */
    public SgtTicketDao() {
        super();
        setClase(SgtTicket.class); //agrega pojo
    }

    @Override
    public List<SgtTicket> findAll() {
        Query query = entityManager.createQuery("from " + SgtTicket.class.getName()+ " order by fecCreacion desc");
        return query.getResultList();
    }
    
    @Override
    public List<SgtTicket> findAllEmpresa(long codEmpresa) {
        Query query = entityManager.createQuery("from " + SgtTicket.class.getName() + " where codEmpresa = "+codEmpresa+" order by fecCreacion desc");
        return query.getResultList();
    }
    
    @Override
    public List<SgtTicket> filterTicketsEmpresa(List<String> listaEstados, List<String> listaTecnicos, long codEmpresa) {
        
        String estados = concatenarLista("estados",listaEstados);
        String tecnicos = concatenarLista("tecnicos",listaTecnicos);
        Query query = null;
        if (listaEstados.isEmpty()) {
            System.out.println("Entra 1");
            query = entityManager.createQuery("from " + SgtTicket.class.getName() + " where codEmpresa = "+codEmpresa+" and codTecnico in ("+tecnicos+") order by fecCreacion desc");
        }
        if (listaTecnicos.isEmpty()) {
            System.out.println("Entra 2");
            query = entityManager.createQuery("from " + SgtTicket.class.getName() + " where codEmpresa = "+codEmpresa+" and codEstado in ("+estados+") order by fecCreacion desc");
        }
        if (!listaEstados.isEmpty() && !listaTecnicos.isEmpty()) {
            System.out.println("Entra 3");
            query = entityManager.createQuery("from " + SgtTicket.class.getName() + " where codEmpresa = "+codEmpresa+" and codEstado in ("+estados+") and codTecnico in ("+tecnicos+") order by fecCreacion desc");
        }
        return query.getResultList();
    }
    
    public String concatenarLista(String tipo, List<String> lista) {
        StringBuilder resultado = new StringBuilder();

        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                if (tipo.equalsIgnoreCase("estados")) {
                    resultado.append(lista.get(i));
                }
                if (tipo.equalsIgnoreCase("tecnicos")) {
                    resultado.append("'").append(lista.get(i)).append("'");
                }
                // Agregar la coma solo si no es el último elemento
                if (i < lista.size() - 1) {
                    resultado.append(",");
                }
            }
            return resultado.toString();
        } else {
            return "";
        }
    }
    
    @Override
    public int createTicket(SgtTicket ticketJson) {
        int res = 0;
        try {
            entityManager.persist(ticketJson);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL createTicket: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }
    
    @Override
    public SgtTicket crearTicket(SgtTicket ticketJson) {
        try {
            entityManager.persist(ticketJson); // Aquí JPA asigna el ID generado automáticamente
            entityManager.flush(); // Asegura que se ejecuta el INSERT en la BD
            return ticketJson; // Ya tiene el ID generado
        } catch (Exception e) {
            System.out.println("ErrorSQL createTicket: " + e);
            return null;
        }
    }
    
    @Override
    public int deleteTicket(SgtTicket reclamo) {
        int res = 0;
        try {
            SgtTicket bar = entityManager.find(SgtTicket.class, reclamo.getCodTicket());
            entityManager.remove(bar);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL DeleteTicket: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }

    @Override
    public int updateTicket(SgtTicket reclamo) {
        int res = 0;
        try {
            entityManager.merge(reclamo);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL UpdateTicket: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }
}
