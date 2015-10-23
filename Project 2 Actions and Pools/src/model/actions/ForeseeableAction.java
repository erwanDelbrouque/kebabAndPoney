package model.actions;


public class ForeseeableAction extends Action {

	protected int nbStepsMax;
	protected int nbCurrentStep;

	public ForeseeableAction(int nbStepsMax) {
		this("Foreseeable Action", nbStepsMax);

	}
	
	public ForeseeableAction(String name, int nbStepsMax) {
		super(name);
		this.nbStepsMax = nbStepsMax;

	}

	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		
		nbCurrentStep++;
		
		if(nbCurrentStep >= nbStepsMax) {
			this.actionState = ACTION_STATE.FINISHED;
		}
		
		notify(getMessageAfterAction());

	}

	@Override
	public String getMessageAfterAction() {
		return "("+nbCurrentStep+"/"+nbStepsMax+")";
	}

}
