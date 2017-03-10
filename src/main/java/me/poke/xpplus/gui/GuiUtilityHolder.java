package me.poke.xpplus.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.io.IOException;

public class GuiUtilityHolder extends GuiScreen {

    GuiButton haste, jump, speed, strength, resistance;

    public static ItemStack stack;

    public GuiUtilityHolder(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
        this.buttonList.add(this.haste = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 42, "Haste: "));
        this.buttonList.add(this.jump = new GuiButton(1, this.width / 2 - 100, this.height / 2 -14, "Jump"));
        this.buttonList.add(this.speed = new GuiButton(2, this.width / 2 - 100, this.height / 2 +14, "Speed"));
        this.buttonList.add(this.strength = new GuiButton(3, this.width / 2 - 100, this.height / 2 + 42, "Strength"));
        this.buttonList.add(this.resistance = new GuiButton(4, this.width / 2 - 100, this.height / 2 + 70, "Resistance"));

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == this.haste) {
            stack.getTagCompound().setBoolean("haste", stack.getTagCompound().getBoolean("haste"));
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
        if (button == this.strength){
            //Main.packetHandler.sendToServer(...);
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
    }

}

