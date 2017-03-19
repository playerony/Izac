/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.other;

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
    private static float timeState;

    public ThrowGarnet(Player player, SpellCard spellCard)
    {
        super(player, spellCard);

        this.timeState = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        x+=xVel;
        y+=yVel;
        
        xVel *= Constants.FRICTION;
        yVel *= Constants.FRICTION;
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState>=1.0f){
            new Garnet(player, spellCard, x, y, r);
            player.getAbilityController().removeAbility(this);
            
            timeState = 0.0f;
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
