package ro.unitbv.shared.resources;

import org.apache.log4j.Logger;

import ro.unitbv.serialcomm.SerialMessage;

public class SharedResourcesSensorsMessage {

	private Logger logger = Logger.getLogger(this.getClass());

	private static final short RECEIVE_MESSAGE_LENGTH = 5;

	private SerialMessage serialMessage;
	
	private byte[] message;
	private int messageLength;

	private boolean validMessage;

	// Sensors
	private boolean s1 = false;
	private boolean s2 = false;
	private boolean s3 = false;
	private boolean s4 = false;
	private boolean s5 = false;
	private boolean s6 = false;
	private boolean s7 = false;
	private boolean s8 = false;
	private boolean s9 = false;

	/*
	 * Mesaj de la mc la calculator '*' 1 S1 S2 S3 S4 S5 S6 S7 1 S8 S9 1 1 1 1 1
	 * crc '#'
	 */

	public SharedResourcesSensorsMessage(SerialMessage message) {
		this.serialMessage = message;
		decode();

	}

	private void decode() {

		//logger.info("partajated resources: decoding message...");

		//logger.info("partajated resources: testing message...");
		
		message = serialMessage.getMessage();
		messageLength = serialMessage.getLength();

		validMessage = checkMessage();

		if (validMessage) {
			//logger.info("partajated resources: message OK");

			s1 = ((message[1] & 0x40) == 0x40);
			s2 = ((message[1] & 0x20) == 0x20);
			s3 = ((message[1] & 0x10) == 0x10);
			s4 = ((message[1] & 0x08) == 0x08);
			s5 = ((message[1] & 0x04) == 0x04);
			s6 = ((message[1] & 0x02) == 0x02);
			s7 = ((message[1] & 0x01) == 0x01);
			s8 = ((message[2] & 0x40) == 0x40);
			s9 = ((message[2] & 0x20) == 0x20);

//			logger.info("partajated resources: reading message results: s1 = "
//					+ s1 + "; s2 = " + s2 + "; s3 = " + s3 + "; s4 = " + s4
//					+ "; s5 = " + s5 + "; s6 = " + s6 + "; s7 = " + s7
//					+ "; s8 = " + s8 + "; s9 = " + s9);

		} else {
			logger.info("partajated resources: message NOT OK");
		}

		//logger.info("partajated resources: decoding message...DONE");

	}

	private Boolean checkMessage() {

		if (messageLength != RECEIVE_MESSAGE_LENGTH) {
			logger.error("partajated resources: mesage length not appropriate ");
			return false;
		}

		if (message[0] != '*') {
			logger.error("partajated resources: missing first character");
			return false;
		}

		if (message[RECEIVE_MESSAGE_LENGTH - 1] != '#') {
			logger.error("partajated resources: mising last character ");
			return false;
		}

		// TODO NO CRC CHECK

		if ((message[1] & 0x80) != 0x80) {
			logger.error("partajated resources: message format error (the first byte o"
					+ "f the payload is '0'" + "( " + (short)message[1] + ")");
			return false;
		}

		if ((message[2] & 0x80) != 0x80) {
			logger.error("partajated resources: message format error (the first byte o"
					+ "f the payload is '0'");
			return false;
		}

		return true;
	}

	public boolean isValidMessage() {
		return validMessage;
	}

	public boolean isS1() {
		return s1;
	}

	public boolean isS2() {
		return s2;
	}

	public boolean isS3() {
		return s3;
	}

	public boolean isS4() {
		return s4;
	}

	public boolean isS5() {
		return s5;
	}

	public boolean isS6() {
		return s6;
	}

	public boolean isS7() {
		return s7;
	}

	public boolean isS8() {
		return s8;
	}

	public boolean isS9() {
		return s9;
	}
	
	

}
