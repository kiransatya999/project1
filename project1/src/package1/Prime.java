package package1;
import java.util.Scanner;
public class Prime 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int flag=0;
		for(int i=2;i<100;i++)
		{
			if(x%i==0)
			{
				flag=1;
				break;
			}
			if(flag==0)
			{
				System.out.println(x+"is prime");
			}
			else
			{
				System.out.println(x+"is not prime");
			}
		}
	}
}
