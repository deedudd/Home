package maven.Home;

public class MethodHidingChild extends methodHidingParent {
	public static void main(String[] args) {
		MethodHidingChild child = new MethodHidingChild();
		test();
		methodHidingParent parent = new MethodHidingChild();
		parent.test1();
	}

	public static void test() {
		System.out.println("in child method hide");
	}

	public void test1() {
		System.out.println("in child methodOverloading");
	}
}
