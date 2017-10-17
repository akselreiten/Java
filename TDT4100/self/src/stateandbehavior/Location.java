package stateandbehavior;

public class Location {

	int y;
	int x;

	void up() {
		y = y - 1;
	}

	void down() {
		y = y + 1;
	}

	void left() {
		x = x - 1;
	}

	void right() {
		x = x + 1;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	public static void main(String[] args) {
		Location location1 = new Location();

		location1.up();
		location1.up();
		location1.right();
		location1.left();

		int posX = location1.getX();
		System.out.println("X = " + posX);

		int posY = location1.getY();
		System.out.println("Y = " + posY);

	}

}
