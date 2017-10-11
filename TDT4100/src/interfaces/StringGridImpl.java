package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringGridImpl implements StringGrid {
	
	private int rows, columns; 
	private List<String> grid = new ArrayList<String>();
	private boolean rowMajor; 

	public StringGridImpl(int rows, int columns){
		this.rows = rows; 
		this.columns = columns;
		
		for (int i=0; i<rows*columns ; i++){
			grid.add("");
		}
	}
	
	@Override
	public int getRowCount() {
		return grid.size()/columns;
	}

	@Override
	public int getColumnCount() {
		return columns;
	}
	
	public void checkCoordinate(int row,int column){
		if (row < 0 || row >= getRowCount() || column < 0 || column >= getColumnCount()){
			throw new IllegalArgumentException("Not valid coordinte. Not in grid.");
		}
	}
	
	public int getIndex(int row, int column){
		return (row+1)*(column+1)-1;
	}

	@Override
	public String getElement(int row, int column) {
		checkCoordinate(row,column);
		return grid.get(getIndex(row,column));
	}

	@Override
	public void setElement(int row, int column, String element) {
		checkCoordinate(row,column);
		grid.set(getIndex(row,column),element);
	}

	@Override
	public Iterator<String> iterator() {
		return grid.iterator();
	}
	
}
