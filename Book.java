import java.util.*;
public class Book{
	static String title;
	static String author;
	static double price ;
	
	public Book(String title, String author, double price){
		this.title= title;
		this.author= author;
		this.price= price;
	}
	
	public static void display(){
	    System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
	}
	
	
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		String title= sc.nextLine();
		String author= sc.nextLine();
		double price= sc.nextDouble();
		
		Book book= new Book(title,author,price);
		display();
	}
}