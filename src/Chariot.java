
public class Chariot extends Vehicule{
	private int niveau;
	public Chariot(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 1.0;
		this.capacite = 10;
	}
	
	public void SetNiveau(int val) {
		this.niveau = val;
	}
	public int GetNiveau() {
		return this.niveau;
	}
}
