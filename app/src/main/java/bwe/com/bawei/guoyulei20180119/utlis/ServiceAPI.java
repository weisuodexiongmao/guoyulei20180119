package bwe.com.bawei.guoyulei20180119.utlis;

import java.util.Map;

import bwe.com.bawei.guoyulei20180119.addcart.add_bean.add_Bean;
import bwe.com.bawei.guoyulei20180119.xq.xq_bean.Xq_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2018/1/19.
 */

public interface ServiceAPI {
   @GET(Api.XQ)
    Observable<Xq_Bean>xq(@QueryMap Map<String,String> map);
    @GET(Api.Add)
    Observable<add_Bean>add(@QueryMap Map<String,String>map);
}
