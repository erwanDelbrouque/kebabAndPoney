package model.actions;

public class UndressAction extends ForeseeableAction {

	public UndressAction(int nbStepsMax) {
		super(nbStepsMax);
	}

	@Override
	public String getMessageAfterAction() {
		return "undressing "+super.getMessageAfterAction();
	}
}
