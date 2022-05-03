package com.example.animalesekeyboard;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.HashMap;
import java.util.Map;

public class Animalese {

    private Map<String, Integer> charToSound;

    public Animalese() {
        charToSound = new HashMap<>();

        charToSound.put("a", R.raw.a);
        charToSound.put("b", R.raw.b);
        charToSound.put("c", R.raw.c);
        charToSound.put("d", R.raw.d);
        charToSound.put("e", R.raw.e);
        charToSound.put("f", R.raw.f);
        charToSound.put("g", R.raw.g);
        charToSound.put("h", R.raw.h);
        charToSound.put("i", R.raw.i);
        charToSound.put("j", R.raw.j);
        charToSound.put("k", R.raw.k);
        charToSound.put("l", R.raw.l);
        charToSound.put("m", R.raw.m);
        charToSound.put("n", R.raw.n);
        charToSound.put("o", R.raw.o);
        charToSound.put("p", R.raw.p);
        charToSound.put("q", R.raw.q);
        charToSound.put("r", R.raw.r);
        charToSound.put("s", R.raw.s);
        charToSound.put("t", R.raw.t);
        charToSound.put("u", R.raw.u);
        charToSound.put("v", R.raw.v);
        charToSound.put("w", R.raw.w);
        charToSound.put("x", R.raw.x);
        charToSound.put("y", R.raw.y);
        charToSound.put("z", R.raw.z);
    }

    public void playSound(Context context, String letter) {
        if (charToSound.containsKey(letter)) {
            MediaPlayer music = MediaPlayer.create(context, charToSound.get(letter));
            music.start();
        }
    }
}
