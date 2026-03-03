/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.exception.InvalidAttributeException;
import com.asotec.riesgos.service.IUsuarioService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Respuesta;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import com.asotec.riesgos.util.Validation;
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
 *
 * @author josesanchez
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("login")
public class LoginController {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IUsuarioService service;

    /**
     * Genera token con caducidad
     *
     * @param usuario
     * @param password
     * @return
     * @throws InvalidAttributeException
     */
    @RequestMapping(value = "/auth",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getUsuario(
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "password", required = true) String password
    ) throws InvalidAttributeException {
        Validation.checkNullEmpty("usuario", usuario);
        Validation.checkNullEmpty("password", password);
        //preproceso
        GenUsuario target = new GenUsuario();
        target.setCodUsuario(usuario.trim());
        target.setCodPassword(password.trim());
        target = service.findByUsernamePass(target);
        if (target == null) {
            return Response.get(Status.ERROR.get(), Message.NO_RESULT.get(), null, HttpStatus.OK);
        } else if (target.getStsUsuario() != 'A') {
            return Response.get(Status.ERROR.get(), "Inactivo", Message.NULL_OBJECT.get(), HttpStatus.OK);
        }
        Respuesta respuesta = Token.generar(target.getCodUsuario());
        //credenciales ok
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }

    /**
     * Obtiene las credenciales del socio
     *
     * @param token sesion
     * @return registro
     */
    @RequestMapping(value = "/mostrar",
            method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getCredencial(
            @RequestParam(value = "token", required = true) String token
    ) {
        
        //Antes se debe descifrar en Front y a los espacios en blanco colocar +
        token = token.replace(" ", "+");
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario target = new GenUsuario();
        target.setCodUsuario(usuario.trim());
        GenUsuario repuesta = service.findByUsername(target);

        return Response.get(Status.OK.get(), Message.OK.get(), repuesta, HttpStatus.OK);
    }
    
    /**
     * Obtiene las credenciales del socio por nombre
     *
     * @param token sesion
     * @return registro
     */
    @RequestMapping(value = "/get",
            method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getUserData(
            @RequestParam(value = "name", required = true) String name
    ) {
        GenUsuario target = new GenUsuario();
        target.setCodUsuario(name);
        GenUsuario repuesta = service.findByUsername(target);
        return Response.get(Status.OK.get(), Message.OK.get(), repuesta, HttpStatus.OK);
    }

}
