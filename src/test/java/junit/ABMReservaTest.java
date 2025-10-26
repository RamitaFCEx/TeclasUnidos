package junit;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teclasunidos.entities.*;
import teclasunidos.services.ReservaService;

import java.time.LocalDateTime;

public class ABMReservaTest {

    @Test
    public void eliminarReservaDeOtroUsuarioNoTieneEfecto() throws EdadInvalidaException, DNIInvalidoException, NombreMuyLargoException {
        Recurso r = new Recurso("Silla", "Tandil");
        Socio socio1 = new Socio("Pablo", 21, "Sarmiento 121", "4124977");
        Socio socio2 = new Socio("Horacio", 44, "Buzon 121", "1124957");
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = LocalDateTime.now();

        ReservaService reservaService = new ReservaService();

        // Se hace la reserva para el socio1
        Assertions.assertTrue(reservaService.reservar(r, socio1, inicio, fin));

        // Socio2 intenta cancelar la reserva anterior, se espera que no tenga efecto en el sistema
        Assertions.assertFalse(reservaService.cancelarReserva(r, socio2, inicio, fin));
    }
}
