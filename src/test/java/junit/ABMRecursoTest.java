package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teclasunidos.entities.Recurso;
import teclasunidos.repositories.RecursoRepository;

public class ABMRecursoTest {
    private final String RECURSO_PROHIBIDO = "Oficina";

    private RecursoRepository recursoRepository;
    private Recurso recursoBase;
    @BeforeEach
    public void setup() {
        recursoRepository = new RecursoRepository();
        recursoBase = new Recurso("S".repeat(5), "T".repeat(9));
    }

    @Test
    public void altaRecurso(){
        recursoRepository.agregar(recursoBase);
        Assertions.assertNotNull(recursoRepository.buscarPorNombre(recursoBase.getNombre()));
    }

    @Test
    public void bajaRecurso(){
        recursoRepository.agregar(recursoBase);
        recursoRepository.eliminar(recursoBase.getNombre());
        Assertions.assertNull(recursoRepository.buscarPorNombre(recursoBase.getNombre()));
    }

    @Test
    public void modificacionRecurso(){
        recursoRepository.agregar(recursoBase);
        recursoBase.setUbicacion("O".repeat(6));
        recursoRepository.actualizar(recursoBase);
        Assertions.assertEquals(recursoBase, recursoRepository.buscarPorNombre(recursoBase.getNombre()));
    }

    @Test
    public void recursoNoPuedeSerTipoOficina(){
        Recurso r = new Recurso(RECURSO_PROHIBIDO, "T".repeat(5));
        Assertions.assertNull(r.getNombre());
    }

}
