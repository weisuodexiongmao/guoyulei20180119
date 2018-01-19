package bwe.com.bawei.guoyulei20180119;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.guoyulei20180119.xq.Xq_Activity;

public class MainActivity extends AppCompatActivity {
    DownLoadFile downLoadFile;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    private String loadUrl = "http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4 ";
    private String filePath = Environment.getExternalStorageDirectory() + "/" + "haodeba.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final TextView tvprogress = (TextView) findViewById(R.id.tv_progress);
        downLoadFile = new DownLoadFile(this, loadUrl, filePath, 3);
        downLoadFile.setOnDownLoadListener(new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                tvprogress.setText("当前进度 ：" + progress + " %");
                progressBar.setProgress(progress);
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(MainActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        downLoadFile.onDestroy();
        super.onDestroy();
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                downLoadFile.downLoad();
                break;
            case R.id.button2:
                downLoadFile.onPause();
                break;
            case R.id.button3:
                downLoadFile.onStart();
                break;
            case R.id.button4:
                downLoadFile.cancel();
                break;
            case R.id.button5:
         startActivity(new Intent(MainActivity.this, Xq_Activity.class));
                break;
        }
    }
}

