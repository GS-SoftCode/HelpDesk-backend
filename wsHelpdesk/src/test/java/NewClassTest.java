/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASOTEC
 */

import java.security.MessageDigest;

public class NewClassTest {
    public static void main(String[] args) {        
        try {
            String text = "1234";
            System.out.println("Cadena cifrada: " + encriptarMD5(text));
            
            //Cadena cifrada: 81dc9bdb52d04dc20036dbd8313ed055
            //Cadena cifrada: 81dc9bdb52d04dc20036dbd8313ed055
            
            
            String cadenaEncriptada = "81dc9bdb52d04dc20036dbd8313ed055"; //1234
            String cadenaDescifrada = descifrarMD5(encriptarMD5(text));
            System.out.println("Cadena descifrada: " + cadenaDescifrada);
        } catch (Exception e) {
            System.out.println("Error al descifrar la cadena: " + e.getMessage());
        }

    }
    
    public static String descifrarMD5(String cadenaEncriptada) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(cadenaEncriptada.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
    
    public static String encriptarMD5(String cadena) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(cadena.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
