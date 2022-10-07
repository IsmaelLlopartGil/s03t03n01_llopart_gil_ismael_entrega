package exercise_1.models.DAO;

import java.util.Map;
import exercise_1.models.Flower;

public abstract class FlowerMapDAO {

	protected Map<Flower, Integer> flowerMap;

	public FlowerMapDAO(Map<Flower, Integer> flowerMap) {
		this.flowerMap = flowerMap;
	}
	
	public abstract void save();

	public abstract void load();
}
