package me.poke.experienceplus.util;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Methods and values borrowed with love from OpenModsLib
 * @see <a href="https://git.io/v5t9T">EnchantmentUtils.java</a>
 */

public class ExpLevelHelper {

    public static int getExperienceForLevel(int level) {
        if (level == 0) return 0;
        if (level > 0 && level < 16) return level * 17;
        if (level > 15 && level < 31) return (int) (1.5 * Math.pow(level, 2) - 29.5 * level + 360);
        return (int)(3.5 * Math.pow(level, 2) - 151.5 * level + 2220);
    }

    public static int getLevelForExperience(int experience) {
        int i = 0;
        while (getExperienceForLevel(i) <= experience) i++;
        return i - 1;
    }

    public static int getPlayerExp(EntityPlayer player) {
        return (int) (getExperienceForLevel(player.experienceLevel) + (player.experience * player.xpBarCap()));
    }

    public static void addPlayerExp(EntityPlayer player, int amount) {
        int experience = getPlayerExp(player) + amount;
        player.experienceTotal = experience;
        player.experienceLevel = getLevelForExperience(experience);
        int expForLevel = getExperienceForLevel(player.experienceLevel);
        player.experience = (float) (experience - expForLevel) / (float) player.xpBarCap();
    }

    public static void removePlayerExp(EntityPlayer player, int amount) {
        addPlayerExp(player, -amount);
    }

}
