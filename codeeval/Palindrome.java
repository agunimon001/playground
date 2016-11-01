public class Palindrome{
	public static void main(String[] args){
		int num = 1000;
		int halfSize = num/2;
		int i = 0;
		while (i < halfSize){
			if (Palindrome.palindrome(--num)){
				for (i = 2; i < halfSize; i++){
					if (num % i == 0) break;
				}
			}
		}
		System.out.println(num);
	}
	private static boolean palindrome(int val){
		String num = String.valueOf(val);
		int size = num.length();
		int halfLength = size / 2;
		for (int i = 0; i < halfLength; i++){
			if (num.charAt(i) != num.charAt(size - 1 - i)) return false;
		}
		return true;
	}
}