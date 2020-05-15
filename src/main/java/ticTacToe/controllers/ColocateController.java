package ticTacToe.controllers;

import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

abstract class ColocateController extends OperationController {

	private CoordinateController coordinateController;

	protected ColocateController(Game game,
	                             CoordinateController coordinateController) {
		super(game);
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}
	
	protected java.lang.Error validateTarget(Coordinate target) {
		if (!this.empty(target)) {
			return java.lang.Error.NOT_EMPTY;
		}
		return null;
	}

	public CoordinateController getCoordinateController(){
		return coordinateController;
	}

}
