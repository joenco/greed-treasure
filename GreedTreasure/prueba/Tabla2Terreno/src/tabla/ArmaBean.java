package tabla;

public class ArmaBean {

	protected String frstName;
	protected String lastName;
	protected int ataque;
	protected int defensa;
	protected int alcance;
	protected int num_armas;
	protected int municiones;
	protected int oro;
	protected String imageName;

	public ArmaBean() {
		// Empty
	}

	public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
			String imageName) {

		this.lastName = name;
		this.ataque = a;
		this.defensa = b;
		this.alcance = c;
		this.num_armas = d;
		this.municiones = e;
		this.oro = f;
		this.imageName = imageName;
	}

	public String getFrstName() {
		return frstName;
	}

	public void setFrstName(String frstName) {
		this.frstName = frstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getNum_Armas() {
		return num_armas;
	}

	public int getMuniciones() {
		return municiones;
	}

	public int getOro() {
		return oro;
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

	public void setNum_Armas(int num_armas) {
		this.num_armas = num_armas;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
