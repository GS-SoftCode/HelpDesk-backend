/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenUsuario;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * Implementacion del dao de usuario
 *
 * @author josesanchez
 */
@Repository
public class UsuarioDao extends GenericDao<GenUsuario> implements IUsuarioDao {

    /**
     * Constructor general
     */
    public UsuarioDao() {
        super();
        setClase(GenUsuario.class); //agrega pojo
    }

    /**
     * Obtiene el registro dado el id
     *
     * @param obj objeto con id
     * @return registro
     */
    @Override
    public GenUsuario findOne(GenUsuario obj) {
        try {
            return entityManager.find(GenUsuario.class, obj);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    @Override
    public GenUsuario findByUsernamePass(GenUsuario obj) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where codUsuario = :usuario and codPassword = :clave");
            query.setParameter("usuario", obj.getCodUsuario());
            query.setParameter("clave", obj.getCodPassword());
            query.setMaxResults(1); //limit 1
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    /**
     * Obtiene el usuario dado el usuario y password
     *
     * @param obj objeto con parametros
     * @return registro
     */
    @Override
    public GenUsuario findByUsername(GenUsuario obj) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where codUsuario = :usuario and stsUsuario= 'A'");
            query.setParameter("usuario", obj.getCodUsuario());
            query.setMaxResults(1); //limit 1
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }
    
    @Override
    public List<GenUsuario> findByCodEmpresa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codEmpresa = :codigo");
            query.setParameter("codigo", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }

    }

    /**
     * Recupera todos los usuarios activos
     *
     * @return registros
     */
    @Override
    public List<GenUsuario> listAll() {
        return entityManager.createQuery("from " + GenUsuario.class.getName() + " where stsUsuario='A'").getResultList();
    }

    /**
     * Recupera todos los usuarios
     *
     * @return registros
     */
    @Override
    public List<GenUsuario> findAll() {
        return entityManager.createQuery("from " + GenUsuario.class.getName()).getResultList();
    }
}
