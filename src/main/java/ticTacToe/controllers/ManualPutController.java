package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.Coordinate;

public class ManualPutController extends PutController{

	public ManualPutController(Game game) {
		super(game);
	}

	@Override
	protected Coordinate selectTarget(String targetTitle) {
		Coordinate target = new Coordinate();
		target.read(targetTitle);
		return target;
	}

}
