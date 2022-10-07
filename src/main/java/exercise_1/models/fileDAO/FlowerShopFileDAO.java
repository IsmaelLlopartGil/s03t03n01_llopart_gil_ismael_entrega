package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import exercise_1.models.FlowerShop;
import exercise_1.models.DAO.FlowerShopDAO;

public class FlowerShopFileDAO extends FlowerShopDAO {
	
	private FileWriter fileWriter;
	private BufferedReader bufferedReader;
	
	public FlowerShopFileDAO(FlowerShop flowerShop) {
		super(flowerShop);
	}

	@Override
	protected void fillMaps() {
		decorMapDAO = new DecorMapFileDAO (flowerShop.getDecorMap(), fileWriter, bufferedReader);
		flowerMapDAO = new FlowerMapFileDAO (flowerShop.getFlowerMap(), fileWriter, bufferedReader);
		treeMapDAO = new TreeMapFileDAO (flowerShop.getTreeMap(), fileWriter, bufferedReader);	
		invoiceListDAO = new InvoiceListFileDAO (flowerShop.getInvoiceList() , fileWriter, bufferedReader);
	}

	@Override
	public void save() {
		
		try {
			fileWriter.write(flowerShop.getName() + "\n");
			fileWriter.write(flowerShop.getInvoiceNumber() + "\n");
			decorMapDAO.save();
			flowerMapDAO.save();
			treeMapDAO.save();
			invoiceListDAO.save();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void load() {
		
		
		try {
			flowerShop.setName(bufferedReader.readLine());
			flowerShop.setInvoiceNumber(Integer.parseInt(bufferedReader.readLine()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		decorMapDAO.load();
		flowerMapDAO.load();
		treeMapDAO.load();
		invoiceListDAO.load();		
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
		fillMaps();
		
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
		fillMaps();
	}
}
