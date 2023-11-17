package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.dto.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFlorService {

	Mono<FlorDTO> createFlor(FlorDTO florDTO);
	Mono<FlorDTO> getFlorById(Integer id);
	Mono<FlorDTO> updateFlor(FlorDTO florDTO);
	Mono<Void> deleteFlorById(Integer id);
	Flux<FlorDTO> getAllFlors();

}
