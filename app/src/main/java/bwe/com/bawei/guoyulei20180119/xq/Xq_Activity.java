package bwe.com.bawei.guoyulei20180119.xq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.guoyulei20180119.gouwuche.Main2Activity;
import bwe.com.bawei.guoyulei20180119.shipin.Bofang_activity;
import bwe.com.bawei.guoyulei20180119.R;
import bwe.com.bawei.guoyulei20180119.addcart.add_bean.add_Bean;
import bwe.com.bawei.guoyulei20180119.addcart.add_presenter.Add_presenter;
import bwe.com.bawei.guoyulei20180119.addcart.add_view.Add_View;
import bwe.com.bawei.guoyulei20180119.xq.xq_bean.Xq_Bean;
import bwe.com.bawei.guoyulei20180119.xq.xqpresenter.Xq_presenter;
import bwe.com.bawei.guoyulei20180119.xq.xqview.Xq_View;

public class Xq_Activity extends AppCompatActivity implements Xq_View,Add_View
{

    @BindView(R.id.simpleDraweeView2)
    SimpleDraweeView simpleDraweeView2;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    private Xq_presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xq_activity);
        ButterKnife.bind(this);
        presenter = new Xq_presenter(this);
        presenter.presen();
    }

    @OnClick({R.id.button6, R.id.button7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button6:
                Add_presenter presenter=new Add_presenter(this);
                presenter.presen111();
             startActivity(new Intent(Xq_Activity.this, Main2Activity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(Xq_Activity.this, Bofang_activity.class));
                break;
        }
    }

    @Override
    public void getData(Xq_Bean xq_bean) {
        String images = xq_bean.getData().getImages();
        String[] split = images.split("\\|");
        simpleDraweeView2.setImageURI(split[0]);
        textView2.setText(xq_bean.getData().getTitle());
        textView3.setText(xq_bean.getData().getSubhead());
        textView4.setText(xq_bean.getData().getPrice()+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.jie();
    }

    @Override
    public void getAddData(add_Bean add_bean) {
        Toast.makeText(this,add_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
