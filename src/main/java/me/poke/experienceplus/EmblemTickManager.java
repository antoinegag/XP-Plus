package me.poke.experienceplus;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence.Wrapper;
import me.poke.experienceplus.items.emblem.IEmblem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("ConstantConditions")
@Mod.EventBusSubscriber(modid = ExperiencePlus.MOD_ID)
public class EmblemTickManager {

    private static final Equivalence<ItemStack> STACK_EQUIVALENCE = new Equivalence<ItemStack>() {

        @Override
        protected boolean doEquivalent(@Nonnull ItemStack a, @Nonnull ItemStack b) {
            return ItemStack.areItemsEqualIgnoreDurability(a, b);
        }

        @Override
        protected int doHash(@Nonnull ItemStack stack) {
            int result = stack.getItem().getRegistryName().hashCode();
            result = 31 * result + stack.getMaxDamage();
            result = 31 * result + (stack.hasTagCompound() ?
                    stack.getTagCompound().hashCode() : 0);
            return result;
        }

    };

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        NonNullList<Wrapper<ItemStack>> cache = NonNullList.create();

        for (ItemStack stack : event.player.inventory.mainInventory) {
            if (stack.getItem() instanceof IEmblem) {
                Wrapper<ItemStack> target = STACK_EQUIVALENCE.wrap(stack);
                if (!cache.contains(target)) {
                    cache.add(target);
                }
            }
        }

        for (Wrapper<ItemStack> stack : cache) {
            ItemStack emblem = stack.get();
            ((IEmblem) emblem.getItem()).onEmblemTick(emblem, event.player);
        }

    }

}
