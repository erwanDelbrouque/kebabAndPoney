package scheduler;

import org.junit.Test;

import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.pools.BasketPool;
import model.ressources.pools.CubiclePool;
import model.scheduler.Swimmer;

public class SwimmerTest extends SequentialSchedulerTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeToUndressTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		new Swimmer("test",baskets, cubicles, -1, 6, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeTodressTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		new Swimmer("test",baskets, cubicles, 4, 6, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negatifTimeToBatheTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		new Swimmer("test",baskets, cubicles, 4, -1, 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void BasketPoolNullTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		BasketPool baskets = null;
		CubiclePool cubicles = new CubiclePool(3);
		new Swimmer("test",baskets, cubicles, 4, 1, 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void cubiclePoolNullTest() throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		BasketPool baskets = new BasketPool(3);
		CubiclePool cubicles = null;
		new Swimmer("test",baskets, cubicles, 4, 1, 5);
	}
	
	@Test
	public void createSwimmerTest() throws IllegalArgumentException, NullPointerException, ActionFinishedException, ActionInProgressException{
		BasketPool baskets = new BasketPool(3);
		CubiclePool cubicles = new CubiclePool(3);
		new Swimmer("test",baskets, cubicles, 4, 1, 5);
	}
}
