package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.Coordinate;

public abstract class CoordinateController extends Controller {

	protected CoordinateController(Game game) {
		super(game);
	}

	public abstract Coordinate getOrigin();
	
	public abstract Coordinate getTarget(String targetTitle);


}
