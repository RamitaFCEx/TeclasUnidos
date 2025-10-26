package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teclasunidos.entities.Recurso;

public class ABMRecursoTest {

    @Test
    public void recursoNoPuedeSerTipoOficina(){
        Recurso r = new Recurso("Oficina", "Tandil");
        Assertions.assertNull(r);
    }

}
