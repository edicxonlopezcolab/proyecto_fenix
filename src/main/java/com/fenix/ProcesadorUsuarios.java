package com.fenix;

import java.util.List;

/**
 * Clase encargada de procesar una lista de usuarios y clasificarlos
 * según su rol (administrador o invitado).
 * <p>
 * Cada usuario se representa como una cadena con el formato:
 * <code>nombre:rol</code>, donde el rol es un valor numérico.
 * </p>
 */
public class ProcesadorUsuarios {

    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;

    /**
     * Procesa una lista de usuarios y devuelve una cadena con los usuarios
     * clasificados por rol.
     *
     * @param usuarios lista de usuarios en formato "nombre:rol"
     * @return una cadena con los administradores y los invitados separados
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins += procesarAdmin(nombre);
                } else if (rol == ROL_INVITADO) {
                    invitados += procesarInvitado(nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    /**
     * Procesa un usuario con rol de invitado.
     *
     * @param nombre nombre del usuario invitado
     * @return nombre del invitado seguido de una coma
     */
    private String procesarInvitado(String nombre) {
        return nombre + ",";
    }

    /**
     * Procesa un usuario con rol de administrador.
     *
     * @param nombre nombre del usuario administrador
     * @return nombre del administrador seguido de una coma
     */
    private String procesarAdmin(String nombre) {
        return nombre + ",";
    }
}
