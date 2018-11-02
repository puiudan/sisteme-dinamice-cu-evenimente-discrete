package ro.unitbv.shared.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesActuators;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesEventsTypes;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesIndicators;

public abstract class SharedResourcesPN extends Observable implements Observer {

	private Logger logger = Logger.getLogger(this.getClass());

	PetriNet petriNet;
	public PetriNetEventGenerator petriNetEventGenerator = new PetriNetEventGenerator();

	private HashMap<String, SharedResourcesActuators> activeActuators = new HashMap<>();
	private int Y3 = 0;
	private int Y7 = 0;

	public SharedResourcesPN() {
		petriNet = generatePN();
		petriNetEventGenerator.addObserver(petriNet.getEventObserver());
	}

	@Override
	public void update(Observable o, Object arg) {
		newEventReceived((SharedResourcesEventsTypes) arg);

	}

	public abstract void newEventReceived(SharedResourcesEventsTypes event);

	public abstract PetriNet generatePN();

	public PetriNet getPetriNet() {
		return petriNet;
	}

	private void sendState() {

		boolean y1 = false;
		boolean y2 = false;
		int y3 = Y3;
		boolean y4 = false;
		boolean y5 = false;
		boolean y6 = false;
		int y7 = Y7
				;
		boolean y8 = false;
		boolean y9 = false;

		Iterator<Entry<String, SharedResourcesActuators>> it = activeActuators
				.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, SharedResourcesActuators> entry = it.next();

			switch (entry.getValue()) {

			case Y1:
				y1 = true;
				break;

			case Y2:
				y2 = true;
				break;

			case Y4:
				y4 = true;
				break;

			case Y5:
				y5 = true;
				break;

			case Y6:
				y6 = true;
				break;

			case Y8:
				y8 = true;
				break;

			case Y9:
				y9 = true;
				break;
			}
		}
		
		sendState(y1, y2, y3, y4, y5, y6, y7, y8, y9);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendState(boolean y1, boolean y2, int y3, boolean y4,
			boolean y5, boolean y6, int y7, boolean y8, boolean y9) {

		SharedResourcesActuatorsMessage partajateResourcesActuatorsMessage = new SharedResourcesActuatorsMessage();
		partajateResourcesActuatorsMessage.setY1(y1);
		partajateResourcesActuatorsMessage.setY2(y2);
		partajateResourcesActuatorsMessage.setY3(y3);
		partajateResourcesActuatorsMessage.setY4(y4);
		partajateResourcesActuatorsMessage.setY5(y5);
		partajateResourcesActuatorsMessage.setY6(y6);
		partajateResourcesActuatorsMessage.setY7(y7);
		partajateResourcesActuatorsMessage.setY8(y8);
		partajateResourcesActuatorsMessage.setY9(y9);

//		logger.info("partajated resorces: actuator message was generated: ");
//		logger.info("                     y1=" + y1 + ", y2=" + y2 + ", y3="
//				+ y3 + ", y4=" + y4 + ", y5=" + y5 + ", y6=" + y6 + ", y7="
//				+ y7 + ", y8=" + y8 + ", y9=" + y9);

		setChanged();
		notifyObservers(partajateResourcesActuatorsMessage);

	}

	public void turnONActuator(String placeID, SharedResourcesActuators actuator) {

		String key = placeID + actuator;

		if (!activeActuators.containsKey(key)) {
			activeActuators.put(key, actuator);

			sendState();

			logger.info("shared resources: actuator " + actuator
					+ " was ACTIVATED by place " + placeID);
		} else {
			logger.error("shared resources: received command to ACTIVATE the actuator "
					+ actuator
					+ ", from place "
					+ placeID
					+ ". The actuator was already ACTVATED and the command was ignored");
		}

	}

	public void changeIndicatorState(String placeID,
			SharedResourcesIndicators indicator, int numberOfComponents) {
		switch (indicator) {
		case Y3:
			Y3 = numberOfComponents;
			break;
		case Y7:
			Y7 = numberOfComponents;
			break;
		}

		sendState();

		logger.info("shared resources: place " + placeID
				+ " updated the number of components from " + indicator
				+ " to " + numberOfComponents);
	}

	public void turnOFFActuator(String placeID,
			SharedResourcesActuators actuator) {

		String key = placeID + actuator;

		if (activeActuators.containsKey(key)) {
			activeActuators.remove(key);

			sendState();

			logger.info("shared resources: actuator " + actuator
					+ " was DEACTIVATED by place " + placeID);
		} else {
			logger.error("shared resources: received command to DEACTIVATE the actuator "
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
