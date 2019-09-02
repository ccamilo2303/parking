package com.parking.parking.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.parking.parking.modelo.Usuarios;

/**
 * 
 * @author Camilo
 * @since 30/08/2019
 *
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
	
	/**
	 * @param nombreUsuario
	 * @return
	 */
	public Usuarios findByNombreUsuario(String nombreUsuario);
	
	@Query(nativeQuery = true, value = "SELECT COALESCE(MAX(id_usuario), 0) + 1 i FROM public.usuarios;")
	public int generarIdUsuario();
	
}
