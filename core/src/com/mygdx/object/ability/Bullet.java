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
public class Bullet extends Ability
{

    public Bullet(Player player, SpellCard spellCard, float r, Color color, float xVel, float yVel)
    {
        super(player, spellCard, r, color);
        
        this.xVel = xVel;
        this.yVel = yVel;
        
        player.getAbilityController().addAbility(this);
    }
    
    public Bullet(Player player, SpellCard spellCard, float r, Color color, float x, float y, float xVel, float yVel)
    {
        this(player, spellCard, r, color, xVel, yVel);
        
        this.x = x;
        this.y = y;
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
