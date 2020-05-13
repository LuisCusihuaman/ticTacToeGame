package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.Coordinate;

public class ManualMoveController extends MoveController {

	public ManualMoveController(Game game) {
		super(game);
	}

	@Override
	protected Coordinate selectOrigin() {
		Coordinate origin = new Coordinate();
		origin.read("De");
		return origin;
	}

	@Override
	protected Coordinate selectTarget(String targetTitle) {
		Coordinate target = new Coordinate();
		target.read(targetTitle);
		return target;
	}

}
