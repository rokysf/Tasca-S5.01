package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.domain;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto.FlorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "florEntity")
@Data

public class FlorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "florid")
	private Integer pk_FlorID;
	@Column(name = "nom", nullable = false)
	private String nomFlor;
	@Column(name ="pais", nullable = false)
	private String paisFlor;
	
	
	public FlorEntity(String nomFlor, String paisFlor) {
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
	}
	
	public static FlorEntity toFlorEntity(FlorDTO florDTO) {

		return FlorEntity.builder()
				.pk_FlorID(florDTO.getPk_FlorID())
				.nomFlor(florDTO.getNomFlor())
				.paisFlor(florDTO.getPaisFlor())
				.build();
	}
	
	
	
	
}

