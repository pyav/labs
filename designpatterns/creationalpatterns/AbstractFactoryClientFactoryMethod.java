/**
 * Output
 * ------
 * This is Second company's MMU
 *
 */

package designpatterns.creationalpatterns;

abstract class CPU {
	void printArchType() {
		System.out.println("This is First company's CPU");
	}
}

class FirstCoCPU extends CPU {
}

class SecondCoCPU extends CPU {
}

abstract class MMU {
	void printArchType() {
		System.out.println("This is Second company's MMU");
	}
}

class FirstCoMMU extends MMU {
}

class SecondCoMMU extends MMU {
}

class FirstCoUtil extends AbstractFactory {

	public CPU createCPU() {
		return new FirstCoCPU();
	}

	public MMU createMMU() {
		return new FirstCoMMU();
	}
}

class SecondCoUtil extends AbstractFactory {

	public CPU createCPU() {
		return new SecondCoCPU();
	}

	public MMU createMMU() {
		return new SecondCoMMU();
	}
}

enum Company {
	FIRST, SECOND;
}

abstract class AbstractFactory {

	public abstract CPU createCPU();

	public abstract MMU createMMU();

	static AbstractFactory getFactory(Company company) {

		switch (company) {
		case FIRST:
			return new FirstCoUtil();
		case SECOND:
			return new SecondCoUtil();
		}
		
		return null;
	}
}

public class AbstractFactoryClient {

	public static void main(String[] args) {
		
		AbstractFactory abstractFactory = AbstractFactory.getFactory(Company.SECOND);
		MMU secondMmu = abstractFactory.createMMU();
		secondMmu.printArchType();
	}

}
