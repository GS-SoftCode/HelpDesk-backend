/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenOficina;
import com.asotec.riesgos.exception.InvalidAttributeException;
import com.asotec.riesgos.service.IOficinaService;
import com.asotec.riesgos.util.*;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementacion del controlador de la oficina
 *
 * @author edwin
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/oficina")
public class OficinaController {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IOficinaService service;

    /**
     * Constructor
     */
    public OficinaController() {
        super();
    }

    /**
     * Obtiene el registro
     *
     * @return registro
     * @throws InvalidAttributeException
     * @throws NoResultException
     */
    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getAllOficina() throws InvalidAttributeException, NoResultException {
        List<GenOficina> respuesta = service.findAll();
        if (respuesta == null) {
            return Response.get(Status.OK.get(), Message.OK.get(), null, HttpStatus.OK);
        } //envia al frontend
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }

    /**
     * Obtiene el registro dada la id
     *
     * @return registro
     * @throws InvalidAttributeException
     * @throws NoResultException
     */
    @RequestMapping(
            value = "/getoficina",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getIdOficina(
            @RequestParam(value = "token", required = true, defaultValue = "0") String token,
            @RequestParam(value = "codigo", required = true, defaultValue = "0") String codigo
    ) throws InvalidAttributeException, NoResultException {
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return new ResponseEntity<>(
                    new WrapMap(Status.TIMEOUT.get(), Message.ERROR.get(), valida[1]).getInstance(),
                    HttpStatus.OK);
        }
        GenOficina respuesta = service.findOne(Convert.strToLong(codigo));
        if (respuesta == null) {
            return new ResponseEntity<>( //cuando hay resultados
                new WrapMap(Status.ERROR.get(), Message.ERROR.get(), null).getInstance(),
                HttpStatus.OK);
        } //envia al frontend
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }
}
