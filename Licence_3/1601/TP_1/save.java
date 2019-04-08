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
		String[] decoupe = null;
	    String entry = null;
	    String sommet = null;
	    int reponse = -1;
		try {
			reader = new BufferedReader( new InputStreamReader( System.in ) );
			System.out.println("Start a new dot file ? 1 to accep 0 to refuse");
			File file = new File("/tmp/exp.dot");
		    file.createNewFile();
            scanner = new Scanner(System.in);
			System.out.println("Reponse test");
			reponse = scanner.nextInt();
			System.out.println("reponse : " + reponse);

			scanner2 = new Scanner(file);
		    
		    String line = new String();
		    String line2 = new String();
		    if(reponse == 0) {
		    	int nbLigne = 1;
		    	while(scanner2.hasNextLine()) {
		    		line2 = scanner2.nextLine();
		    		if(nbLigne == 2) sommet = line2.split("->")[0].trim();
		    		if(nbLigne > 2) {
		    			decoupe = line2.split("->");
		    			for(int i=1; i<decoupe.length; i++) {
							if(sommet.equals(decoupe[i].trim())) sommet = decoupe[0].trim();
						}
		    		}
		    	    line +=  line2.toString() + "\n";
		    	    nbLigne++;
		    	}
		    	line = line.substring(0, line.length() - 2);
		    	System.out.println(line);
		    }
		    
		    
		    writer = new BufferedWriter( new FileWriter( file ) );
		    
		    if(reponse == 0) writer.append(line);
		    if(reponse == 1) writer.append("digraph G {\n");
		    entry = reader.readLine();
		    if(reponse == 1)sommet = entry.split("->")[0].trim();
		    
			while(!entry.equals(".")){
				decoupe = entry.split("->");
				for(int i=1; i<decoupe.length; i++) {
					if(sommet.equals(decoupe[i].trim())) sommet = decoupe[0].trim();
				}
				
				if(!entry.contains(";")) entry += ";\n";
				
				writer.append(entry);
			    
				System.out.println("New sommet. enter . alone to exit the input ");
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
			   System.out.println("Input closed");
			   System.out.println("sommet : " + sommet);
			   
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
