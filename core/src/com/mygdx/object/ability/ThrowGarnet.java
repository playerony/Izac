/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.mygdx.object.ability.Garnet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;
import com.mygdx.util.Constants;

/**
 *
 * @author pawel_000
 */
public class ThrowGarnet extends Ability
{
    private float timeState = 0.0f;

    public ThrowGarnet(Player player, SpellCard spellCard, float r, Color color)
    {
        super(player, spellCard, r, color);
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        super.update();
        
        xVel *= Constants.FRICTION;
        yVel *= Constants.FRICTION;
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState>=1.0f)
        {
            new Garnet(player, spellCard, r, color, x, y);
            player.getAbilityController().removeAbility(this);
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.FOREST);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
    
}
