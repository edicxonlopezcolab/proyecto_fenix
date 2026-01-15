package com.proyecto.fenix;

import java.util.List;

/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
/**
 * Clase encargada de la lógica de procesamiento y clasificación 
 * de usuarios según su rol asignado.
 * * @author Edicxon Gabriel Lopez Duque
 * @version 1.0
 */
public class ProcesadorUsuarios {

    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;

    /**
     * Procesa una lista de cadenas con formato "nombre:rol" y las clasifica.
     * * @param usuarios Lista de Strings que contienen los datos de los usuarios.
     * @return Un String formateado con la lista de Admins e Invitados.
     */
    
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String usuario : usuarios) {
            String[] parts = usuario.split(":");
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins, nombre);
                } else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    /** 
     * @param admins
     * @param nombre
     * @return String
     */
    private String procesarAdmin(String admins, String nombre) {
        return admins + nombre + ",";
    }

    /** 
     * @param invitados
     * @param nombre
     * @return String
     */
    private String procesarInvitado(String invitados, String nombre) {
        return invitados + nombre + ",";
    }
}