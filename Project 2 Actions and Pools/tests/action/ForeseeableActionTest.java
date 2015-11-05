package action;

import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.foreseeableactions.OneStepAction;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

public class ForeseeableActionTest extends ActionTest {

	/* (non-Javadoc)
	 * @see action.ActionTest#createAction()
	 */
	@Override
	protected IAction createAction() {
		return new OneStepAction();
	}

	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(int)
	 */
	@Override
	protected IAction createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(java.lang.String, int)
	 */
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name, nbStepsMax);
	}
	
	/**
	 * Tests a foreseeable action
	 */
	@Test
	public void foreseeableTest() throws ActionFinishedException {
		IAction fa = createAction(2);
		
		isReadyTest(fa);
		fa.doStep();
		isInProgressTest(fa);
		fa.doStep();
		isFinishedTest(fa);
		
	}
	
	/**
	 * Tests the creation of a foreseeable action with an invalid number of steps
	 */
	@Test(expected=IllegalArgumentException.class)
	public void invalidNbStepsArgumentTest() {
		createAction(-1);
	}

	
	

	


}