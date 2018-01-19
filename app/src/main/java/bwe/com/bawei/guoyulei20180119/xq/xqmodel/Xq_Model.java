package bwe.com.bawei.guoyulei20180119.xq.xqmodel;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20180119.utlis.RetrofitHelper;
import bwe.com.bawei.guoyulei20180119.xq.xq_bean.Xq_Bean;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/19.
 */

public class Xq_Model {
    public void getxqdata(final xqdata xqdata){
        Map<String, String> map=new HashMap<>();
        map.put("pid","40");
//        map.put("source","android");
        Observable<Xq_Bean> observable = RetrofitHelper.getAPI().xq(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Xq_Bean>() {
                    @Override
                    public void accept(Xq_Bean xq_bean) throws Exception {
                        xqdata.data(xq_bean);
                    }
                });
    }
    public interface xqdata{
        void data(Xq_Bean xq_bean);
    }
}
