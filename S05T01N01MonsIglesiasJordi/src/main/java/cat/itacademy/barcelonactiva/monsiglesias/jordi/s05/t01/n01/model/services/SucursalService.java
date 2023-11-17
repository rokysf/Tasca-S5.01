package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalService implements ISucursalService{

	@Autowired
	private SucursalRepository sucursalrepository;
	
	@Override
	public Sucursal createSucursal(Sucursal sucursal) {
		return sucursalrepository.save(sucursal);
	}

	@Override
	public SucursalDTO getSucursalById(Integer id) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		Optional<Sucursal> sucursal = sucursalrepository.findById(id);
		if(sucursal.isEmpty()) {
		sucursalDTO = null;	
		}else {
		sucursalDTO.setPk_SucursalID(sucursal.get().getPk_SucursalID());
		sucursalDTO.setNomSucursal(sucursal.get().getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.get().getPaisSucursal());
		sucursalDTO.setTipusSucursal(sucursalDTO.tipusSucursal(sucursalDTO.getPaisSucursal()));
		}
		return sucursalDTO;
	}

	@Override
	public Sucursal updateSucursal(Sucursal sucursalModificada) {
		return sucursalrepository.save(sucursalModificada);
	}

	@Override
	public void deleteSucursalById(Integer id) {
		sucursalrepository.deleteById(id);
	}

	public List<SucursalDTO> getAllSucursals(){
		List<Sucursal> listSucursal = sucursalrepository.findAll();
		List<SucursalDTO> listDTO = new ArrayList<SucursalDTO>();
		for (Sucursal sucursal : listSucursal) {
			SucursalDTO sucursalDTO = new SucursalDTO();
			sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
			sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
			sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
			sucursalDTO.setTipusSucursal(sucursalDTO.tipusSucursal(sucursalDTO.getPaisSucursal()));
			listDTO.add(sucursalDTO);
		}
	
	return listDTO;
	
	}

}
