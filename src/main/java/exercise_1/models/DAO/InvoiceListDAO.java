package exercise_1.models.DAO;

import java.util.List;
import exercise_1.models.Invoice;

public abstract class InvoiceListDAO {

	protected List<Invoice> invoiceList;
	protected ItemMapDAO itemMapDAO;
	
	public InvoiceListDAO(List<Invoice> invoiceList) {
		this.invoiceList=invoiceList;
	}
	
	public abstract void save();

	public abstract void load();
}
