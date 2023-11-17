package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.services;

import java.util.List;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.dto.SucursalDTO;

public interface ISucursalService {

	Sucursal createSucursal(Sucursal sucursal);
	
	SucursalDTO getSucursalById(Integer id);
	
	Sucursal updateSucursal(Sucursal sucursalModificada);
	
	void deleteSucursalById(Integer id);
	
	List<SucursalDTO> getAllSucursals();
}
