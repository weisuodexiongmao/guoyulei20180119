package bwe.com.bawei.guoyulei20180119.addcart.add_model;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20180119.addcart.add_bean.add_Bean;
import bwe.com.bawei.guoyulei20180119.utlis.RetrofitHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/19.
 */

public class Add_Model {
    public void getAdd(final getaddData data){
        Map<String, String> map=new HashMap<>();
        map.put("uid","71");
        map.put("pid","49");
//        map.put("source","android");
        Observable<add_Bean> observable = RetrofitHelper.getAPI().add(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<add_Bean>() {
                    @Override
                    public void accept(add_Bean add_bean) throws Exception {
                        data.adddata(add_bean);
                    }
                });
    }
    public interface getaddData{
        void adddata(add_Bean add_bean);
    }
}
