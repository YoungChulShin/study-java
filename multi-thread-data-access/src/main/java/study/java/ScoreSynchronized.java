package study.java;

public class ScoreSynchronized {
    private int currentScore;

    public synchronized void addScore() {
        currentScore++;
    }

    public synchronized int getScore() {
        return currentScore;
    }
}
