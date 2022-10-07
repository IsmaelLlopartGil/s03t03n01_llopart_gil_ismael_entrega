package exercise_1.models.DAO;

import exercise_1.models.FlowerShop;

public abstract class FlowerShopDAO {

	protected FlowerShop flowerShop;
	protected DecorMapDAO decorMapDAO;
	protected FlowerMapDAO flowerMapDAO;
	protected TreeMapDAO treeMapDAO;
	protected InvoiceListDAO invoiceListDAO;

	public FlowerShopDAO(FlowerShop flowerShop) {
		this.flowerShop = flowerShop;
		fillMaps();
	}
	
	protected abstract void fillMaps();

	public abstract void save();

	public abstract void load();

}
