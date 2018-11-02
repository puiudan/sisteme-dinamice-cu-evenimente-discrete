package ro.unitbv.manufacturing.system;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.unitbv.manufacturing.system.ManufacturingSystemController.ManufacturingSystemActuators;
import ro.unitbv.manufacturing.system.ManufacturingSystemController.ManufacturingSystemEventsTypes;

public abstract class ManufacturingSystemPN extends Observable implements
		Observer {

	private Logger logger = Logger.getLogger(this.getClass());

	private HashMap<String, ManufacturingSystemActuators> activeActuators = new HashMap<>();

	PetriNet petriNet;
	public PetriNetEventGenerator petriNetEventGenerator = new PetriNetEventGenerator();

	public ManufacturingSystemPN() {
		petriNet = generatePN();
		petriNetEventGenerator.addObserver(petriNet.getEventObserver());
	}
	
	public void initialise(){
		sendState();
	}

	@Override
	public void update(Observable o, Object arg) {
		newEventReceived((ManufacturingSystemEventsTypes) arg);

	}

	public abstract void newEventReceived(ManufacturingSystemEventsTypes event);

	public abstract PetriNet generatePN();

	public PetriNet getPetriNet() {
		return petriNet;
	}

	private void sendState() {
		boolean al = false;
		boolean y1 = false;
		boolean y2 = false;
		boolean y3 = false;
		boolean y4 = false;
		boolean y5 = false;
		boolean y6 = false;
		boolean y7 = false;
		boolean y8 = false;
		boolean y9 = false;
		boolean y10 = false;
		boolean y11 = false;
		boolean y12 = false;
		boolean y13 = false;
		boolean y14 = false;

		Iterator<Entry<String, ManufacturingSystemActuators>> it = activeActuators
				.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, ManufacturingSystemActuators> entry = it.next();

			switch (entry.getValue()) {

			case AL:
				al = true;
				break;

			case Y1:
				y1 = true;
				break;

			case Y2:
				y2 = true;
				break;

			case Y3:
				y3 = true;
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

			case Y7:
				y7 = true;
				break;

			case Y8:
				y8 = true;
				break;

			case Y9:
				y9 = true;
				break;

			case Y10:
				y10 = true;
				break;

			case Y11:
				y11 = true;
				break;

			case Y12:
				y12 = true;
				break;

			case Y13:
				y13 = true;
				break;

			case Y14:
				y14 = true;
				break;

			}

		}

		sendMessage(y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12, y13,
				y14, al);

	}

	public void turnONActuator(String placeID,
			ManufacturingSystemActuators actuator) {

		String key = placeID + actuator;

		if (!activeActuators.containsKey(key)) {
			activeActuators.put(key, actuator);

			sendState();

			logger.info("manufacturing system: actuator " + actuator
					+ " was ACTIVATED by place " + placeID);
		} else {
			logger.error("manufacturing system: received command to ACTIVATE the actuator "
					+ actuator
					+ ", from place "
					+ placeID
					+ ". The actuator was already ACTVATED and the command was ignored");
		}

	}

	public void turnOFFActuator(String placeID,
			ManufacturingSystemActuators actuator) {

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

	private void sendMessage(boolean y1, boolean y2, boolean y3, boolean y4,
			boolean y5, boolean y6, boolean y7, boolean y8, boolean y9,
			boolean y10, boolean y11, boolean y12, boolean y13, boolean y14,
			boolean al) {

		ManufacturingSystemActuatorsMessage fabricatieSystemActuatorsMessage = new ManufacturingSystemActuatorsMessage();
		fabricatieSystemActuatorsMessage.setY1(y1);
		fabricatieSystemActuatorsMessage.setY2(y2);
		fabricatieSystemActuatorsMessage.setY3(y3);
		fabricatieSystemActuatorsMessage.setY4(y4);
		fabricatieSystemActuatorsMessage.setY5(y5);
		fabricatieSystemActuatorsMessage.setY6(y6);
		fabricatieSystemActuatorsMessage.setY7(y7);
		fabricatieSystemActuatorsMessage.setY8(y8);
		fabricatieSystemActuatorsMessage.setY9(y9);
		fabricatieSystemActuatorsMessage.setY10(y10);
		fabricatieSystemActuatorsMessage.setY11(y11);
		fabricatieSystemActuatorsMessage.setY12(y12);
		fabricatieSystemActuatorsMessage.setY13(y13);
		fabricatieSystemActuatorsMessage.setY14(y14);
		fabricatieSystemActuatorsMessage.setAl(al);

//		logger.debug("manufacturing system: actuator message was generated: ");
//		logger.debug("                      y1=" + y1 + ", y2=" + y2 + ", y3="
//				+ y3 + ", y4=" + y4 + ", y5=" + y5 + ", y6=" + y6 + ", y7="
//				+ y7 + ", y8=" + y8 + ", y9=" + y9 + ", y10=" + y10 + ", y11="
//				+ y11 + ", y12=" + y12 + ", y13=" + y13 + ",y14=" + y14
//				+ ", al=" + al);

		setChanged();
		notifyObservers(fabricatieSystemActuatorsMessage);

	}

	public PetriNetEventGenerator getPetriNetEventGenerator() {
		return petriNetEventGenerator;
	}

}
