import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scie_A_Ruban extends Usine {
	private int niveau;
	private double vitesse;
	private int rentabilite;
	private int stockage_interne_avant;
	private int stockage_interne_arriere;
	private int parcelle_id;
	public float temps_prod = 10;
	
	public Scie_A_Ruban(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.stockage_interne_avant = 10;
		this.stockage_interne_arriere = 10;
		this.parcelle_id = parcelle_id;
		try {
			File getCSVFiles = new File("GameData/scie_a_ruban.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
		        	
		        	vitesse = Float.parseFloat(parts[1]);
		        	rentabilite = Integer.parseInt(parts[2]);
		        	stockage_interne_avant = Integer.parseInt(parts[3]);
		        	stockage_interne_arriere = Integer.parseInt(parts[4]);
		        	niveau = Integer.parseInt(parts[5]);
		        	break;
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file");
			System.out.print(e);
		}
		for(int i=0; i<niveau; i++) {
			temps_prod *= 0.95;
		}
	}
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/scie_a_ruban.csv");
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
		        	data += String.valueOf(stockage_interne_avant);
		        	data += ";";
		        	data += String.valueOf(stockage_interne_arriere);
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
			System.out.print("failed to open file GameData/scie_a_ruban.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/scie_a_ruban.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save scie_a_ruban.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
	
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
	
	public void SetStockageInterneArriere(int val) {
		this.stockage_interne_arriere = val;
	}
	public int GetStockageInterneArriere() {
		return this.stockage_interne_arriere;
	}
	
	public void SetStockageInterneAvant(int val) {
		this.stockage_interne_avant = val;
	}
	public int GetStockageInterneAvant() {
		return this.stockage_interne_avant;
	}
	
	public void SetRentabilite(int val) {
		this.rentabilite = val;
	}
	public int GetRentabilite() {
		return this.rentabilite;
	}
}
