package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.repository.FlorRepository;

@Service
public class FlorService implements IFlorService {

	@Autowired
	private FlorRepository florRepository;

	@Override
	public FlorDTO createFlor(FlorDTO florDTO) {
		FlorEntity flor = FlorEntity.toFlorEntity(florDTO);
		return FlorDTO.toFlorDTO(florRepository.save(flor));
	}

	@Override
	public FlorDTO getFlorById(Integer id) {
		FlorDTO florDTO = new FlorDTO();
		Optional<FlorEntity> flor = florRepository.findById(id);
		if (flor.isEmpty()) {
			florDTO = null;
		} else {
			florDTO = FlorDTO.toFlorDTO(flor.get());
		}
		return florDTO;
	}

	@Override
	public FlorDTO updateFlor(FlorDTO florDTOModificada) {
		FlorEntity flor = FlorEntity.toFlorEntity(florDTOModificada);
		return FlorDTO.toFlorDTO(florRepository.save(flor));
	}

	@Override
	public void deleteFlorById(Integer id) {
		florRepository.deleteById(id);

	}

	@Override
	public List<FlorDTO> getAllFlors() {
		List<FlorEntity> listFlor = florRepository.findAll();
		List<FlorDTO> listDTO = new ArrayList<FlorDTO>();
		for (FlorEntity flor : listFlor) {
			FlorDTO florDTO = new FlorDTO();
			florDTO = FlorDTO.toFlorDTO(flor);
			listDTO.add(florDTO);
		}

		return listDTO;
	}

}
