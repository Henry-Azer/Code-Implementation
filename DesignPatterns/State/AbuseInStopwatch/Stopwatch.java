package DesignPatterns.State.Abuse;

public class Stopwatch {
    private StopwatchState currentState = new StoppedState(this);

    public StopwatchState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StopwatchState currentState) {
        this.currentState = currentState;
    }

    public void click() {
        currentState.click();
    }
}
