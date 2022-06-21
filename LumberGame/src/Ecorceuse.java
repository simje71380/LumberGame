import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ecorceuse extends Usine {
	private int niveau;
	private double vitesse;
	private double rentabilite;
	private int stockage_interne;
	private int parcelle_id;
	
	public Ecorceuse(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.rentabilite = 10.0;
		this.stockage_interne = 10;
		this.parcelle_id = parcelle_id;
		try {
			File getCSVFiles = new File("GameData/ecorceuse.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
		        	
		        	vitesse = Float.parseFloat(parts[1]);
		        	rentabilite = Float.parseFloat(parts[2]);
		        	stockage_interne = Integer.parseInt(parts[3]);
		        	niveau = Integer.parseInt(parts[4]);
		        	break;
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file");
			System.out.print(e);
		}
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
	
	public void SetStockageInterne(int val) {
		this.stockage_interne = val;
	}
	public int GetStockageInterne() {
		return this.stockage_interne;
	}
	
	public void SetRentabilite(double val) {
		this.rentabilite = val;
	}
	public double GetRentabilite() {
		return this.rentabilite;
	}
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/ecorceuse.csv");
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
		        	data += String.valueOf(rentabilite);
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
			System.out.print("failed to open file GameData/ecorceuse.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/ecorceuse.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save ecorceuse.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
}
