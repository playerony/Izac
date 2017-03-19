/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.other;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class Bullet extends Ability
{

    public Bullet(Player player, SpellCard spellCard, float xVel, float yVel)
    {
        super(player, spellCard);
        
        this.xVel = xVel;
        this.yVel = yVel;
        
        player.getAbilityController().addAbility(this);
    }
    
    public Bullet(Player player, SpellCard spellCard, float x, float y, float xVel, float yVel)
    {
        super(player, spellCard, x, y);
        
        this.xVel = xVel;
        this.yVel = yVel;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        x += xVel;
        y += yVel;
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
    
}
