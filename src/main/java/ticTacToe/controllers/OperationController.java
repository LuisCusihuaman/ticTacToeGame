package ticTacToe.controllers;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;

public interface OperationController {

	void accept(OperationControllerVisitor operationControllerVisitor);
	
	Color getColor(Coordinate coordinate);
}

