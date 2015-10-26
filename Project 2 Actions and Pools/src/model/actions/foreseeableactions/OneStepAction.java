package model.actions.foreseeableactions;

public class OneStepAction extends ForeseeableAction {
	
	public OneStepAction() {
		this("One Step Action");
	}
	
	public OneStepAction(String name) {
		super(name, 1);
	}

}
