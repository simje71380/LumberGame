
public class Responsable {
	private int rentabilite;
	private int niveau;
	
	public Responsable(int parcelle_id) {
		rentabilite = 0;
		niveau = 0;
	};
	
	public int GetRentabilite() {
		return this.rentabilite;
	}
	
	public void SetRentabilite(int val) {
		this.rentabilite = val;
	}
	
	public void SetNiveau(int valeur) {
		this.niveau = valeur;
	}
	
	public int GetNiveau() {
		return this.niveau;
	}
	
	public void LevelUp() { //incrémente le niveau du responsable
		this.niveau++;
	}
	
	
	
	//Simon : me permettra de stocker les données
	public void UpdateDB() {
		
	}
}
