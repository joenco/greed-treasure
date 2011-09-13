package table;

public class ArmasBean {
	public String nombre;
	public int ataque;
	public int defensa;
	public int alcance;
	public int num_armas;
	public int municiones;
	public int oro;
	
	public ArmasBean(){
		//VACIO
	}
	
	public ArmasBean(String nombre, int ataque, int defensa, int alcance,
			int num_armas, int municiones, int oro) {

		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.alcance = alcance;
		this.num_armas = num_armas;
		this.municiones = municiones;
		this.oro = oro;
	}
	

	// -------

	public String getNombre() {
		return nombre;

	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAtaque() {
		return ataque;

	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	
	public int getDefensa() {
		return defensa;

	}
	
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	
	public int getAlcance() {
		return alcance;

	}
	
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	

	public int getNum_arma() {
		return num_armas;

	}
	
	public void setNum_armas(int num_armas) {
		this.num_armas = num_armas;
	}
	
	public int getMuniciones() {
		return municiones;

	}
	
	public void setMuniciones(int municiones) {
		this.municiones = municiones;
	}

	public int getOro() {
		return oro;

	}
	
	public void setOro(int oro) {
		this.oro = oro;
	}
	
	
	
}