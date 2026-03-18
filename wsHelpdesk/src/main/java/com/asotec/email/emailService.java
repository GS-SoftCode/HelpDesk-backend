/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.email;

import com.asotec.riesgos.entity.SgtTicket;
import com.asotec.riesgos.entity.SgtTicketSolicitante;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author josesanchez
 */
@Service
public class emailService {

    /**
     * Carga datos config
     */

    @Autowired
    private JavaMailSender emailSender;

    public void sendMessageWithAttachment(String to, String subject, String text) throws MessagingException {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Set From: header field of the header.
            helper.setFrom(new InternetAddress("no-reply@adelca.com"));
            //helper.addRecipient( Message.RecipientType.TO, new InternetAddress( "soporte.asotec@hotmail.com" ) );

            //helper.setFrom("soporte.asotec@hotmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            message.setContent(text, "text/html; charset=utf-8");
            //helper.setText(text);
            emailSender.send(message);
            String msg = "Email enviado login  bandeja:" + message;
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        } catch (MessagingException | MailException e) {
            String msg = "Error al sincronizar Email no enviado  bandeja:" + e.getMessage();
            System.out.println(msg);
            Logger.getLogger(emailService.class.getName()).log(Level.WARNING, msg);
        }
    }
    
    //metodo para enviar un email con una plantilla preparada para la creacion del ticket
    public void senMailTicketCreation(
        SgtTicketSolicitante solicitante,
        SgtTicket ticket,
        String img1,
        String img2
        ){
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // true = multipart

            // Set From: header field of the header.
            helper.setFrom(new InternetAddress("no-reply@adelca.com"));
            helper.setTo(solicitante.getEmailSolicitante());
            helper.setSubject(ticket.getTxtTitulo());
            

            //en text envio la codificacion de mi mensaje para el envio del ticket
            
            String fechaCreacion = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ticket.getFecCreacion());
            
            // Construir el HTML del correo
            String text="<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
            + "    <tr>\n"
            + "        <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 20px; color:#000\">\n"
            + "            <h2>Nuevo Ticket Creado</h2>\n"
            + "        </td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td bgcolor=\"#f4f4f4\" style=\"padding: 20px;\">\n"
            + "            <p><strong>Nro de ticket:</strong> " + solicitante.getCodTicket() + "</p>\n"
            + "            <p><strong>Fecha de creación:</strong> " + fechaCreacion + "</p>\n"
            + "            <p><strong>Empresa:</strong> " + ticket.getTxtTitulo() + "</p>\n"
            + "            <p><strong>Descripción:</strong> " + ticket.getTxtDesc() + "</p>\n"
            + "            <hr>\n"
            + "            <p><strong>Solicitante:</strong> " + solicitante.getNomSolicitante() + " " + solicitante.getApeSolicitante() + "</p>\n"
            + "            <p><strong>Email:</strong> " + solicitante.getEmailSolicitante() + "</p>\n"
            + "            <p><strong>Teléfono:</strong> " + solicitante.getTelSolicitante() + "</p>\n"
            + "            <hr>\n"
            + "            <p><strong>Tipo de Remoto:</strong> " + ticket.getTypeRemote() + "</p>\n"
            + "            <p><strong>Código Remoto:</strong> " + ticket.getCodRemote() + "</p>\n"
            + "            <p><strong>Contraseña Remota:</strong> " + ticket.getPassRemote() + "</p>\n"
            + "        </td>\n"
            + "    </tr>\n"
            + "    <tr>\n"
            + "        <td bgcolor=\"#1D52A5\" style=\"padding: 20px; color:#ffffff; text-align: center\">\n"
            + "            <p>Gracias por utilizar nuestra plataforma de tickets.</p>\n"
            + "        </td>\n"
            + "    </tr>\n"
            + "</table>";
            
            // Establecer el contenido HTML del correo
            helper.setText(text, true);  // true = es HTML
            
            // ADJUNTAR IMÁGENES (ANTES de enviar)
            if (img1 != null && !img1.isEmpty()) {
                try {
                    // Separar el prefijo "data:image/png;base64," de los datos
                    String base64Data = img1.contains(",") ? img1.split(",")[1] : img1;
                    byte[] imagen1Bytes = Base64.getDecoder().decode(base64Data);
                    helper.addAttachment("imagen1.png", new ByteArrayResource(imagen1Bytes));
                } catch (Exception e) {
                    Logger.getLogger(emailService.class.getName()).log(Level.WARNING, 
                        "Error al adjuntar imagen1: " + e.getMessage());
                }
            }
            
            if (img2 != null && !img2.isEmpty()) {
                try {
                    String base64Data = img2.contains(",") ? img2.split(",")[1] : img2;
                    byte[] imagen2Bytes = Base64.getDecoder().decode(base64Data);
                    helper.addAttachment("imagen2.jpg", new ByteArrayResource(imagen2Bytes));
                } catch (Exception e) {
                    Logger.getLogger(emailService.class.getName()).log(Level.WARNING, 
                        "Error al adjuntar imagen2: " + e.getMessage());
                }
            }
            
            // ENVIAR EL EMAIL (una sola vez, con todas las imágenes adjuntas)
            emailSender.send(message);
            
            String msg = "Email enviado correctamente a: " + solicitante.getEmailSolicitante();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        
        } catch (MessagingException | MailException e) {
            String msg = "Error al enviar email: " + e.getMessage();
            System.out.println(msg);
            Logger.getLogger(emailService.class.getName()).log(Level.WARNING, msg);
        }
    }
    
    /**
     * Envia correco desde la config
     *
     * @param clavetemporal envio
     */
