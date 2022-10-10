package maven.Home;

public class ChildClass extends ParentClass{
	public void method1() {
		System.out.println("child method1");
		
	}
	public static void method2() {
		System.out.println("child method2");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParentClass p = new ParentClass();
		ChildClass c = new ChildClass();
		
		p.method1();
		p.method2();
		c.method1();
		c.method2();
	}

}
