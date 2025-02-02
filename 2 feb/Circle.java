import java.util.*;
public class Circle{
	static double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public static double circumference(double radius){
		return 2*3.14*radius;
	}
	
	public static double area(double radius){
		return 3.14*Math.pow(radius,2);
	}
	
	public static void display(){
	    System.out.println("Circumference: "+circumference(radius));
		System.out.println("Area: "+area(radius));
	}
	
	
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		double radius= sc.nextDouble();
		
		Circle circle= new Circle(radius);
		double circum= circumference(radius);
		double area= area(radius);
		display();
	}
}