package exercise_1.models;

import exercise_1.types.Color;

public class Flower extends Item {
	
	private Color color;
	
	public Flower(String name) {
		super(name);
	}
	
	public Flower() {
		super();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void acceptAdd(FlowerShop flowerShop) {
		flowerShop.visitAdd(this);
	}

	@Override
	protected void acceptRemove(FlowerShop flowerShop) {
		flowerShop.visitRemove(this);	
	}
}
