
public class Conditionnement extends Usine{
	private int stockage_commande;
	
	public Conditionnement(int parcelle_id) {
		this.stockage_commande = 10;
	}
	
	public void SetStockageCommande(int val) {
		this.stockage_commande = val;
	}
	public int GetStockageCommande() {
		return this.stockage_commande;
	}

}
