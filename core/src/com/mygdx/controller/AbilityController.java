/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.controller;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.equipment.SpellCard;
import com.mygdx.game.MyGdxGame;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;
import com.mygdx.object.ability.Aurelion;
import com.mygdx.object.ability.Bullet;
import com.mygdx.object.ability.BulletWave;
import com.mygdx.object.ability.District;
import com.mygdx.object.ability.PuddleBall;
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
    
    public void shoot(SpellCard spellCard)
    {
        int abilityID = 0;
        
        if(spellCard != null)
        {
            abilityID = spellCard.id;
        }
        
        switch(abilityID)
        {
            case 0:
                new District(player, spellCard, Color.CYAN);
                break;
                
            case 1:
                
                break;
                
            case 2:
                
                break;
                
            case 3:
                
                break;
                
            case 4:
                
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
