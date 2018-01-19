package bwe.com.bawei.guoyulei20180119.gouwuche.gwpresenter;

import java.util.List;
import java.util.Map;

import bwe.com.bawei.guoyulei20180119.gouwuche.gwbean.ShopCar;
import bwe.com.bawei.guoyulei20180119.gouwuche.gwmodel.Model;
import bwe.com.bawei.guoyulei20180119.gouwuche.gwview.IView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class NewsPresenter implements IPresenter {
    private IView iView;
    private DisposableSubscriber<ShopCar> subscriber;

    public void attachView(IView iView) {
        this.iView = iView;
    }

    @Override
    public void getData(Map<String, String> map) {
        Model model = new Model(this);
        model.getData(map);
    }

    public void detachView() {
        if (subscriber != null) {
            //如果该资源已被处理，则可一次性返回true。如果没有被处理返回false
            if (!subscriber.isDisposed()) {
                subscriber.dispose();
            }
        }

    }

    public void get(Flowable<ShopCar> flowable) {
        subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopCar>() {
                    @Override
                    public void onNext(ShopCar listMessageBean) {
                        if (listMessageBean != null) {
                            List<ShopCar.DataBean> data = listMessageBean.getData();
                            if (data != null) {
                                iView.OnSuccess(data);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        iView.OnFailed(new Exception(t));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}