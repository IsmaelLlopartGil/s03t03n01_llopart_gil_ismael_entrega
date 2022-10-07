package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import exercise_1.models.Decor;
import exercise_1.models.DAO.DecorMapDAO;
import exercise_1.types.Material;

public class DecorMapFileDAO extends DecorMapDAO {

	FileWriter fileWriter;
	BufferedReader bufferedReader;

	public DecorMapFileDAO(Map<Decor, Integer> decorMap, FileWriter fileWriter, BufferedReader bufferedReader) {
		super(decorMap);
		this.fileWriter = fileWriter;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void save() {

		try {
			fileWriter.write(decorMap.size() + "\n");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (Decor decor : decorMap.keySet()) {

			try {
				
				fileWriter.write(decor.getName() + "\n");
				fileWriter.write(decor.getDescripcion() + "\n");
				fileWriter.write(decor.getSalePrice() + "\n");
				fileWriter.write(decor.getMaterial() + "\n");
				fileWriter.write(decorMap.get(decor) + "\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void load() {
		
		decorMap.clear();
		
		try {
			
			int decorMapSize = Integer.parseInt(bufferedReader.readLine());
			
			for (int i = 0; i < decorMapSize; i++) {
				
				Decor decor = new Decor();
				decor.setName(bufferedReader.readLine());
				decor.setDescripcion(bufferedReader.readLine());
				decor.setSalePrice(Float.parseFloat(bufferedReader.readLine()));
				
				switch (bufferedReader.readLine()) {
				
				case "WOOD":
					decor.setMaterial(Material.WOOD);
					break;
					
				case "PLASTIC":
					decor.setMaterial(Material.PLASTIC);
					break;
				}
				
				decorMap.put(decor, Integer.parseInt(bufferedReader.readLine()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void associateFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
}
