package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        
        config.title = MyGdxGame.GAME_NAME;
        config.width = MyGdxGame.SCREEN_WIDTH;
        config.height = MyGdxGame.SCREEN_HEIGHT;
        config.resizable = false;
        
        new LwjglApplication(new MyGdxGame(), config);
    }
}
