/**
 * 
 */
package ro.unitbv.manufacturing.system;

import ro.unitbv.serialcomm.SerialController;

/**
 * @author Gligoras.Stefan
 * 
 */

public class ManufacturingSystemModule {

	private SerialController serialController = new SerialController();

	private ManufacturingSystemController manufacturingSystemController = new ManufacturingSystemController();
	
	private ManufacturingSystemPN manufacturingSystemPN;

	public ManufacturingSystemModule(ManufacturingSystemPN manufSystemPN) {
		this.manufacturingSystemPN = manufSystemPN;
		initialiseManufSystemModule();
	}

	private void initialiseManufSystemModule() {
		serialController.addObserver(manufacturingSystemController);
		manufacturingSystemController.addObserver(manufacturingSystemPN);
		manufacturingSystemPN.addObserver(serialController);
		manufacturingSystemPN.initialise();

	}

	public void close() {
		serialController.closeSerialPort();
	}

}
