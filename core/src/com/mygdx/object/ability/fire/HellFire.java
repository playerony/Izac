/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.fire;

import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class HellFire extends Ability
{

    public HellFire(Player player, SpellCard spellCard)
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
            
            player.getAbilityController().addAbility(new FireBall(player, spellCard, xV, yV));
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
