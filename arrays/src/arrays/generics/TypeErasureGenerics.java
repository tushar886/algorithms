package arrays.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureGenerics {

	public static void main(String[] args) {
		
		final List<Integer> myInts = new ArrayList<Integer>();
		
		myInts.add(1);
		myInts.add(2);
		
		 // final List<Number> myNums = myInts;  // This will not be possible in this case because for the case of generics. 
		//myNums.add(3.14); // Thus heap pollution is not possible here which is corrected in the case of generics.
		
		//Covariance
		List<? extends Number> myNums = new ArrayList<Integer>();
		//myNums.add(45); // For the case of co-variance this add will not be possible because compiler cannot determine what's being added.
		Number x = myNums.get(0); // This works correctly
		
		//Contravariance
		List<? super Integer> myInts2 = new ArrayList<Number>();
		myInts2.add(34); // int this only integer can be added , if user will try to add anything apart from Integer its not possible
		//Number num = myInts2.get(0); // not possible compiler cannot convert from number to integer
	}
}
