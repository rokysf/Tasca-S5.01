package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto;

import java.util.ArrayList;
import java.util.List;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.domain.FlorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlorDTO {

	private Integer pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
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

	public String tipusFlor(String paisFlor) {
		
		return (paisos.contains(paisFlor))?"UE":"Fora UE";

	}

	public static FlorDTO toFlorDTO(FlorEntity flor) {
		FlorDTO dto = FlorDTO.builder()
				.pk_FlorID(flor.getPk_FlorID())
				.nomFlor(flor.getNomFlor())
				.paisFlor(flor.getPaisFlor())
				.build();

		dto.setTipusFlor(paisos.contains(dto.getPaisFlor()) ? "EU" : "ForaUE");
		return dto;
	}
	


}
