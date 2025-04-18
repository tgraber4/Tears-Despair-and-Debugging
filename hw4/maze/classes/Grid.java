package hw4.maze.classes;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
	ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	public Grid() {
		Random rand = new Random();
		this.rows = new ArrayList<Row>();
		int randomInt = rand.nextInt(5) + 3;
		int randomExitInt = rand.nextInt(randomInt);
		for (int i = 0; i < randomInt; i++) {
			ArrayList<Cell> cells = new ArrayList<Cell>();
			for (int j = 0; j < randomInt; j++) {
				if (i == randomExitInt && j == 0) {
					cells.add(new Cell(CellComponents.EXIT, CellComponents.WALL, CellComponents.WALL, CellComponents.WALL));
				} else {
					cells.add(new Cell(CellComponents.WALL, CellComponents.WALL, CellComponents.WALL, CellComponents.WALL));
				}
			}
			Row temp = new Row(cells);
			this.rows.add(temp);
		}
	}
	
	public void printGrid() {
		int rowCounter = 0;
		int rowSize = this.getRows().size();
		for (Row row : this.getRows()) {
			String line1 = "";
			String line2 = "";
			String line3 = "";
			int cellCounter = 0;
			int cellSize = row.getCells().size();
			for (Cell cell : row.getCells()) {
				line1 += "#";
				if (cell.getUp().name() == "WALL") {
					line1 += "#";
				} else {
					line1 += " ";
				}
				
				if (cell.getLeft().name() == "WALL") {
					line2 += "#";
				} else {
					line2 += " ";
				}
				
				if (cell.getUp().name() == "EXIT" || cell.getDown().name() == "EXIT" || cell.getRight().name() == "EXIT" || cell.getLeft().name() == "EXIT") {
					line2 += "E";
				} else {
					line2 += "A";
				}
				
				// end of row
				if ((cellCounter + 1) == cellSize) {
					line1 += "#";
					if (cell.getRight().name() == "WALL") {
						line2 += "#";
					} else {
						line2 += " ";
					}
				}
				
				// last row in grid
				if ((rowCounter + 1) == rowSize) {
					line3 += "#";
					if (cell.getDown().name() == "WALL") {
						line3 += "#";
					} else {
						line3 += " ";
					}
					if ((cellCounter + 1) == cellSize) {
						line3 += "#";
					}
				}
				cellCounter++;
			}
			System.out.println(line1);
			System.out.println(line2);
			if ((rowCounter + 1) == rowSize) {
				System.out.println(line3);
			}
			rowCounter++;
		}
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		String temp = "Grid [rows=[";
		int size = this.getRows().size();
		int counter = 0;
		for (Row item : this.getRows()) {
			temp += item.toString();
			counter++;
			if (counter < size) {
				temp += ", ";
			}
		}
		temp += "]]";
		return temp;
	}
}
