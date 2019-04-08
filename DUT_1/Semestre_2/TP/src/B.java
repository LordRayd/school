public class B extends A {
	public void mb1(){
		System.out.println("je t assure");
		this.ma1();
		this.ma3();
	}
	public void ma3(){
		super.ma3();
		System.out.println("?");
	}
}