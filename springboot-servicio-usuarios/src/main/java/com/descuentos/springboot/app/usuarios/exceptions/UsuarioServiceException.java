package com.descuentos.springboot.app.usuarios.exceptions;

public class UsuarioServiceException extends RuntimeException{
 
	private static final long serialVersionUID = 1348771109171435607L;

	public UsuarioServiceException(String message)
	{
		super(message);
	}
}
