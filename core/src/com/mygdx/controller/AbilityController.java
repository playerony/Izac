/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.controller;

import com.mygdx.equipment.SpellCard;
import com.mygdx.game.MyGdxGame;
import com.mygdx.object.Player;
import com.mygdx.object.SpellIdentity;
import com.mygdx.object.ability.Ability;
import com.mygdx.object.ability.fire.FireBall;
import com.mygdx.object.ability.fire.HellFire;
import com.mygdx.object.ability.fire.LavaBall;
import java.util.ArrayList;

/**
 *
 * @author pawel_000
 */
public class AbilityController
{
    private Player player;
    
    private ArrayList<Ability> abilities;
    private ArrayList<Ability> waitingAbilities;
    private ArrayList<Ability> toRemoveAbilities;
    
    public AbilityController(Player player)
    {
        this.player = player;
        
        init();
    }
    
    private void init()
    {
        abilities = new ArrayList<Ability>();
        waitingAbilities = new ArrayList<Ability>();
        toRemoveAbilities = new ArrayList<Ability>();
    }
    
    public void shoot(SpellIdentity spellIdentity, SpellCard spellCard)
    {
        switch(spellIdentity)
        {
            case SPELL_0:
                
                break;
                
            case SPELL_1:
                new FireBall(player, spellCard, player.getxVel(), player.getyVel());
                break;
                
            case SPELL_2:
                new LavaBall(player, spellCard, player.getxVel(), player.getyVel());
                break;
                
            case SPELL_3:
                new HellFire(player, spellCard);
                break;
        }
    }
    
    public void render(float delta)
    {
         for(Ability a : abilities)
        {
            a.render(delta);
        }
    }
    
    public void update()
    {
        for(Ability a : abilities)
        {
            a.update();
            
            if(a.getX() < 0 || a.getX() > MyGdxGame.SCREEN_WIDTH || a.getY() < 0 || a.getY() > MyGdxGame.SCREEN_HEIGHT)
                toRemoveAbilities.add(a);
        }
        
        for(Ability a : waitingAbilities)
        {
            abilities.add(a);
        }
        
        for(Ability a : toRemoveAbilities)
        {
            abilities.remove(a);
        }
        
        if(!toRemoveAbilities.isEmpty())
            toRemoveAbilities.clear();
        
        if(!waitingAbilities.isEmpty())
            waitingAbilities.clear();
    }

    public ArrayList<Ability> getAbilities()
    {
        return abilities;
    }
    
    public void addAbility(Ability a)
    {
        waitingAbilities.add(a);
    }
    
    public void removeAbility(Ability a)
    {
        toRemoveAbilities.add(a);
    }
}
