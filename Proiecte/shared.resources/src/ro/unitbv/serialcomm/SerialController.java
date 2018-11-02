package ro.unitbv.serialcomm;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.TooManyListenersException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.shared.resources.SharedResourcesActuatorsMessage;

public class SerialController extends Observable implements Observer,
		SerialPortEventListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	static CommPortIdentifier commPortIdentifier;
	private SerialPort serialPort;

	private SerialPortConfiguration serialPortConfiguration;
	private String pathtoConfigFile = "./resources/SerialPortConfiguration.xml";

	private InputStream in;
	private OutputStream out;

	public SerialController() {

		readSerialConnectionConfiguration();
		connectToSerialPort();

	}

	private void readSerialConnectionConfiguration() {

		logger.debug("Reading the serial port configuration file ("
				+ pathtoConfigFile + ")...");
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(SerialPortConfiguration.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Unmarshaller um = null;
		try {
			um = context.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			serialPortConfiguration = (SerialPortConfiguration) um
					.unmarshal(new FileReader(pathtoConfigFile));
		} catch (FileNotFoundException e) {

			logger.error("The file " + pathtoConfigFile + " was not found", e);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("Reading the serial port configuration file ("
				+ pathtoConfigFile + ")...DONE");

	}

	private void connectToSerialPort() {

		logger.debug("Connecting to the serial port:...");

		try {
			commPortIdentifier = CommPortIdentifier
					.getPortIdentifier(serialPortConfiguration.getPortName());
		} catch (NoSuchPortException e) {
			logger.error("The port " + serialPortConfiguration.getPortName()
					+ " does not exist. Check the file " + pathtoConfigFile
					+ ".", e);

		}

		try {
			serialPort = (SerialPort) commPortIdentifier.open(this.getClass()
					.getName(), 2000);
		} catch (PortInUseException e) {
			logger.error("Unable to connect to the port "
					+ serialPortConfiguration.getPortName()
					+ " beacuse it is used by another aplication", e);
		}

		int stopBits;
		switch (serialPortConfiguration.getStopBits()) {
		case 1:
			stopBits = SerialPort.STOPBITS_1;
			break;

		case 2:
			stopBits = SerialPort.STOPBITS_2;
			break;

		case 15:
			stopBits = SerialPort.STOPBITS_1_5;
			break;

		default:
			logger.info("Unable to use stopBits configuration from file "
					+ pathtoConfigFile
					+ ". Default value was used (stop bits = 1).");
			stopBits = SerialPort.STOPBITS_1;
		}

		int dataBits;
		switch (serialPortConfiguration.getDataBits()) {
		case 5:
			dataBits = SerialPort.DATABITS_5;
			break;

		case 6:
			dataBits = SerialPort.DATABITS_6;
			break;

		case 7:
			dataBits = SerialPort.DATABITS_7;
			break;

		case 8:
			dataBits = SerialPort.DATABITS_8;
			break;

		default:
			logger.info("Unable to use databits configuration from file "
					+ pathtoConfigFile
					+ ". Default value was used (data bits = 8).");
			dataBits = SerialPort.DATABITS_8;

		}

		try {
			serialPort.setSerialPortParams(
					serialPortConfiguration.getBaudRate(), dataBits, stopBits,
					SerialPort.PARITY_NONE);
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		}

		try {
			out = serialPort.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			in = serialPort.getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			serialPort.addEventListener(this);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
		serialPort.notifyOnDataAvailable(true);

		logger.debug("Connecting to the serial port:...DONE");
		logger.info("Successfuly connected to the serial port ("
				+ serialPortConfiguration + ")");

	}

	public void closeSerialPort() {
		serialPort.close();

	}

	private int index;
	private boolean messageStarted = false;
	private byte[] buffer = new byte[1024];

	@Override
	public synchronized void serialEvent(SerialPortEvent arg0) {

		byte[] b = new byte[1];

		try {
			in.read(b, 0, 1);
			registerNewByte(b[0]);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void registerNewByte(byte b) {
		if (b == ((byte) '*')) {
			index = 1;
			buffer[0] = b;
			messageStarted = true;
		} else {
			if (messageStarted) {
				buffer[index++] = b;

				if (b == ((byte) '#')) {
					messageStarted = false;
					SerialMessage msg = new SerialMessage(buffer, index);
					setChanged();
					notifyObservers(msg);

				}

			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		SharedResourcesActuatorsMessage partajateResourcesActuatorsMessage = (SharedResourcesActuatorsMessage) arg;
		byte[] message = partajateResourcesActuatorsMessage.encode();
		
		try {
			out.write(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
