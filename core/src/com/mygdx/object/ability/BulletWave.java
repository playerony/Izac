/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public class BulletWave extends Ability
{
    private float elements = 1.0f;

    public BulletWave(Player player, SpellCard spellCard, float r, Color color, int elements)
    {
        super(player, spellCard, r, color);
        
        this.elements = (float) elements;
                
        init();
        
        player.getAbilityController().addAbility(this);
    }
    
    private void init()
    {
        float radius = 2.0f;
        float xPos = 0.0f;
        float yPos = 0.0f;
        float xV = 0.0f;
        float yV = 0.0f;
        
        for(int i=0 ; i<elements ; i++)
        {
            xV = (float) (radius * Math.sin(2 * Math.PI * (i / elements)));
            yV = (float) (radius * -Math.cos(2 * Math.PI * (i / elements)));
            
            new Bullet(player, spellCard, r, color, xV, yV);
        }
        
        player.getAbilityController().removeAbility(this);
    }

    @Override
    public void render(float delta)
    {
        
    }
    
}
