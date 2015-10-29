package model.actions.foreseeableactions;

/**
 * <b>This action represents a dressing Swimmer
 * 
 * @see ForeseeableAction
 * @see Swimmer
 */
public class DressAction extends ForeseeableAction {

	/**
	 * Constructor with the number of steps to do before being dressed 
	 * @param nbStepsMax The number of steps to do to be dressed
	 * @throws IllegalArgumentException When the number of max steps <= 0
	 */
	public DressAction(int nbStepsMax) throws IllegalArgumentException {
		super("Dressing Action", nbStepsMax);
	}
	
	@Override
	public String getMessageAfterAction() {
		return "dressing "+super.getMessageAfterAction();
	}

}
