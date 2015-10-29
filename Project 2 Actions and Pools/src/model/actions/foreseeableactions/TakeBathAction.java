package model.actions.foreseeableactions;

/**
 * <b>This action represents a bathing Swimmer
 * 
 * @see ForeseeableAction
 * @see Swimmer
 */
public class TakeBathAction extends ForeseeableAction {

	/**
	 * Constructor with the number of steps to do before being undressed 
	 * @param nbStepsMax The number of steps to do to finish the bathe
	 * @throws IllegalArgumentException When the number of max steps <= 0
	 */
	public TakeBathAction(int nbStepsMax) throws IllegalArgumentException {
		super("Take bathe action", nbStepsMax);
	}
	
	@Override
	public String getMessageAfterAction() {
		return "taking bathe " + super.getMessageAfterAction();
	}

}
