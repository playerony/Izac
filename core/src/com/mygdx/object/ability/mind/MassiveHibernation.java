/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.mind;

import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;
import com.mygdx.object.ability.fire.FireBall;

/**
 *
 * @author pawel_000
 */
public class MassiveHibernation extends Ability
{
    public MassiveHibernation(Player player, SpellCard spellCard)
    {
        super(player, spellCard);
        
        init();
    }
    
    private void init()
    {
        float shots = 8.0f;
        float radius = 2.0f;
        float xPos = 0.0f;
        float yPos = 0.0f;
        float xV = 0.0f;
        float yV = 0.0f;
        
        for(int i=0 ; i<shots ; i++)
        {
            xV = (float) (radius * Math.sin(2 * Math.PI * (i / shots)));
            yV = (float) (radius * -Math.cos(2 * Math.PI * (i / shots)));
            
            new Hibernation(player, spellCard, xV, yV);
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
