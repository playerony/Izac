/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public class AurelionBall extends Ability
{
    private float angle = 0.0f;
    private float rotate = 0.0f;

    public AurelionBall(Player player, SpellCard spellCard, float r, Color color)
    {
        super(player, spellCard, r, color);
        
        this.xVel = 0.0f;
        this.yVel = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }
    
    @Override
    public void update()
    {
        x = player.getX();
        y = player.getY();
        
        angle += 0.1f;
            
        if(angle >= 360.0f)
            angle = 0.0f;
            
        if(rotate < 100.0f)
            rotate += 0.5f;
            
        xVel = rotate * (float) Math.sin(angle);
        yVel = rotate * (float) -Math.cos(angle);
        
        x += xVel;
        y += yVel;
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
