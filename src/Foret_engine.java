package GameData;

public class Foret_engine {
	private Player_data player;
	private int parcelle;
	private GameWindow gw;
	public Foret_engine(Player_data player, int parcelle_id, GameWindow gw) {
		this.player = player;
		parcelle = parcelle_id;
		this.gw = gw;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(gw.continu) {
			//do stuff
			player.argent++;
			try {
				Thread.sleep(1000);//1 sec
			}
			catch(InterruptedException e) {
				
			}
		}
	}
}
