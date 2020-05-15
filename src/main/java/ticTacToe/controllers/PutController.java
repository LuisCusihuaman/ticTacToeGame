package ticTacToe.controllers;

import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class PutController extends ColocateController {

	PutController(Game game, CoordinateController coordinateController) {
		super(game, coordinateController);
	}

	@Override
	public void put(Coordinate target) {
		assert this.validateTarget(target) == null;
		super.put(target);
	}
	
	public Error validateTarget(Coordinate target) {
		return super.validateTarget(target);
	}
}