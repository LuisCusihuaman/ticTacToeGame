package ticTacToe.views;

import ticTacToe.controllers.Error;
import ticTacToe.models.Coordinate;
import ticTacToe.utils.IO;
import ticTacToe.utils.LimitedIntDialog;
import ticTacToe.utils.YesNoDialog;
import ticTacToe.controllers.ContinueController;
import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.MoveController;
import ticTacToe.controllers.OperationController;
import ticTacToe.controllers.OperationControllerVisitor;
import ticTacToe.controllers.PutController;
import ticTacToe.controllers.RandomCoordinateController;
import ticTacToe.controllers.StartController;
import ticTacToe.controllers.UserCoordinateController;

public class TicTacToeView implements OperationControllerVisitor {

	private IO io = new IO();

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		int users = new LimitedIntDialog("Cuántos usuarios?", 0, 2).read();
		startController.start(users);
		new BoardView(startController).write();
	}
	
	@Override
	public void visit(PutController putController) {
		ColorView colorView = new ColorView(putController.take());
		colorView.writeln("Pone el jugador ");
		Coordinate                  target;
		ticTacToe.controllers.Error error = null;
		do {
			target = this.getTarget("En",
					putController.getCoordinateController());
			error = putController.validateTarget(target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		putController.put(target);
		new BoardView(putController).write();
		if (putController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	@Override
	public void visit(MoveController moveController) {
		ColorView colorView = new ColorView(moveController.take());
		colorView.writeln("Mueve el jugador ");
		Coordinate origin;
		Error      error = null;
		do {
			origin = this.getOrigin(moveController.getCoordinateController());
			error = moveController.validateOrigin(origin);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		moveController.remove(origin);
		Coordinate target;
		error = null;
		do {
			target = this.getTarget("A",
					moveController.getCoordinateController(), origin);
			error = moveController.validateTarget(origin, target);
			if (error != null) {
				io.writeln("" + error);
			}
		} while (error != null);
		moveController.put(target);
		new BoardView(moveController).write();
		if (moveController.existTicTacToe()) {
			colorView.writeWinner();
		}
	}

	@Override
	public void visit(ContinueController continueController) {
		continueController.resume(new YesNoDialog("Desea continuar")
				.read());
	}
	
	private Coordinate getTarget(String title,
			CoordinateController coordinateController) {
		assert title != null;
		assert coordinateController != null;
		if (coordinateController instanceof UserCoordinateController) {
			return this.getTarget(title,
					(UserCoordinateController) coordinateController);
		} else if (coordinateController instanceof RandomCoordinateController) {
			return this.getTarget(title,
					(RandomCoordinateController) coordinateController);
		}
		return null;
	}

	private Coordinate getTarget(String title,
			UserCoordinateController coordinateController) {
		assert title != null;
		assert coordinateController != null;
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView(title, coordinate).read();
		return coordinate;
	}

	private Coordinate getTarget(String title,
			RandomCoordinateController coordinateController) {
		assert title != null;
		assert coordinateController != null;
		Coordinate coordinate = coordinateController.getTarget();
		new CoordinateView("La máquina pone en ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}
	
	private Coordinate getOrigin(CoordinateController coordinateController) {
		assert coordinateController != null;
		if (coordinateController instanceof UserCoordinateController) {
			return this
					.getOrigin((UserCoordinateController) coordinateController);
		} else if (coordinateController instanceof RandomCoordinateController) {
			return this
					.getOrigin((RandomCoordinateController) coordinateController);
		}
		return null;
	}

	private Coordinate getOrigin(UserCoordinateController coordinateController) {
		assert coordinateController != null;
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("De", coordinate).read();
		return coordinate;
	}

	private Coordinate getOrigin(RandomCoordinateController coordinateController) {
		assert coordinateController != null;
		Coordinate coordinate = coordinateController.getOrigin();
		new CoordinateView("La máquina quita de ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

	private Coordinate getTarget(String title,
			CoordinateController coordinateController, Coordinate origin) {
		assert title != null;
		assert origin != null;
		assert coordinateController != null;
		if (coordinateController instanceof UserCoordinateController) {
			return this.getTarget(title,
					(UserCoordinateController) coordinateController);
		} else if (coordinateController instanceof RandomCoordinateController) {
			return this.getTarget(title,
					(RandomCoordinateController) coordinateController, origin);
		}
		return null;
	}

	private Coordinate getTarget(String title,
			RandomCoordinateController coordinateController, Coordinate origin) {
		assert title != null;
		assert origin != null;
		assert coordinateController != null;
		Coordinate coordinate = coordinateController.getTarget(origin);
		new CoordinateView("La máquina pone en ", coordinate).write();
		io.readString(". Pulse enter para continuar");
		return coordinate;
	}

}
