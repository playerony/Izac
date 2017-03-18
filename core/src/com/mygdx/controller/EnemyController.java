/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.controller;

import com.mygdx.equipment.generate.ItemCreator;
import com.mygdx.object.Enemy;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pawel_000
 */
public class EnemyController
{
    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> toRemoveEnemies;
    
    private ItemController itemController;
    
    public EnemyController(ItemController itemController)
    {
        init();
        
        this.itemController = itemController;
    }

    private void init()
    {
        enemies = new ArrayList<Enemy>();
        toRemoveEnemies = new ArrayList<Enemy>();
        
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
    
    public void render(float delta)
    {
        for(Enemy e : enemies)
        {
            e.render(delta);
        }
    }
    
    public void update(Player player)
    {
        for(Enemy e : enemies)
        {
            for(Ability a : player.getAbilityController().getAbilities())
            {
                if(a.isCircleCollision(e))
                {
                    player.getAbilityController().removeAbility(a);
                    
                    if(!toRemoveEnemies.contains(e))
                        toRemoveEnemies.add(e);
                }
            }
        }
        
        for(Enemy e : toRemoveEnemies)
        {
            itemController.addRandomItem(e.getMobRank(), e.getX(), e.getY());
            
            enemies.remove(e);
        }
        
        if(!toRemoveEnemies.isEmpty())
            toRemoveEnemies.clear();
    }
}
