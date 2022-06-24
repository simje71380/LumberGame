import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Foret extends Parcelle{
	private int stockage_interne;
	private int niveau;
	public float temps_prod;
	private int parcelle_id;
	
	public Foret(Player_data player, int parcelle_id, GameWindow gw) {
		//do stuff
		this.stockage_interne = 10;
		this.temps_prod = 10;
		this.parcelle_id = parcelle_id;
		try {
			File getCSVFiles = new File("GameData/foret.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
		        	
		        	stockage_interne = Integer.parseInt(parts[1]);
		        	niveau = Integer.parseInt(parts[2]);
		        	break;
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file");
			System.out.print(e);
		}
		for(int i = 0;i < niveau; i++) {
			temps_prod *= 0.95;
		}
	}
	public int GetNiveau() {
		return this.niveau;
	}
	public void LvlUp() {
		this.niveau++;
		temps_prod *= 0.95;
	}
	public int GetStockageInterne() {
		return this.stockage_interne;
	}
	public void SetStockageInterne(int val) {
		this.stockage_interne = val;
	}
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/foret.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        
	        String line;
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(stockage_interne);
		        	data += ";";
		        	data += String.valueOf(niveau);
		        	data += "\n";
	        	}
	        	else {
	        		data+=line;
	        		data+="\n";
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file GameData/foret.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/foret.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save foret.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
}
