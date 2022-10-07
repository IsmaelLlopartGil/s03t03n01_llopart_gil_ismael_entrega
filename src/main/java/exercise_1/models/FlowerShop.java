package exercise_1.models;

import java.util.*;

public class FlowerShop {

	private String name;
	private Map<Flower, Integer> flowerMap;
	private Map<Tree, Integer> treeMap;
	private Map<Decor, Integer> decorMap;
	private ArrayList<Invoice> invoiceList;
	private int invoiceNumber = 001;

	public FlowerShop(String name) {
		this.name = name;
		this.flowerMap = new HashMap<>();
		this.treeMap = new HashMap<>();
		this.decorMap = new HashMap<>();
		this.invoiceList = new ArrayList<>();
	}

	public FlowerShop() {
		this.name = null;
		this.flowerMap = new HashMap<>();
		this.treeMap = new HashMap<>();
		this.decorMap = new HashMap<>();
		this.invoiceList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addItem(Item item) {
		item.acceptAdd(this);
	}

	public void visitAdd(Decor decor) {

		if (decorMap.containsKey(decor)) {
			decorMap.replace(decor, decorMap.get(decor) + 1);
		} else {
			decorMap.put(decor, 1);
		}
	}

	public void visitAdd(Flower flower) {

		if (flowerMap.containsKey(flower)) {
			flowerMap.replace(flower, flowerMap.get(flower) + 1);
		} else {
			flowerMap.put(flower, 1);
		}
	}

	public void visitAdd(Tree tree) {

		if (treeMap.containsKey(tree)) {
			treeMap.replace(tree, treeMap.get(tree) + 1);
		} else {
			treeMap.put(tree, 1);
		}
	}

	public void removeItem(Item item) {
		item.acceptRemove(this);
	}

	public void removeItemQuantity(Decor decorProxy, int quantity) {

		for (Decor decor : decorMap.keySet()) {

			if (decorProxy.equals(decor)) {
				decorMap.replace(decor, decorMap.get(decor) - quantity);
			}
		}
	}

	public void removeItemQuantity(Flower flowerProxy, int quantity) {

		for (Flower flower : flowerMap.keySet()) {

			if (flowerProxy.equals(flower)) {
				flowerMap.replace(flower, flowerMap.get(flower) - quantity);
			}
		}
	}

	public void removeItemQuantity(Tree treeProxy, int quantity) {

		for (Tree tree : treeMap.keySet()) {

			if (treeProxy.equals(tree)) {
				treeMap.replace(tree, treeMap.get(tree) - quantity);
			}
		}
	}

	public void visitRemove(Decor decor) {
		decorMap.remove(decor);
	}

	public void visitRemove(Flower flower) {
		flowerMap.remove(flower);
	}

	public void visitRemove(Tree Tree) {
		treeMap.remove(Tree);
	}

	public String getStockText() {
		String text = "";

		for (Decor decor : decorMap.keySet()) {
			text += String.format("%-16s", decor.getName()) + String.format("%-10s", decorMap.get(decor))
					+ String.format("%-20s", "Decoració") + "\n";
		}

		for (Flower flower : flowerMap.keySet()) {
			text += String.format("%-16s", flower.getName()) + String.format("%-10s", flowerMap.get(flower))
					+ String.format("%-20s", "Flor") + "\n";
		}

		for (Tree tree : treeMap.keySet()) {
			text += String.format("%-16s", tree.getName()) + String.format("%-10s", treeMap.get(tree))
					+ String.format("%-20s", "Arbre") + "\n";
		}
		return text;
	}

	public int getNextInvoiceNumber() {
		return invoiceNumber++;
	}

	public boolean ifExistItem(Decor decor) {
		return decorMap.containsKey(decor);
	}

	public boolean ifExistItem(Flower flower) {
		return flowerMap.containsKey(flower);
	}

	public boolean ifExistItem(Tree tree) {
		return treeMap.containsKey(tree);
	}

	public int getItemQuantity(Decor decor) {
		return decorMap.get(decor);
	}

	public int getItemQuantity(Flower flower) {
		return flowerMap.get(flower);
	}

	public int getItemQuantity(Tree tree) {
		return treeMap.get(tree);
	}

	public void addInvoice(Invoice invoice) {

		invoiceList.add(invoice);
	}

	public Decor getItem(Decor decor) {
		for (Decor item : decorMap.keySet()) {

			if (item.equals(decor)) {
				return item;
			}
		}
		return decor;
	}

	public Flower getItem(Flower flower) {
		for (Flower item : flowerMap.keySet()) {

			if (item.equals(flower)) {
				return item;
			}
		}
		return flower;
	}

	public Tree getItem(Tree tree) {
		for (Tree item : treeMap.keySet()) {

			if (item.equals(tree)) {
				return item;
			}
		}
		return tree;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public String getTotalValue() {
		Double totalValue=0.0;
		
		for (Decor decor : decorMap.keySet()) {
			totalValue += (decor.getSalePrice() * decorMap.get(decor));
		}
		
		for (Flower flower : flowerMap.keySet()) {
			totalValue += (flower.getSalePrice() * flowerMap.get(flower));
		}
		
		for (Tree tree : treeMap.keySet()) {
			totalValue += (tree.getSalePrice() * treeMap.get(tree));
		}
		
		return String.valueOf(totalValue);
	}

	public String getEarnings() {
		Double totalEarnings=0.0;
		
		for (Invoice invoice : invoiceList) {
			totalEarnings += invoice.getAmount();
		}
		return String.valueOf(totalEarnings);
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public Map<Decor, Integer> getDecorMap () {
		return decorMap;
	}
	
	public Map<Flower, Integer> getFlowerMap () {
		return flowerMap;
	}
	
	public Map<Tree, Integer> getTreeMap () {
		return treeMap;
	}

	public void setFlowerMap(Map<Flower, Integer> flowerMap) {
		this.flowerMap = flowerMap;
	}

	public void setTreeMap(Map<Tree, Integer> treeMap) {
		this.treeMap = treeMap;
	}

	public void setDecorMap(Map<Decor, Integer> decorMap) {
		this.decorMap = decorMap;
	}

	public void setInvoiceList(ArrayList<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

}
