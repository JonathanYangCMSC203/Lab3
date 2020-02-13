import java.util.Scanner;//Import Scanner Class

/**
 * 
 * @author Jonathan Yang
 * This program collects the user's input of Movies, ratings, and movie tickets sold. 
 * This program also checks if the value are valid.
 * 
 */
public class MovieDriver {//Driver class

	public static void main(String[] args) {//Main Method
		//fields
		Scanner input = new Scanner(System.in);//Scanner Object.
		Movie a = new Movie();//Create a new movie object.
		
		
		do {
			System.out.println("Enter title of movie: ");//Prompt user to enter the title of the movie
			a.setTitle(input.nextLine());//input title
			a.setRating(checkRating(a));//input Rating through the checkRating method. 
			a.setSoldTickets(checkMovieTickets(a)); //inputs setSoldTickets through checkMovieTickets method.
			//input.nextLine(); This line is unnecessary but Programmer Jonathan can look back to see this in case of errors for future programs. This will help stop nextInt() from messing up the program.
			System.out.println(a.toString() + "\n");//toString() method display movie title, rating and movie tickets sold.
		}while(askAgain());//Loops until askAgain() method returns true;
		
		System.out.println("Goodbye");//displays Goodbye to indicate end of program
		System.out.println("Programmer: Jonathan Yang");//Display Programmer Name.
	}//end of main
	
	
	//method
	
	/**
	 * This is to make sure the user enters yes or no. If any other input is entered, the program will loop. 
	 * @return yes, no.
	 */
	private static boolean askAgain()
	{
		//fields
		Scanner input = new Scanner(System.in);//Scanner Object
		String confirm = "";//String confirm initialized to "" so that it can enter the while loop.
		
		while(!confirm.equals("yes") || !confirm.equals("no"))//User is not meant to leave this loop naturally. The loops stays until the user inputs a value that returns true or false in the loop.
		{
			System.out.println("Do you want to type in another movie? Type Yes or no: ");//Prompts user to enter yes or no to enter another movie.
			confirm = input.nextLine();//User inputs yes or no.
			
			if(confirm.toLowerCase().equals("yes"))//If user enters yes, askAgain() returns true and leaves loop.
				return true;//First way to leave loop. User will then enter another movie.

			else if(confirm.toLowerCase().equals("no"))//If user enters no, askAgain()return false and leaves loop.
				return false;//Second way to leave loop. User will then end the program afterwards.
		}
		
		System.out.println("Something went wrong.");//Error message. Program is never meant to reach here.
		return false;//This is so that the program has a way to get out of askAgain() if something went wrong. This will end the program.
	}//end of askAgain
	
	/**
	 * This method checks for valid movie ratings. 
	 * @param movie a
	 * @return R, PG13, PG, G
	 */
	private static String checkRating(Movie a)
	{
		//fields
		Scanner input = new Scanner(System.in);//Scanner Object
		String rating = "";//rating initialized to "" so that it can enter while loop.
		
		while(!rating.toUpperCase().equals("R") || !rating.toUpperCase().equals("PG13") || !rating.toUpperCase().equals("PG") || !rating.toUpperCase().equals("G"))
		{
			System.out.println("Ratings: (R, PG13, PG, G)"); //prompts user of the ratings available.
			System.out.println("Rate the movie, '" + a.getTitle() + "': ");//Prompt user to input the rating of the movie.
			rating = input.nextLine();//user inputs movie rating.
			if(rating.toUpperCase().equals("R") || rating.toUpperCase().equals("PG13") || rating.toUpperCase().equals("PG") || rating.toUpperCase().equals("G"))
			{
				return rating.toUpperCase();//returns rating when while loop doesn't work. But value is valid.
			}
			else
			{
				System.out.println("Invalid Rating, Please enter valid movie rating.");//display message when invalid rating variable is entered. Then loops.
			}
		}
		return rating;//returns rating when if statement doesn't work but value is valid.
	}//end of checkRating method
	
	/**
	 * This method checks for valid movie tickets.
	 * @param movie a
	 * @return movie Tickets
	 */
	private static int checkMovieTickets(Movie a)
	{
		//fields
		Scanner input = new Scanner(System.in);//Scanner Object
		int movieTickets = -1;//MovieTickets initialized to -1 so it can enter while loop.
		while(movieTickets < 0)
		{
			System.out.println("Enter the amount of tickets sold from '" + a.getTitle() + "': ");//Prompts user to input the amount of tickets.
			movieTickets = input.nextInt();//Input setSoldTickets.
			if(movieTickets < 0)//Checks to see if movie tickets is above 0
				System.out.println("Error. Movie Tickets cannot be negative number.");//Display message that user enter the value incorrectly.
		}
		return movieTickets;//returns movieTickets if valid.
	}//end of checkMovieTickets

}//end of program
