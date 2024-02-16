package hw._240216.jeonghyeon;

public class JavaTest {
	public static void main(String[] args) {
		int a = 21;
		a |= 7;
		System.out.println(a);
		System.out.println((int) 'a');

		int keys = 22;
		char newChar = 'B';
		int newVisited = keys & (int) Math.pow(2, newChar - 65);
		System.out.println(newVisited);
	}
}
