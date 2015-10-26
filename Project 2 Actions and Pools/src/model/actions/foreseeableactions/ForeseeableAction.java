package model.actions.foreseeableactions;

import model.actions.Action;
import model.actions.Action.ACTION_STATE;
import model.exceptions.ActionFinishedException;


public class ForeseeableAction extends Action {

	protected int nbStepsMax;
	protected int nbCurrentStep;

	public ForeseeableAction(int nbStepsMax) {
		this("Foreseeable Action", nbStepsMax);

	}
	
	public ForeseeableAction(String name, int nbStepsMax) throws IllegalArgumentException {
		super(name);
		if(nbStepsMax <= 0) {
			throw new IllegalArgumentException("You must specify a number of steps > 0");
		}
		
		this.nbStepsMax = nbStepsMax;

	}

	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		
		nbCurrentStep++;
		
		if(nbCurrentStep >= nbStepsMax) {
			this.actionState = ACTION_STATE.FINISHED;
		}
		
	}
	
	@Override
	public String getMessageBeforeAction() {
		return "";
	}

	@Override
	public String getMessageAfterAction() {
		return "("+nbCurrentStep+"/"+nbStepsMax+")";
	}

}
