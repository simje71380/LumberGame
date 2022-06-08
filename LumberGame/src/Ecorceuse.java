
public class Ecorceuse extends Usine {
	private int niveau;
	private double vitesse;
	private double rentabilite;
	private int stockage_interne;
	
	public Ecorceuse(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.rentabilite = 10.0;
		this.stockage_interne = 10;
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
	
	public void SetStockageInterne(int val) {
		this.stockage_interne = val;
	}
	public int GetStockageInterne() {
		return this.stockage_interne;
	}
	
	public void SetRentabilite(double val) {
		this.rentabilite = val;
	}
	public double GetRentabilite() {
		return this.rentabilite;
	}
}
