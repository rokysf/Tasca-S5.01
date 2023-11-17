package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SucursalDTO {

	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private static List<String> paisos = new ArrayList<>();
	
		
	public static void omplirLlistaPaisos() {
		
		paisos.add("Alemania");
		paisos.add("Bélgica");
		paisos.add("Croacia");
		paisos.add("Dinamarca");
		paisos.add("España");
		paisos.add("Francia");
		paisos.add("Irlanda");
		paisos.add("Letonia");
		paisos.add("Luxemburgo");
		paisos.add("Países Bajos");
		paisos.add("Suecia");
		paisos.add("Bulgaria");
		paisos.add("Eslovaquia");
		paisos.add("Estonia");
		paisos.add("Grecia");
		paisos.add("Malta");
		paisos.add("Polonia");
		paisos.add("República Checa");
		paisos.add("Austria");
		paisos.add("Chipre");
		paisos.add("Eslovenia");
		paisos.add("Finlandia");
		paisos.add("Hungría");
		paisos.add("Italia");
		paisos.add("Lituania");
		paisos.add("Portugal");
		paisos.add("Rumanía");
			
	}

	public String tipusSucursal(String paisSucursal) {
		
		return (paisos.contains(paisSucursal))?"UE":"Fora UE";

	}
	
}

