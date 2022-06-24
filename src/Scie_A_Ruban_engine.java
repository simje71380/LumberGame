import java.util.concurrent.TimeUnit;

public class Scie_A_Ruban_engine implements Runnable{
	
	private Player_data player;
	private int parcelle;
	private GameWindow gw;
	public Scie_A_Ruban_engine(Player_data player, int parcelle_id, GameWindow gw) {
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
				long cooldown = (long)player.scie[parcelle].temps_prod;
				//ajout benefice du resp sur le cooldown
				TimeUnit.SECONDS.sleep(cooldown);
				if(player.scie[parcelle].GetNiveau() != 0 && player.poutre > 0) {
					player.remove_poutre(1);
					player.add_planche_non_poncee(1);
					player.add_money(player.scie[parcelle].GetRentabilite());
					
					System.out.println("planche_non_poncee produit par parcelle : " + String.valueOf(parcelle));
				}
				
			}
			catch(InterruptedException e) {
				System.out.print(e);
			}
		}
	}
}
