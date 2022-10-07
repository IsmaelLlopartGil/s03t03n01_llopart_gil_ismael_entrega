package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import exercise_1.models.Session;
import exercise_1.models.DAO.SessionDAO;
import exercise_1.types.StateValue;

public class SessionFileDAO extends SessionDAO {

    public static final String EXTENSION = ".fp";
	public static final String DIRECTORY = "./saves";
	private static File directory;
	
	static {
		SessionFileDAO.directory = new File(SessionFileDAO.DIRECTORY);
		
		if (!SessionFileDAO.directory.exists() || !SessionFileDAO.directory.isDirectory()) {
			SessionFileDAO.directory.mkdir();
		} 
	}
	
	private FlowerShopFileDAO flowerShopFileDAO;
	
	@Override
	public void associate(Session session) {
		super.associate(session);
		flowerShopFileDAO = new FlowerShopFileDAO (this.session.getFlowerShop());
	}
	
    @Override
	public void save(String name) {
    	
		if (name.endsWith(SessionFileDAO.EXTENSION)) {
			name = name.replace(SessionFileDAO.EXTENSION, "");
		}
		
		File file = new File(SessionFileDAO.directory, name + SessionFileDAO.EXTENSION);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.flowerShopFileDAO.setFileWriter(fileWriter);
			this.flowerShopFileDAO.save();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void load(String name) {
		this.session.setName(name);
		File file = new File(SessionFileDAO.directory, name);
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.flowerShopFileDAO.setBufferedReader(bufferedReader);
			this.flowerShopFileDAO.load();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        this.session.setValueState(StateValue.MAIN);
	}
	
    @Override
	public String[] getShopNames() {
		return SessionFileDAO.directory.list();
	}

    @Override
	public boolean exists(String name) {
		for (String auxName : this.getShopNames()) {
			if (auxName.equals(name + SessionFileDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}
}
