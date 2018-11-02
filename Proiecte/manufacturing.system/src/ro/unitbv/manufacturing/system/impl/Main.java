package ro.unitbv.manufacturing.system.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.manufacturing.system.ManufacturingSystemModule;
//import ro.unitbv.manufacturing.system.test.ManufacturingSystemTest;

//import ro.unitbv.manufacturing.system.impl.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger logger = LoggerFactory.getLogger("Main.class");

		ManufacturingSystemStateMachine manufacturingSystemStateMachine = new ManufacturingSystemStateMachine();
		ManufacturingSystemModule manufacturingSystemModule = new ManufacturingSystemModule(
				manufacturingSystemStateMachine);

		System.out.println("Press <ENTER> to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		manufacturingSystemModule.close();

		logger.info("Process finished");

	}

}
