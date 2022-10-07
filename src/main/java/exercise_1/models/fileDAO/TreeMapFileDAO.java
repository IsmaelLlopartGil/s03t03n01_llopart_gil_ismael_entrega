package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import exercise_1.models.Tree;
import exercise_1.models.DAO.TreeMapDAO;

public class TreeMapFileDAO extends TreeMapDAO {

	FileWriter fileWriter;
	BufferedReader bufferedReader;

	public TreeMapFileDAO(Map<Tree, Integer> treeMap, FileWriter fileWriter, BufferedReader bufferedReader) {
		super(treeMap);
		this.fileWriter = fileWriter;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void save() {

		try {
			fileWriter.write(treeMap.size() + "\n");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (Tree tree : treeMap.keySet()) {
			
			try {
				fileWriter.write(tree.getName() + "\n");
				fileWriter.write(tree.getDescripcion() + "\n");
				fileWriter.write(tree.getSalePrice() + "\n");
				fileWriter.write(tree.getHeight() + "\n");
				fileWriter.write(treeMap.get(tree) + "\n");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void load() {
		
		treeMap.clear();
		
		try {
			
			int treeMapSize = Integer.parseInt(bufferedReader.readLine());
			
			for (int i = 0; i < treeMapSize; i++) {
				
				Tree tree = new Tree();
				tree.setName(bufferedReader.readLine());
				tree.setDescripcion(bufferedReader.readLine());
				tree.setSalePrice(Float.parseFloat(bufferedReader.readLine()));
				tree.setHeight(bufferedReader.readLine());
				treeMap.put(tree, Integer.parseInt(bufferedReader.readLine()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
