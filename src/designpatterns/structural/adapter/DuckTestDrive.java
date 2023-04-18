package designpatterns.structural.adapter;

public class DuckTestDrive {
	
	public static void main(String[] args) {
		WildTurkey turkey = new WildTurkey();
		MallardDuck duck = new MallardDuck();
		
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		System.out.println("The Turkey says:\n");
		turkey.gobble();
		turkey.fly();
		System.out.println("The Duck says:\n");
		testDuck(duck);
		System.out.println("The TurkeyAdapter says:\n");
		testDuck(turkeyAdapter);
	}

	private static void testDuck(Duck duck) {
		duck.fly();
		duck.quack();
	}
	
}
