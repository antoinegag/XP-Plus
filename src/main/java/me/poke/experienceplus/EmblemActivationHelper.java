package me.poke.experienceplus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

import java.util.Random;

public class EmblemActivationHelper {

    public static void playActivationSound(World world, EntityPlayer player) {
        SoundEvent sound = SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE;
        world.playSound(null, player.posX, player.posY, player.posZ, sound, SoundCategory.PLAYERS, 2.0F, 0.2F);
    }

    public static void createActivationAura(World world, EntityPlayer player) {
        BlockPos min = player.getPosition().subtract(new Vec3i(1, 0, 1));
        BlockPos max = player.getPosition().add(new Vec3i(1, 0, 1));
        Iterable<BlockPos> area = BlockPos.getAllInBox(min, max);
        for (BlockPos pos : area) {
            double x = pos.getX(), y = pos.getY(), z = pos.getZ();
            spawnAreaParticle(world, EnumParticleTypes.PORTAL, new Random(), x, y + 1.5, z);
            spawnAreaParticle(world, EnumParticleTypes.PORTAL, new Random(), x, y + 0.5, z);
        }
    }

    protected static void spawnAreaParticle(
            World world, EnumParticleTypes particle, Random random, double x, double y, double z) {
        world.spawnParticle(particle, x - 0.5, y, z, -(random.nextFloat() % 2),  0,  0);
        world.spawnParticle(particle, x, y, z - 0.5,  0,  0, -(random.nextFloat() % 2));
        world.spawnParticle(particle, x - 0.5, y, z - 0.5, -(random.nextFloat() % 2),  0,  -(random.nextFloat() % 2));
        world.spawnParticle(particle, x, y, z,  0,  0,  0);
        world.spawnParticle(particle, x + 0.5, y, z + 0.5, (random.nextFloat() % 2),  0,  (random.nextFloat() % 2));
        world.spawnParticle(particle, x, y, z + 0.5,  0,  0, (random.nextFloat() % 2));
        world.spawnParticle(particle, x + 0.5, y, z, (random.nextFloat() % 2),  0,  0);
    }

}
