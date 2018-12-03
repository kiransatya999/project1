package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> x=new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		//Fill array
		System.out.println("Fill array");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());
			
		}
		//Sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
					x.set(j, x.get(j+1));
					x.set(j+1, temp);
				}
			}
		}
		//display array
		for(int i=0;i<n;i++)
		{
			System.out.println(x.get(i));
		}
	}

}
