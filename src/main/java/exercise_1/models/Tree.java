package exercise_1.models;

public class Tree extends Item {

	private String height;

	public Tree(String name) {
		super(name);
	}
	
	public Tree() {
		super();
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
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
