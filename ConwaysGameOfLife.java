package curriculum;

import processing.core.PApplet;


public class ConwaysGameOfLife extends PApplet {
	
	int beginningConstant = 15; // the probability that a cell is alive when the game begins
	int cellSize = 2; // size of the cell in pixels 
	int cellState; // if the cell is alive (colorful, 1) or dead (black, 0)
	int[][] world; // 2D grid of cells
	int[][] worldCopy; // copy of grid, so we can record the state of the cells each time the game updates and perform the updates without filling up our original grid
	
	int interval = 100; // we'll update the cell states every time the interval (in milliseconds) passes
	int lastRecordedTime = 0; 

	public void setup() {
		
		size(640,360);
		
		// initialize the grids
		world = new int[width/cellSize][height/cellSize]; 
		worldCopy = new int[width/cellSize][height/cellSize]; 
		
		noStroke();
		
		// assign a certain percentage of cells to be 0 (dead) and the rest to be 1 (alive)
		for (int i = 0; i < width/cellSize; i++) {
			for (int j = 0; j < height/cellSize; j++) {
				cellState = (int)(random(100));
				if (cellState > beginningConstant) {
					cellState = 0;
				}
				else{
					cellState = 1;
				}
				world[i][j] = cellState;
			}
		}
		
		background(0);
		
	}// end setup()

	public void draw() {
		
		// check if each cell is alive or dead; if it's alive, fill it with a color, and if it's dead, fill it black
		for (int z = 0; z < width/cellSize; z++) {
			for (int a = 0; a < height/cellSize; a++) {
				if (world[z][a] == 1) {
					fill(random(255), random(255), random(255));
				}
				else{
					fill(0);
				}
				rect(z*cellSize, a*cellSize, cellSize, cellSize);
			}
		}
		
		// millis() records the milliseconds since play began
		if (millis() - lastRecordedTime > interval) {
			updateCells();
			lastRecordedTime = millis();
		}
	} // end draw()
	
	public void updateCells() {
		
		for (int x = 0; x < width/cellSize; x++) {
			for (int y = 0; y < height/cellSize; y++) {
				worldCopy[x][y] = world[x][y];
			}
		}
		
		for (int col = 0; col < width/cellSize; col++) {
			for (int row = 0; row < height/cellSize; row++) {
				if (worldCopy[col][row] == 1) {
					if (getLiveNeighborCount(col,row) < 2 || getLiveNeighborCount(col, row) >= 4) {
						world[col][row] = 0;
					}
				}
				
				if (worldCopy[col][row] == 0) {
					if (getLiveNeighborCount(col, row) == 3) {
						world[col][row] = 1;
					}
				}
				
			}
		}
		
	} // end updateCells()
	
	public int getLiveNeighborCount(int x, int y) {
		
		int col = x;
		int row = y;
		int liveNeighborCount = 0;
		
		for (int newCol = col-1; newCol <= col+1; newCol++) {
	        for (int newRow = row-1; newRow <= row+1; newRow++) {  
	          if (((newCol >= 0) && (newCol < width/cellSize)) && ((newRow >= 0) && (newRow < height/cellSize))) { 
	            if (!((newCol == col) && (newRow == row))) { // Make sure to to check against self
	              if (worldCopy[newCol][newRow]==1){
	                liveNeighborCount++; 
	              }
	            } 
	          } 
	        } 
	      } 
		
		return liveNeighborCount;

	} // end getLiveNeighborCount()
	
} // end Conway's Game of Life
