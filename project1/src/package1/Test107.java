package package1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test107 
{
	public static void main(String[] args) 
	{
		String x="aajdSKAKDJAfl454 78sadass Shgjg0545";
		Pattern p= Pattern.compile("[0-9][0-9]");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
