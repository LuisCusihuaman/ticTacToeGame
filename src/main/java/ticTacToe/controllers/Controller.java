package ticTacToe.controllers;

import ticTacToe.models.Board;
import ticTacToe.models.Game;
import ticTacToe.models.State;
import ticTacToe.models.Turn;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	protected Board getBoard() {
		return game.getBoard();
	}
	
	protected Turn getTurn() {
		return game.getTurn();
	}
	
	protected Game getGame(){
		return game;
	}
}
