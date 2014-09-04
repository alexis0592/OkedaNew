package co.gov.fna.okeda.interfaces;

import com.parse.ParseUser;

import co.gov.fna.okeda.modelo.entidades.Usuario;

public interface IFactoryUsuario {

	public Usuario createUser(ParseUser user);

	public Usuario getCurrentUserInActivity();

	public void setUsuario(Usuario usuario);

}
