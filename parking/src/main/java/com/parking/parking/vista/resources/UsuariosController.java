package com.parking.parking.vista.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.parking.modelo.Usuarios;
import com.parking.parking.negocio.services.UsuriosService;

/**
 * @author Camilo
 * @since  30/08/2019
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/")
public class UsuariosController {

	@Autowired
	private UsuriosService usuariosService;



	@GetMapping(path ="/login/{nombreUsuario}/{clave}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> login(@PathVariable String nombreUsuario, @PathVariable String clave) {
		return usuariosService.login(nombreUsuario, clave);
	}

	@PostMapping(path = "/registro", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> registro(@RequestBody Usuarios usuario){
		return usuariosService.crearUsuario(usuario);
	}

}
