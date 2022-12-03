package study.java;

public class MultiThreadDataAccessWithSynchronized {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(calculateScore());
        }
    }

    private static int calculateScore() throws InterruptedException {
        ScoreSynchronized score = new ScoreSynchronized();
        int loop = 2000;
        Thread thread1 = new Thread(() -> addScore(score, loop));
        Thread thread2 = new Thread(() -> addScore(score, loop));
        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        return score.getScore();
    }

    private static void addScore(ScoreSynchronized score, int loop) {
        for (int i = 0; i < loop; i++) {
            score.addScore();
        }
    }
}
