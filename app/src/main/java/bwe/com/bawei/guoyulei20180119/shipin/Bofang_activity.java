package bwe.com.bawei.guoyulei20180119.shipin;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import bwe.com.bawei.guoyulei20180119.R;

public class Bofang_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bofang_activity);
        View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);
        String url = Environment.getExternalStorageDirectory() + "/haodeba.mp4";
        new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();
    }
}
