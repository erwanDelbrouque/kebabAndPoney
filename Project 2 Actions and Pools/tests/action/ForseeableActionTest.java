package action;

import model.actions.Action;
import model.actions.ForeseeableAction;
import model.actions.OneStepAction;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

public class ForseeableActionTest extends ActionTest {

	@Override
	protected Action createAction() {
		return new OneStepAction();
	}

	@Override
	protected Action createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	
	@Test
	public void foreseeableTest() throws ActionFinishedException {
		Action fa = createAction(2);
		
		isReadyTest(fa);
		fa.doStep();
		isInProgressTest(fa);
		fa.doStep();
		isFinishedTest(fa);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidNbStepsArgumentTest() {
		Action a = createAction(-1);
	}
	

	


}