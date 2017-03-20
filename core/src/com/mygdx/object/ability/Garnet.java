/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.mygdx.object.ability.Bullet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import java.util.Random;

/**
 *
 * @author pawel_000
 */
public class Garnet extends Ability
{
    private int power = 20;
    
    private float timeState = 0.0f;
    private float elementSize = 5.0f;
    
    public Garnet(Player player, SpellCard spellCard, float r, Color color)
    {
        super(player, spellCard, r, color);
        
        player.getAbilityController().addAbility(this);
    }
    
    public Garnet(Player player, SpellCard spellCard, float r, Color color, float x, float y)
    {
        this(player, spellCard, r, color);
        
        this.x = x;
        this.y = y;
    }

    @Override
    public void update()
    {
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState>=2.0f){
            Random random = new Random();
            
            for(int i=0 ; i<10 ; i++){
                int xV = 0;
                int yV = 0;
                
                do{
                  xV = random.nextInt(power) - power / 2;
                  yV = random.nextInt(power) - power / 2;
                }while(xV == 0 || yV == 0);
                
                new Bullet(player, spellCard, elementSize, color, x, y, xV, yV);
             }
            
            player.getAbilityController().removeAbility(this);
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(color);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
    
}
