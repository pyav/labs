
public class TwilioFourthBit {

	public static int fourthBit(int number) {
		
		//return ((int) (number & 8) == 1)?  1:  0;
		/*int eight = 8;
		if (number & eight == 8) {
			return 1; 
		} else {
			return 0;
		}*/
		
		int a = number & 8;
		return (a == 8)? 1: 0;
	}

	public static void main(String[] args) {
		System.out.println(TwilioFourthBit.fourthBit(8));
	}

}
