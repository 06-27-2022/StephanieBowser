public class GradingCalculator {
	public static void main (String[] args) {
	int []arr = {95, 85, 62, 40, 79};
	
	for (int i = 0; i <  arr.length; i++) {
		System.out.println(arr[i]);

		
		if (arr[i] > 0 && arr[i] < 60) {
		// && AND operator - both conditions need to be true
		//you can have multiple && operators in the same condition
		System.out.println("The grade is an F");
		}
		else if (arr[i] > 59 && arr[i] < 70) {
		// && AND operator - both conditions need to be true
		//you can have multiple && operators in the same condition
		System.out.println("The grade is a D");
		}
		else if (arr[i] > 69 && arr[i] < 80) {
		// && AND operator - both conditions need to be true
		//you can have multiple && operators in the same condition
		System.out.println("The grade is a C");
		}
		else if (arr[i] > 79 && arr[i] < 90) {
		// && AND operator - both conditions need to be true
		//you can have multiple && operators in the same condition
		System.out.println("The grade is a B");
		}
		else if (arr[i] > 89 && arr[i] <= 100) {
		// && AND operator - both conditions need to be true
		//you can have multiple && operators in the same condition
		System.out.println("The grade is an A");
		}
		else {
			System.out.println("The number is neither");
		}
	}
	}
}
