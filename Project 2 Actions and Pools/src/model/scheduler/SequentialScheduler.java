package model.scheduler;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;


/**
 * <b>A Sequential Scheduler is a scheduler that execute actions by finishing each of them before going to the next one</b>
 * 
 * @see IScheduler
 * @see Scheduler
 */
public class SequentialScheduler extends Scheduler {

	/**
	 * Default constructor with default name ("Sequential Scheduler")
	 */
	public SequentialScheduler() {
		this("Sequential Scheduler");
	}

	/**
	 * Constructor with a name
	 * @param name The name of this sequential scheduler
	 * @throws NullPointerException When the name is null
	 * @throws IllegalArgumentException When the name is empty
	 */
	public SequentialScheduler(String name) throws NullPointerException, IllegalArgumentException {
		super(name);
	}

	/**
	 * Constructor with actions at the begining 
	 * @param actions The actions of this sequential scheduler
	 * @throws ActionFinishedException When we try to add an action while this sequential scheduler has finished his activity (impossible in this case)
	 * @throws ActionInProgressException When we try to add an action while this sequential scheduler has begun his activity (impossible in this case)
	 */
	public SequentialScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		super(actions);
	}

	@Override
	public void checkState() {
		if(currentAction.isFinished()) {
			this.actions.remove(currentAction);
		}

		super.checkState();

	}

	@Override
	public IAction getNextAction() {
		return this.actions.get(0);
	}

}
