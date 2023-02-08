package com.educacionit.javawebapi.jdbc.interfaces;

import java.util.List;

/**
 * 
 * @author Octavio Robleto
 *
 * @param <E> Elemento (Registro) a retornar
 * @param <K> Clave Primaria de la tabla
 */
public interface DAO<E, K> {

	E buscarPorID(K k);

	boolean guardar(E e);

	boolean eliminar(E e);

	List<E> listar();

}
