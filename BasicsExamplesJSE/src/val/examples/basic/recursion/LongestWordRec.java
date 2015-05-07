package val.examples.basic.recursion;


/**
 * This class is a recursive version that lets you know which of parameters received is the longest
 * 
 * 
 * @author Val
 * @version 1.0
 * 
 *
 */
public class LongestWordRec {
	
	private static String longestParam (int position, String[] args, String longerString )
	
	{
		
		if (position<args.length)//recursive case
		{
			if (args[position].length()>longerString.length())
			{
				longerString = longestParam(position+1, args, args[position]);
			} else longerString = longestParam(position+1, args, longerString);
		} //doesn't exist base case
		
		return longerString;	
		
	}
	
	/**
	 * 
	 * @param args Contains the set of parameters you have to decide on which is the largest
	 */
	public static void main(String[] args) {
		String longest = null;
		
		try {
			
			longest = longestParam(1, args, args[0]);
			System.out.println("The longest arugment recieved is " + longest);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("At least, you should pass one argument invoking this program");
		}
		
	}

}
