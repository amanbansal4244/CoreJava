package WissenInfotechPvt.Ltd;

public interface StatisticsAggregator {

	
	public void putNewPrice(String symbol, double price) ;

	
	public double getAveragePrice(String symbol);

	
	public int getTickCount(String symbol);
}
