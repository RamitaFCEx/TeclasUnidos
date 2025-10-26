package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teclasunidos.entities.*;
import teclasunidos.repositories.ActividadRepository;
import teclasunidos.services.InscripcionService;

public class ABMActividadTest {
    private ActividadRepository actividadRepo;
    private Actividad actividadBase;
    @BeforeEach
    public void setup() {
        actividadRepo = new ActividadRepository();
        actividadBase = new Actividad("Zumba", "Pablo", "15", 18, "Tandil", 1);
    }

    @Test
    public void altaActividad(){
        actividadRepo.agregar(actividadBase);
        Assertions.assertNotNull(actividadRepo.buscarPorNombre(actividadBase.getNombre()));
    }

    @Test
    public void bajaActividad(){
        actividadRepo.agregar(actividadBase);
        actividadRepo.eliminar(actividadBase.getNombre());
        Assertions.assertNull(actividadRepo.buscarPorNombre(actividadBase.getNombre()));
    }

    @Test
    public void modificacionActividad(){
        final String nuevoNombre = "Pedro";
        actividadRepo.agregar(actividadBase);
        actividadBase.setEncargado(nuevoNombre);
        actividadRepo.actualizar(actividadBase);
        Assertions.assertEquals(actividadBase.getNombre(), actividadRepo.buscarPorNombre(actividadBase.getNombre()).getNombre());
    }


    @Test
    public void formatoActividadToString(){
        String[] l = actividadBase.toString().split("-");
        Assertions.assertEquals(2, l.length);
    }

    @Test
    public void unSocioNoPuedeInscribirseSiYaSeLlegoAlCupo() throws EdadInvalidaException, DNIInvalidoException, NombreMuyLargoException {
        Socio socio1 = new Socio("A".repeat(6), 22, "B".repeat(6), "4".repeat(6));
        Socio socio2 = new Socio("A".repeat(6), 22, "B".repeat(6), "1".repeat(7));

        InscripcionService inscripcionService = new InscripcionService();
        Assertions.assertTrue(inscripcionService.inscribir(socio1, actividadBase));
        Assertions.assertFalse(inscripcionService.inscribir(socio2, actividadBase));
    }

}
