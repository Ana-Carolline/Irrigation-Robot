package backend;


import java.io.IOException;

public class IrrigationRobot {

	public static void main(String[] args) throws IOException {

		MarketGarden  marketGarden = new MarketGarden();
		marketGarden.setSize();
		marketGarden.onPlace();
		RobotMain robot = new RobotMain();
		robot.setInitialPosit(marketGarden);
		robot.setInitialOrient(marketGarden);
		
		while(marketGarden.hasMorePlaces()== true) {
			robot.setPlace(marketGarden.getNextPlace());
			robot.moveToPlaces();
			robot.irrigated();
		}
		System.out.println(robot.getPath());
	}

}
