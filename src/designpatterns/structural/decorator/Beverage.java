package designpatterns.structural.decorator;

public abstract class Beverage {

	String description = "Base Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
	
}

