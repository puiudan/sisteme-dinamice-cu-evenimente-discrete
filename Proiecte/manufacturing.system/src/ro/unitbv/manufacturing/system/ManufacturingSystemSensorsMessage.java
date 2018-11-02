package ro.unitbv.manufacturing.system;

import org.apache.log4j.Logger;

import ro.unitbv.serialcomm.SerialMessage;

public class ManufacturingSystemSensorsMessage {

	private Logger logger = Logger.getLogger(this.getClass());

	private static final short RECEIVE_MESSAGE_LENGTH = 6;

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
	private boolean s10 = false;
	private boolean s11 = false;
	private boolean s12 = false;
	private boolean s13 = false;
	private boolean s14 = false;
	private boolean bci = false;

	/*
	 * Mesaj de la mc la calculator '*' 1 S1 S2 S3 S4 S5 S6 S7 1 S8 S9 S10 S11 S12 S13 S14
1 BCI 1 1 1 1 1 1	 * crc '#'
	 */

	public ManufacturingSystemSensorsMessage(SerialMessage message) {
		this.serialMessage = message;
		decode();

	}

	private void decode() {

		//logger.info("manufacturing system: decoding message...");

		//logger.info("manufacturing system: testing message...");
		
		message = serialMessage.getMessage();
		messageLength = serialMessage.getLength();

		validMessage = checkMessage();

		if (validMessage) {
			//logger.info("manufacturing system: message OK");

			s1 = ((message[1] & 0x40) == 0x40);
			s2 = ((message[1] & 0x20) == 0x20);
			s3 = ((message[1] & 0x10) == 0x10);
			s4 = ((message[1] & 0x08) == 0x08);
			s5 = ((message[1] & 0x04) == 0x04);
			s6 = ((message[1] & 0x02) == 0x02);
			s7 = ((message[1] & 0x01) == 0x01);
			s8 = ((message[2] & 0x40) == 0x40);
			s9 = ((message[2] & 0x20) == 0x20);
			s10 = ((message[2] & 0x10) == 0x10);
			s11 = ((message[2] & 0x08) == 0x08);
			s12 = ((message[2] & 0x04) == 0x04);
			s13 = ((message[2] & 0x02) == 0x02);
			s14 = ((message[2] & 0x01) == 0x01);
			bci = ((message[3] & 0x40) == 0x40);
//			logger.info("manufacturing system: reading message results: s1 = "
//					+ s1 + "; s2 = " + s2 + "; s3 = " + s3 + "; s4 = " + s4
//					+ "; s5 = " + s5 + "; s6 = " + s6 + "; s7 = " + s7
//					+ "; s8 = " + s8 + "; s9 = " + s9 + "; s10 = " + s10 + "; s11 = " + s11 + "; s12 = " + s12 + "; s13 = " + s13 + "; s14 = " + s14 + "; bci = " + bci);

		} else {
			logger.info("manufacturing system: message NOT OK");
		}

		//logger.info("manufacturing system: decoding message...DONE");

	}

	private Boolean checkMessage() {

		if (messageLength != RECEIVE_MESSAGE_LENGTH) {
			logger.error("manufacturing system: mesage length not appropriate ");
			return false;
		}

		if (message[0] != '*') {
			logger.error("manufacturing system: missing first character");
			return false;
		}

		if (message[RECEIVE_MESSAGE_LENGTH - 1] != '#') {
			logger.error("manufacturing system: mising last character ");
			return false;
		}

		// TODO NO CRC CHECK

		if ((message[1] & 0x80) != 0x80) {
			logger.error("manufacturing system: message format error (the first byte o"
					+ "f the payload is '0'" + "( " + (short)message[1] + ")");
			return false;
		}

		if ((message[2] & 0x80) != 0x80) {
			logger.error("manufacturing system: message format error (the first byte o"
					+ "f the payload is '0'");
			return false;
		}
		
		if ((message[3] & 0x80) != 0x80) {
			logger.error("manufacturing system: message format error (the first byte o"
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
	
	public boolean isS10() {
		return s10;
	}	
	public boolean isS11() {
			return s11;
	}
	public boolean isS12() {
		return s12;
	}
	public boolean isS13() {
		return s13;
	}
	public boolean isS14() {
		return s14;
	}
	public boolean isBCI() {
		return bci;
	}
	}

	


