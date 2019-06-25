package com.at.loginapp.utils;

public interface MapperService<T, S> {
	/**
	 * 
	 * Metodo que mapea una entidad a dto
	 * 
	 * @param entity
	 * @return
	 */
	T mapToDto( S entity);
	/**
	 * 
	 * metodo que mapea un dto a entity
	 * 
	 * @param dto
	 * @return
	 */
	S mapToEntity(T dto);
}
