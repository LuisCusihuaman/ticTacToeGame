package ticTacToe.controllers;

import ticTacToe.models.Game;
import ticTacToe.models.State;
import ticTacToe.utils.ClosedInterval;

public class StartController extends OperationController {

	private ColocateControllerBuilder colocateControllerBuilder;

	StartController(Game game, ColocateControllerBuilder colocateControllerBuilder) {
		super(game);
		assert colocateControllerBuilder != null;
		this.colocateControllerBuilder = colocateControllerBuilder;
	}
	
	public void setUsers(int users){
		assert new ClosedInterval(0, this.numPlayers()).includes(users);
		assert this.getState() == State.INITIAL;
		colocateControllerBuilder.build(users);
		this.setState(State.IN_GAME);
	}

}
