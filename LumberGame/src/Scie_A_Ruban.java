
public class Scie_A_Ruban extends Usine {
	private int niveau;
	private double vitesse;
	private double rentabilite;
	private int stockage_interne_avant;
	private int stockage_interne_arriere;
	
	public Sice_A_Ruban(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.rentabilite = 10.0;
		this.stockage_interne_avant = 10;
		this.stockage_interne_arriere = 10;
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
	
	public void SetStockageInterneArriere(int val) {
		this.stockage_interne_arriere = val;
	}
	public int GetStockageInterneArriere() {
		return this.stockage_interne_arriere;
	}
	
	public void SetStockageInterneAvant(int val) {
		this.stockage_interne_avant = val;
	}
	public int GetStockageInterneAvant() {
		return this.stockage_interne_avant;
	}
	
	public void SetRentabilite(double val) {
		this.rentabilite = val;
	}
	public double GetRentabilite() {
		return this.rentabilite;
	}
}
