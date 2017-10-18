package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{

	private StringGrid grid; 
	private boolean rowMajor;
	private int rows, columns;
	
	
	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid; 
		this.rowMajor = rowMajor;
		rows = columns = 0;
	}
	
	@Override
	public boolean hasNext() {
		return grid.getColumnCount() > columns && grid.getRowCount() > rows;
	}

	@Override
	public String next() {
		String element = grid.getElement(rows, columns);
		if (rowMajor) { // iteration goes horizontally (row wise)
			if (columns >= grid.getColumnCount() - 1) {
				columns = 0;
				rows++;
			} else {
				columns++;
			}
		} else { // iteration goes vertically (column wise)
			if (rows >= grid.getRowCount() - 1) {
				rows = 0;
				columns++;
			} else {
				rows++;
			}
		}
		return element;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("Not possible to remove strings in this iterator");
	}
	
	
	
}
