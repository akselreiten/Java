package stateandbehavior;

public class Rectangle {

	int x, y, minX, minY, maxX, maxY;
	
	public Rectangle(){
		
	}
	
	private int getMinX(){
		return minX; 
	}
	
	private int getMinY(){
		return minY; 
	}
	
	private int getMaxX(){
		return maxX;
	}
	
	private int getMaxY(){
		return maxY; 
	}
	
	private int getWidth(){
		if (isEmpty()){
			return 0;
		} 
		return maxX - minX;
	}
	
	private int getHeight(){
		if (isEmpty()){
			return 0;
		} 
		return maxY - minY;
	}
	
	private boolean isEmpty(){
		if (x == 0 || y == 0) {
			return true; 
		}
		return false;
	}
	
	boolean contains(int x, int y){
		if (isEmpty()){
			return false; 
		}
		if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean contains(Rectangle rect) {
		if (isEmpty()){
			return false; 
		}
		
		if (rect.getMinX() >= minX && rect.getMinY() >= minY
				&& rect.getMaxX() <= maxX && rect.getMaxY() <= maxY) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean add(int x, int y) {
		
		
		return false;
	}
	
	boolean add(Rectangle rect) {
		if (rect == null) {
			
		} else {
			int x = rect.getMinX();
		}
		
		return true; 
	}
	
}
