package ro.unitbv.autonomous.robots;

import org.apache.log4j.Logger;

import ro.unitbv.serialcomm.SerialMessage;

public class AutonomousRobotsSensorsMessage {

	private Logger logger = Logger.getLogger(this.getClass());

	private static final short RECEIVE_MESSAGE_LENGTH = 4;

	private SerialMessage serialMessage;

	private byte[] message;
	private int messageLength;

	private boolean validMessage;

	// Sensors
	private boolean b1 = false;
	private boolean b2 = false;
	private boolean b3 = false;
	private boolean b4 = false;
	private boolean b5 = false;
	private boolean b6 = false;

	/*
	 * Mesaj de la mc la calculator '*' 1 S1 S2 S3 S4 S5 S6 S7 1 S8 S9 1 1 1 1 1
	 * crc '#'
	 */

	public AutonomousRobotsSensorsMessage(SerialMessage message) {
		this.serialMessage = message;
		decode();

	}

	private void decode() {

		// logger.info("autonomous robots: decoding message...");

		// logger.info("autonomous robots: testing message...");

		message = serialMessage.getMessage();
		messageLength = serialMessage.getLength();

		validMessage = checkMessage();

		if (validMessage) {
			// logger.info("autonomous robots: message OK");

			b1 = ((message[1] & 0x40) == 0x40);
			b2 = ((message[1] & 0x20) == 0x20);
			b3 = ((message[1] & 0x10) == 0x10);
			b4 = ((message[1] & 0x08) == 0x08);
			b5 = ((message[1] & 0x04) == 0x04);
			b6 = ((message[1] & 0x02) == 0x02);

		} else {
			logger.info("autonomous robots: message NOT OK");
		}

		// logger.info("autonomous robots: decoding message...DONE");

	}

	private Boolean checkMessage() {

		if (messageLength != RECEIVE_MESSAGE_LENGTH) {
			logger.error("autonomous robots: mesage length not appropriate ");
			return false;
		}

		if (message[0] != '*') {
			logger.error("autonomous robots: missing first character");
			return false;
		}

		if (message[RECEIVE_MESSAGE_LENGTH - 1] != '#') {
			logger.error("autonomous robots: mising last character ");
			return false;
		}

		// TODO NO CRC CHECK

		if ((message[1] & 0x80) != 0x80) {
			logger.error("autonomous robots: message format error (the first byte o"
					+ "f the payload is '0'" + "( " + (short) message[1] + ")");
			return false;
		}

		return true;
	}

	public boolean isValidMessage() {
		return validMessage;
	}

	public boolean isB1() {
		return b1;
	}

	public boolean isB2() {
		return b2;
	}

	public boolean isB3() {
		return b3;
	}

	public boolean isB4() {
		return b4;
	}

	public boolean isB5() {
		return b5;
	}

	public boolean isB6() {
		return b6;
	}
}
