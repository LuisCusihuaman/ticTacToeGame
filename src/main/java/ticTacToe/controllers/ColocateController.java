package ticTacToe.controllers;

import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;
import ticTacToe.models.State;
import ticTacToe.utils.IO;

public abstract class ColocateController extends OperationController {

	private String actionTitle;
	
	private CoordinateController coordinateController;
	
	private Coordinate target;

	protected ColocateController(Game game, String actionTitle,
	                             CoordinateController coordinateController) {
		super(game);
		assert actionTitle != null;
		assert coordinateController != null;
		this.actionTitle = actionTitle;
		this.coordinateController = coordinateController;
	}

	public void control() {
		assert this.getState() == State.IN_GAME;
		IO io = new IO();
		io.writeln(actionTitle + " el jugador " + this.take());
		this.colocate();
		this.write();
		if (this.existTicTacToe()) {
			io.writeln("Victoria!!!! " + this.take() + "! " + this.take()
					+ "! " + this.take() + "! Victoria!!!!");
			this.setState(State.FINAL);
		} else {
			this.change();
		}
	}

	protected abstract void colocate();
	
	protected void put(String targetTitle) {
		Error error;
		do {
			target = this.getCoordinateController().getTarget(targetTitle);
			error = this.validateTarget();
			if (error != null){
				new IO().writeln(""+error);
			}
		} while (error != null);	
		this.put(target);
	}

	protected Error validateTarget(){
		if (!this.empty(target)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

	protected CoordinateController getCoordinateController(){
		return coordinateController;
	}
	
	protected Coordinate getTarget(){
		return target;
	}

}
