package ro.unitbv.manufacturing.system;



/**
 * Class for managing the actuators of the manufacturing  system.
 * 
 *
 * 
 */

public class ManufacturingSystemActuatorsMessage {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * the actuators
	 */
	public static boolean al=false;
	public static boolean y1=false;
	public static boolean y2=false;
	public static boolean y3=false;
	public static boolean y4=false;
	public static boolean y5=false;
	public static boolean y6=false;
	public static boolean y7=false;
	public static boolean y8=false;
	public static boolean y9=false;
	public static boolean y10=false;
	public static boolean y11=false;
	public static boolean y12=false;
	public static boolean y13=false;
	public static boolean y14=false;

	/**
	 * The message structure: Mesaj de la calculator la mc '*' 1 Y1 Y2 Y3 Y4 Y5
	 * Y6 Y7 1 y8 y9 y10 y11 y12 y13 y14 1 al 1 1 1 1 1 1 crc #
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
		if (y3)
			byteVal += 16;
		if (y4)
			byteVal += 8;
		if (y5)
			byteVal += 4;
		if (y6)
			byteVal += 2;
		if (y7)
			byteVal += 1;
		message[1] = (byte) byteVal;

		// generate byte 2
		byteVal = 128;
		if (y8)
			byteVal += 64;
		if (y9)
			byteVal += 32;
		if (y10)
			byteVal += 16;
		if (y11)
			byteVal += 8;
		if (y12)
			byteVal += 4;
		if (y13)
			byteVal += 2;
		if (y14)
			byteVal += 1;
		message[2] = (byte) byteVal;

		
		// generate byte 3
		byteVal = 128;
		if (al)
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
		ManufacturingSystemActuatorsMessage.y1 = y1;
	}

	public void setY2(boolean y2) {
		ManufacturingSystemActuatorsMessage.y2 = y2;
	}
	public void setY3(boolean y3) {
		ManufacturingSystemActuatorsMessage.y3 = y3;
	}
	public void setY4(boolean y4) {
		ManufacturingSystemActuatorsMessage.y4 = y4;
	}

	public void setY5(boolean y5) {
		ManufacturingSystemActuatorsMessage.y5 = y5;
	}

	public void setY6(boolean y6) {
		ManufacturingSystemActuatorsMessage.y6 = y6;
	}
	public void setY7(boolean y7) {
		ManufacturingSystemActuatorsMessage.y7 = y7;
	}
	public void setY8(boolean y8) {
		ManufacturingSystemActuatorsMessage.y8 = y8;
	}

	public void setY9(boolean y9) {
		ManufacturingSystemActuatorsMessage.y9 = y9;
	}
	public void setY10(boolean y10) {
		ManufacturingSystemActuatorsMessage.y10 = y10;
	}
	public void setY11(boolean y11) {
		ManufacturingSystemActuatorsMessage.y11 = y11;
	}
	public void setY12(boolean y12) {
		ManufacturingSystemActuatorsMessage.y12 = y12;
	}
	public void setY13(boolean y13) {
		ManufacturingSystemActuatorsMessage.y13 = y13;
	}
	public void setY14(boolean y14) {
		ManufacturingSystemActuatorsMessage.y14 = y14;
	}
	public void setAl(boolean al) {
		ManufacturingSystemActuatorsMessage.al = al;
	}

}
