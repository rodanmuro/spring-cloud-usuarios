package com.example.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${server.port}")
	String puerto;
	
	@GetMapping("/")
	public String inicio() {
		return "Hola, soy el inicio de Usuarios desde el puerto "+puerto;
	}
	
	@GetMapping("/ordenes")
	public String ordenes(@RequestParam String usuario) {
		
		return restTemplate.getForObject("http://spring-cloud-ordenes.railway.internal:8080/ordenes/ordenes?usuario="+usuario, String.class);
		
	}

}
