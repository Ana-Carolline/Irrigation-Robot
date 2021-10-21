package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketGarden {
	
	public MarketGarden() {}
	
	int width, height;
	List irrigationPlace = new ArrayList<>();
	Scanner read = new Scanner(System.in);
	String error = "";
	
	public MarketGarden setSize() throws IOException {
		System.out.println("Please, type it the width of the garden place:" );
		this.width = read.nextInt();
		
		System.out.println("Please, type it the height of the garden place:" );
		this.height = read.nextInt();
		return this;	
	}

	public List onPlace() throws IOException {
		String input = "";
		while (!input.equalsIgnoreCase("S")) {
			System.out.println("Please, type it the spot to irrigate or press 'S' to stop. \n" +
		"The spots must be informed once at time in x,y format.");
			input = read.next();
			if (this.checkPlace(input))
				irrigationPlace.add(input);
			else {
				input = "";
				System.out.println(error);
			}
		}
		return irrigationPlace;
	}
	
	public String getNextPlace() {
		String place = irrigationPlace.get(0).toString();
		irrigationPlace.remove(0);
		return place;
	}
	
	 public boolean hasMorePlaces() {
	        if (irrigationPlace.size() > 1) return true;
	        else return false;
	 }       
	
	public boolean checkPlace (String input) {
		if (input.equalsIgnoreCase("S")) {
			if (irrigationPlace.size() < 1) {
				error = "Please type it at least one spot to irrigate";
				return false;
			}
			else return true;
		} else {
			String[] XY = new String [2];
			XY = input.split("\\,");
			if ((this.width < Integer.parseInt(XY[0])) || this.height < Integer.parseInt(XY[1])) {
				error = "This command is not valid";
				return false;
			}
		}
		
		return true;
	}
		
	

}
