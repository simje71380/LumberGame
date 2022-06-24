import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fendage extends Usine {
	private int niveau;
	private double vitesse;
	private int parcelle_id;
	private int rentabilite;
	public float temps_prod = 10;
	
	public Fendage(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.parcelle_id = parcelle_id;
		try {
			File getCSVFiles = new File("GameData/fendage.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
		        	
		        	vitesse = Float.parseFloat(parts[1]);
		        	niveau = Integer.parseInt(parts[2]);
		        	rentabilite = Integer.parseInt(parts[3]);
		        	break;
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file");
			System.out.print(e);
		}
		for(int i=0; i< niveau ; i++) {
			temps_prod *= 0.95;
		}
	}
	public void LevelUp() {
		this.niveau++;
		this.temps_prod *=0.95;
		this.rentabilite++;
	}
	
	public void SetNiveau(int val) {
		this.niveau = val;
	}
	public int GetNiveau() {
		return this.niveau;
	}
	
	public double GetVitesse() {
		return this.vitesse;
	}
	public void SetVitesse(double val) {
		this.vitesse = val;
	}
	public int GetRentabilite() {
		return this.rentabilite;
	}
	
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/fendage.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        
	        String line;
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(vitesse);
		        	data += ";";
		        	data += String.valueOf(niveau);
		        	data += ";";
		        	data += String.valueOf(rentabilite);
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
			System.out.print("failed to open file GameData/fendage.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/fendage.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save fendage.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
}
