import java.util.concurrent.TimeUnit;

public class Poncage_engine implements Runnable {
	private Player_data player;
	private int parcelle;
	private GameWindow gw;
	public Poncage_engine(Player_data player, int parcelle_id, GameWindow gw) {
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
				long cooldown = (long)player.ponc[parcelle].temps_prod;
				//ajout benefice du resp sur le cooldown
				TimeUnit.SECONDS.sleep(cooldown);
				if(player.ponc[parcelle].GetNiveau() != 0 && player.planche_non_poncee > 0) {
					player.remove_planche_non_poncee(1);
					player.add_planche(1);
					player.add_money(player.ponc[parcelle].GetRentabilite());
					System.out.println("planche produit par parcelle : " + String.valueOf(parcelle));
				}
				
			}
			catch(InterruptedException e) {
				System.out.print(e);
			}
		}
	}
}
