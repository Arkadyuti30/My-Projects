import java.io.*;
import java.util.*;
class BaseConverter
{
	/***** Function to convert a decimal number to any base *****/
	static String dec_to_any(String n1, int b)
	{ //Begin function dec_to_any()
		int n = Integer.parseInt(n1);
		String s= "", x="";

		while(n>0)
		{ //Begin while
			int d = n%b;
			n = n/b;
			
			if(d>=10)
			{
				char c = (char) (d+55);
				x = Character.toString(c);
			}
			else x = Integer.toString(d);
			
			s = s+x;
		} //End while

		StringBuffer sb = new StringBuffer(s);
		sb.reverse();

		return sb.toString();
	} //End function dec_to_any()


	/***** Function to convert a number in any to decimal *****/
	static int any_to_dec(String n, int b)
	{ //Begin function any_to_dec()
		int len = n.length(), c=0, d, nb=0;

		for(int i = len-1; i>=0; i--)
		{ //Begin for
			char ch = n.charAt(i);
			
			if(Character.isLetter(ch)== true)
				d = (int) (ch-55);
			else
				d = Integer.parseInt(Character.toString(ch));
				
			nb = nb + (int)(d*Math.pow(b,c));
			c++;
		} //End for

		return nb;
	} //End function any_to_dec()


/***** Main function *****/
public static void main(String args[])throws IOException
{
	InputStreamReader read = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(read);
	System.out.println("Enter the base of the number");
	int b1 = Integer.parseInt(in.readLine());
	System.out.println("Enter the number in base "+b1);
	String n = in.readLine();
	System.out.println("Enter the base to which the number will be converted");
	int b2 = Integer.parseInt(in.readLine());
	
	if(b1==10) //Checks if the base of entered number is equal to 10
	{
		String val = dec_to_any(n, b2);
		System.out.println("The number in base "+b2+" is:\n"+val);
	}
	if(b2==10) //Checks if the base to which conversion will be done is equal to 10
	{
		int val = any_to_dec(n, b1);
		System.out.println("The number in base "+b2+" is:\n"+val);
	}
	if(b1 != 10 && b2 != 10) //Checks if both the bases are not equal to 10
	{
		int z = any_to_dec(n, b1);
		String val = dec_to_any(Integer.toString(z), b2);
		System.out.println("The number in base "+b2+" is:\n"+val);
	}
}
}
