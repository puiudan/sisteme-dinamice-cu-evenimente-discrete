package ro.unitbv.autonomous.robots;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.serialcomm.SerialMessage;

public class AutonomousRobotsController extends Observable implements Observer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static enum AutonomousRobotsEventsTypes {
		EV_B1, EV_B2, EV_B3, EV_B4, EV_B5, EV_B6
	};

	public static enum AutonomousRobotsActuators {
		Y1_GREEN, Y1_RED, Y2_GREEN, Y2_RED, Y3_GREEN, Y3_RED, Y4_GREEN, Y4_RED, Y5_GREEN, Y5_RED, Y6_GREEN, Y6_RED, GARAJ
	}

	public static enum AutonomousRobotsIndicators {
		C1, C2, C3, GARAJ

	}

	// sensors
	private boolean b1_last_state = false;
	private boolean b2_last_state = false;
	private boolean b3_last_state = false;
	private boolean b4_last_state = false;
	private boolean b5_last_state = false;
	private boolean b6_last_state = false;

	public void interpretSensorMessage(AutonomousRobotsSensorsMessage message) {

		if (message.isValidMessage()) {

			if ((b1_last_state == false) && message.isB1()) {
				logger.info("partajated resources: B1 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B1);
			}

			b1_last_state = message.isB1();

			if ((b2_last_state == false) && message.isB2()) {
				logger.info("partajated resources: B2 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B2);

			}

			b2_last_state = message.isB2();

			if ((b3_last_state == false) && message.isB3()) {
				logger.info("partajated resources: B3 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B3);
			}

			b3_last_state = message.isB3();

			if ((b4_last_state == false) && message.isB4()) {
				logger.info("partajated resources: B4 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B4);
			}

			b4_last_state = message.isB4();

			if ((b5_last_state == false) && message.isB5()) {
				logger.info("partajated resources: B5 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B5);
			}

			b5_last_state = message.isB5();

			if ((b6_last_state == false) && message.isB6()) {
				logger.info("partajated resources: B6 event was generated");
				setChanged();
				notifyObservers(AutonomousRobotsEventsTypes.EV_B6);
			}

			b6_last_state = message.isB6();

		}

	}

	public void sendActuatorsState() {

	}

	@Override
	public void update(Observable o, Object arg) {
		AutonomousRobotsSensorsMessage autonomousRobotsSensorsMessage = new AutonomousRobotsSensorsMessage(
				(SerialMessage) arg);
		interpretSensorMessage(autonomousRobotsSensorsMessage);

	}

}
