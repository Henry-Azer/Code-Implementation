package Executors;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {

    public Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("Site 1", "Site 2", "Site 3");

        return sites.stream().map(this::getQuote);
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a Quote from: " + site);

            var rand = new Random();
            LongTask.simulate(rand.nextInt(5000));
            var price = 100 + rand.nextInt(10);

            return new Quote(site, price);
        });
    }
}
