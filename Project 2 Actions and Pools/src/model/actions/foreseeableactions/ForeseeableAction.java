package model.actions.foreseeableactions;

import model.actions.Action;
import model.exceptions.ActionFinishedException;

/**
 * <b>This action has a number of steps to do before being finished</b>
 * 
 * @see IAction
 * @see Action
 */
public class ForeseeableAction extends Action {

	/**
	 * Max number of steps to do
	 */
	protected int nbStepsMax;
	
	/**
	 * Number of done steps 
	 */
	protected int nbCurrentStep;

	/**
	 * Constructor with the number of steps to do before being finished 
	 * @param nbStepsMax The number of steps to do to finish this action
	 * @throws IllegalArgumentException When the number of max steps <= 0
	 */
	public ForeseeableAction(int nbStepsMax) throws IllegalArgumentException {
		this("Foreseeable Action", nbStepsMax);

	}
	
	/**
	 * Constructor with the name and the number of steps to do before being finished 
	 * @param name The name of this action
	 * @param nbStepsMax The number of steps to do to finish this action
	 * @throws IllegalArgumentException When the number of max steps <= 0
	 */
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
		
		checkState();
		
	}
	
	@Override
	public void checkState() {
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
