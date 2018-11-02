/**
 * 
 */
package ro.unitbv.shared.resources;

import ro.unitbv.serialcomm.SerialController;

/**
 * @author dan.puiu
 * 
 */

public class SharedResourcesModule {

	private SerialController serialController = new SerialController();

	private SharedResourcesController sharedResourcesController = new SharedResourcesController();
	
	private SharedResourcesPN sharedResourcesPN;

	public SharedResourcesModule(SharedResourcesPN partajatedResourcesPN) {
		this.sharedResourcesPN = partajatedResourcesPN;
		initialisePartajatedResourcesModule();
	}

	private void initialisePartajatedResourcesModule() {
		serialController.addObserver(sharedResourcesController);
		sharedResourcesController.addObserver(sharedResourcesPN);
		sharedResourcesPN.addObserver(serialController);

	}

	public void close() {
		serialController.closeSerialPort();
	}

}
