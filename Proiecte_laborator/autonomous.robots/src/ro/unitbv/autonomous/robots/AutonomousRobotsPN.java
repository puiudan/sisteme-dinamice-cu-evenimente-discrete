package ro.unitbv.autonomous.robots;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsActuators;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsEventsTypes;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsIndicators;

public abstract class AutonomousRobotsPN extends Observable implements Observer {

	private Logger logger = Logger.getLogger(this.getClass());

	PetriNet petriNet;
	public PetriNetEventGenerator petriNetEventGenerator = new PetriNetEventGenerator();

	private HashMap<String, AutonomousRobotsActuators> activeActuators = new HashMap<>();
	private int nRobotsC1 = 0;
	private int nRobotsC2 = 0;
	private int nRobotsC3 = 0;
	private int nRobotsGaraj = 4;

	public AutonomousRobotsPN() {
		petriNet = generatePN();
		petriNetEventGenerator.addObserver(petriNet.getEventObserver());
	}

	@Override
	public void update(Observable o, Object arg) {
		newEventReceived((AutonomousRobotsEventsTypes) arg);

	}

	public abstract void newEventReceived(AutonomousRobotsEventsTypes event);

	public abstract PetriNet generatePN();

	public PetriNet getPetriNet() {
		return petriNet;
	}

	private void sendState() {
		boolean y1_green = false;
		boolean y1_red = false;
		boolean y2_green = false;
		boolean y2_red = false;
		boolean y3_green = false;
		boolean y3_red = false;
		boolean y4_green = false;
		boolean y4_red = false;
		boolean y5_green = false;
		boolean y5_red = false;
		boolean y6_green = false;
		boolean y6_red = false;
		int garaj = nRobotsGaraj;
		int c1 = nRobotsC1;
		int c2 = nRobotsC2;
		int c3 = nRobotsC3;

		Iterator<Entry<String, AutonomousRobotsActuators>> it = activeActuators
				.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, AutonomousRobotsActuators> entry = it.next();

			switch (entry.getValue()) {

			case Y1_GREEN:
				y1_green = true;
				break;
			case Y1_RED:
				y1_red = true;
				break;

			case Y2_GREEN:
				y2_green = true;
				break;
			case Y2_RED:
				y2_red = true;
				break;

			case Y3_GREEN:
				y3_green = true;
				break;
			case Y3_RED:
				y3_red = true;
				break;

			case Y4_GREEN:
				y4_green = true;
				break;
			case Y4_RED:
				y4_red = true;
				break;

			case Y5_GREEN:
				y5_green = true;
				break;
			case Y5_RED:
				y5_red = true;
				break;

			case Y6_GREEN:
				y6_green = true;
				break;
			case Y6_RED:
				y6_red = true;
				break;

			}
		}

		sendState(y1_green, y1_red, y2_green, y2_red, y3_green, y3_red,
				y4_green, y4_red, y5_green, y5_red, y6_green, y6_red, garaj,
				c1, c2, c3);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendState(boolean y1_green, boolean y1_red, boolean y2_green,
			boolean y2_red, boolean y3_green, boolean y3_red, boolean y4_green,
			boolean y4_red, boolean y5_green, boolean y5_red, boolean y6_green,
			boolean y6_red, int garaj, int c1, int c2, int c3) {

		AutonomousRobotsActuatorsMessage partajateResourcesActuatorsMessage = new AutonomousRobotsActuatorsMessage();
		partajateResourcesActuatorsMessage.setY1_green(y1_green);
		partajateResourcesActuatorsMessage.setY1_red(y1_red);
		partajateResourcesActuatorsMessage.setY2_green(y2_green);
		partajateResourcesActuatorsMessage.setY2_red(y2_red);
		partajateResourcesActuatorsMessage.setY3_green(y3_green);
		partajateResourcesActuatorsMessage.setY3_red(y3_red);
		partajateResourcesActuatorsMessage.setY4_green(y4_green);
		partajateResourcesActuatorsMessage.setY4_red(y4_red);
		partajateResourcesActuatorsMessage.setY5_green(y5_green);
		partajateResourcesActuatorsMessage.setY5_red(y5_red);
		partajateResourcesActuatorsMessage.setY6_red(y6_red);
		partajateResourcesActuatorsMessage.setY6_green(y6_green);
		partajateResourcesActuatorsMessage.setGaraj(garaj);
		partajateResourcesActuatorsMessage.setC1(c1);
		partajateResourcesActuatorsMessage.setC2(c2);
		partajateResourcesActuatorsMessage.setC3(c3);

		// logger.info("partajated resorces: actuator message was generated: ");
//		logger.info("                     y1_green=" + y1_green + ", y1_red="
//				+ y1_red + "y2_green=" + y2_green + ", y2_red=" + y2_red
//				+ "y3_green=" + y3_green + ", y3_red=" + y3_red + "y4_green="
//				+ y4_green + ", y4_red=" + y4_red + "y5_green=" + y5_green
//				+ ", y5_red=" + y5_red + ", garaj=" + garaj + ", c1=" + c1
//				+ ", c2=" + c2 + ", c3=" + c3);
		setChanged();
		notifyObservers(partajateResourcesActuatorsMessage);

	}

	public void turnONActuator(String placeID,
			AutonomousRobotsActuators actuator) {

		String key = placeID + actuator;

		if (!activeActuators.containsKey(key)) {
			activeActuators.put(key, actuator);

			sendState();

			logger.info("autonomous robots: actuator " + actuator
					+ " was ACTIVATED by place " + placeID);
		} else {
			logger.error("autonomous robots: received command to ACTIVATE the actuator "
					+ actuator
					+ ", from place "
					+ placeID
					+ ". The actuator was already ACTVATED and the command was ignored");
		}

	}

	public void changeIndicatorState(String placeID,
			AutonomousRobotsIndicators indicator, int numberOfRobots) {
		switch (indicator) {
		case C1:
			nRobotsC1 = numberOfRobots;
			break;
		case C2:
			nRobotsC2 = numberOfRobots;
			break;
		case C3:
			nRobotsC3 = numberOfRobots;
			break;
		case GARAJ:
			nRobotsGaraj = numberOfRobots;
			break;
		}

		sendState();

		logger.info("autonomous robots: place " + placeID
				+ " updated the number of robots from " + indicator + " to "
				+ numberOfRobots);
	}

	public void turnOFFActuator(String placeID,
			AutonomousRobotsActuators actuator) {

		String key = placeID + actuator;

		if (activeActuators.containsKey(key)) {
			activeActuators.remove(key);

			sendState();

			logger.info("manufacturing system: actuator " + actuator
					+ " was DEACTIVATED by place " + placeID);
		} else {
			logger.error("manufacturing system: received command to DEACTIVATE the actuator "
					+ actuator
					+ ", from place "
					+ placeID
					+ ". The actuator was already DEACTIVATED and the command was ignored");
		}
	}

	public PetriNetEventGenerator getPetriNetEventGenerator() {
		return petriNetEventGenerator;
	}

}
