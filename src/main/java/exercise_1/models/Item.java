package exercise_1.models;

import java.util.Objects;

public abstract class Item {

	private String name;
	private String descripcion;
	private float salePrice;

	public Item(String name) {
		this.name = name;
	}

	public Item() {
		this.name = null;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public String getName() {
		return name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public abstract void acceptAdd(FlowerShop flowerShop);

	protected abstract void acceptRemove(FlowerShop flowerShop);

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(name, other.name);
	}

}
