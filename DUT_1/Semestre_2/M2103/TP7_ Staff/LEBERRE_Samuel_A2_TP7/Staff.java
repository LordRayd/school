package staff;
import java.util.ArrayList;
	/**
	 * Instantiates and use the object Staff
	 * @author S.LEBERRE - MARS 2017
  	 * @version 1.0
  	 * @since JDK 1.8
	 */
	public class Staff{
		
		private ArrayList<StaffMember> staffList;
		
		/**
		 * Constructor of Staff
		 */
		public Staff(){
			staffList = new ArrayList<StaffMember>();
		}
		
		/**
		 * Add a StaffMember object to the staffList
		 * @param member the member you want to add to the staffList
		 */
		public void addNewMember(StaffMember member){
			if(member != null){
				this.staffList.add(member);
			} else {
				System.out.println("Param addNewMember FALSE");
			}
		}
		
		/**
		 * Get a member in the staffList. Return null if the param sup at the size of staffList or inf 0.
		 * @param index the position where we want to get the member
		 * @return the member at the position given in param
		 */
		public StaffMember getMember(int index){
			StaffMember member = null;
			if(index >= 0 && index < this.staffList.size()){
				member = this.staffList.get(index);
			} else {
				System.out.println("Param getMember FALSE");
			}
			return member;
		}
		
		/**
		 * Give their pay to the employees and thanks the volunteers
		 */
		public void payDay(){
			double salary = 0.0;
			for (StaffMember member : staffList){
				salary = member.pay();
				if(salary == 0.0){
					System.out.println("-------------------------------------------------------");
					System.out.println("Thanks "+member.name+" for your help");
				} else {
					System.out.println("-------------------------------------------------------");
					System.out.println(member.name+" was paid "+salary);
				}
			}
		}
	}
