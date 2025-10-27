package tdyv.java;

public class PruebaHumo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			NominaSocios.Asociar(new Persona("Juan Bautista","Alberdii","25073057" ,50));
			NominaSocios.Asociar(new Persona("Carlos Aberto","Spinettai","12073557" ,75));
			NominaSocios.Asociar(new Persona("Juan Salvador","Dahli","173057" ,90));
			System.out.println("El club tiene "+NominaSocios.ContarSocios()+" socios");
			System.out.println(NominaSocios.YaExisteEnNomina(new Persona("Juan Bautsta","Alberdii","25073057" ,50)));
			System.out.println(NominaSocios.nomina.get(0));
			
			OfertaActividades.NuevaActividad(new Actividad("Futbol",new Persona("Juan Salvador","Bilardo","1225588",70 ),2,16));
			OfertaActividades.NuevaActividad(new Actividad("Tenis",new Persona("Juan Matín","Del Potro","285588",350 ),4,50));
			
			OfertaActividades.GetNomina().get(0).inscribirSocio(NominaSocios.GetNomina().get(0));
			OfertaActividades.GetNomina().get(0).inscribirSocio(NominaSocios.GetNomina().get(1));
			OfertaActividades.GetNomina().get(0).inscribirSocio(NominaSocios.GetNomina().get(2));
			
		} catch (YaExisteSocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
