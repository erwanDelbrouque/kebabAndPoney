package model.actions.foreseeableactions;

public class TakeBathAction extends ForeseeableAction {

	public TakeBathAction(int nbStepsMax) {
		super(nbStepsMax);
	}
	
	@Override
	public String getMessageAfterAction() {
		return "taking bathe "+super.getMessageAfterAction();
	}

}
