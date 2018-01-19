package bwe.com.bawei.guoyulei20180119.xq.xqpresenter;

import bwe.com.bawei.guoyulei20180119.xq.xq_bean.Xq_Bean;
import bwe.com.bawei.guoyulei20180119.xq.xqmodel.Xq_Model;
import bwe.com.bawei.guoyulei20180119.xq.xqview.Xq_View;

/**
 * Created by 猥琐的熊猫 on 2018/1/19.
 */

public class Xq_presenter {
    private Xq_View view;
    private Xq_Model model;
    public Xq_presenter(Xq_View view) {
        this.view = view;
        this.model=new Xq_Model();
    }
    public void presen(){
        model.getxqdata(new Xq_Model.xqdata() {
            @Override
            public void data(Xq_Bean xq_bean) {
                view.getData(xq_bean);
            }
        });
    }
    public void jie(){
        if (view!=null){
            view=null;
        }
    }
}
