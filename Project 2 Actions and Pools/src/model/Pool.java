package model;

import view.ConsoleView;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.pools.BasketPool;
import model.ressources.pools.CubiclePool;
import model.scheduler.FairScheduler;
import model.scheduler.Swimmer;

/**
 * <b>This class is the main class of this program</b>
 *
 */
public class Pool {
	/**
	 * Main function
	 * @param args Arguments passed to the program
	 * @throws ActionFinishedException When an action is executed after being finished
	 * @throws ActionInProgressException When a scheduler tries to add an action when it already started
	 */
	public static void main(String[] args) throws ActionFinishedException, ActionInProgressException {
		ConsoleView console = new ConsoleView();
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();

		s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("Loïs", baskets, cubicles, 2, 10, 4));
		s.addAction(new Swimmer("Maé", baskets, cubicles, 10, 18, 10));
		s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
		s.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
		s.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
		s.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));

		s.addObserver(console);

		int nbSteps = 0;
		while (!s.isFinished()) {
			nbSteps++;
			try {
				s.doStep();
			} catch(Exception e) {
				console.printlnMessage(e.getMessage());
			}
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}
}