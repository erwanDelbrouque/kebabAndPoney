package scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.foreseeableactions.DressAction;
import model.actions.foreseeableactions.TakeBathAction;
import model.actions.foreseeableactions.UndressAction;
import model.actions.resourcepoolactions.freeactions.FreeBasketAction;
import model.actions.resourcepoolactions.freeactions.FreeCubicleAction;
import model.actions.resourcepoolactions.takeactions.FindCubicleAction;
import model.actions.resourcepoolactions.takeactions.TakeBasketAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.pools.BasketPool;
import model.ressources.pools.CubiclePool;
import model.scheduler.Swimmer;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SwimmerTest extends SequentialSchedulerTest {
	protected BasketPool baskets;
	protected CubiclePool cubicles;
	
	protected Swimmer createSwimmer(String name, BasketPool baskets, CubiclePool cubicles, int timeToUndress, int timeToBathe, int timeToDress) throws IllegalArgumentException, NullPointerException, ActionFinishedException, ActionInProgressException {
		return new Swimmer(name, baskets, cubicles, timeToUndress, timeToBathe, timeToDress);
	}
	
	@Before
	public void setUp() {
		baskets = new BasketPool(6);
		cubicles = new CubiclePool(3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeToUndressTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		createSwimmer("test", baskets, cubicles, -1, 6, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeTodressTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		createSwimmer("test", baskets, cubicles, 4, 6, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeToBatheTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		createSwimmer("test", baskets, cubicles, 4, -1, 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void BasketPoolNullTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException, NullPointerException{
		createSwimmer("test", null, cubicles, 4, 1, 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void cubiclePoolNullTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException, NullPointerException{
		createSwimmer("test", baskets, null, 4, 1, 5);
	}
	
	@Test
	public void createSwimmerTest() throws IllegalArgumentException, NullPointerException, ActionFinishedException, ActionInProgressException{
		createSwimmer("test", baskets, cubicles, 4, 1, 5);
	}
	
	@Test
	public void swimmerTest() throws IllegalArgumentException, NullPointerException, ActionFinishedException, ActionInProgressException {
		Swimmer s = createSwimmer("Swimmer", baskets, cubicles, 1, 1, 1);
		List<Action> actions = s.getActions();
		
		assertTrue(actions.get(0) instanceof TakeBasketAction);
		assertTrue(actions.get(1) instanceof FindCubicleAction);
		assertTrue(actions.get(2) instanceof UndressAction);
		assertTrue(actions.get(3) instanceof FreeCubicleAction);
		assertTrue(actions.get(4) instanceof TakeBathAction);
		assertTrue(actions.get(5) instanceof FindCubicleAction);
		assertTrue(actions.get(6) instanceof DressAction);
		assertTrue(actions.get(7) instanceof FreeCubicleAction);
		assertTrue(actions.get(8) instanceof FreeBasketAction);
		
	}
}
