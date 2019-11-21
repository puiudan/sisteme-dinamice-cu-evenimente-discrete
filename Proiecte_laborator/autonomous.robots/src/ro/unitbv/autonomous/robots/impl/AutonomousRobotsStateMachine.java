package ro.unitbv.autonomous.robots.impl;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.Place;
import ro.tarnauca.mdplus.petrinetexec.core.PlaceActionCallback;
import ro.tarnauca.mdplus.petrinetexec.core.Transition.TransitionType;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsActuators;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsEventsTypes;
import ro.unitbv.autonomous.robots.AutonomousRobotsController.AutonomousRobotsIndicators;
import ro.unitbv.autonomous.robots.AutonomousRobotsPN;

public class AutonomousRobotsStateMachine extends AutonomousRobotsPN {

	final String p1 = "G";
	final String p2 = "C1";
	final String t1 = "B1";
	final String t2 = "B2";

	@Override
	public void newEventReceived(AutonomousRobotsEventsTypes event) {
		
		switch (event) {
		case EV_B1:
			petriNetEventGenerator.pushEvent(t1, 0L);
			getPetriNet().executeActivePlaces();

			break;
		case EV_B2:
			petriNetEventGenerator.pushEvent(t2, 0L);
			getPetriNet().executeActivePlaces();

			break;
		}		

	}

	@Override
	public PetriNet generatePN() {

		PetriNet petriNet = new PetriNet("Agent_Petri_Net",
				PetriNet.Capacity.INFINITE);
		
		petriNet.addPlace(p1, "G", 1);
		petriNet.addPlace(p2, "C1", 0);

		petriNet.addTransition(t1, "B1", TransitionType.NORMAL);
		petriNet.addTransition(t2, "B2", TransitionType.NORMAL);

		try {
			petriNet.retrieveTransition(t1).connectToOutputPlace(
					petriNet.retrievePlace(p1), "", "", 1);
			petriNet.retrieveTransition(t2).connectToOutputPlace(
					petriNet.retrievePlace(p2), "", "", 1);

			petriNet.retrievePlace(p1).connectToOutputTransition(
					petriNet.retrieveTransition(t2), "", "", 1);
			petriNet.retrievePlace(p2).connectToOutputTransition(
					petriNet.retrieveTransition(t1), "", "", 1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		petriNet.retrievePlace(p1).createPlaceMarkingChangeCallback(
				new PlaceActionCallback() {

					@Override
					protected void callback(PetriNet arg0, Place arg1) {
						System.out.println("The marking of the place p1 is " +arg1.getMarking());
						turnONActuator(p1, AutonomousRobotsActuators.Y5_GREEN);
						turnONActuator(p1, AutonomousRobotsActuators.Y5_RED);
						changeIndicatorState(p1, AutonomousRobotsIndicators.GARAJ,
								3);
					}
				});

		petriNet.retrievePlace(p2).createPlaceMarkingChangeCallback(
				new PlaceActionCallback() {

					@Override
					protected void callback(PetriNet arg0, Place arg1) {
						System.out.println("The marking of the place p2 is " +arg1.getMarking());
						turnOFFActuator(p2, AutonomousRobotsActuators.Y5_GREEN);
						turnOFFActuator(p2, AutonomousRobotsActuators.Y5_RED);
						changeIndicatorState(p2, AutonomousRobotsIndicators.GARAJ,
								6);
					}
				});

		return petriNet;
	}

}
