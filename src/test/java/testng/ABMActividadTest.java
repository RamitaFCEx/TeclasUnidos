package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teclasunidos.entities.*;
import teclasunidos.repositories.ActividadRepository;
import teclasunidos.services.InscripcionService;

public class ABMActividadTest {

    private ActividadRepository actividadRepo;
    private Actividad actividadBase;
    @BeforeTest
    public void setup() {
        actividadRepo = new ActividadRepository();
        actividadBase = new Actividad("Zumba", "Pablo", "15", 18, "Tandil", 1);
    }

    @Test
    public void altaActividad(){
        actividadRepo.agregar(actividadBase);
        Assert.assertNotNull(actividadRepo.buscarPorNombre(actividadBase.getNombre()));
    }

    @Test
    public void bajaActividad(){
        actividadRepo.agregar(actividadBase);
        actividadRepo.eliminar(actividadBase.getNombre());
        Assert.assertNull(actividadRepo.buscarPorNombre(actividadBase.getNombre()));
    }

    @Test
    public void modificacionActividad(){
        final String nuevoNombre = "Pedro";
        actividadRepo.agregar(actividadBase);
        actividadBase.setEncargado(nuevoNombre);
        actividadRepo.actualizar(actividadBase);
        Assert.assertEquals(actividadBase.getNombre(), actividadRepo.buscarPorNombre(actividadBase.getNombre()).getNombre());
    }


    @Test
    public void formatoActividadToString(){
        String[] l = actividadBase.toString().split("-");
        Assert.assertEquals(2, l.length);
    }

    @Test
    public void unSocioNoPuedeInscribirseSiYaSeLlegoAlCupo() throws EdadInvalidaException, DNIInvalidoException, NombreMuyLargoException {
        Socio socio1 = new Socio("A".repeat(6), 22, "B".repeat(6), "4".repeat(6));
        Socio socio2 = new Socio("A".repeat(6), 22, "B".repeat(6), "1".repeat(7));

        InscripcionService inscripcionService = new InscripcionService();
        Assert.assertTrue(inscripcionService.inscribir(socio1, actividadBase));
        Assert.assertFalse(inscripcionService.inscribir(socio2, actividadBase));
    }
}
