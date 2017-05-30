package vip.qianbai.test.service.order.rxjava;
import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.Getter;
import lombok.Setter;


/** 
 * rxjava test s<br/>
 * @date    2017年5月30日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */
@Setter
@Getter
public class TestRxJava {

	@Test
	public void testObserver(){
		Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> e) throws Exception {
				e.onNext("ok1");
				e.onNext("ok2");
				e.onComplete();
			}
		
		});
		Observer<String> observer = new Observer<String>(){

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println(d.isDisposed());
			}

			@Override
			public void onNext(String t) {
				System.out.println("got :"+t);
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("observer compelted");
			}
		};
		observable.subscribe(observer);
	}
	
	
}
