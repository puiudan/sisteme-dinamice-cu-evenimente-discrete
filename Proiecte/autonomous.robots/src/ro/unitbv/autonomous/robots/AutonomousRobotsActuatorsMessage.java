package ro.unitbv.autonomous.robots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for managing the actuators of the partajated resources system.
 * 
 * @author dan.puiu
 * 
 */

public class AutonomousRobotsActuatorsMessage {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * the actuators
	 */
	public boolean y1_green = false;
	public boolean y1_red = false;
	public boolean y2_green = false;
	public boolean y2_red = false;
	public boolean y3_green = false;
	public boolean y3_red = false;
	public boolean y4_green = false;
	public boolean y4_red = false;
	public boolean y5_green = false;
	public boolean y5_red = false;
	public boolean y6_green = false;
	public boolean y6_red = false;
	public boolean garaj_A = false;
	public boolean garaj_B = false;
	public boolean garaj_C = false;
	public boolean garaj_D = false;
	public boolean c1_A = false;
	public boolean c1_B = false;
	public boolean c1_C = false;
	public boolean c1_D = false;
	public boolean c2_A = false;
	public boolean c2_B = false;
	public boolean c2_C = false;
	public boolean c2_D = false;
	public boolean c3_A = false;
	public boolean c3_B = false;
	public boolean c3_C = false;
	public boolean c3_D = false;


	/**
	 * The message structure: Mesaj de la calculator la mc '*' 1 Y1 Y2 Y4 Y5 Y6
	 * Y8 Y9 1 y3_A y3_B y3_C y3_D y7_A y7_B y7_C 1 y7_D 1 1 1 1 1 1 crc #
	 */
	public byte[] encode() {

		byte[] message = new byte[7];

		message[0] = '*';

		// generate byte 1
		int byteVal = 128;
		if (y1_green)
			byteVal += 64;
		if (y1_red)
			byteVal += 32;
		if (y2_green)
			byteVal += 16;
		if (y2_red)
			byteVal += 8;
		if (y3_green)
			byteVal += 4;
		if (y3_red)
			byteVal += 2;
		if (y4_green)
			byteVal += 1;
		message[1] = (byte) byteVal;
		
		// generate byte 2
		byteVal = 128;
		if (y4_red)
			byteVal += 64;
		if (y5_green)
			byteVal += 32;
		if (y5_red)
			byteVal += 16;
		if (y6_green)
			byteVal += 8;
		if (y6_red)
			byteVal += 4;
		if (garaj_A)
			byteVal += 2;
		if (garaj_B)
			byteVal += 1;
		message[2] = (byte) byteVal;

		// generate byte 3
		byteVal = 128;
		if (garaj_C)
			byteVal += 64;
		if (garaj_D)
			byteVal += 32;
		if (c1_A)
			byteVal += 16;
		if (c1_B)
			byteVal += 8;
		if (c1_C)
			byteVal += 4;
		if (c1_D)
			byteVal += 2;
		if (c2_A)
			byteVal += 1;
		message[3] = (byte) byteVal;

		// generate byte 4
		byteVal = 128;
		if (c2_B)
			byteVal += 64;
		if (c2_C)
			byteVal += 32;
		if (c2_D)
			byteVal += 16;
		if (c3_A)
			byteVal += 8;
		if (c3_B)
			byteVal += 4;
		if (c3_C)
			byteVal += 2;
		if (c3_D)
			byteVal += 1;
		message[4] = (byte) byteVal;

		// TODO: generate the CRC
		message[5] = 'A';

		// end of message.
		message[6] = '#';

		return message;
	}

	public void setY1_green(boolean y1_green) {
		this.y1_green = y1_green;
	}

	public void setY1_red(boolean y1_red) {
		this.y1_red = y1_red;
	}

	public void setY2_green(boolean y2_green) {
		this.y2_green = y2_green;
	}

	public void setY2_red(boolean y2_red) {
		this.y2_red = y2_red;
	}

	public void setY3_green(boolean y3_green) {
		this.y3_green = y3_green;
	}

	public void setY3_red(boolean y3_red) {
		this.y3_red = y3_red;
	}

	public void setY4_green(boolean y4_green) {
		this.y4_green = y4_green;
	}

	public void setY4_red(boolean y4_red) {
		this.y4_red = y4_red;
	}

	public void setY5_green(boolean y5_green) {
		this.y5_green = y5_green;
	}

	public void setY5_red(boolean y5_red) {
		this.y5_red = y5_red;
	}

	public void setY6_green(boolean y6_green) {
		this.y6_green = y6_green;
	}

	public void setY6_red(boolean y6_red) {
		this.y6_red = y6_red;
	}

