package package2;

public class Sample 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int m=101;
		
		if (m<35)
		{
			System.out.println("Failed");
		}
		else if(m>=35 && m<40)
		{
			System.out.println("E Grade");
		}
		else if(m>=40 && m<45)
		{
			System.out.println("D Grade");
		}
		else if(m>=45 && m<55)
		{
			System.out.println("C Grade");
		}
		else if(m>=55 && m<60)
		{
			System.out.println("B Grade");
		}
		else if(m>=60 && m<70)
		{
			System.out.println("A Grade");
		}
		else if(m>=70 && m<=100)
		{
			System.out.println("A+ Grade");
		}
		else
		{
			System.out.println("Invalid");
		}
	}
}