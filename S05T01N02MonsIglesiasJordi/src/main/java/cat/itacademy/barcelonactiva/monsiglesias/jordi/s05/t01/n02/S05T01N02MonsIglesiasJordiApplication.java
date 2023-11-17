package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n02.model.repository.FlorRepository;



@SpringBootApplication
public class S05T01N02MonsIglesiasJordiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N02MonsIglesiasJordiApplication.class, args);

		FlorDTO.omplirLlistaPaisos();
	}

	@Autowired
	private FlorRepository florRepository;

	@Override
	public void run(String... args) throws Exception {
		FlorEntity flor1 = new FlorEntity("Rosa", "España");
		florRepository.save(flor1);
		FlorEntity flor2 = new FlorEntity("Clavel", "Francia");
		florRepository.save(flor2);
		FlorEntity flor3 = new FlorEntity("Margarita", "Dinamarca");
		florRepository.save(flor3);
		FlorEntity flor4 = new FlorEntity("Amapola", "Andorra");
		florRepository.save(flor4);
		FlorEntity flor5 = new FlorEntity("Geranio", "Portugal");
		florRepository.save(flor5);

	}

}
