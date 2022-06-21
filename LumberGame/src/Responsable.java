// Import the IOException class to handle errors
import java.io.*;
import java.util.Scanner;

public class Responsable {
	private int rentabilite;
	private int niveau; //niveau 0 = pas débloqué
	private int parcelle_id;
	
	public Responsable(int parcelle_id) {
		this.parcelle_id = parcelle_id;
		try {
			File getCSVFiles = new File("GameData/responsables.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(parcelle_id)) {
		        	rentabilite = Integer.parseInt(parts[1]);
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
	};
	
	public int GetRentabilite() {
		return this.rentabilite;
	}
	
	public void SetRentabilite(int val) {
		this.rentabilite = val;
	}
	
	public void SetNiveau(int valeur) {
		this.niveau = valeur;
	}
	
	public int GetNiveau() {
		return this.niveau;
	}
	
	public void LevelUp() { //incrémente le niveau du responsable
		this.niveau++;
	}
	
	
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/responsables.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        
	        String line;
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(rentabilite);
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
			System.out.print("failed to open file GameData/responsables.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/responsables.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save resp.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
}
