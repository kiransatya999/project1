package package2;

public class Arraysum {

	
		public static void main(String args[ ]) {

			/* Declaration of integer type array and initialize with 10 values */
			int array1[ ] = {1,2,3,4,5,6,7,8,9,10};
			int array2[ ] = {10,9,8,7,6,5,4,3,2,1};

			/* Declaration of integer type array */
			int ans[ ] = new int[10];
			for(int i = 0; i < 10; i++)
				ans[i] = array1[i] + array2[i];
			System.out.println("Sum of two Array:");
			for(int i = 0; i < 10; i++)
				System.out.println(ans[i]);
		}
	}

