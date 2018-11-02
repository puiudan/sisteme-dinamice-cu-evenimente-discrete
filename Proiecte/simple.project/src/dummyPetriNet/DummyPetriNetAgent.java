package dummyPetriNet;


import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;
import ro.tarnauca.mdplus.petrinetexec.core.Place;
import ro.tarnauca.mdplus.petrinetexec.core.PlaceActionCallback;
import ro.tarnauca.mdplus.petrinetexec.core.Transition;
import ro.tarnauca.mdplus.petrinetexec.core.TransitionActionCallback;


public class DummyPetriNetAgent {	

	DummyContext context;
	public PetriNet myPetriNet = new PetriNet("Agent_Petri_Net", PetriNet.Capacity.FINITE);
	public PetriNetEventGenerator eventGeneratorA = new PetriNetEventGenerator();
	
	// declara pozitii si tranzitii

	public DummyPetriNetAgent(DummyContext context){

		this.context = context;
		
		// adauga pozitiile si tranzitiile retelei petri
		try {
			
		// "traseaza" arcele	
		} catch (Exception e) {
			e.printStackTrace();
		}	

		// declara si atribuie callback-uri

	}	
	
		public void step(){
			eventGeneratorA.addObserver(myPetriNet.getEventObserver());
			
			//executa tranzitii
		}
}
