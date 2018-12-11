package WissenInfotechPvt.Ltd;
import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		HashMap<String, Double> newPriceMap = new HashMap<>();
		HashMap<String, Integer> tickCountMap = new HashMap<>();
		
		@Override
		public void putNewPrice(String symbol, double price) {
			if(newPriceMap.containsKey(symbol)){
				price = newPriceMap.get(symbol) + price;
				newPriceMap.put(symbol, price);
				tickCountMap.put(symbol, tickCountMap.get(symbol)+1);
			}else{
				newPriceMap.put(symbol, price);
				tickCountMap.put(symbol, 1);
			}
		}
		
		@Override
		public double getAveragePrice(String symbol) {
			double avgPrice = newPriceMap.get(symbol)/tickCountMap.get(symbol);
			return avgPrice;
		}

		@Override
		public int getTickCount(String symbol) {
			return tickCountMap.get(symbol);
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}