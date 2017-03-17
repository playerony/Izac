package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;

/**
 * Created by pawel_000 on 2017-02-25.
 */
public abstract class AbstractScreen implements Screen 
{
    public OrthographicCamera camera;
    public SpriteBatch batch, equipmentBatch;
    public MyGdxGame myGdxGame;
    protected Stage stage;
    public ShapeRenderer shapeRenderer;
    public BitmapFont font;

    public AbstractScreen(MyGdxGame myGdxGame)
    {
        this.myGdxGame = myGdxGame;
        createCamera();
        stage = new Stage(new StretchViewport(MyGdxGame.SCREEN_WIDTH, MyGdxGame.SCREEN_HEIGHT, camera));
        batch = new SpriteBatch();
        equipmentBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);

        init();
    }

    protected abstract void init();

    private void createCamera() 
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, myGdxGame.SCREEN_WIDTH, myGdxGame.SCREEN_HEIGHT);
        camera.update();
    }

    @Override
    public void show() 
    {

    }

    @Override
    public void render(float delta) 
    {
        clearScreen();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() 
    {
        Gdx.gl.glClearColor(0.6f, 0.8f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() 
    {
        
    }

    @Override
    public void pause() 
    {
        
    }

    @Override
    public void dispose() 
    {
        myGdxGame.dispose();
    }

    @Override
    public void resize(int width, int height) 
    {

    }

    @Override
    public void hide() 
    {

    }
}
