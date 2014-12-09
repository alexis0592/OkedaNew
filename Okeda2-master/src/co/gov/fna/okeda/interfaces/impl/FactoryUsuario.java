package co.gov.fna.okeda.interfaces.impl;

import com.parse.ParseUser;

import co.gov.fna.okeda.interfaces.IFactoryUsuario;
import co.gov.fna.okeda.modelo.entidades.Usuario;

public class FactoryUsuario implements IFactoryUsuario {

	private Usuario user;
	private static FactoryUsuario instance;

	private FactoryUsuario() {

	}

	public static FactoryUsuario getInstance() {
		if (instance == null)
			instance = new FactoryUsuario();
		return instance;
	}

	@Override
	public Usuario createUser(ParseUser user) {
		Usuario u = null;
		if (user != null) {
			u = new Usuario(user);
			this.user = u;
		}
		return u;
	}

	@Override
	public Usuario getCurrentUserInActivity() {
		return this.user;
	}

	@Override
	public void setUsuario(Usuario usuario) {
		this.user= usuario;
	}

}
