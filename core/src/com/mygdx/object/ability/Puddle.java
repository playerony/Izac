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
public class Puddle extends Ability
{

    public Puddle(Player player, SpellCard spellCard, float r, Color color, float x, float y)
    {
        super(player, spellCard, r, color);
        
        this.x = x;
        this.y = y;
        this.xVel = 0.0f;
        this.yVel = 0.0f;
        
        player.getAbilityController().addAbility(this);
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
