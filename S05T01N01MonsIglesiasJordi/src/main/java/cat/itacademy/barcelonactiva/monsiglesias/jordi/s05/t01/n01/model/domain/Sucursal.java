package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sucursal")
@Data
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sucursalid")
	private Integer pk_SucursalID;
	@Column(name = "nom", nullable = false)
	private String nomSucursal;
	@Column(name ="pais", nullable = false)
	private String paisSucursal;
	
	
	public Sucursal() {
		
	}
	
	public Sucursal(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
	
}
