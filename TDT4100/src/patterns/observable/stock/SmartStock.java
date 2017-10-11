package patterns.observable.stock;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class SmartStock implements StockListener{
	
	public SmartStock(){
		
	}
	
	public void addStockListener(StockListener listener, double min, double max){
	}
	
	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
	}
	

}
