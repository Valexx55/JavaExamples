package val.examples.basic;


/**
 * This class is a recursive version that lets you know which of parameters received is the longest
 * 
 * @author Val
 * @version 1.0
 * 
 *
 */
public class LongestWordRec {
	
	private static String longerParam (int position, String[] args, String longerString )
	
	{
		
		if (position<args.length)
		{
			if (args[position].length()>longerString.length())
			{
				longerString = longerParam(position+1, args, args[position]);
			} else longerString = longerParam(position+1, args, longerString);
		}
		
		return longerString;	
		
	}
	
	public static void main(String[] args) {
		String longest = null;
		
		try {
			
			longest = longerParam(1, args, args[0]);
			System.out.println("The longest arugment recieved is " + longest);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("At least, you should pass one argument invoking this program");
		}
		
	}

}
