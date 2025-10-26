package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import teclasunidos.entities.DNIInvalidoException;
import teclasunidos.entities.EdadInvalidaException;
import teclasunidos.entities.NombreMuyLargoException;
import teclasunidos.entities.Socio;
import teclasunidos.repositories.SocioRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ABMSociosTest {
    SocioRepository socioRepository;
    Socio socioBase;

    @BeforeEach
    public void setup() throws EdadInvalidaException, DNIInvalidoException, NombreMuyLargoException {
        socioRepository = new SocioRepository();
        socioBase = new Socio("A", 1, "S".repeat(1), "4".repeat(6));
    }

    @Test
    public void altaSocio(){
        socioRepository.agregar(socioBase);
        Assertions.assertNotNull(socioRepository.buscarPorDni(socioBase.getDni()));
    }

    @Test
    public void bajaSocio(){
        socioRepository.agregar(socioBase);
        socioRepository.eliminar(socioBase.getDni());
        Assertions.assertNull(socioRepository.buscarPorDni(socioBase.getDni()));
    }

    @Test
    public void modificacionSocio(){
        socioRepository.agregar(socioBase);
        socioBase.setDireccion("D".repeat(5));
        socioRepository.actualizar(socioBase);
        Assertions.assertEquals(socioBase.getDireccion(), socioRepository.buscarPorDni(socioBase.getDni()).getDireccion());
    }

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
