package yanzhikai.indicatedvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yanzhikai.soundutils.SoundsPlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_1,btn_2;
    private SoundsPlayer mSoundsPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);

        mSoundsPlayer = new SoundsPlayer(this,2);
        mSoundsPlayer.loadSounds(this,R.raw.med_ui_wakesound,R.raw.med_ui_wakesound_touch);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                mSoundsPlayer.play(R.raw.med_ui_wakesound);
                break;
            case R.id.btn_2:
                mSoundsPlayer.play(R.raw.med_ui_wakesound_touch);
                break;
        }
    }
}
