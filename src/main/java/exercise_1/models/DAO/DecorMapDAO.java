package exercise_1.models.DAO;

import java.util.Map;
import exercise_1.models.Decor;

public abstract class DecorMapDAO {

	protected Map<Decor, Integer> decorMap;

	public DecorMapDAO(Map<Decor, Integer> decorMap) {
		this.decorMap = decorMap;
	}
	
	public abstract void save();

	public abstract void load();
}
