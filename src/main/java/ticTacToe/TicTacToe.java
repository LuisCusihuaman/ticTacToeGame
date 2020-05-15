package ticTacToe;

import ticTacToe.controllers.Logic;
import ticTacToe.controllers.OperationController;
import ticTacToe.views.TicTacToeView;

public class TicTacToe {

	private Logic logic;
	
	private TicTacToeView view;
	
	public TicTacToe() {
		logic = new Logic();
		view = new TicTacToeView();
	}
	
	public void play() {
		OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
		
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}
}
