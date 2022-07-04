package com.example.animalesekeyboard;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Map;


public class Animalese {

    private static final int MAX_STREAMS = 6;
    private SoundPool soundPool;
    private Map<String, Integer> charToCode;

    public Animalese(Context context) {
        charToCode = new HashMap<>();

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(MAX_STREAMS)
                .setAudioAttributes(audioAttributes)
                .build();

        charToCode.put("a", soundPool.load(context, R.raw.a, 1));
        charToCode.put("b", soundPool.load(context, R.raw.b, 1));
        charToCode.put("c", soundPool.load(context, R.raw.c, 1));
        charToCode.put("d", soundPool.load(context, R.raw.d, 1));
        charToCode.put("e", soundPool.load(context, R.raw.e, 1));
        charToCode.put("f", soundPool.load(context, R.raw.f, 1));
        charToCode.put("g", soundPool.load(context, R.raw.g, 1));
        charToCode.put("h", soundPool.load(context, R.raw.h, 1));
        charToCode.put("i", soundPool.load(context, R.raw.i, 1));
        charToCode.put("j", soundPool.load(context, R.raw.j, 1));
        charToCode.put("k", soundPool.load(context, R.raw.k, 1));
        charToCode.put("l", soundPool.load(context, R.raw.l, 1));
        charToCode.put("m", soundPool.load(context, R.raw.m, 1));
        charToCode.put("n", soundPool.load(context, R.raw.n, 1));
        charToCode.put("o", soundPool.load(context, R.raw.o, 1));
        charToCode.put("p", soundPool.load(context, R.raw.p, 1));
        charToCode.put("q", soundPool.load(context, R.raw.q, 1));
        charToCode.put("r", soundPool.load(context, R.raw.r, 1));
        charToCode.put("s", soundPool.load(context, R.raw.s, 1));
        charToCode.put("t", soundPool.load(context, R.raw.t, 1));
        charToCode.put("u", soundPool.load(context, R.raw.u, 1));
        charToCode.put("v", soundPool.load(context, R.raw.v, 1));
        charToCode.put("w", soundPool.load(context, R.raw.w, 1));
        charToCode.put("x", soundPool.load(context, R.raw.x, 1));
        charToCode.put("y", soundPool.load(context, R.raw.y, 1));
        charToCode.put("z", soundPool.load(context, R.raw.z, 1));
    }

    public void playSound(String letter) {
        if(charToCode.containsKey(letter))
            soundPool.play(charToCode.get(letter), 1, 1, 0, 0, 1);
    }

    public boolean isPresent(String letter) {
        return charToCode.containsKey(letter);
    }
}
