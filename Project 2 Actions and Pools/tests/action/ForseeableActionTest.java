package action;

import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.foreseeableactions.OneStepAction;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

public class ForseeableActionTest extends ActionTest {

	@Override
	protected IAction createAction() {
		return new OneStepAction();
	}

	@Override
	protected IAction createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	
	@Test
	public void foreseeableTest() throws ActionFinishedException {
		IAction fa = createAction(2);
		
		isReadyTest(fa);
		fa.doStep();
		isInProgressTest(fa);
		fa.doStep();
		isFinishedTest(fa);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidNbStepsArgumentTest() {
		IAction a = createAction(-1);
	}
	

	


}