package study.java;

import java.util.concurrent.atomic.AtomicInteger;

public class ScoreAtomic {
    private AtomicInteger currentScore = new AtomicInteger(0);

    public void addScore() {
        this.currentScore.incrementAndGet();
    }

    public int getScore() {
        return currentScore.get();
    }
}