/*
    public void envioEmailTransferenciaClaveTemporal(SgfSocio registro, GenEmpresa empres, WebClaveTemporal clavetemporal) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        try {
            sendMessageWithAttachment(registro.getDirCorreo(), empres.getNomEmpresa(),
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Ingreso banca web</h2>"
                    + "                 <img src=" + this.logo + " alt=\"150\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Fecha:" + dateToString + "</p>\n"
                    + "                <p>Estimado/a:<b> " + registro.getNomSocio() + " " + registro.getApeSocio() + "</b></p>\n"
                    + "                <p>Clave temporal es: <b>" + clavetemporal.getClave_temporal() + "</b></p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p>La caducidad de clave es: 5 minutos</p>\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
        } catch (MessagingException mex) {
            String msg = "Error al sincronizar correo:" + mex.getMessage();
            System.out.println(msg);
        }
    }
*/
    /**
     * Envia correco desde la config
     *
     * @param registro envio
     * @param empres
     * @param ip
     */
/*
    public void envioEmailLogin(SgfSocio registro, GenEmpresa empres, String ip) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        try {
            System.out.println("Email enviado a : " + registro.getDirCorreo());
            sendMessageWithAttachment(registro.getDirCorreo(), empres.getNomEmpresa(),
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Ingreso banca web</h2>"
                    + "                <img src=" + this.logo + " alt=\"\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Fecha:" + dateToString + "</p>\n"
                    + "                <p>Estimado/a:<b> " + registro.getNomSocio() + " " + registro.getApeSocio() + "</b></p>\n"
                    + "                <p><b>Su ingreso se realizo con éxito</b></p>\n"
                    + "                <p>Desde la IP: <b>" + ip + "</b></p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
            String msg = "Email enviado login completado:" + registro.getDirCorreo();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        } catch (MessagingException mex) {
            System.out.println("No se ha podido enviar el email: " + mex.getMessage());
            String msg = "Email enviado login no completado:" + registro.getDirCorreo() + "message:" + mex.getMessage();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        }
    }
*/

/*
    public void envioEmail(SgfSocio registro, GenEmpresa empres, String mensaje) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        try {
            sendMessageWithAttachment(registro.getDirCorreo(), empres.getNomEmpresa(),
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Ingreso banca web</h2>"
                    + "                 <img src=" + this.logo + " alt=\"150\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Fecha:" + dateToString + "</p>\n"
                    + "                <p>Estimado/a:<b> " + registro.getNomSocio() + " " + registro.getApeSocio() + "</b></p>\n"
                    + "                <p>Mensaje:. <b>" + mensaje + "</b></p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p></p>\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
            String msg = "Email enviado recuperar contraseña completado:" + registro.getDirCorreo();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        } catch (MessagingException mex) {
            String msg = "Error al sincronizar email 1: " + registro.getDirCorreo() + " mensaje es: " + mex.getMessage();
            System.out.println(msg);
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        }
    }
*/
/*
    public void envioEmailUsuarioBloqueado(SgfSocio registro, GenEmpresa empres, String mensaje) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        try {
            sendMessageWithAttachment(registro.getDirCorreo(), empres.getNomEmpresa(),
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Ingreso banca web</h2>"
                    + "                 <img src=" + this.logo + " alt=\"\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Fecha:" + dateToString + "</p>\n"
                    + "                <p>Estimado/a:<b> " + registro.getNomSocio() + " " + registro.getApeSocio() + "</b></p>\n"
                    + "                 <p>Mensaje: <b>" + mensaje + "</b></p>\n"
                    + "                <p>Recupera tu usuario o crea una nueva contraseña desde Banca web en el texto <b>¿Olvide mi contraseña?</b></p> \n"
                    + "                 \n"
                    + "                <h3>RECUERDA </h3>\n"
                    + "                <p> El usuario y clave que cambies en Banca web también se cambiará en Banca móvil y viceversa.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p></p>\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "                <p>Atentamente:</p>\n"
                    + "                <p>" + empres.getNomEmpresa() + "</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
        } catch (MessagingException mex) {
            String msg = "Error al sincronizar email 1:" + mex.getMessage();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        }
    }
*/

    /**
     * Envia correco desde la config
     *
     * @param registro envio
     * @param empres
     */
