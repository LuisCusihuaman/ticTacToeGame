package ticTacToe.controllers.local;

import ticTacToe.controllers.Error;
import ticTacToe.controllers.OperationControllerVisitor;
import ticTacToe.controllers.PutController;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class LocalPutController extends LocalColocateController implements
		PutController {

	LocalPutController(Game game, LocalCoordinateController coordinateController) {
		super(game, coordinateController);
		assert coordinateController != null;
	}

	@Override
	public void put(Coordinate target) {
		assert target != null;
		assert this.validateTarget(target) == null;
		super.put(target);
	}

	public Error validateTarget(Coordinate target) {
		assert target != null;
		return super.validateTarget(target);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		assert operationControllerVisitor != null;
		operationControllerVisitor.visit(this);
	}
}
