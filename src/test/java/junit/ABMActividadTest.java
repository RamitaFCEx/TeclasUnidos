package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teclasunidos.entities.Actividad;

public class ABMActividadTest {
    @Test
    public void formatoActividadToString(){
        Actividad a = new Actividad("Zumba", "Pablo", "15", 18, "Tandil", 5);
        String s = a.toString();
        String[] l = s.split("-");
        Assertions.assertEquals(2, l.length);
    }

}
