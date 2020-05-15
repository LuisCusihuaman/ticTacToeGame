package ticTacToe.controllers;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;

public interface ColocateController extends OperationController {
	
	Color take();
	
	void put(Coordinate target);

	boolean existTicTacToe();
		
	CoordinateController getCoordinateController();
	
}
