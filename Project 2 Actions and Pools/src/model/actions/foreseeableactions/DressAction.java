package model.actions.foreseeableactions;

public class DressAction extends ForeseeableAction {

	public DressAction(int nbStepsMax) {
		super(nbStepsMax);
	}
	
	@Override
	public String getMessageAfterAction() {
		return "dressing "+super.getMessageAfterAction();
	}

}
