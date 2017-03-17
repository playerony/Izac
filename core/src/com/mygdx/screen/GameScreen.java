/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.screen;

import com.mygdx.game.MyGdxGame;
import com.mygdx.object.Enemy;
import com.mygdx.object.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pawel_000
 */
public class GameScreen extends AbstractScreen
{
    private ArrayList<Enemy> enemies;
    
    private Player player;

    public GameScreen(MyGdxGame gdxGame)
    {
        super(gdxGame);
        
        init();
    }

    @Override
    protected void init() 
    {
        player = new Player(50, 50);
        enemies = new ArrayList<Enemy>();
        
        initEnemies();
    }
    
    private void initEnemies()
    {
        Random random = new Random();
        
        int x = 0;
        int y = 0;
        
        for(int i=0 ; i<55 ; i++)
        {
            enemies.add(new Enemy(random.nextInt(3) + 1, 75 + 75 * x, 100 + 75 * y));
            
            x++;
            
            if(x > 10)
            {
                x = 0;
                y++;
            }
        }
    }
    
    private void renderEnemies(float delta)
    {
        for(Enemy e : enemies)
        {
            e.render(delta);
        }
    }

    @Override
    public void render(float delta) 
    {
        super.render(delta);

        player.update();
        player.render(delta);
        
        renderEnemies(delta);
    }
}
