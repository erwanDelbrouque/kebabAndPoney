package model.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observer;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

public abstract class Scheduler extends Action implements IScheduler {
	
	protected List<Action> actions;
	
	public Scheduler() {
		this("Scheduler");
	}
	
	public Scheduler(String name) {
		super(name);
		this.actions = new ArrayList<Action>();
	}
	
	public Scheduler(Action ... actions) throws ActionFinishedException, ActionInProgressException {
		this();
		addActions(actions);
	}

	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#addAction(model.actions.Action)
	 */
	@Override
	public void addAction(Action action) throws ActionFinishedException, ActionInProgressException, IllegalArgumentException {
		if(this.isFinished()) {
			throw new ActionFinishedException("This scheduler has finished to do all his actions");
		}
		
		if(this.isInProgress()) {
			throw new ActionInProgressException("You can't add actions in progress");
		}
		
		if(action == null) {
			throw new NullPointerException("You must add a non null action");
		}
		
		if(this.actions.contains(action)) {
			throw new IllegalArgumentException("This action already exists in " + name);
		}
		
		this.actions.add(action);
		
	}
	
	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#doStep()
	 */
	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		
		if(this.actions.isEmpty()) {
			throw new NoSuchElementException("There are no actions in this scheduler, add some");
		}
		
		IAction action = getNextAction();
		this.notify(action.getMessageBeforeAction());
		action.doStep();
		this.notify(action.getMessageAfterAction());
		
		checkState(action);
	}
	
	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#getNextAction()
	 */
	@Override
	public abstract IAction getNextAction();

	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#getActions()
	 */
	@Override
	public List<Action> getActions() {
		return this.actions;
	}
	
	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#checkState(model.actions.IAction)
	 */
	@Override
	public void checkState(IAction lastAction) {
		if(this.actions.isEmpty()) {
			this.actionState = ACTION_STATE.FINISHED;
		}
	}

	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#addActions(model.actions.Action)
	 */
	@Override
	public void addActions(Action... actions) throws ActionFinishedException, ActionInProgressException {
		for(Action action : actions) {
			addAction(action);
		}
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		for(Action action : actions) {
			action.addObserver(o);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#getMessageBeforeAction()
	 */
	@Override
	public String getMessageBeforeAction() {
		return "";
	}
	
	/* (non-Javadoc)
	 * @see model.scheduler.IScheduler#getMessageAfterAction()
	 */
	@Override
	public String getMessageAfterAction() {
		return "";
	}
	
	
}