	public void setGaraj(int garaj) {
		switch (garaj) {
		case 0:
			garaj_A = false;
			garaj_B = false;
			garaj_C = false;
			garaj_D = false;
			break;

		case 1:
			garaj_A = true;
			garaj_B = false;
			garaj_C = false;
			garaj_D = false;
			break;

		case 2:
			garaj_A = false;
			garaj_B = true;
			garaj_C = false;
			garaj_D = false;
			break;

		case 3:
			garaj_A = true;
			garaj_B = true;
			garaj_C = false;
			garaj_D = false;
			break;

		case 4:
			garaj_A = false;
			garaj_B = false;
			garaj_C = true;
			garaj_D = false;
			break;

		case 5:
			garaj_A = true;
			garaj_B = false;
			garaj_C = true;
			garaj_D = false;
			break;

		case 6:
			garaj_A = false;
			garaj_B = true;
			garaj_C = true;
			garaj_D = false;
			break;

		case 7:
			garaj_A = true;
			garaj_B = true;
			garaj_C = true;
			garaj_D = false;
			break;

		case 8:
			garaj_A = false;
			garaj_B = false;
			garaj_C = false;
			garaj_D = true;
			break;

		case 9:
			garaj_A = true;
			garaj_B = false;
			garaj_C = false;
			garaj_D = true;
			break;
		default:
			logger.error("Error while setting y3 value. The received "
					+ "value is " + garaj + " and it has to be in "
					+ "the interval [0;9]. Default value was used garaj=0.");
			garaj_A = false;
			garaj_B = false;
			garaj_C = false;
			garaj_D = false;
			break;
		}
	}

	public void setC1(int c1) {
		switch (c1) {
		case 0:
			c1_A = false;
			c1_B = false;
			c1_C = false;
			c1_D = false;
			break;

		case 1:
			c1_A = true;
			c1_B = false;
			c1_C = false;
			c1_D = false;
			break;

		case 2:
			c1_A = false;
			c1_B = true;
			c1_C = false;
			c1_D = false;
			break;

		case 3:
			c1_A = true;
			c1_B = true;
			c1_C = false;
			c1_D = false;
			break;

		case 4:
			c1_A = false;
			c1_B = false;
			c1_C = true;
			c1_D = false;
			break;

		case 5:
			c1_A = true;
			c1_B = false;
			c1_C = true;
			c1_D = false;
			break;

		case 6:
			c1_A = false;
			c1_B = true;
			c1_C = true;
			c1_D = false;
			break;

		case 7:
			c1_A = true;
			c1_B = true;
			c1_C = true;
			c1_D = false;
			break;

		case 8:
			c1_A = false;
			c1_B = false;
			c1_C = false;
			c1_D = true;
			break;

		case 9:
			c1_A = true;
			c1_B = false;
			c1_C = false;
			c1_D = true;
			break;
		default:
			logger.error("Error while setting y3 value. The received "
					+ "value is " + c1 + " and it has to be in "
					+ "the interval [0;9]. Default value was used c1=0.");
			c1_A = false;
			c1_B = false;
			c1_C = false;
			c1_D = false;
			break;
		}
	}
	
	public void setC2(int c2) {
		switch (c2) {
		case 0:
			c2_A = false;
			c2_B = false;
			c2_C = false;
			c2_D = false;
			break;

		case 1:
			c2_A = true;
			c2_B = false;
			c2_C = false;
			c2_D = false;
			break;

		case 2:
			c2_A = false;
			c2_B = true;
			c2_C = false;
			c2_D = false;
			break;

		case 3:
			c2_A = true;
			c2_B = true;
			c2_C = false;
			c2_D = false;
			break;

		case 4:
			c2_A = false;
			c2_B = false;
			c2_C = true;
			c2_D = false;
			break;

		case 5:
			c2_A = true;
			c2_B = false;
			c2_C = true;
			c2_D = false;
			break;

		case 6:
			c2_A = false;
			c2_B = true;
			c2_C = true;
			c2_D = false;
			break;

		case 7:
			c2_A = true;
			c2_B = true;
			c2_C = true;
			c2_D = false;
			break;

		case 8:
			c2_A = false;
			c2_B = false;
			c2_C = false;
			c2_D = true;
			break;

		case 9:
			c2_A = true;
			c2_B = false;
			c2_C = false;
			c2_D = true;
			break;
		default:
			logger.error("Error while setting y3 value. The received "
					+ "value is " + c2 + " and it has to be in "
					+ "the interval [0;9]. Default value was used c2=0.");
			c2_A = false;
			c2_B = false;
			c2_C = false;
			c2_D = false;
			break;
		}
	}

	public void setC3(int c3) {
		switch (c3) {
		case 0:
			c3_A = false;
			c3_B = false;
			c3_C = false;
			c3_D = false;
			break;

		case 1:
			c3_A = true;
			c3_B = false;
			c3_C = false;
			c3_D = false;
			break;

		case 2:
			c3_A = false;
			c3_B = true;
			c3_C = false;
			c3_D = false;
			break;

		case 3:
			c3_A = true;
			c3_B = true;
			c3_C = false;
			c3_D = false;
			break;

		case 4:
			c3_A = false;
			c3_B = false;
			c3_C = true;
			c3_D = false;
			break;

		case 5:
			c3_A = true;
			c3_B = false;
			c3_C = true;
			c3_D = false;
			break;

		case 6:
			c3_A = false;
			c3_B = true;
			c3_C = true;
			c3_D = false;
			break;

		case 7:
			c3_A = true;
			c3_B = true;
			c3_C = true;
			c3_D = false;
			break;

		case 8:
			c3_A = false;
			c3_B = false;
			c3_C = false;
			c3_D = true;
			break;

		case 9:
			c3_A = true;
			c3_B = false;
			c3_C = false;
			c3_D = true;
			break;
		default:
			logger.error("Error while setting y3 value. The received "
					+ "value is " + c3 + " and it has to be in "
					+ "the interval [0;9]. Default value was used c3=0.");
			c3_A = false;
			c3_B = false;
			c3_C = false;
			c3_D = false;
			break;
		}
	}

	

}
