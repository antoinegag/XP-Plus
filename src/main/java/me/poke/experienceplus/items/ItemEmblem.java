package me.poke.experienceplus.items;

import me.poke.experienceplus.ExperiencePlus;
import me.poke.experienceplus.items.emblem.IEmblem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemEmblem extends Item {

    public ItemEmblem(String name) {
        setRegistryName(name);
        setUnlocalizedName(ExperiencePlus.MOD_ID + "." + name);
        setCreativeTab(ExperiencePlus.CTAB);
        setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (this instanceof IEmblem && !stack.hasTagCompound()) {
            if (((IEmblem) this).getEmblemType().equals(IEmblem.EmblemType.TOGGLEABLE)) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setBoolean("activated", false);
                tag.setBoolean("enabled", false);
                stack.setTagCompound(tag);
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (this instanceof IEmblem && player.isSneaking()) {
            ActionResult<ItemStack> success = new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            if (((IEmblem) this).toggleEmblemState(world, player, hand)) {
                return success;
            } else {
                if (((IEmblem) this).tryActivateEmblem(world, player, hand)) {
                    return success;
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        String key = stack.getUnlocalizedName() + ".tooltip";
        if (I18n.hasKey(key)) {
            // Description tooltips
            tooltip.add(I18n.format(key));
        }
        if (this instanceof IEmblem) {
            tooltip.addAll(((IEmblem) this).getEmblemTooltip(stack));
            if (((IEmblem) this).getEmblemType().equals(IEmblem.EmblemType.MANUAL)) {
                int uses = (stack.getMaxDamage() + 1) - stack.getMetadata();
                tooltip.add(I18n.format("tooltip.experienceplus.remaining_uses", uses));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return this instanceof IEmblem && ((IEmblem) this).isEmblemEnabled(stack);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

}
