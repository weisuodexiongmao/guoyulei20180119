package bwe.com.bawei.guoyulei20180119.gouwuche.gwmodel;

import java.util.Map;

import bwe.com.bawei.guoyulei20180119.gouwuche.gwpresenter.NewsPresenter;
import bwe.com.bawei.guoyulei20180119.gouwuche.RetrofitUtils;
import bwe.com.bawei.guoyulei20180119.gouwuche.gwbean.ShopCar;
import io.reactivex.Flowable;

public class Model implements IModel {
    private NewsPresenter presenter;

    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        Flowable<ShopCar> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
        presenter.get(flowable);
    }
}