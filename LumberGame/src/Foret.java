
public class Foret extends Parcelle{
	private int stockage_interne;
	private int temps_prod;
	
	public Foret(int parcelle_id) {
		//do stuff
		this.stockage_interne = 10;
	}
	
	public int GetStockageInterne() {
		return this.stockage_interne;
	}
	public void SetStockageInterne(int val) {
		this.stockage_interne = val;
	}
}
