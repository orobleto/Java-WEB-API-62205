package com.educacionit.interfaces;

import jakarta.ws.rs.core.Response;

public interface ServicioGenerico<E, K> {

	Response buscarPorID(K k);

	Response guardar(E e);

	Response eliminar(E e);

	Response listar();
}
