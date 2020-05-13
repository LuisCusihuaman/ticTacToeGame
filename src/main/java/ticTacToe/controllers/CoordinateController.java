package ticTacToe.controllers;

import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public abstract class CoordinateController extends Controller {

	protected CoordinateController(Game game) {
		super(game);
	}

	public abstract Coordinate getOrigin();
	
	public abstract Coordinate getTarget(String targetTitle);


}
