
public class Fendage extends Usine {
	private int niveau;
	private double vitesse;
	
	public Fendage(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
	}
	
	public void SetNiveau(int val) {
		this.niveau = val;
	}
	public int GetNiveau() {
		return this.niveau;
	}
	
	public double GetVitesse() {
		return this.vitesse;
	}
	public void SetVitesse(double val) {
		this.vitesse = val;
	}
}
