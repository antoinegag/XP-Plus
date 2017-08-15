package me.poke.experienceplus.items.emblem;

import me.poke.experienceplus.EmblemActivationHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public interface IEmblem {

    enum EmblemType { MANUAL, TOGGLEABLE }
    EmblemType getEmblemType();

    int getLevelCost();

    default boolean isEmblemEnabled(ItemStack stack) {
        return  !getEmblemType().equals(EmblemType.TOGGLEABLE)
                || ((stack.hasTagCompound()
                && stack.getTagCompound() != null
                && stack.getTagCompound().getBoolean("enabled")));
    }

    default boolean onUseEmblem(World world, EntityPlayer player) {
        return false;
    }

    default void onEmblemTick(ItemStack stack, EntityPlayer player) {
        // no-op
    }

    default boolean toggleEmblemState(World world, EntityPlayer player, EnumHand hand) {
        if (!getEmblemType().equals(EmblemType.TOGGLEABLE)) return false;
        ItemStack stack = player.getHeldItem(hand);
        if (stack.hasTagCompound() && stack.getTagCompound() != null) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (!nbt.getBoolean("activated")) {
                if (tryActivateEmblem(world, player, hand)) {
                    nbt.setBoolean("activated", true);
                } else {
                    String key = "message.experienceplus.no_experience";
                    player.sendStatusMessage(new TextComponentTranslation(key), true);
                }
            } else {
                boolean state = nbt.getBoolean("enabled");
                world.playSound(null, player.posX, player.posY, player.posZ,
                SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.PLAYERS,
                0.5F, (state ? 0.1F : 0.8F));
                nbt.setBoolean("enabled", !state);
            }
            return true;
        }
        return false;
    }

    default boolean tryActivateEmblem(World world, EntityPlayer player, EnumHand hand) {
        if (player.experienceLevel >= getLevelCost()) {
            if (onUseEmblem(world, player)) {
                player.experienceLevel -= getLevelCost();
                EmblemActivationHelper.playActivationSound(world, player);
                EmblemActivationHelper.createActivationAura(world, player);
                if (getEmblemType().equals(EmblemType.MANUAL)) {
                    player.getHeldItem(hand).damageItem(1, player);
                }
                return true;
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    default List<String> getEmblemTooltip(ItemStack stack) {
        List<String> tooltip = new ArrayList<>();
        if (stack.hasTagCompound() && stack.getTagCompound() != null) {
            if (stack.getTagCompound().getBoolean("activated")) {
                boolean enabled = stack.getTagCompound().getBoolean("enabled");
                tooltip.add(I18n.format("tooltip.experienceplus." + (enabled ? "disable" : "enable")));
            } else {
                tooltip.add(I18n.format("tooltip.experienceplus.activate", getLevelCost()));
            }
        }
        return tooltip;
    }

}
