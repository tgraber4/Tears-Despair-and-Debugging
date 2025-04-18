package hw4.maze.classes;

import java.util.ArrayList;

public class Row {
	ArrayList<Cell> cells;

	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	
	
	@Override
	public String toString() {
		String temp = "Row [cells=[";
		int size = this.cells.size();
		int counter = 0;
		for (Cell item : this.cells) {
			temp+= item.toString();
			counter++;
			if (counter < size) {
				temp += ", ";
			}
		}
		temp += "]]";
		return temp;
	}
	
	
}
