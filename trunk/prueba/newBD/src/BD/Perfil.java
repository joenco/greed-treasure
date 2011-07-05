package BD;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import BD.Usuario;

public class Perfil {

	private int id;
	private char[] descripcion;
	private byte[] foto;
	private Usuario usuario;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char[] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(char[] descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	  @OneToOne(cascade = CascadeType.ALL)
	  @PrimaryKeyJoinColumn
	  public Usuario getUsuario() {
	    return usuario;
	  }

	  public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	  }
}
