import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Poncage extends Usine {
	private int niveau;
	private double vitesse;
	private int parcelle_id;
	
	public Poncage(int parcelle_id) {
		this.niveau = 0;
		this.vitesse = 10;
		this.parcelle_id = parcelle_id;
		
		try {
			File getCSVFiles = new File("GameData/poncage.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        line = sc.nextLine();
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
		        	niveau = Integer.parseInt(parts[1]);
		        	vitesse = Float.parseFloat(parts[2]);
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
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/poncage.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        
	        String line;
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals(String.valueOf(parcelle_id))) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(niveau);
		        	data += ";";
		        	data += String.valueOf(vitesse);
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
			System.out.print("failed to open file GameData/poncage.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/poncage.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save poncage.csv.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	};
}