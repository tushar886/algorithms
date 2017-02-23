package arrays;

public class MaximumSubArrayKadanesAlgo {
	
	private final static int arr[] = {-2, -3, 4, 1, 2, 1, -5, -3};

	public static void main(String[] args) {

		final int maxSum = maxSubArraySum(arr, arr.length);
		System.out.println("Max Sum is as " + maxSum);
	}
	
	static int maxSubArraySum(final int a[], final int size)
	{
	   int max_so_far = a[0];
	   int curr_max = a[0];
	 
	   for (int i = 1; i < size; i++)
	   {
	        curr_max = Math.max(a[i], curr_max+a[i]);
	        max_so_far = Math.max(max_so_far, curr_max);
	   }
	   return max_so_far;
	}

}
