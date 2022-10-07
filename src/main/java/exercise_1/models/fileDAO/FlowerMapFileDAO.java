package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import exercise_1.models.Flower;
import exercise_1.models.DAO.FlowerMapDAO;
import exercise_1.types.Color;

public class FlowerMapFileDAO extends FlowerMapDAO {

	FileWriter fileWriter;
	BufferedReader bufferedReader;

	public FlowerMapFileDAO(Map<Flower, Integer> flowerMap, FileWriter fileWriter, BufferedReader bufferedReader) {
		super(flowerMap);
		this.fileWriter = fileWriter;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void save() {

		try {
			fileWriter.write(flowerMap.size() + "\n");

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Flower flower : flowerMap.keySet()) {

			try {
				fileWriter.write(flower.getName() + "\n");
				fileWriter.write(flower.getDescripcion() + "\n");
				fileWriter.write(flower.getSalePrice() + "\n");
				fileWriter.write(flower.getColor() + "\n");
				fileWriter.write(flowerMap.get(flower) + "\n");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void load() {

		flowerMap.clear();

		try {

			int flowerMapSize = Integer.parseInt(bufferedReader.readLine());

			for (int i = 0; i < flowerMapSize; i++) {

				Flower flower = new Flower();
				flower.setName(bufferedReader.readLine());
				flower.setDescripcion(bufferedReader.readLine());
				flower.setSalePrice(Float.parseFloat(bufferedReader.readLine()));

				switch (bufferedReader.readLine()) {

				case "WHITE":
					flower.setColor(Color.WHITE);
					break;

				case "YELLOW":
					flower.setColor(Color.YELLOW);
					break;

				case "RED":
					flower.setColor(Color.RED);
					break;
				}

				flowerMap.put(flower, Integer.parseInt(bufferedReader.readLine()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
