/**
 * 
 */
package ro.unitbv.autonomous.robots;

import ro.unitbv.serialcomm.SerialController;

/**
 * @author dan.puiu
 * 
 */

public class AutonomousRobotsModule {

	private SerialController serialController = new SerialController();

	private AutonomousRobotsController partajatedResourcesController = new AutonomousRobotsController();
	
	private AutonomousRobotsPN partajatedResourcesPN;

	public AutonomousRobotsModule(AutonomousRobotsPN partajatedResourcesPN) {
		this.partajatedResourcesPN = partajatedResourcesPN;
		initialisePartajatedResourcesModule();
	}

	private void initialisePartajatedResourcesModule() {
		serialController.addObserver(partajatedResourcesController);
		partajatedResourcesController.addObserver(partajatedResourcesPN);
		partajatedResourcesPN.addObserver(serialController);

	}

	public void close() {
		serialController.closeSerialPort();
	}

}
