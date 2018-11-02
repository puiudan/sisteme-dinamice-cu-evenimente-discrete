package ro.unitbv.shared.resources;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.serialcomm.SerialMessage;

public class SharedResourcesController extends Observable implements
		Observer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static enum SharedResourcesEventsTypes {
		EV_S1, EV_S2, EV_S3, EV_S4, EV_S5, EV_S6, EV_S7, EV_S8, EV_S9
	};
	
	public static enum SharedResourcesActuators {
		Y1, Y2, Y4, Y5, Y6, Y8, Y9
	}

	public static enum SharedResourcesIndicators {
		Y3, Y7

	}

	// sensors
	private boolean s1_last_state = false;
	private boolean s2_last_state = false;
	private boolean s3_last_state = false;
	private boolean s4_last_state = false;
	private boolean s5_last_state = false;
	private boolean s6_last_state = false;
	private boolean s7_last_state = false;
	private boolean s8_last_state = false;
	private boolean s9_last_state = false;

	// actuators
	private boolean y1_last_state = false;
	private boolean y2_last_state = false;
	private boolean y4_last_state = false;
	private boolean y5_last_state = false;
	private boolean y6_last_state = false;
	private boolean y8_last_state = false;
	private boolean y9_last_state = false;
	private short y3_last_state = 0;
	private short y7_last_state = 0;

	public void interpretSensorMessage(SharedResourcesSensorsMessage message) {

		if (message.isValidMessage()) {

			if ((s1_last_state == false) && message.isS1()) {
				logger.info("partajated resources: S1 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S1);
			}

			s1_last_state = message.isS1();

			if ((s2_last_state == false) && message.isS2()) {
				logger.info("partajated resources: S2 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S2);

			}

			s2_last_state = message.isS2();

			if ((s3_last_state == false) && message.isS3()) {
				logger.info("partajated resources: S3 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S3);
			}

			s3_last_state = message.isS3();

			if ((s4_last_state == false) && message.isS4()) {
				logger.info("partajated resources: S4 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S4);
			}

			s4_last_state = message.isS4();

			if ((s5_last_state == false) && message.isS5()) {
				logger.info("partajated resources: S5 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S5);
			}

			s5_last_state = message.isS5();

			if ((s6_last_state == false) && message.isS6()) {
				logger.info("partajated resources: S6 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S6);
			}

			s6_last_state = message.isS6();

			if ((s7_last_state == false) && message.isS7()) {
				logger.info("partajated resources: S7 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S7);
			}

			s7_last_state = message.isS7();

			if ((s8_last_state == false) && message.isS8()) {
				logger.info("partajated resources: S8 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S8);
			}

			s8_last_state = message.isS8();

			if ((s9_last_state == false) && message.isS9()) {
				logger.info("partajated resources: S9 event was generated");
				setChanged();
				notifyObservers(SharedResourcesEventsTypes.EV_S9);
			}

			s9_last_state = message.isS9();

		}

	}

	public void sendActuatorsState() {

	}

	@Override
	public void update(Observable o, Object arg) {
		SharedResourcesSensorsMessage partajateResourcesSensorsMessage = new SharedResourcesSensorsMessage(
				(SerialMessage) arg);
		interpretSensorMessage(partajateResourcesSensorsMessage);

	}

}
