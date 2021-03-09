package DesignPatterns.State.Abuse;

public class RunningState implements StopwatchState {
    private final Stopwatch stopwatch;

    public RunningState(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new StoppedState(stopwatch));
        System.out.println("Stopped.");
    }
}
