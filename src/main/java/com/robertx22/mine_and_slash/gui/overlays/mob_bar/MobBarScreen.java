package com.robertx22.mine_and_slash.gui.overlays.mob_bar;

import com.robertx22.mine_and_slash.config.forge.ClientContainer;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.GuiUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.LookUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MobBarScreen extends AbstractGui {

    private Minecraft mc;

    ResourceLocation TEX = new ResourceLocation(Ref.MODID, "textures/gui/mob_bar/mob_bar.png");

    public MobBarScreen(Minecraft mc) {
        super();
        this.mc = mc;

    }

    int xSize = 102;
    int ySize = 7;

    LivingEntity en;
    int ticks = 0;

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderPlayerOverlay(RenderGameOverlayEvent event) {

        try {
            if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
                return;
            }

            if (!ClientContainer.INSTANCE.RENDER_SIMPLE_MOB_BAR.get()) {
                return;
            }

            Entity e = LookUtils.getEntityLookedAt(mc.player);

            if (e instanceof LivingEntity) {
                en = (LivingEntity) e;
            } else {
                ticks++;
                if (ticks > 20) {
                    en = null;
                    ticks = 0;
                }
            }

            if (en != null) {

                EntityCap.UnitData data = Load.Unit(en);

                if (data != null && data.getUnit() != null) {
                    int currentHp = (int) data.getUnit()
                        .getCurrentEffectiveHealth(en, data);
                    int maxHP = (int) en.getMaxHealth();
                    int percent = Math.round((float) currentHp / (float) maxHP * 100);

                    int height = mc.mainWindow.getScaledHeight();
                    int width = mc.mainWindow.getScaledWidth();

                    int x = width / 2 - xSize / 2;
                    int y = 30;

                    mc.getTextureManager()
                        .bindTexture(TEX);

                    blit(x, y, 0, 0, xSize, ySize); // the bar

                    blit(x, y, 0, ySize, (int) ((float) xSize * percent / 100F), ySize); // inner fill texture

                    String name = CLOC.translate(data.getName(en));

                    mc.fontRenderer.drawStringWithShadow(name, width / 2 - mc.fontRenderer.getStringWidth(name) / 2,
                        y - 10, TextFormatting.WHITE.getColor()
                    );

                    String hpText = (int) currentHp + "/" + (int) maxHP;

                    GuiUtils.renderScaledText(
                        width / 2, (int) (y + (float) ySize / 2) + 1, 0.75F, hpText, TextFormatting.GREEN);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
