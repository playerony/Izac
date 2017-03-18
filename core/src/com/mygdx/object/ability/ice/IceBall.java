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
public class IceBall extends Ability
{
    private float timeState;
    private float lifeTime;
    
    public IceBall(Player player, SpellCard spellCard, float xVel, float yVel)
    {
        super(player, spellCard);
        
        this.xVel = xVel / 10;
        this.yVel = yVel / 10;
        this.timeState = 0.0f;
        this.lifeTime = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }
    
    @Override
    public void update() 
    {
        x += xVel;
        y += yVel;
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 5.0f)
        {
            player.getAbilityController().addAbility(new Ice(player, x, y));
            timeState = 0.0f;
        }
        
        lifeTime+=Gdx.graphics.getDeltaTime();
        if(lifeTime >= 5.0f)
        {
            player.getAbilityController().removeAbility(this);
            lifeTime = 0.0f;
        }
    }

    @Override
    public void render(float delta) 
    {
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, 10.0f);
        shapeRenderer.end();
    }
}
