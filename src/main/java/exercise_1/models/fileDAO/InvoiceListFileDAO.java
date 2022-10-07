package exercise_1.models.fileDAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import exercise_1.models.Invoice;
import exercise_1.models.DAO.InvoiceListDAO;

public class InvoiceListFileDAO extends InvoiceListDAO {

	private FileWriter fileWriter;
	BufferedReader bufferedReader;

	public InvoiceListFileDAO(List<Invoice> invoiceList, FileWriter fileWriter, BufferedReader bufferedReader) {
		super(invoiceList);
		this.fileWriter = fileWriter;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void save() {

		try {
			fileWriter.write(invoiceList.size() + "\n");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (Invoice invoice : invoiceList) {

			itemMapDAO = new ItemMapFileDAO(invoice.getItemMap(), fileWriter, bufferedReader);

			try {
				fileWriter.write(invoice.getName() + "\n");
				fileWriter.write(invoice.getAmount().toString() + "\n");
				itemMapDAO.save();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void load() {
		
		invoiceList.clear();
		
		try {
			
			int invoiceListSize = Integer.parseInt(bufferedReader.readLine());
			
			for (int i = 0; i < invoiceListSize; i++) {
				
				Invoice invoice = new Invoice(bufferedReader.readLine());
				invoice.setAmount(Double.parseDouble (bufferedReader.readLine()));
				invoiceList.add(invoice);
				itemMapDAO = new ItemMapFileDAO(invoice.getItemMap(), fileWriter, bufferedReader);
				itemMapDAO.load();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
