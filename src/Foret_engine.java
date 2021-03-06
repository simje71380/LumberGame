import java.util.concurrent.TimeUnit;


public class Foret_engine implements Runnable{
	private Player_data player;
	private int parcelle;
	private GameWindow gw;
	public Foret_engine(Player_data player, int parcelle_id, GameWindow gw) {
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
				long cooldown = (long)player.foret[parcelle].temps_prod;
				//ajout benefice du resp sur le cooldown
				TimeUnit.SECONDS.sleep(cooldown);
				if(player.foret[parcelle].GetNiveau() != 0) {
					player.add_bois(1);
					System.out.println("bois produit par parcelle : " + String.valueOf(parcelle));
				}
				
			}
			catch(InterruptedException e) {
				System.out.print(e);
			}
		}
	}
}
