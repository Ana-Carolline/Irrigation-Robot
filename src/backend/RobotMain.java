package backend;

import java.io.IOException;
import java.util.Scanner;

public class RobotMain {
	
	public RobotMain() {} ;
	
	int positionX;
	int positionY;
	int destinationX;
	int destinationY;
	char direction;
	
	Scanner primary = new Scanner(System.in);
	StringBuilder path = new StringBuilder();

	public RobotMain setInitialPosit(MarketGarden marketGarden) throws IOException{
		System.out.println("Please, type it initial position at x,y format");
		
		return this;
	}
	
	public RobotMain setInitialOrient (MarketGarden marketGarden) throws IOException{
		System.out.println("Please, type it initial orientation: N, S, E, W.");
		String input = primary.next();
		return this;
	}
	
	public void setPlace (String destination) {
		String[] input = new String[2];
		input = destination.split("\\,");
		this.destinationX = Integer.parseInt(input[0]);
		destinationX = Integer.parseInt(input[0]);
		destinationY = Integer.parseInt(input[1]);
	}
	
	private int directionToInt(char d) {
        int directionAsInt = 0;
        if (d == 'N') directionAsInt = 0;
        if (d == 'E') directionAsInt = 1;
        if (d == 'S') directionAsInt = 2;
        if (d == 'W') directionAsInt = 3;

        return directionAsInt;
    }
	
	public String moveToPlaces() {
		char turnTo;
		if (positionX != destinationX) {
			if(positionX > destinationX) turnTo = 'W';
			else turnTo = 'E';
			path.append(adjustOrient(direction,turnTo));
			path.append(move(positionX, destinationX));
			positionX = destinationX;
		}
		if (positionY != destinationY) {
			if(positionY > destinationY) turnTo = 'S';
			else turnTo = 'N';
			path.append(adjustOrient(direction,turnTo));
			path.append(move(positionY,destinationY));
			positionY = destinationY;	
		}
		return path.toString();
	}
	
	public String adjustOrient (char direction, char turnTo) {
		String turns = "";
		if(direction != turnTo) {
			int dir = (directionToInt(direction)) - directionToInt(turnTo);
			dir = ((dir + 3) % 4);
			if (dir == 0) turns = "E";
			else if (dir == 1) turns = "E E";
			else turns = "D";
			this.direction = turnTo;	
		}
		return turns;
	}
	
	public boolean checkInitialOrient(char orient) {
		String validOrient = "NSEW";
		if (orient == 'W' || orient == 'N' || orient == 'E' || orient == 'S') {
			this.direction = orient;
			return true;
		}else return false;	
	}
	
	public boolean ckeckInitialPosit(String initialPosit, int width, int height) {
		String[] posit = new String[2];
		posit = initialPosit.split("\\,");
		if ((width >= Integer.parseInt(posit[0])) && height >= Integer.parseInt(posit[1])) {
			positionX = Integer.parseInt(posit[0]);
			positionY = Integer.parseInt(posit[1]);
			return true;
		}else return false;		
	}
	
	public String move (int position,int destination) {
		StringBuilder moves = new StringBuilder("");
		while (position != destination) {
			if (position> destination) position --;
			else position ++;
			moves.append("M");
		}
		return moves.toString();
	}
	
	public void irrigated() {
		path.append("I");
	}
	public StringBuilder getPath() {
		return path;
	}
}

