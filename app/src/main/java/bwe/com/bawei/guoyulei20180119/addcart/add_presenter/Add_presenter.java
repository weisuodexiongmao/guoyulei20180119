package bwe.com.bawei.guoyulei20180119.addcart.add_presenter;

import bwe.com.bawei.guoyulei20180119.addcart.add_bean.add_Bean;
import bwe.com.bawei.guoyulei20180119.addcart.add_model.Add_Model;
import bwe.com.bawei.guoyulei20180119.addcart.add_view.Add_View;

/**
 * Created by 猥琐的熊猫 on 2018/1/19.
 */

public class Add_presenter {
    private Add_View view;
    private Add_Model model;
    public Add_presenter(Add_View view) {
        this.view = view;
        this.model=new Add_Model();
    }
    public void presen111(){
        model.getAdd(new Add_Model.getaddData() {
            @Override
            public void adddata(add_Bean add_bean) {
                view.getAddData(add_bean);
            }
        });
    }
    public void kai(){
        if (view!=null){
            view=null;
        }
    }
}
