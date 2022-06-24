import java.io.*;
public class Engine extends Thread {
	private Player_data player;
	private int parcelle;
	public Engine(Player_data player, int parcelle_id) {
		this.player = player;
		parcelle = parcelle_id;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
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
