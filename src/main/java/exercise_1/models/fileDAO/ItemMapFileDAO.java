package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import exercise_1.models.Decor;
import exercise_1.models.Item;
import exercise_1.models.DAO.ItemMapDAO;

public class ItemMapFileDAO extends ItemMapDAO {

	FileWriter fileWriter;
	BufferedReader bufferedReader;

	public ItemMapFileDAO(Map<Item, Integer> itemMap, FileWriter fileWriter, BufferedReader bufferedReader) {
		super(itemMap);
		this.fileWriter = fileWriter;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void save() {
		
		try {

			fileWriter.write(itemMap.size() + "\n");
			
			for (Item item : itemMap.keySet()) {

				fileWriter.write(item.getName() + "\n");
				fileWriter.write(item.getDescripcion() + "\n");
				fileWriter.write(item.getSalePrice() + "\n");
				fileWriter.write(itemMap.get(item) + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() {

		itemMap.clear();

		try {
			int itemMapSize = Integer.parseInt(bufferedReader.readLine());

			for (int i = 0; i < itemMapSize; i++) {

				Decor item = new Decor();
				item.setName(bufferedReader.readLine());
				item.setDescripcion(bufferedReader.readLine());
				item.setSalePrice(Float.parseFloat(bufferedReader.readLine()));
				itemMap.put(item, Integer.parseInt(bufferedReader.readLine()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
