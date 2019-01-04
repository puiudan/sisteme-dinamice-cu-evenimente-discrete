package ro.unitbv.serialcomm;

public class SerialMessage {

	byte[] message;
	int length;

	public SerialMessage(byte[] message, int length) {
		super();
		this.message = message;
		this.length = length;
	}

	public byte[] getMessage() {
		return message;
	}

	public int getLength() {
		return length;
	}

}
