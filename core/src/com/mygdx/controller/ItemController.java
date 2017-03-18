/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.equipment.Item;
import com.mygdx.equipment.ScrollDropped;
import com.mygdx.equipment.SpellCard;
import com.mygdx.equipment.generate.ItemCreator;
import com.mygdx.equipment.generate.ItemDropped;
import com.mygdx.equipment.generate.SpellCreator;
import com.mygdx.object.Player;
import java.util.ArrayList;

/**
 *
 * @author pawel_000
 */
public class ItemController
{
    private ArrayList<ItemDropped> itemDropped;
    private ArrayList<ScrollDropped> scrollDropped;
    
    private ItemCreator itemCreator;
    private SpellCreator spellCreator;
    private Player player;
    
    private SpriteBatch batch;
    public BitmapFont font;

    public ItemController(Player player)
    {
        init();
        
        this.player = player;
    }

    private void init()
    {
        itemDropped = new ArrayList<ItemDropped>();
        scrollDropped = new ArrayList<ScrollDropped>();
        
        spellCreator = new SpellCreator();
        itemCreator = new ItemCreator();
                
        batch = new SpriteBatch();
        font = new BitmapFont();
    }
    
    public void render(float delta)
    {
        renderItems(delta);
        renderDescriptions(delta);
    }
    
    public void update()
    {
        for(ItemDropped i : itemDropped)
        {
            if(i.getEntity().isColision(player))
            {
                player.getEquipment().addItem(i.getItem());
                itemDropped.remove(i);
                
                break;
            }
        }
        
        for(ScrollDropped s : scrollDropped)
        {
            if(s.getEntity().isColision(player))
            {
                player.getEquipment().setSpellCard(s.getSpellCard());
                scrollDropped.remove(s);
                
                break;
            }
        }
    }
    
    public void addRandomItem(int mobRank, float x, float y)
    {
        if(!addItemDropped(mobRank, x, y))
        {
            addScrollDropped(mobRank, x, y);
        }
    }
    
    private boolean addItemDropped(int mobRank, float x, float y)
    {
        Item item = itemCreator.createRandomItem(mobRank);
        
        if(item != null)
        {
            ItemDropped it = new ItemDropped(item, x, y);
            itemDropped.add(it);
            
            return true;
        }
        
        return false;
    }
    
    private void addScrollDropped(int mobRank, float x, float y)
    {
        SpellCard spellCard = spellCreator.createSpell(mobRank);
        
        if(spellCard != null)
        {
            ScrollDropped it = new ScrollDropped(spellCard, x, y);
            scrollDropped.add(it);
        }
    }

    private void renderItems(float delta)
    {
        batch.begin();
        
        for(ItemDropped i : itemDropped)
        {
            batch.draw(i.getItem().getIcon(), i.getEntity().getX(), i.getEntity().getY());
        }
        
        for(ScrollDropped s : scrollDropped)
        {
            batch.draw(s.getSpellCard().getIcon(), s.getEntity().getX(), s.getEntity().getY());
        }
        
        batch.end();
    }
    
    private void renderDescriptions(float delta)
    {
        batch.begin();
        
        for(ItemDropped item : itemDropped)
        {
            String str = "Efekt: " + item.getItem().effectType.toString();
            
            batch.draw(item.getItem().getIcon(), item.getEntity().getX(), item.getEntity().getY());
            font.setColor(Color.BLACK);
            font.draw(batch, str.toString(), item.getEntity().getX() - 25, item.getEntity().getY() + 50);
        }
        
        for(ScrollDropped scroll : scrollDropped)
        {
            String str = "Spell name: " + scroll.getSpellCard().name;
            
            batch.draw(scroll.getSpellCard().getIcon(), scroll.getEntity().getX(), scroll.getEntity().getY());
            font.setColor(Color.BLACK);
            font.draw(batch, str.toString(), scroll.getEntity().getX() - 50, scroll.getEntity().getY() + 50);
        }
        
        batch.end();
    }
}
