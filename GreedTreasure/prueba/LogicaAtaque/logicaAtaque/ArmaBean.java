
public class ArmaBean {

	protected String name;
	protected int nivel;
	protected int ataque;
	protected int defensa;
	protected int alcance;
	protected int resistencia;
	protected int municiones;
	protected int vida;

	public ArmaBean() {
		// Empty
	}

	public ArmaBean(String name, int nv, int a, int d, int alc, int m, int ra, int v) {

		this.name = name;
		this.ataque = a;
		this.defensa = d;
		this.alcance = alc;
		this.resistencia = ra;
		this.municiones = m;
		this.nivel = nv;
		this.vida = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getRA() {
		return resistencia;
	}

	public int getMuniciones() {
		return municiones;
	}

	public int getVida() {
		return vida;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setMuniciones(int municiones) {
		this.municiones = municiones;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public void setRA(int resistencia) {
		this.resistencia = resistencia;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
