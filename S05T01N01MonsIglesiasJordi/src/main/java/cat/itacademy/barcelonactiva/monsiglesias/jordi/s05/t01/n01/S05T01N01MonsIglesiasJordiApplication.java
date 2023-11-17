package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.repository.SucursalRepository;



@SpringBootApplication
public class S05T01N01MonsIglesiasJordiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01MonsIglesiasJordiApplication.class, args);
	
		SucursalDTO.omplirLlistaPaisos();
	
	}

	@Autowired
	private SucursalRepository sucursalrepository;
		
	@Override
	public void run(String... args) throws Exception {
		Sucursal sucursal1 = new Sucursal("Prueba1", "España");
		sucursalrepository.save(sucursal1);
		Sucursal sucursal2 = new Sucursal("Prueba2", "Italia");
		sucursalrepository.save(sucursal2);
		Sucursal sucursal3 = new Sucursal("Prueba3", "Rusia");
		sucursalrepository.save(sucursal3);
		Sucursal sucursal4 = new Sucursal("Prueba4", "Andorra");
		sucursalrepository.save(sucursal4);
		
	}

}
