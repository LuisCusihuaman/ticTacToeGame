package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.State;
import ticTacToe.utils.IO;

public class ContinueController extends OperationController {

	public ContinueController(Game game) {
		super(game);
	}

	@Override
	public void control() {
		assert this.getState() == State.FINAL;
		IO   io = new IO();
		char answer;
		do {
			answer = io.readChar("Desea continuar? (s/n): ");
		} while (answer != 's' && answer != 'S' && answer != 'n'
				&& answer != 'N');
		if (answer == 's') {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

}
