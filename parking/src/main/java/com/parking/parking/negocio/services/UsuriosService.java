package com.parking.parking.negocio.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.parking.modelo.Usuarios;
import com.parking.parking.negocio.repository.UsuariosRepository;

/**
 * @author Camilo
 * @since  30/08/2019
 */
@Service
@Transactional(readOnly = true)
public class UsuriosService {
	
	private final UsuariosRepository usuariosRepository;
	
	/**
	 * 
	 * @param usuariosRepository
	 */
	public UsuriosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	
	/**
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	public Usuarios findByNombreUsuario(String nombreUsuario) {
		return usuariosRepository.findByNombreUsuario(nombreUsuario);
	}
	
	/**
	 * 
	 * @param nombreUsuario
	 * @param clave
	 * @return
	 */
	public Map<String, Object> login(String nombreUsuario, String clave) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		
		Usuarios usuario = findByNombreUsuario(nombreUsuario);
		if(usuario == null) {
			retorno.put("error", true);
			retorno.put("mensaje", "El usuario: "+nombreUsuario+" no existe en el sistema");
		}else if(usuario.getClave().equals(clave) == false) {
			retorno.put("error", true);
			retorno.put("mensaje", "La contraseña es incorrecta");
		}else {
			retorno.put("error", false);
		}
		System.out.println(retorno);
		return retorno;
	}
	
	/**
	 * @param usuario
	 * @return
	 */
	@Transactional
	public Map<String, Object> crearUsuario(Usuarios usuario){
		Map<String, Object>registro = new HashMap<String, Object>();
		
		Usuarios usuarioTemp = findByNombreUsuario(usuario.getNombreUsuario());
		if(usuarioTemp != null) {
			registro.put("error", true);
			registro.put("mensaje", "El usuario: "+usuario.getNombreUsuario()+", ya existe en el sistema");
			return registro;
		}
		
		int idUsuario = usuariosRepository.generarIdUsuario();
		usuario.setIdUsuario(idUsuario);
		usuariosRepository.save(usuario);
		
		registro.put("error", false);
		registro.put("mensaje", "Usuario creado correctamente");
		
		return registro;
	}
	
	/**
	 * @return
	 */
	public List<Usuarios> findAll(){
		return usuariosRepository.findAll();
	}
	
}
