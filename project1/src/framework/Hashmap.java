package framework;

import java.util.HashMap;
import java.util.Map;

public class Hashmap 
{
	public static void main(String[] args) 
	{
		// create hashmap
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		//Insert data into Hashmap
		hm.put(101, "Kalam");
		hm.put(102, "Kohli");
		//get data from hashmap
		for(Map.Entry e:hm.entrySet())
		{
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
	}
}
