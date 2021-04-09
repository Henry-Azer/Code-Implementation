package RaceCondition;

public class DownloadFile implements Runnable{

    private final DownloadStatus status;

    public DownloadFile(DownloadStatus stats) {
        this.status = stats;
    }

    @Override
    public void run() {
        System.out.println("Download a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) status.incrementTotalBytes();

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
