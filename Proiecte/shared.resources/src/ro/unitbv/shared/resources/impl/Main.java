package ro.unitbv.shared.resources.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.shared.resources.SharedResourcesModule;

public class Main {

	public static void main(String[] args) {
				
		Logger logger = LoggerFactory.getLogger("Main.class");

		
		SharedResourcesStateMachine sharedResourcesStateMachine = new SharedResourcesStateMachine();
		
		SharedResourcesModule sharedResourcesModule = new SharedResourcesModule(
				sharedResourcesStateMachine);

		
		
		System.out.println("Press <ENTER> to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sharedResourcesModule.close();
	
		
		logger.info("Process finished");
		

	}

}
