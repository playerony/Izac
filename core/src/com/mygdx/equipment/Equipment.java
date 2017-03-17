/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.equipment;

import com.badlogic.gdx.Gdx;
import java.util.ArrayList;

/**
 *
 * @author pawel_000
 */
public class Equipment 
{
    private ArrayList<Item> bagpack;
    private SpellCard spellCard = null;
    private float timeState = 0.0f;
    
    public Equipment()
    {
        init();
    }
    
    public void init()
    {
        bagpack = new ArrayList<Item>();
    }
    
    public void update()
    {
        
    }

    public void addItem(Item item)
    {
        if(item != null)
        {
            boolean isAdd = false;
            
            for(Item it : bagpack)
            {
                if(it.name.equals(item.name) && it.packable)
                {
                    it.time += item.time;
                    
                    isAdd = true;
                    
                    break;
                }
            }

            if(!isAdd)
                bagpack.add(item);
        }
    }
    
    public void removeItem(Item item)
    {
        bagpack.remove(item);
    }
    
    public void removeSpell()
    {
        this.spellCard = null;
    }

    public ArrayList<Item> getBagpack()
    {
        return bagpack;
    }

    public SpellCard getSpellCard()
    {
        return spellCard;
    }

    public void setSpellCard(SpellCard spell)
    {
        if(spellCard != null && spellCard.name.equals(spell.name))
            spellCard.time += spell.time;
        else
            spellCard = spell;
    }
}
