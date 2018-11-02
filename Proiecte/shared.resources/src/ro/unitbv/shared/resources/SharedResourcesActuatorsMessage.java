package ro.unitbv.shared.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for managing the actuators of the partajated resources system.
 * 
 * @author dan.puiu
 * 
 */

public class SharedResourcesActuatorsMessage {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * the actuators
	 */
	public static boolean y1 = false;
	public static boolean y2 = false;
	public static boolean y4 = false;
	public static boolean y5 = false;
	public static boolean y6 = false;
	public static boolean y8 = false;
	public static boolean y9 = false;
	public static boolean y3A = false;
	public static boolean y3B = false;
	public static boolean y3C = false;
	public static boolean y3D = false;
	public static boolean y7A = false;
	public static boolean y7B = false;
	public static boolean y7C = false;
	public static boolean y7D = false;

	/**
	 * The message structure: Mesaj de la calculator la mc '*' 1 Y1 Y2 Y4 Y5 Y6
	 * Y8 Y9 1 y3_A y3_B y3_C y3_D y7_A y7_B y7_C 1 y7_D 1 1 1 1 1 1 crc #
	 */
	public byte[] encode() {

		byte[] message = new byte[6];

		message[0] = '*';

		// generate byte 1
		int byteVal = 128;
		if (y1)
			byteVal += 64;
		if (y2)
			byteVal += 32;
		if (y4)
			byteVal += 16;
		if (y5)
			byteVal += 8;
		if (y6)
			byteVal += 4;
		if (y8)
			byteVal += 2;
		if (y9)
			byteVal += 1;
		message[1] = (byte) byteVal;

		// generate byte 2
		byteVal = 128;
		if (y3A)
			byteVal += 64;
		if (y3B)
			byteVal += 32;
		if (y3C)
			byteVal += 16;
		if (y3D)
			byteVal += 8;
		if (y7A)
			byteVal += 4;
		if (y7B)
			byteVal += 2;
		if (y7C)
			byteVal += 1;
		message[2] = (byte) byteVal;

		// generate byte 3
		byteVal = 128;
		if (y7D)
			byteVal += 64;
		byteVal += 32 + 16 + 8 + 4 + 2 + 1;
		message[3] = (byte) byteVal;

		// TODO: generate the CRC
		message[4] = 'A';

		// end of message.
		message[5] = '#';

		return message;
	}

	public void setY1(boolean y1) {
		SharedResourcesActuatorsMessage.y1 = y1;
	}

	public void setY2(boolean y2) {
		SharedResourcesActuatorsMessage.y2 = y2;
	}

	public void setY4(boolean y4) {
		SharedResourcesActuatorsMessage.y4 = y4;
	}

	public void setY5(boolean y5) {
		SharedResourcesActuatorsMessage.y5 = y5;
	}

	public void setY6(boolean y6) {
		SharedResourcesActuatorsMessage.y6 = y6;
	}

	public void setY8(boolean y8) {
		SharedResourcesActuatorsMessage.y8 = y8;
	}

	public void setY9(boolean y9) {
		SharedResourcesActuatorsMessage.y9 = y9;
	}

	public void setY3(int y3) {

		switch (y3) {
		case 0:
			y3A = false;
			y3B = false;
			y3C = false;
			y3D = false;
			break;

		case 1:
			y3A = true;
			y3B = false;
			y3C = false;
			y3D = false;
			break;

		case 2:
			y3A = false;
			y3B = true;
			y3C = false;
			y3D = false;
			break;

		case 3:
			y3A = true;
			y3B = true;
			y3C = false;
			y3D = false;
			break;

		case 4:
			y3A = false;
			y3B = false;
			y3C = true;
			y3D = false;
			break;

		case 5:
			y3A = true;
			y3B = false;
			y3C = true;
			y3D = false;
			break;

		case 6:
			y3A = false;
			y3B = true;
			y3C = true;
			y3D = false;
			break;

		case 7:
			y3A = true;
			y3B = true;
			y3C = true;
			y3D = false;
			break;

		case 8:
			y3A = false;
			y3B = false;
			y3C = false;
			y3D = true;
			break;

		case 9:
			y3A = true;
			y3B = false;
			y3C = false;
			y3D = true;
			break;
		default:
			logger.error("Error while setting y3 value. The received "
					+ "value is " + y3 + " and it has to be in "
					+ "the interval [0;9]. Default value was used y3=0.");
			y3A = false;
			y3B = false;
			y3C = false;
			y3D = false;
			break;
		}

	}

	public void setY7(int y7) {
		switch (y7) {
		case 0:
			y7A = false;
			y7B = false;
			y7C = false;
			y7D = false;
			break;

		case 1:
			y7A = true;
			y7B = false;
			y7C = false;
			y7D = false;
			break;

		case 2:
			y7A = false;
			y7B = true;
			y7C = false;
			y7D = false;
			break;

		case 3:
			y7A = true;
			y7B = true;
			y7C = false;
			y7D = false;
			break;

		case 4:
			y7A = false;
			y7B = false;
			y7C = true;
			y7D = false;
			break;

		case 5:
			y7A = true;
			y7B = false;
			y7C = true;
			y7D = false;
			break;

		case 6:
			y7A = false;
			y7B = true;
			y7C = true;
			y7D = false;
			break;

		case 7:
			y7A = true;
			y7B = true;
			y7C = true;
			y7D = false;
			break;

		case 8:
			y7A = false;
			y7B = false;
			y7C = false;
			y7D = true;
			break;

		case 9:
			y7A = true;
			y7B = false;
			y7C = false;
			y7D = true;
			break;
		default:
			logger.error("Error while setting y7 value. The received "
					+ "value is " + y7 + " and it has to be in "
					+ "the interval [0;9]. Default value was used y7=0.");
			y7A = false;
			y7B = false;
			y7C = false;
			y7D = false;
			break;
		}
	}

}
