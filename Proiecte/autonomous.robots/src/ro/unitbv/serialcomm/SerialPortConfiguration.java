/**
 * 
 */
package ro.unitbv.serialcomm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dan.puiu
 * 
 */
@XmlRootElement
public class SerialPortConfiguration {

	private String portName;
	private int baudRate;
	private int dataBits;
	private int stopBits;
	private String parity;

	/**
	 * 
	 */
	public SerialPortConfiguration() {

	}

	@XmlElement
	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	@XmlElement
	public int getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	@XmlElement
	public int getDataBits() {
		return dataBits;
	}

	public void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	@XmlElement
	public int getStopBits() {
		return stopBits;
	}

	public void setStopBits(int stopBits) {
		this.stopBits = stopBits;
	}

	@XmlElement
	public String getParity() {
		return parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	public String toString() {
		return "serial port configuration: port=" + portName + ", baudRate=" + baudRate + ", dataBits="
				+ dataBits + ", stopBits=" + stopBits + ", parity=" +parity;
	}

}
