package game;
import java.util.ArrayList;

import fieldObjects.EmptyCell;
import fieldObjects.FieldObject;

public class Field {
	private ArrayList<FieldObject> objects;
	private FieldObject[][] field;
	private int height;
	private int width;
	
	public Field(int width, int height){
		objects = new ArrayList<FieldObject>();
		field = new FieldObject[width][height];
		this.height = height;
		this.width = width;
		}
	
	public int getHeigth() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public FieldObject[][] getField(){
		return field;
	}
	
	public ArrayList<FieldObject> getObjects(){
		return objects;
	}
	
	public void initilizeField() {
		field = new FieldObject[getWidth()][getHeigth()];
		for (int i = 0; i < objects.size(); i++){
			int x = objects.get(i).getLocation().x;
			int y = objects.get(i).getLocation().y;
			field[x][y] = objects.get(i);
		}
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeigth(); y++) {
				if (field[x][y] == null) {
					field[x][y] = new EmptyCell(x, y);
				}
			}
		}
	}
	
	public boolean isOnField(int x, int y) {
		return (x < getWidth() && x >= 0 && y < getHeigth() && y >= 0);
	}
}
