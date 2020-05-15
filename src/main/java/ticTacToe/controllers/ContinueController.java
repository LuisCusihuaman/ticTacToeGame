package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.State;
import ticTacToe.views.TicTacToeView;

public class ContinueController extends OperationController {

	ContinueController(Game game) {
		super(game);
	}
	
	public void setContinue(boolean another){
		assert this.getState() == State.FINAL;
		if (another) {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

	@Override
	public void accept(TicTacToeView ticTacToeView) {
		ticTacToeView.visit(this);		
	}

}
