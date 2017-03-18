/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.fire;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class Aurelion extends Ability
{
    private float angle;
    private float rotate;
    private float timeState;
    
    public Aurelion(Player player, SpellCard spellCard)
    {
        super(player, spellCard);
        
        this.xVel = 0.0f;
        this.yVel = 0.0f;
        this.angle = 0.0f;
        this.rotate = 0.0f;
    }

    @Override
    public void update()
    {
        x = player.getX();
        y = player.getY();
        
        x += xVel;
        y += yVel;
        
        angle += 0.1f;
            
        if(angle >= 360.0f)
            angle = 0.0f;
            
        if(rotate < 100.0f)
            rotate += 0.5f;
            
        xVel = rotate * (float) Math.sin(angle);
        yVel = rotate * (float) -Math.cos(angle);
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.FIREBRICK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
}
