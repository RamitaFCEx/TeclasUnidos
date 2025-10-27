package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teclasunidos.entities.Recurso;
import teclasunidos.repositories.RecursoRepository;

public class ABMRecursoTest {

    private final String RECURSO_PROHIBIDO = "Oficina";

    private RecursoRepository recursoRepository;
    private Recurso recursoBase;
    @BeforeTest
    public void setup() {
        recursoRepository = new RecursoRepository();
        recursoBase = new Recurso("S".repeat(5), "T".repeat(9));
    }

    @Test
    public void altaRecurso(){
        recursoRepository.agregar(recursoBase);
        Assert.assertNotNull(recursoRepository.buscarPorNombre(recursoBase.getNombre()));
    }

    @Test
    public void bajaRecurso(){
        recursoRepository.agregar(recursoBase);
        recursoRepository.eliminar(recursoBase.getNombre());
        Assert.assertNull(recursoRepository.buscarPorNombre(recursoBase.getNombre()));
    }

    @Test
    public void modificacionRecurso(){
        recursoRepository.agregar(recursoBase);
        recursoBase.setUbicacion("O".repeat(6));
        recursoRepository.actualizar(recursoBase);
        Assert.assertEquals(recursoBase.getUbicacion(), recursoRepository.buscarPorNombre(recursoBase.getNombre()).getUbicacion());
    }

    @Test
    public void recursoNoPuedeSerTipoOficina(){
        Recurso r = new Recurso(RECURSO_PROHIBIDO, "T".repeat(5));
        Assert.assertNull(r.getNombre());
    }
}
