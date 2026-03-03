/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SgtEmpresa;
import com.asotec.riesgos.service.IUsuarioService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASOTEC
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("usuarios")
public class UsuarioController {
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IUsuarioService service;
    
    /**
     * Obtiene usuario por id y empresa
     *
     * @return registro
     */
    @RequestMapping(value = "/get",
            method = RequestMethod.POST)
    public ResponseEntity<List<GenUsuario>> getUsuarioEmpresa(
            @RequestParam(value = "codigo", required = true) long codEmpresa
    ) {
        System.out.println("Entra get usuario");
        List<GenUsuario> resp = service.findByCodEmpresa(codEmpresa);
        //return Response.get(Status.OK.get(), Message.OK.get(), repuesta, HttpStatus.OK);
        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
