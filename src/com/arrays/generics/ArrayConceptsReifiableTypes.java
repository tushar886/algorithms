package arrays.generics;

/**
 * This also proves that arrays are of type co-variant means array of type T can contain elements of sub-type of T
 * 
 * @author tsrivast
 */

public class ArrayConceptsReifiableTypes {
	
	public static void main (String args[]) {
		
		Number number [] = new Number[3];
		
		number[0] = new Integer(8);
		number[1] = new Double(3.14);
		//number[2] = new Byte("O");
		
		//Thus this proves an array of type T[] can contain elements of sub-type of T.
		
        Integer[] myInts = {1, 2, 3, 4};
        number = myInts ;
        
		number[0] = 3.14; // This line will compile fine but will throw runtime exception. This is known as heap pollution which is overcome in generics.
		
	}

}
