import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class

public class Player_data { //ressource critique
	int nb_parcelle;
	public Responsable resp[];
	public Poncage ponc[]; //3 poncage max
	public Fendage fend[];
	public Ecorceuse ecor[];
	public Scie_A_Ruban scie[];
	public Conditionnement cond;
	public Foret foret[];
	public int argent; //argent du joueur
	public int bois;  //bois produit par foret
	public int rondin;  //produit a partir de bois via écorceuse
	public int poutre;  //produit a partir de rondins via fendage
	public int planche_non_poncee; //produit a partir de poutre via scie a ruban
	public int planche; //produit a partir de planche non poncées vie poncage
	
	
	public Player_data(int nb_parcelles){
		nb_parcelle = nb_parcelles;
		Get_P_Data();
		Get_Resp_Data();
		Get_Poncage_Data();
		Get_Ecor_Data();
		Get_Fend_Data();
		Get_Scie_Data();
		Get_Foret_Data();
	};
	
	public void Get_P_Data() {
		try {
			File getCSVFiles = new File("GameData/player.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        String line;
	        
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals("argent")) {
		        	argent = Integer.parseInt(parts[1]);
	        	}
	        	else if(parts[0].equals("bois")) {
		        	bois = Integer.parseInt(parts[1]);
	        	}
	        	else if(parts[0].equals("rondin")) {
		        	rondin = Integer.parseInt(parts[1]);
	        	}
	        	else if(parts[0].equals("poutre")) {
		        	poutre = Integer.parseInt(parts[1]);
	        	}
	        	else if(parts[0].equals("planche_non_poncee")) {
		        	planche_non_poncee = Integer.parseInt(parts[1]);
	        	}
	        	else if(parts[0].equals("planche")) {
		        	planche = Integer.parseInt(parts[1]);
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file GameData/player.csv");
			System.out.print(e);
		}
		System.out.println("argent " + argent);
		System.out.println("bois " + bois);
		System.out.println("rondin " + rondin);
		System.out.println("poutre " + poutre);
		System.out.println("planche non poncée " + planche_non_poncee);
		System.out.println("planche " + planche);
	}
	public void Get_Resp_Data() {
		resp = new Responsable[nb_parcelle];
		for(int i=0; i<nb_parcelle;++i) {
			resp[i] = new Responsable(i);
		}
	}
	public void Get_Poncage_Data() {
		ponc = new Poncage[3];
		for(int i=0; i<3;++i) {
			ponc[i] = new Poncage(i);
		}
	}
	public void Get_Ecor_Data() {
		ecor = new Ecorceuse[3];
		for(int i=0; i<3;++i) {
			ecor[i] = new Ecorceuse(i);
		}
	}
	public void Get_Scie_Data() {
		scie = new Scie_A_Ruban[3];
		for(int i=0;i<3;++i) {
			scie[i] = new Scie_A_Ruban(i);
		}
	}
	public void Get_Fend_Data() {
		fend = new Fendage[3];
		for(int i=0; i<3;++i) {
			fend[i] = new Fendage(i);
		}
	}
	public void Get_Foret_Data() {
		foret = new Foret[9];
		for(int i=0; i<9;++i) {
			foret[i] = new Foret(i);
		}
	}
	
	public void save_data(){
		String data = "";
		try {
			File getCSVFiles = new File("GameData/player.csv");
	        Scanner sc = new Scanner(getCSVFiles);
	        
	        String line;
	        while (sc.hasNextLine())
	        {
	        	line = sc.nextLine();
	        	String[] parts =line.split(";");
	        	if(parts[0].equals("argent")) {
		        	data += parts[0];
		        	data += ";";
		        	data += String.valueOf(argent);
		        	data += "\n";
	        	}
	        	else if(parts[0].equals("bois")) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(bois);
		        	data += "\n";
	        	}
	        	else if(parts[0].equals("rondin")) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(rondin);
		        	data += "\n";
	        	}
	        	else if(parts[0].equals("poutre")) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(poutre);
		        	data += "\n";
	        	}
	        	else if(parts[0].equals("planche_non_poncee")) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(planche_non_poncee);
		        	data += "\n";
	        	}
	        	else if(parts[0].equals("planche")) {
	        		data += parts[0];
		        	data += ";";
		        	data += String.valueOf(planche);
		        	data += "\n";
	        	}
	        }
	        sc.close(); 
		}
		catch(IOException e) {
			System.out.print("failed to open file GameData/player.csv");
			System.out.print(e);
		}
		
		
		try {
		      FileWriter myWriter = new FileWriter("GameData/player.csv");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully save Player_data.");
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		for(int i=0; i<nb_parcelle;++i) {
			resp[i].save_data();
		}
		for(int i=0; i<3;++i) {
			ponc[i].save_data();
		}
		for(int i=0; i<3;++i) {
			ecor[i].save_data();
		}
		for(int i=0; i<3;++i) {
			fend[i].save_data();
		}
		for(int i=0; i<3;++i) {
			scie[i].save_data();
		}
		for(int i=0; i<3;++i) {
			scie[i].save_data();
		}
		for(int i=0; i<9;++i) {
			foret[i].save_data();
		}
	};

	synchronized public void add_money(int montant) {
		argent+=montant;
	}
	synchronized public boolean remove_money(int montant) { //retourne true si l'opération à été effectuée
		if(argent >= montant) {
			argent-=montant;
			return true;
		}
		else {
			return false;
		}
	}
	synchronized public void add_bois(int nombre) {
		bois+=nombre;
	}
	synchronized public boolean remove_bois(int nombre) {
		if(bois >= nombre) {
			bois-=nombre;
			return true;
		}
		else {
			return false;
		}
	}
	synchronized public void add_planche(int nombre) {
		planche+=nombre;
	}
	synchronized public boolean remove_planche(int nombre) {
		if(planche >= nombre) {
			planche-=nombre;
			return true;
		}
		else {
			return false;
		}
	}
}