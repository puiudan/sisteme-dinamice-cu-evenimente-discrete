package ro.unitbv.autonomous.robots.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.unitbv.autonomous.robots.AutonomousRobotsModule;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger logger = LoggerFactory.getLogger("Main.class");

		AutonomousRobotsStateMachine autonomousRobotsStateMachine = new AutonomousRobotsStateMachine();

		AutonomousRobotsModule autonomousRobotsModule = new AutonomousRobotsModule(autonomousRobotsStateMachine);
		
		System.out.println("Press <ENTER> to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		autonomousRobotsModule.close();
		
		logger.info("Process finished");
		

	}

}
