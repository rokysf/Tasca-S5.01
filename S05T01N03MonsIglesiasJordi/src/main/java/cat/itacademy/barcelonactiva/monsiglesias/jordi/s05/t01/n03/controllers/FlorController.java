package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException.NotFound;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n03.model.services.IFlorService;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/flor")
public class FlorController {

	@Autowired
	private IFlorService florservice;

	@PostMapping("/clientFlorsAdd")
	public ResponseEntity<Mono<FlorDTO>> createFlor(@RequestBody FlorDTO florDTO) {
		return new ResponseEntity<>(florservice.createFlor(florDTO), HttpStatus.CREATED);
	}

	@GetMapping("/clientFlorsGetOne/{id}")
	public Mono<ResponseEntity<FlorDTO>> getFlorById(@PathVariable("id") Integer id) {
		 
		return florservice.getFlorById(id)
	           .map(florDTO -> new ResponseEntity<>(florDTO, HttpStatus.OK))
	           .onErrorReturn(NotFound.class, new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/clientFlorsUpdate")
	public Mono<ResponseEntity<FlorDTO>> update(@RequestBody FlorDTO florDTOModificada) {
		
		return 	florservice.updateFlor(florDTOModificada)
				.map(updateFlorDTO -> new ResponseEntity<>(updateFlorDTO, HttpStatus.OK))
				.onErrorReturn(NotFound.class, new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/clientFlorsDelete/{id}")
	public Mono<ResponseEntity<Void>> deleteFlorById(@PathVariable("id") Integer id) {
		return 	florservice.deleteFlorById(id)
				.map(updateFlorDTO -> new ResponseEntity<Void>(HttpStatus.OK))
				.onErrorReturn(NotFound.class, new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/clientFlorsGetAll")
	public Mono<ResponseEntity<List<FlorDTO>>> getAllFlors() {
		return florservice.getAllFlors()
	            .collectList()
	            .map(allFlorDTO -> {
	                if (allFlorDTO.isEmpty()) {
	                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	                } else {
	                    return new ResponseEntity<>(allFlorDTO, HttpStatus.OK);
	                }
	            });
	}          
}	
