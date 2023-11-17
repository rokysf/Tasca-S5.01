package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.dto.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class FlorService implements IFlorService{

	@Autowired
	private WebClient webClient;
	
	@Override
	public Mono<FlorDTO> createFlor(FlorDTO florDTO) {
		Mono<FlorDTO> mono = webClient.post().uri("/add")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(florDTO), FlorDTO.class)
				.retrieve()
				.bodyToMono(FlorDTO.class);
		return mono;
	}
	
	@Override
	public Mono<FlorDTO> getFlorById(Integer id) {
		Mono<FlorDTO> mono = webClient.get().uri("/getOne/{id}", id)
				.retrieve()
				.bodyToMono(FlorDTO.class);
		return mono;
	}
	
	@Override
	public Mono<FlorDTO> updateFlor(FlorDTO florDTO) {
		Mono<FlorDTO> mono = webClient.put().uri("/update")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(florDTO), FlorDTO.class)
				.retrieve()
				.bodyToMono(FlorDTO.class);
		return mono;
	}
	
	@Override
	public Mono<Void> deleteFlorById(Integer id) {
		Mono<Void> mono = webClient.delete().uri("/delete/{id}", id)
				.retrieve()
				.bodyToMono(Void.class);
		return mono;
	}

	@Override
	public Flux<FlorDTO> getAllFlors() {
		Flux<FlorDTO> flux = webClient.get().uri("/getAll")
				.retrieve()
				.bodyToFlux(FlorDTO.class);
		return flux;
	}
}