/*
    public void avisoMensajeMasivoAdmin(SgfSocio registro, GenEmpresa empres, String mensaje) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        try {
            System.out.println("Email enviado a : " + "soporte.asotec@hottmail.com");
            sendMessageWithAttachment("soporte.asotec@hotmail.com", "AVISO URGENTE :::" + empres.getNomEmpresa(),
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Ingreso banca web</h2>"
                    + "                <img src=" + this.logo + " alt=\"\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Fecha:" + dateToString + "</p>\n"
                    + "                <p>Socio posible:<b> " + registro.getNomSocio() + " " + registro.getApeSocio() + "</b></p>\n"
                    + "                <p><b>Su ingreso se realizo con éxito</b></p>\n"
                    + "                <p>Desde la IP: <b> " + mensaje + " </b></p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
            String msg = "Email enviado login  completado:" + registro.getDirCorreo();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        } catch (MessagingException mex) {
            System.out.println("No se ha podido enviar el email: " + mex.getMessage());
            String msg = "Email enviado login no completado:" + registro.getDirCorreo() + "message:" + mex.getMessage();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        }
    }
*/
    
/*
    public void envioEmailSolicApertura(GenEmpresa empresa, String numId, String apeSocio, String nomSocio, java.sql.Date fecNac,
            String txtPaisNac, String txtProvNac, String txtCantonNac,
            String txtPaisDom, String txtProvDom, String txtCantonDom, String txtDir, String telf,String celular,String correo
    ) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SgfMensajes sms = new SgfMensajes();
        sms.setFecMensaje(new Date());
        String dateToString = df.format(sms.getFecMensaje());
        
        try {
            System.out.println("Email enviado a : " + empresa.getTxtEmail());
            sendMessageWithAttachment(empresa.getTxtEmail(), "Solicitud Apertura de Cuenta "+apeSocio+" "+nomSocio,
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n"
                    + "        <tr>\n"
                    + "            <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0;color:#000\">\n"
                    + "               <h2>Solicitud de Apertura de Cuenta</h2>"
                    + "                <img src=" + this.logo + " alt=\"\" style=\"display: block;\" />\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#eaeaea\" style=\"padding: 40px 30px 40px 30px;\">\n"
                    + "                <p>Un cliente ha completado el formulario de apertura de cuenta. A continuación, se detallan los datos proporcionados:</p>\n"
                    + "                <table>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Fecha de Solicitud: <b>"+dateToString+"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Identificación: <b>"+numId+"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Nombres: <b>"+apeSocio+" "+nomSocio+"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Fecha nac.: <b>"+fecNac.toString()+"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">País de nac.: <b>"+txtPaisNac+"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Provincia de nac.: <b>"+ txtProvNac +"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Canton de nac.: <b>"+txtCantonNac+"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 5px 10px 5px 10px;\"><b>Domicilio:</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">País: <b>"+ txtPaisDom +"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Provinvia: <b>"+txtProvDom+"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Cantón: <b>"+ txtCantonDom +"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Dirección: <b>"+ txtDir +"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Teléfono: <b>"+ telf +"</b></td>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">Celular: <b>"+ celular +"</b></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td style=\"padding: 0px 10px 0px 10px;\">E-mail: <b>"+ correo +"</b></td>\n"
                    + "                    </tr>\n"
                    + "                </table>\n"
                    //+ "                <p><b>Su ingreso se realizo con éxito</b></p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "            <td bgcolor=\"#1D52A5\" style=\"padding: 30px 30px 30px 30px;color:#fff\">\n"
                    + "                <p>Gracias por utilizar nuestro servicio.</p>\n"
                    + "            </td>\n"
                    + "        </tr>\n"
                    + "    </table>");
            String msg = "Email enviado login  completado:" + empresa.getTxtEmail();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        } catch (MessagingException mex) {
            System.out.println("No se ha podido enviar el email: " + mex.getMessage());
            String msg = "Email enviado login no completado:" + empresa.getTxtEmail() + "message:" + mex.getMessage();
            Logger.getLogger(emailService.class.getName()).log(Level.INFO, msg);
        }
    }
*/

}
