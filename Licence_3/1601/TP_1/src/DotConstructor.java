import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DotConstructor {

	public static void main(String[] args) {
		Scanner scanner = null;
		Scanner scanner2 = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String[] split = null;
	    String entry = null;
	    String top = null;
	    int newDot = 1;
		try {
			reader = new BufferedReader( new InputStreamReader( System.in ) );
			File file = new File("/tmp/exp.dot");
			scanner = new Scanner(System.in);
			if(file.exists()) {
				System.out.println("Commencer un nouveau fichier dot ou completer l ancien ? 1 pour creer un nouveau, 0 pour ajouter");
				newDot = scanner.nextInt();
			}
		    file.createNewFile();
			
		    scanner2 = new Scanner(file);
		    String line = new String();
		    if(newDot == 0) {
		    	String line2 = new String();
		    	int nbLigne = 1;
		    	while(scanner2.hasNextLine()) {
		    		line2 = scanner2.nextLine();
		    		if(nbLigne == 2) top = line2.split("->")[0].trim();
		    		if(nbLigne > 2) {
		    			split = line2.split("->");
		    			for(int i=1; i<split.length; i++) {
							if(top.equals(split[i].trim())) top = split[0].trim();
						}
		    		}
		    	    line +=  line2.toString() + "\n";
		    	    nbLigne++;
		    	}
		    	line = line.substring(0, line.length() - 2);
		    	System.out.println(line);
		    }
		    
		    writer = new BufferedWriter( new FileWriter( file ) );
		    
		    if(newDot == 0) writer.append(line);
		    if(newDot == 1) writer.append("digraph G {\n");
		    
			System.out.println("Nouveau noeud a ajouter. Entrer . pour arreter la saisie");
		    entry = reader.readLine();
		    if(newDot == 1)top = entry.split("->")[0].trim();
		    
			while(!entry.equals(".")){
				split = entry.split("->");
				for(int i=1; i<split.length; i++) {
					if(top.equals(split[i].trim())) top = split[0].trim();
				}
				
				if(!entry.contains(";")) entry += ";\n";
				
				writer.append(entry);
			    
				System.out.println("Nouveau noeud a ajouter. Entrer . pour arreter la saisie");
				entry = reader.readLine();
			}
			writer.append("}");
			
		} catch (IOException ex) {
		    ex.printStackTrace();
		} finally {
			try {
			   writer.close();
			   scanner.close();
			   scanner2.close();
			   reader.close();
			   System.out.println("Entre terminee");
			   System.out.println("Le sommet du graphe est : " + top);
			   
			   Process dot = Runtime.getRuntime().exec("dot -Tpdf /tmp/exp.dot -o /tmp/exp.pdf");
			   dot.waitFor();
			   
			   Process evince = Runtime.getRuntime().exec("evince /tmp/exp.pdf");
			   evince.waitFor();
		   } catch (Exception ex) {
			   ex.printStackTrace();
		   }
		}
	}
}