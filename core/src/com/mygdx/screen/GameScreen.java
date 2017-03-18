/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.screen;

import com.mygdx.controller.EnemyController;
import com.mygdx.controller.ItemController;
import com.mygdx.game.MyGdxGame;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public class GameScreen extends AbstractScreen
{
    private Player player;
    
    private EnemyController enemyController;
    private ItemController itemController;

    public GameScreen(MyGdxGame gdxGame)
    {
        super(gdxGame);
        
        init();
    }

    @Override
    protected void init() 
    {
        player = new Player(50, 50);

        itemController = new ItemController(player);
        enemyController = new EnemyController(itemController);
    }

    @Override
    public void render(float delta) 
    {
        super.render(delta);

        player.update();
        player.render(delta);
        
        enemyController.render(delta);
        enemyController.update(player);
        
        itemController.render(delta);
    }
}
