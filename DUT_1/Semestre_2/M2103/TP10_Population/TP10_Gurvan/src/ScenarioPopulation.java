import pays.*;
import tri.*;
import java.util.ArrayList;

public class ScenarioPopulation{
	public static void main(String[] args){
		Population pop = new Population("worldpop","worldarea");
		//System.out.println("\n\tPOPULATION : \n"+pop.getPopMap());
		//System.out.println("\n\tAREA : \n"+pop.getAreaMap());
		//System.out.println("\n\tCOUNTRIES : \n"+pop.getListePays());
		//System.out.println("\n\tDENSITY : \n"+pop.getDensityMap());

		//System.out.println("MAX PAYS : \n"+pop.maxDensity());

		/*TriParSelectionAlpha tri = new TriParSelectionAlpha(pop.getListePays());
		tri.trierAlpha();
		Pays[] tab = tri.getPays();
		for(int i = 0; i < tab.length; i++){
			System.out.println(tab[i]);
		}*/

		//RWFile.writeMap(pop.getDensityMap(), "worlddensity");
		System.out.println(pop.containsPays("France"));

	}
}
