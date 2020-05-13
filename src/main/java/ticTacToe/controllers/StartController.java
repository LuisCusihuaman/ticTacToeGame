package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.State;

public class StartController extends Controller {

	protected StartController(Game game){
		super(game);
	}
	
	public void control() {
		assert this.getState() == State.INITIAL;
		this.getBoard().write();
		this.setState(State.IN_GAME);
	}

}
