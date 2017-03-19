/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.light;

import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;
import com.mygdx.object.ability.fire.FireBall;

/**
 *
 * @author pawel_000
 */
public class Storm extends Ability
{
    private float shots;

    public Storm(Player player, SpellCard spellCard, float shots)
    {
        super(player, spellCard);
        
        this.shots = shots;
        
        init();
    }
    
    private void init()
    {
        float radius = 2.0f;
        float xV = 0.0f;
        float yV = 0.0f;
        
        for(int i=0 ; i<shots ; i++)
        {
            xV = (float) (radius * Math.sin(2 * Math.PI * (i / shots)));
            yV = (float) (radius * -Math.cos(2 * Math.PI * (i / shots)));
            
            new Lighting(player, spellCard, xV, yV);
        }
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render(float delta)
    {
        
    }
}
