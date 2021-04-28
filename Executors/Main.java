package Executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var startTime = LocalTime.now();

        var service = new FlightService();
        CompletableFuture
                .allOf(service.getQuotes()
                .map(future -> future.thenAccept(System.out::println)).toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    var endTime = LocalTime.now();
                    var duration = Duration.between(startTime, endTime);

                    System.out.println("\nRetrieved all Quotes in: " + duration.toMillis() + " msec.");
                });

        Thread.sleep(6_000);
    }
}
