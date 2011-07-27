

public class CaballeroBean {

	protected String nick;
	protected int nivel;
	protected int ataque;
	protected int sa;
	protected int defensa;
	protected int sd;
	protected int habilidad;
	protected int vida;
	protected int exp;
	protected int victoria;
	protected int derrota;

	public CaballeroBean() {
		// Empty
	}

	public CaballeroBean(String nick, int nc, int a, int sa, int d, int sd, int e, int hab, int v, int vc, int dc) {

		this.nick = nick;
		this.ataque = a;
		this.sa = sa;
		this.defensa = d;
		this.sd = sd;
		this.nivel = nc;
		this.habilidad = hab;
		this.vida = v;
		this.exp = e;
		this.victoria = vc;
		this.derrota = dc;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public  int getSA() {
		return sa;
	}

	public void setSA(int sa) {
		this.sa = sa;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSD() {
		return sd;
	}

	public void setSD(int sd) {
		this.sd = sd;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getHab() {
		return habilidad;
	}

	public void setHab(int habilidad) {
		this.habilidad = habilidad;
}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getVictoria() {
		return victoria;
	}

	public void setVictoria(int victoria) {
		this.victoria = victoria;
	}

	public int getDerrota() {
		return derrota;
	}

	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}
}
