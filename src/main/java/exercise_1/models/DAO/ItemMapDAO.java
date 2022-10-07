package exercise_1.models.DAO;

import java.util.Map;
import exercise_1.models.Item;

public abstract class ItemMapDAO {

	protected Map<Item, Integer> itemMap;

	public ItemMapDAO(Map<Item, Integer> itemMap) {
		this.itemMap = itemMap;
	}
	
	public abstract void save();

	public abstract void load();
}
