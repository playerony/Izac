package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.screen.SplashScreen;

public class MyGdxGame extends Game {
    public static String GAME_NAME = "Izac";

    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 480;
	
    @Override
    public void create () {
        this.setScreen(new SplashScreen(this));
    }
}
