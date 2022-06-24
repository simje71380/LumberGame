
public class Vehicule {
	protected int capacite;
	protected double vitesse;
	protected int nombre; // pas sûr que ce soit utile guetteur et setteur pas faient
	
	public void SetVitesse(double val) {
		this.vitesse = val;
	}
	public double GetVitesse() {
		return this.vitesse;
	}
	
	public void SetCapacite(int val) {
		this.capacite = val;
	}
	public int GetCapacite() {
		return this.capacite;
	}
	
}
