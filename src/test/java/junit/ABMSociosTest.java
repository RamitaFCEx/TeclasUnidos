package junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import teclasunidos.entities.DNIInvalidoException;
import teclasunidos.entities.NombreMuyLargoException;
import teclasunidos.entities.Socio;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ABMSociosTest {

    @Test
    public void nombreMuyLargo(){
        assertThrows(NombreMuyLargoException.class, () -> {
            new Socio("A".repeat(51), 1, "S".repeat(8), "4".repeat(6));;
        });
    }

    @Test
    public void deberiaLanzarExcepcionConDNINull(){
        assertThrows(DNIInvalidoException.class, () -> {
            new Socio("A", 1, "S".repeat(8), null);
        });
    }

    @ParameterizedTest(name = "DNI Inválido: {0}")
    @ValueSource(strings = {
            "88888888",     // Muy largo (8)
            "55555",        // Muy corto (5)
            "66666.",       // Con punto
            "111111A"      // Con letra
    })
    @NullAndEmptySource
    void deberiaLanzarExcepcionConDNIInvalido(String dni) {
        assertThrows(DNIInvalidoException.class, () -> {
            new Socio("A", 1, "S".repeat(1), dni);
        });
    }


}
