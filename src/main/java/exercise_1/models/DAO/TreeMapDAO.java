package exercise_1.models.DAO;

import java.util.Map;
import exercise_1.models.Tree;

public abstract class TreeMapDAO {

	protected Map<Tree, Integer> treeMap;

	public TreeMapDAO(Map<Tree, Integer> treeMap) {
		this.treeMap = treeMap;
	}
	
	public abstract void save();

	public abstract void load();
}
