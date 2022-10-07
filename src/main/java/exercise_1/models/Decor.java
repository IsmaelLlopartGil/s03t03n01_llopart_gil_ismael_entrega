package exercise_1.models;

import exercise_1.types.Material;

public class Decor extends Item {

	private Material material;

	public Decor(String name) {
		super(name);
	}

	public Decor() {
		super();
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public Material getMaterial() {
		return material;
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
