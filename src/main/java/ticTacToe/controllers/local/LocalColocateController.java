package ticTacToe.controllers.local;

import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.Error;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

abstract class LocalColocateController extends LocalOperationController {

	private LocalCoordinateController coordinateController;

	protected LocalColocateController(Game game, 
			LocalCoordinateController coordinateController) {
		super(game);
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}
	
	protected Error validateTarget(Coordinate target) {
		assert target != null;
		if (!this.empty(target)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

	public CoordinateController getCoordinateController(){
		return coordinateController;
	}

}
