package lab1;

public class triangle {
	public String cal (int a, int b, int c){
		if((a+b>c)&&(a+c>b)&&(b+c>a))
		{
			if((a==b)||(a==c)||(b==c)){
				
				if((a==b) && (a==c))
				{
					return "equilateral triangle";
				}
				return "isosceles triangle";
			}
			return "scalene triangle";
		}	
		return "Not a triangle";
	}
}
