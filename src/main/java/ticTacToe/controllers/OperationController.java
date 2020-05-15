package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.views.TicTacToeView;

public abstract class OperationController extends Controller {

	protected OperationController(Game game) {
		super(game);
	}
	
	public abstract void accept(TicTacToeView ticTacToeView);
	

}
