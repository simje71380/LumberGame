
public class Bucheron extends Ressource_Humaine{
	private int productivite;
	
	public Bucheron(int parcelle_id) {
		this.productivite = 0;
		this.revenu = 10;
		this.niveau = 0;
	}
	
	
	public int GetProductivite() {
		return this.productivite;
	}
	public void SetProductivite(int val) {
		this.productivite = val;
	}
}
