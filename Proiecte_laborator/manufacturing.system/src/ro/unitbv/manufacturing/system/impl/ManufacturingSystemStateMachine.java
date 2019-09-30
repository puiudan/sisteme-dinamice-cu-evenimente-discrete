package ro.unitbv.manufacturing.system.impl;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.tarnauca.mdplus.petrinetexec.core.Place;
import ro.tarnauca.mdplus.petrinetexec.core.PlaceActionCallback;
import ro.tarnauca.mdplus.petrinetexec.core.Transition.TransitionType;
import ro.tarnauca.mdplus.petrinetexec.exceptions.PetriNetException;
import ro.unitbv.manufacturing.system.ManufacturingSystemController.ManufacturingSystemActuators;
import ro.unitbv.manufacturing.system.ManufacturingSystemController.ManufacturingSystemEventsTypes;
import ro.unitbv.manufacturing.system.ManufacturingSystemPN;

public class ManufacturingSystemStateMachine extends ManufacturingSystemPN {



	@Override
	public void newEventReceived(ManufacturingSystemEventsTypes event) {

		PetriNetEventGenerator gen = getPetriNetEventGenerator();

		switch (event) {
		case EV_S1_ACTIVE:
			gen.pushEvent("T1", (long) 0);
			break;

		case EV_S2_ACTIVE:
			gen.pushEvent("T2", (long) 0);
			break;
		}
	}

	@Override
	public PetriNet generatePN() {
		PetriNet petriNet = new PetriNet("Manufacturing system");

		petriNet.addPlace("P1", "P1", 1);
		petriNet.addPlace("P2", "P2",	0);


		petriNet.addTransition("T1", "T1", TransitionType.NORMAL);
		petriNet.addTransition("T2", "T2", TransitionType.NORMAL);


		try {
			petriNet.retrievePlace("P1").connectToOutputTransition(petriNet.retrieveTransition("T1"), "P1 -> T1", "", 1);
			petriNet.retrievePlace("P2").connectToOutputTransition(petriNet.retrieveTransition("T2"), "P2 -> T2", "", 1);

			petriNet.retrieveTransition("T1").connectToOutputPlace(petriNet.retrievePlace("P2"), "T1 -> P2", "", 1);
			petriNet.retrieveTransition("T2").connectToOutputPlace(petriNet.retrievePlace("P3"), "T2 -> P3", "", 1);

		} catch (PetriNetException e) {
			e.printStackTrace();
		}


		petriNet.retrievePlace("P2").createPlaceMarkingChangeCallback(new PlaceActionCallback() {

			@Override
			protected void callback(PetriNet arg0, Place arg1) {
				//for positions with actuators(led)
				if(arg1.getMarking()==1)
				{
					turnONActuator("P2", ManufacturingSystemActuators.Y6);
				}
				else
				{
					turnOFFActuator("P2", ManufacturingSystemActuators.Y6);
				}
			}
		});
		
			return petriNet;
		}

	}
