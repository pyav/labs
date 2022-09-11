package designpatterns.behavioral;

interface IFlyBehavior {
	public void fly();
}

interface IQuackBehavior {
	public void quack();
}

interface IDisplayBehavior {
	public void display();
}

class Duck {
	IFlyBehavior fb;
	IQuackBehavior qb;
	IDisplayBehavior db;

	Duck(IFlyBehavior fb, IQuackBehavior qb, IDisplayBehavior db) {
		this.fb = fb;
		this.qb = qb;
		this.db = db;
	}

	public void fly() {
		this.fb.fly();
	}

	public void quack() {
		this.qb.quack();
	}

	public void display() {
		this.db.display();
	}
}

public class StrategyPattern {

	public static void main(String[] args) {

	}

}
