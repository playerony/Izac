/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.ice;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class IceWave extends Ability
{
    private float timeState;

    public IceWave(Player player, SpellCard spellCard)
    {
        super(player, spellCard);
        
        this.r = 0.0f;
        this.timeState = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        r += 1.3f;
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 5.0f)
        {
            player.getAbilityController().removeAbility(this);
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.OLIVE);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
    
}
