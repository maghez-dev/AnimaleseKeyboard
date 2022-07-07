package com.example.animalesekeyboard;

import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class AnimaleseKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;
    private Animalese animaleseSounds;

    private boolean isCaps = false;
    private boolean isSymbol = false;

    // Press Ctrl+O to override methods

    @SuppressLint("InflateParams")
    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard,null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);

        animaleseSounds = new Animalese(this);
        return kv;
    }

    @Override
    public void onPress(int i) {
    }

    @Override
    public void onRelease(int i) {
    }

    @Override
    public void onKey(int i, int[] ints) {
        InputConnection ic = getCurrentInputConnection();

        switch (i) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1,0);
                playClick(i);
                break;
            case Keyboard.KEYCODE_SHIFT:
                isCaps = !isCaps;
                keyboard.setShifted(isCaps);
                kv.invalidateAllKeys();
                playClick(i);
                break;
            case Keyboard.KEYCODE_MODE_CHANGE:
                if (isSymbol)
                    keyboard = new Keyboard(this, R.xml.qwerty);
                else
                    keyboard = new Keyboard(this, R.xml.symbols);
                isSymbol = !isSymbol;
                kv.setKeyboard(keyboard);
                keyboard.setShifted(isCaps);
                kv.invalidateAllKeys();
                playClick(i);
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                playClick(i);
                break;
            default:
                char code = (char)i;
                if(Character.isLetter(code) && isCaps)
                    code = Character.toUpperCase(code);
                ic.commitText(String.valueOf(code),1);

                if(animaleseSounds.isPresent(String.valueOf(code).toLowerCase()))
                    animaleseSounds.playSound(String.valueOf(code).toLowerCase());
                else
                    playClick(i);
        }
    }

    private void playClick(int i) {
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        assert am != null;
        switch(i) {
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeUp() {
    }
}