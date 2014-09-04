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
		// TODO Auto-generated method stub
		Usuario u = null;
		if (user != null) {
			u = new Usuario(user);
			this.user = u;
		}
		return u;
	}

	@Override
	public Usuario getCurrentUserInActivity() {
		// TODO Auto-generated method stub
		return this.user;
	}

	@Override
	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.user= usuario;
	}

}
