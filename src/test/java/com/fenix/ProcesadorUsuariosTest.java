package com.fenix;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ProcesadorUsuariosTest {

    @Test
    void testProcesarListaComportamientoActual() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();

        List<String> usuarios = List.of(
            "Ana:1",
            "Luis:2",
            "Eva:1"
        );

        String resultado = procesador.procesarLista(usuarios);

        assertEquals("Admins: Ana,Eva, | Invitados: Luis,", resultado);
    }
}
