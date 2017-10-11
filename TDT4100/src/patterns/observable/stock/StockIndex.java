package patterns.observable.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockIndex implements StockListener {
	
	private String name;
	private List<Stock> stocks; 
	
	public StockIndex(String name, Stock... stocks){
		if (stocks != null){
			this.stocks = new ArrayList<Stock>(Arrays.asList(stocks));
		} else {
			this.stocks = new ArrayList<Stock>(); 
		}
		this.name = name; 
	}
	
	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		
	}
	
	public void addStock(Stock stock){
		if (!stocks.contains(stock)){
			stocks.add(stock);
		}
	}
	public void removeStock(Stock stock){
		if (stocks.contains(stock)){
			stocks.remove(stocks.indexOf(stock));
		}
	}
	
	public double getIndex(){
		double index = 0;
		for (Stock stock : stocks){
			index += stock.getPrice();
		}
		return index; 
	}
	
	
	
}
