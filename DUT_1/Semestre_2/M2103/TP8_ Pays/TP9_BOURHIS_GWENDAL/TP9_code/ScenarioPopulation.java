import pays.*;


public class ScenarioPopulation{
	public static void main(String[] args){
		String pop = "worldpop.txt";
		String area = "worldarea.txt";
		Population popu = new Population(pop,area);
		System.out.println("\n\tPOPULATION : \n"+popu.getPopMap());
		System.out.println("\n\tAREA : \n"+popu.getAreaMap());
		System.out.println("\n\tCOUNTRIES : \n"+popu.getListePays());
	}
}
