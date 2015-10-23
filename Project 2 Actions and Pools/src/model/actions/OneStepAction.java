package model.actions;

public class OneStepAction extends ForeseeableAction {
	
	public OneStepAction() {
		this("");
	}
	
	public OneStepAction(String name) {
		super(name, 1);
	}

}
