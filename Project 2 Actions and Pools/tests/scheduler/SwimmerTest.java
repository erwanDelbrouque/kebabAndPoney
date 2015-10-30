package scheduler;

import org.junit.Test;

import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.pools.BasketPool;
import model.ressources.pools.CubiclePool;
import model.scheduler.Swimmer;

public class SwimmerTest extends SequentialSchedulerTest {
	
	@Test
	public void negatifTimeToUndressTest() throws ActionFinishedException, ActionInProgressException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		Swimmer mockedSwimmer = new Swimmer("test",baskets, cubicles, -1, 6, 5);
	}
	
	@Test
	public void negatifTimeTodressTest() throws ActionFinishedException, ActionInProgressException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		Swimmer mockedSwimmer = new Swimmer("test",baskets, cubicles, 4, 6, -1);
	}
	
	@Test
	public void negatifTimeToBatheTest() throws ActionFinishedException, ActionInProgressException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		Swimmer mockedSwimmer = new Swimmer("test",baskets, cubicles, 4, -1, 5);
	}
}
