package ro.unitbv.shared.resources.impl;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.tarnauca.mdplus.petrinetexec.core.Place;
import ro.tarnauca.mdplus.petrinetexec.core.PlaceActionCallback;
import ro.tarnauca.mdplus.petrinetexec.core.Transition;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesActuators;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesEventsTypes;
import ro.unitbv.shared.resources.SharedResourcesController.SharedResourcesIndicators;
import ro.unitbv.shared.resources.SharedResourcesPN;

public class SharedResourcesStateMachine extends SharedResourcesPN {

	@Override
	public void newEventReceived(SharedResourcesEventsTypes event) {
		PetriNetEventGenerator gen = getPetriNetEventGenerator();

		switch (event) {
		case EV_S1:
			gen.pushEvent("T1", (long) 0);
			break;

		case EV_S3:
			gen.pushEvent("T2", (long) 0);
			break;

		}

	}

	@Override
	public PetriNet generatePN() {

		PetriNet petriNet = new PetriNet("Shared resources");

		petriNet.addPlace("P1", "P1", 5);
		petriNet.addPlace("P2", "P2", 0);

		petriNet.addTransition("T1", "T1", Transition.TransitionType.NORMAL);
		petriNet.addTransition("T2", "T2", Transition.TransitionType.NORMAL);
	

		try {

			petriNet.retrievePlace("P1").connectToOutputTransition(
					petriNet.retrieveTransition("T1"), "P1 -> T1", "", 1);
			petriNet.retrievePlace("P2").connectToOutputTransition(
					petriNet.retrieveTransition("T2"), "P2 -> T2", "", 1);
			
			petriNet.retrieveTransition("T1").connectToOutputPlace(
					petriNet.retrievePlace("P2"), "T1 -> P2", "", 1);
			petriNet.retrieveTransition("T2").connectToOutputPlace(
					petriNet.retrievePlace("P1"), "T2 -> P3", "", 1);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		petriNet.retrievePlace("P1").createPlaceMarkingChangeCallback(
				new PlaceActionCallback() {

					@Override
					protected void callback(PetriNet arg0, Place arg1) {
						//for positions with display indicators
						changeIndicatorState("P1",
								SharedResourcesIndicators.Y3, arg1.getMarking());
					}
				});

		petriNet.retrievePlace("P2").createPlaceMarkingChangeCallback(
				new PlaceActionCallback() {

					@Override
					protected void callback(PetriNet arg0, Place arg1) {
						//for positions with actuators(led)
						if (arg1.getMarking() == 1)
							turnONActuator("P2", SharedResourcesActuators.Y1);
						else
							turnOFFActuator("P2", SharedResourcesActuators.Y1);

					}
				});
		
		return petriNet;
	}

}
