package fieldObjects;

import game.Field;
import game.Game;
import utils.Point;

public class AcceleratorBonus implements FieldBonuses {
	private Point location;
	private int lifeTime = 10;
	public static final int speedChanger = 50;
	public static final int bonusChance = 5;
	
	public AcceleratorBonus(int x, int y) {
		location = new Point(x, y);
			
	}

	public void setLocation(int x, int y) {
		location = new Point(x, y);
	}

	public Point getLocation() {
		return location;
	}
	
	public int getLifeTime() {
		return lifeTime;
	}
	
	public int getBonusChance() {
		return lifeTime;
	}
	
	public void decreaseLifeTime() {
		lifeTime--;
	}
	
	public void treatCollision(Game game) {
		Field field = game.getField();
		SnakeHead snakeHead = game.findSnakeHead(); 
		Point headLocation = snakeHead.getLocation();
		Object bonus = field.getField()[headLocation.x][headLocation.y];
		int currentSpeed = game.getSpeed();
		if (currentSpeed > 100) {
			game.setSpeed(currentSpeed - speedChanger);
		}
		field.getObjects().remove(bonus);
		game.consts.bonuses.put(new AcceleratorBonus(-1, -1), false);
	}
}
