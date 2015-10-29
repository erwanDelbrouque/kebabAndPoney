package model.actions.foreseeableactions;

/**
 * <b>This action is a foreseeable action with one step to do before beeing finished</b>
 */
public class OneStepAction extends ForeseeableAction {
	
	/**
	 * Default constructor with default name ("One Step Action") and a default number of steps (1)
	 */
	public OneStepAction() {
		this("One Step Action");
	}
	
	/**
	 * Constructor with the name and a default number of steps (1)
	 * @param name The name of this action
	 */
	public OneStepAction(String name) {
		super(name, 1);
	}

}
