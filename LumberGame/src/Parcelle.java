
public class Parcelle {
	protected int taille;
	protected boolean unlocked;
	
	public int GetTaille() {
		return this.taille;
	}
	public void SetTaille(int val) {
		this.taille = val;
	}
	
	public boolean IsUnlocked() {
		return this.unlocked;
	}
	public void Unlock() {
		this.unlocked = true;
	}
}
