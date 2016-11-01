public class PrimeSum{
	public static void main(String[] args){
		int sum = 2;
		int count = 1;
		int i, j;
		for (i = 3; count < 1000; i++){
			for (j = 2; j < i; j++){
				if (i % j == 0) break;
			}
			if (i == j){
				sum += i;
				count++;
			}
		}
		System.out.println(sum);
	}
}