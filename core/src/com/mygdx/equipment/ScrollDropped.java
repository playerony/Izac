/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.equipment;

import com.mygdx.object.Entity;

/**
 *
 * @author pawel_000
 */
public class ScrollDropped
{
    private Entity entity = null;
    private SpellCard spellCard = null;
    
    public ScrollDropped(SpellCard spellCard, float x, float y)
    {
        entity = new Entity(x, y);
        this.spellCard = spellCard;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public SpellCard getSpellCard()
    {
        return spellCard;
    }
}
