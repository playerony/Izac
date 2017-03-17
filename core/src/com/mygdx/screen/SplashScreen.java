package com.mygdx.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.util.Path;

/**
 * Created by pawel_000 on 2017-02-25.
 */
public class SplashScreen extends AbstractScreen 
{
    private Texture texture;

    public SplashScreen(MyGdxGame gdxGame)
    {
        super(gdxGame);

        Timer.schedule(new Timer.Task() 
        {
            @Override
            public void run() 
            {
                myGdxGame.setScreen(new GameScreen(myGdxGame));
            }
        }, 1);
    }

    @Override
    protected void init() 
    {
        texture = new Texture(Path.IMAGE_PATH + "badlogic.jpg");
    }

    @Override
    public void render(float delta) 
    {
        super.render(delta);

        batch.begin();
        batch.draw(texture, 100, 100);
        batch.end();
    }
}
