package yanzhikai.soundutils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RawRes;

import java.util.HashMap;

/**
 * Created by yany on 2017/11/17.
 */

public class SoundsPlayer {
    private SoundPool mSoundPool;
    private HashMap<Integer,Integer> mSoundIds;

    public SoundsPlayer(Context context, int maxSounds){
        if (Build.VERSION.SDK_INT >= 21) {
            //SDK_INT >= 21时，才能使用SoundPool.Builder创建SoundPool

            //音频属性
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                    .build();
            mSoundPool = new SoundPool.Builder()
                    //可同时播放的音频流
                    .setMaxStreams(maxSounds)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            //低版本的构造方法，已经deprecated了
            mSoundPool = new SoundPool(maxSounds, AudioManager.STREAM_MUSIC, 0);
        }
        mSoundIds = new HashMap<>();
    }

    public void loadSounds(Context context, @RawRes int... rawIds){
        for (int id : rawIds){
            mSoundIds.put(id,mSoundPool.load(context,id,1));
        }
    }

    public void play(@RawRes int rawId){
        mSoundPool.play(mSoundIds.get(rawId),1,1,1,0,1);
    }
}
