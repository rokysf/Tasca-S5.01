package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.controllers;

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
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.services.IFlorService;


@RestController
@RequestMapping("/flor")
public class FlorController {

	@Autowired
	private IFlorService florservice;

	@PostMapping("/add")
	public ResponseEntity<FlorDTO> createFlor(@RequestBody FlorDTO florDTO) {
		return new ResponseEntity<>(florservice.createFlor(florDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getFlorById(@PathVariable("id") Integer id) {
		FlorDTO florDTO = florservice.getFlorById(id);
		if (florDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(florDTO, HttpStatus.OK);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<FlorDTO> update(@RequestBody FlorDTO florDTOModificada) {
		FlorDTO florDTO = florservice.getFlorById(florDTOModificada.getPk_FlorID());
		if (florDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(florservice.updateFlor(florDTOModificada), HttpStatus.OK);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFlorById(@PathVariable("id") Integer id) {
		FlorDTO florDTO = florservice.getFlorById(id);
		if (florDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			florservice.deleteFlorById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAllFlors() {
		if (florservice.getAllFlors().size() == 0) {
			return new ResponseEntity<List<FlorDTO>>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<List<FlorDTO>>(florservice.getAllFlors(), HttpStatus.OK);
	}
}
