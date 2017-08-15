package me.poke.experienceplus.items.emblem;

import me.poke.experienceplus.items.ItemEmblem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EmblemHealing extends ItemEmblem implements IEmblem {

    private final int cost;
    private final float health;

    public EmblemHealing(String name, int cost, float health) {
        super(name);
        this.cost = cost;
        this.health = health;
        setMaxDamage(15);
    }

    @Override
    public boolean onUseEmblem(World world, EntityPlayer player) {
        if (player.shouldHeal()) {
            player.heal(health);
            player.getCooldownTracker().setCooldown(this, 600);
            return true;
        } return false;
    }

    @Override
    public EmblemType getEmblemType() {
        return EmblemType.MANUAL;
    }

    @Override
    public int getLevelCost() {
        return cost;
    }

}
