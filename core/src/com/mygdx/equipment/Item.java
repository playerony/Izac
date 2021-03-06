/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.equipment;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.util.Path;

/**
 *
 * @author pawel_000
 */
public class Item implements Iconable
{   
    public String name;
    public String file;
    public String description;
    
    public boolean packable;
    public boolean isPermanent;
    
    public float bonus;
    
    public int time;
    public int buy;
    public int sell;
    
    public ItemType itemType;
    public EffectType effectType;
    
    public Item(JsonValue json)
    {
        this.file = json.getString("file");
        this.name = json.getString("name");
        this.description = json.getString("description");
        
        this.packable = json.has("packable") ? json.getBoolean("packable") : true;
        this.isPermanent = json.has("isPermanent") ? json.getBoolean("isPermanent") : false;
        
        this.bonus = json.has("bonus") ? json.getFloat("bonus") : 0.0f;
        this.time = json.has("time") ? json.getInt("time") : 0;
        this.buy = json.has("buy") ? json.getInt("buy") : 0;
        this.sell = json.has("sell") ? json.getInt("sell") : 0;
        
        this.itemType = ItemType.valueOf(json.getString("itemType"));
        this.effectType = EffectType.valueOf(json.getString("type"));
    }
    
    public Texture getIcon()
    {
        return new Texture(Path.ICON_PATH + itemType.toString() + "s/" + file);
    }
}
