package fieldObjects;

import game.Field;
import game.Game;
import gui.Animation;
import utils.Point;

public class Apple implements FieldObject {
	private Point location;
	public Animation animation;
	
	public Apple(int x, int y) {
		location = new Point(x, y);
		
	}

	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}

	public Point getLocation() {
		return location;
	}

	public void treatCollision(Game game) {
		Field field = game.getField();
		SnakeHead snakeHead = game.findSnakeHead(); 
		Object tailCell = game.findSnakeTail(snakeHead);
		Point headLocation = snakeHead.getLocation();
		Object apple = field.getField()[headLocation.x][headLocation.y];
		if (tailCell.getClass() == SnakeHead.class) {
			SnakeHead snakeTail = (SnakeHead)tailCell;
			snakeTail.setPreviousPart(new SnakePart(snakeTail.getLocation().x,
                                                    snakeTail.getLocation().y));
			field.getObjects().add(snakeTail.getPreviousPart());
		}
		else {
			SnakePart snakeTail = (SnakePart)tailCell;
			snakeTail.setPreviousPart(new SnakePart(snakeTail.getLocation().x,
                                                    snakeTail.getLocation().y));
			field.getObjects().add(snakeTail.getPreviousPart());
			snakeTail = (SnakePart)snakeTail;
		}
		field.getObjects().remove(apple);
		game.objectGenerator(Apple.class);
	}
}
