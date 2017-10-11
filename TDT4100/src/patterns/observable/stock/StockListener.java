package patterns.observable.stock;

public interface StockListener {

	void stockPriceChanged(Stock stock, double oldPrice, double newPrice); 
	
}
