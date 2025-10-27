package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import teclasunidos.entities.DNIInvalidoException;
import teclasunidos.entities.EdadInvalidaException;
import teclasunidos.entities.NombreMuyLargoException;
import teclasunidos.entities.Socio;
import teclasunidos.repositories.SocioRepository;
import static org.testng.Assert.assertThrows;

public class ABMSocioTest {

    SocioRepository socioRepository;
    Socio socioBase;

    @BeforeTest
    public void setup() throws EdadInvalidaException, DNIInvalidoException, NombreMuyLargoException {
        socioRepository = new SocioRepository();
        socioBase = new Socio("A", 1, "S".repeat(1), "4".repeat(6));
    }

    @Test
    public void altaSocio(){
        socioRepository.agregar(socioBase);
        Assert.assertNotNull(socioRepository.buscarPorDni(socioBase.getDni()));
    }

    @Test
    public void bajaSocio(){
        socioRepository.agregar(socioBase);
        socioRepository.eliminar(socioBase.getDni());
        Assert.assertNull(socioRepository.buscarPorDni(socioBase.getDni()));
    }

    @Test
    public void modificacionSocio(){
        socioRepository.agregar(socioBase);
        socioBase.setDireccion("D".repeat(5));
        socioRepository.actualizar(socioBase);
        Assert.assertEquals(socioBase.getDireccion(), socioRepository.buscarPorDni(socioBase.getDni()).getDireccion());
    }

    @Test
    public void nombreMuyLargo(){
        assertThrows(NombreMuyLargoException.class, () -> {
            new Socio("A".repeat(51), 1, "S".repeat(8), "4".repeat(6));;
        });
    }

    @DataProvider(name = "dniInvalidosProvider")
    public Object[][] provideDNIInvalidos(){
        return new Object[][]{
                {"88888888"},     // Muy largo (8)
                {"55555"},        // Muy corto (5)
                {"66666."},       // Con punto
                {"111111A"},       // Con letra
                {null},
                {""}
        };
    }

    @Test(dataProvider = "dniInvalidosProvider")
    void deberiaLanzarExcepcionConDNIInvalido(String dni) {
        assertThrows(DNIInvalidoException.class, () -> {
            new Socio("A", 1, "S".repeat(1), dni);
        });
    }
}
