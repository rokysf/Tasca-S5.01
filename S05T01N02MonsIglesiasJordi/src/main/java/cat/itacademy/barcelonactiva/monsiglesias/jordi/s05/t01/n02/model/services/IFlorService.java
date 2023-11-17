package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.services;

import java.util.List;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto.FlorDTO;

public interface IFlorService {

	FlorDTO createFlor(FlorDTO florDTO);

	FlorDTO getFlorById(Integer id);

	FlorDTO updateFlor(FlorDTO florDTOModificada);

	void deleteFlorById(Integer id);

	List<FlorDTO> getAllFlors();
}
