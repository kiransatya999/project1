package Javaprogs;

public class Stars
{
	public static void main(String[] args) 
	{
		
		for(int i=1;i<=5;i++)
		{
			for(int j=5;j>i;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(i);
			}
			for(int l=1;l<i;l++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
