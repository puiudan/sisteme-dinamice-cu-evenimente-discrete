package ro.unitbv.manufacturing.system;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.serialcomm.SerialMessage;

public class ManufacturingSystemController extends Observable implements
		Observer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static enum ManufacturingSystemEventsTypes {
		EV_S1_ACTIVE, EV_S2_ACTIVE, EV_S3_ACTIVE, EV_S4_ACTIVE, 
		EV_S5_ACTIVE, EV_S6_ACTIVE, EV_S7_ACTIVE, EV_S8_ACTIVE, 
		EV_S9_ACTIVE, EV_S10_ACTIVE, EV_S11_ACTIVE, EV_S12_ACTIVE, 
		EV_S13_ACTIVE, EV_S14_ACTIVE, 
		EV_S1_INACTIVE, EV_S2_INACTIVE, EV_S3_INACTIVE, EV_S4_INACTIVE, 
		EV_S5_INACTIVE, EV_S6_INACTIVE, EV_S7_INACTIVE, EV_S8_INACTIVE, 
		EV_S9_INACTIVE, EV_S10_INACTIVE, EV_S11_INACTIVE, EV_S12_INACTIVE, 
		EV_S13_INACTIVE, EV_S14_INACTIVE,
		EV_BCI
	};

	public static enum ManufacturingSystemActuators {
		AL, Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9, Y10, Y11, Y12, Y13, Y14
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
	private boolean s10_last_state = false;
	private boolean s11_last_state = false;
	private boolean s12_last_state = false;
	private boolean s13_last_state = false;
	private boolean s14_last_state = false;
	private boolean bci_last_state = false;
//	// actuators
//	private boolean al_last_state = false;
//	private boolean y1_last_state = false;
//	private boolean y2_last_state = false;
//	private boolean y3_last_state = false;
//	private boolean y4_last_state = false;
//	private boolean y5_last_state = false;
//	private boolean y6_last_state = false;
//	private boolean y7_last_state = false;
//	private boolean y8_last_state = false;
//	private boolean y9_last_state = false;
//	private boolean y10_last_state = false;
//	private boolean y11_last_state = false;
//	private boolean y12_last_state = false;
//	private boolean y14_last_state = false;

	/*
	 * private short y3_last_state = 0; private short y7_last_state = 0;
	 */
	public void interpretSensorMessage(ManufacturingSystemSensorsMessage message) {

		if (message.isValidMessage()) {

			if ((s1_last_state == false) && message.isS1()) {
				logger.info("manufacturing system: S1_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S1_ACTIVE);
			}
			
			if ((s1_last_state == true) && (!message.isS1())) {
				logger.info("manufacturing system: S1_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S1_INACTIVE);
			}

			s1_last_state = message.isS1();

			if ((s2_last_state == false) && message.isS2()) {
				logger.info("manufacturing system: S2_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S2_ACTIVE);

			}
			
			if ((s2_last_state == true) && (!message.isS2())) {
				logger.info("manufacturing system: S2_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S2_INACTIVE);

			}

			s2_last_state = message.isS2();

			if ((s3_last_state == false) && message.isS3()) {
				logger.info("manufacturing system: S3_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S3_ACTIVE);
			}
			
			if ((s3_last_state == true) && (!message.isS3())) {
				logger.info("manufacturing system: S3_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S3_INACTIVE);
			}

			s3_last_state = message.isS3();

			if ((s4_last_state == false) && message.isS4()) {
				logger.info("manufacturing system: S4_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S4_ACTIVE);
			}
			
			if ((s4_last_state == true) && (!message.isS4())) {
				logger.info("manufacturing system: S4_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S4_INACTIVE);
			}

			s4_last_state = message.isS4();

			if ((s5_last_state == false) && message.isS5()) {
				logger.info("manufacturing system: S5_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S5_ACTIVE);
			}
			
			if ((s5_last_state == true) && (!message.isS5())) {
				logger.info("manufacturing system: S5_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S5_INACTIVE);
			}

			s5_last_state = message.isS5();

			if ((s6_last_state == false) && message.isS6()) {
				logger.info("manufacturing system: S6_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S6_ACTIVE);
			}
			
			if ((s6_last_state == true) && (!message.isS6())) {
				logger.info("manufacturing system: S6_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S6_INACTIVE);
			}

			s6_last_state = message.isS6();

			if ((s7_last_state == false) && message.isS7()) {
				logger.info("manufacturing system: S7_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S7_ACTIVE);
			}
			
			if ((s7_last_state == true) && (!message.isS7())) {
				logger.info("manufacturing system: S7_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S7_INACTIVE);
			}

			s7_last_state = message.isS7();

			if ((s8_last_state == false) && message.isS8()) {
				logger.info("manufacturing system: S8_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S8_ACTIVE);
			}
			
			if ((s8_last_state == true) && (!message.isS8())) {
				logger.info("manufacturing system: S8_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S8_INACTIVE);
			}

			s8_last_state = message.isS8();

			if ((s9_last_state == false) && message.isS9()) {
				logger.info("manufacturing system: S9_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S9_ACTIVE);
			}
			
			if ((s9_last_state == true) && (!message.isS9())) {
				logger.info("manufacturing system: S9_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S9_INACTIVE);
			}

			s9_last_state = message.isS9();

			if ((s10_last_state == false) && message.isS10()) {
				logger.info("manufacturing system: S10_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S10_ACTIVE);
			}
			
			if ((s10_last_state == true) && (!message.isS10())) {
				logger.info("manufacturing system: S10_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S10_INACTIVE);
			}
			
			s10_last_state = message.isS10();

			if ((s11_last_state == false) && message.isS11()) {
				logger.info("manufacturing system: S11_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S11_ACTIVE);

			}
			
			if ((s11_last_state == true) && (!message.isS11())) {
				logger.info("manufacturing system: S11_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S11_INACTIVE);

			}
			
			s11_last_state = message.isS11();

			if ((s12_last_state == false) && message.isS12()) {
				logger.info("manufacturing system: S12_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S12_ACTIVE);

			}
			
			if ((s12_last_state == true) && (!message.isS12())) {
				logger.info("manufacturing system: S12_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S12_INACTIVE);

			}
			
			s12_last_state = message.isS12();

			if ((s13_last_state == false) && message.isS13()) {
				logger.info("manufacturing system: S13_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S13_ACTIVE);

			}
			
			if ((s13_last_state == true) && (!message.isS13())) {
				logger.info("manufacturing system: S13_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S13_INACTIVE);

			}
			
			s13_last_state = message.isS13();

			if ((s14_last_state == false) && message.isS14()) {
				logger.info("manufacturing system: S14_ACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S14_ACTIVE);

			}
			
			if ((s14_last_state == true) && (!message.isS14())) {
				logger.info("manufacturing system: S14_INACTIVE event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_S14_INACTIVE);

			}
			
			s14_last_state = message.isS14();

			if ((bci_last_state == false) && message.isBCI()) {
				logger.info("manufacturing system: BCI event was generated");
				setChanged();
				notifyObservers(ManufacturingSystemEventsTypes.EV_BCI);

			}
			bci_last_state = message.isBCI();
		}

	}

	public void sendActuatorsState() {

	}

	@Override
	public void update(Observable o, Object arg) {
		ManufacturingSystemSensorsMessage partajateResourcesSensorsMessage = new ManufacturingSystemSensorsMessage(
				(SerialMessage) arg);
		interpretSensorMessage(partajateResourcesSensorsMessage);

	}

}
