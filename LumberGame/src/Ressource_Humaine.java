
public class Ressource_Humaine {
	protected double revenu;
	protected int nombre; //pas sur que ce soit utile
	protected int niveau;
	
	public void SetNiveau(int val) {
		this.niveau = val;
	}
	public int GetNiveau() {
		return this.niveau;
	}
	
	public void SetRevenu(int val) {
		this.revenu = val;
	}
	public double GetRevenu() {
		return this.revenu;
	}
}
