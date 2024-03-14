package me.wacko.basiceconomy.auction.model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Auction {

    private final ItemStack item;
    private final Player host;
    private final int id;
    private final long duration;
    private long endTime;

    private boolean started;
    private boolean ended;

    public Auction(ItemStack item, int id, Player host, long duration){
        this.item = item;
        this.id = id;
        this.host = host;
        this.duration = duration;
    }

    public void start(){

        if(isStarted()) return;
        if(isEnded()) return;

        started = true;
    }

    public ItemStack getItem(){return item;}
    public Player getHost(){return host;}
    public int getId(){return id;}
    public long getDuration(){return duration;}
    public boolean isStarted(){return started;}
    public boolean isEnded(){return ended;}

}
