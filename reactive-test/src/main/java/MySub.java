import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

  private Subscription s;

  @Override
  public void onSubscribe(Subscription s) {
    System.out.println("구독자: 구독정보 잘 받았어");
    this.s = s;

    System.out.println("구독자: 나 이제 신문 1개씩 줘");
    s.request(1); // backPressure - 소비자가 한번에 처리할 수 있는 개수를 요청. 1개만 줘가 아니라, 1개씩 줘
  }

  @Override
  public void onNext(Integer integer) {
    System.out.println("onNext(): " + integer);
    s.request(1);
  }

  @Override
  public void onError(Throwable t) {
    System.out.println("구독중 에러");
  }

  @Override
  public void onComplete() {
    System.out.println("구독 완료");
  }
}
