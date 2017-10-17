package patterns.observable.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	private String ticker; 
	private double price;
	private List<StockListener> listeners = new ArrayList<StockListener>();
	
	public Stock(String ticker, double price){
		this.ticker = ticker; 
		this.price = price; 
	}
	
	public void setPrice(double price){
		if (price >= 0){
			for (StockListener listener : listeners){
				listener.stockPriceChanged(this, this.price, price);
			}
			this.price = price;
		}
	}
	
	public String getTicker(){
		return ticker; 
	}
	
	public double getPrice(){
		return price; 
	}
	
	public void addStockListener(StockListener listener){
		if (!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public void removeStockListener(StockListener listener){
		if (listeners.contains(listener)){
			listeners.remove(listeners.indexOf(listener));
		}
	}
}
