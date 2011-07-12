package tablaEnemigo;

public class EnemigoBean {

	protected String txtNick;
	protected int inNivel;
	protected int inVictoria;
	protected int inDerrota;

	public EnemigoBean() {
		// Empty
	}

	public EnemigoBean(String nick, int n, int v, int d) {

		this.txtNick = nick;
		this.inNivel = n;
		this.inVictoria = v;
		this.inDerrota = d;
	}

	public String getNick() {
		return txtNick;
	}

	public void setNick(String txtNick) {
		this.txtNick = txtNick;
	}
	
	public int getNivel() {
		return inNivel;
	}

	public int getVictoria() {
		return inVictoria;
	}

	public int getDerrota() {
		return inDerrota;
	}
	
	public void setNivel(int inNivel) {
		this.inNivel = inNivel;
	}

	public void setVictoria(int inVictoria) {
		this.inVictoria = inVictoria;
	}

	public void setDerrota(int inDerrota) {
		this.inDerrota = inDerrota;
	}
}
