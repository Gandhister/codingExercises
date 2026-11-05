package easy_e;

/*
 You are given an string representing the initial conditions of some dominoes. Each element can take one of three values:

L, meaning the domino has just been pushed to the left,
R, meaning the domino has just been pushed to the right, or
., meaning the domino is standing still.
Determine the orientation of each tile when the dominoes stop falling. Note that if a domino receives a force from the left and right side simultaneously, it will remain upright.

For example, given the string .L.R....L, you should return LL.RRRLLL.

Given the string ..R...L.L, you should return ..RR.LLLL.
*/

public class Dominoes {
	

	public static void main(String[] args) {

		String microsoft1 = ".L.R....L";
		String microsoft2 = "..R...L.L";
		String deepseek = "R.R";
		
		System.out.println(" initial_microsoft1: " + microsoft1);
		System.out.println("falling(microsoft1): " + falling(microsoft1));
		System.out.println("microsoft1:expected: LL.RRRLLL");
		System.out.println();
		System.out.println(" initial_microsoft2: " + microsoft2);
		System.out.println("falling(microsoft2): " + falling(microsoft2));
		System.out.println("microsoft1:expected: ..RR.LLLL");
		System.out.println();
		System.out.println("deepseek_expected:" + "RRR");
		System.out.println("  deepseek_output:" + falling(deepseek));
	}
	
	public static String falling(String dominos) {
		
		char[] fallen = new char[dominos.length()];
		for(int i = 0; i < dominos.length(); i++) { 
			int rightL = dominos.indexOf('L', i);
			int leftR = dominos.lastIndexOf('R', i);
			boolean hasRightL = rightL != -1;
			boolean hasLeftR = leftR != - 1;
			if (hasRightL && hasLeftR) {
				if(rightL - i == i - leftR) {
					fallen[i] = '.';
				} else if(rightL - i < i - leftR) {
					fallen[i] = 'L';
				} else if(rightL - i > i - leftR) {
					fallen[i] = 'R';
				} 
			} else if(hasLeftR) { 
					if(dominos.lastIndexOf('R', i) > dominos.lastIndexOf('L', i)) {
						fallen[i] = 'R';
					} else {
						fallen[i] = '.';
					}
			} else if(hasRightL) { // && 
				if(dominos.indexOf('R', i) < dominos.indexOf('L', i)) {
					fallen[i] = '.';
				} else {
					fallen[i] = 'L';
					}
			} else {
					fallen[i] = '.';
				}
			
		}
		
		return new String(fallen);
	}
	
}
