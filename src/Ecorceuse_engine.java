import java.util.concurrent.TimeUnit;

public class Ecorceuse_engine implements Runnable {
	private Player_data player;
	private int parcelle;
	private GameWindow gw;
	public Ecorceuse_engine(Player_data player, int parcelle_id, GameWindow gw) {
		this.player = player;
		parcelle = parcelle_id;
		this.gw = gw;
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(gw.continu) {
			try {
				long cooldown = (long)player.ecor[parcelle].temps_prod;
				//ajout benefice du resp sur le cooldown
				TimeUnit.SECONDS.sleep(cooldown);
				if(player.ecor[parcelle].GetNiveau() != 0 && player.bois > 0) {
					player.add_rondin(1);
					player.remove_bois(1);
					player.add_money(player.ecor[parcelle].GetRentabilite());
					System.out.println("rondin produit par parcelle : " + String.valueOf(parcelle));
				}
				
			}
			catch(InterruptedException e) {
				System.out.print(e);
			}
		}
	}
}

