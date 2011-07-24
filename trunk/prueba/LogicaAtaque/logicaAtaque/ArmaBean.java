
public class ArmaBean {

	protected String frstName;
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

	public ArmaBean(String name, int a, int b, int c, int d, int e, int f, int nv) {

		this.name = name;
		this.ataque = a;
		this.defensa = b;
		this.alcance = c;
		this.resistencia = d;
		this.municiones = e;
		this.nivel = nv;
		this.vida = f;
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
