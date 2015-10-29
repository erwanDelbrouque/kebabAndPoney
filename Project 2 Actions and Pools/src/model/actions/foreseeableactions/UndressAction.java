package model.actions.foreseeableactions;

/**
 * <b>This action represents a undressing Swimmer
 * 
 * @see ForeseeableAction
 * @see Swimmer
 */
public class UndressAction extends ForeseeableAction {

	/**
	 * Constructor with the number of steps to do before being undressed 
	 * @param nbStepsMax The number of steps to do to be undressed
	 * @throws IllegalArgumentException When the number of max steps <= 0
	 */
	public UndressAction(int nbStepsMax) throws IllegalArgumentException {
		super("Undress action", nbStepsMax);
	}

	@Override
	public String getMessageAfterAction() {
		return "undressing " + super.getMessageAfterAction();
	}
}
