package study.java;

public class MultiThreadDataAccess {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(calculateScore());
        }
    }

    private static int calculateScore() throws InterruptedException {
        Score score = new Score();
        int loop = 2000;
        Thread thread1 = new Thread(() -> addScore(score, loop));
        Thread thread2 = new Thread(() -> addScore(score, loop));
        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        return score.currentScore;
    }

    private static void addScore(Score score, int loop) {
        for (int i = 0; i < loop; i++) {
            score.currentScore += 1;
        }
    }
}
