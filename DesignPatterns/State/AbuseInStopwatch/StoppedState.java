package DesignPatterns.State.Abuse;

public class StoppedState implements StopwatchState {
    private final Stopwatch stopwatch;

    public StoppedState(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new RunningState(stopwatch));
        System.out.println("Running.");
    }
}
