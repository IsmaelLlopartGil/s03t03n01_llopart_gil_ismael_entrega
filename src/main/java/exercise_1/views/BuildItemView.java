package exercise_1.views;

import com.liche.utils.io.Input;

import exercise_1.models.Item;

public class BuildItemView {

	Item item;

	public BuildItemView(Item item) {
		this.item = item;
	}

	public void build() {
		item.setDescripcion(Input.readString("Introdueix la descripció: "));
		item.setSalePrice(Input.readFloat("Introdueix el preu de venda: "));		
	}
}
