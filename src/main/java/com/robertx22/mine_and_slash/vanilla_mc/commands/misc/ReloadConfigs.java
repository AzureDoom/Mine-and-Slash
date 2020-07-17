package com.robertx22.mine_and_slash.vanilla_mc.commands.misc;

import com.mojang.brigadier.CommandDispatcher;
import com.robertx22.mine_and_slash.vanilla_mc.commands.CommandRefs;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ConfigRegister;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

import static net.minecraft.command.Commands.literal;

public class ReloadConfigs {
    public static void register(CommandDispatcher<CommandSource> commandDispatcher) {
        commandDispatcher.register(

            literal(CommandRefs.ID)
                .then(literal("configs").requires(e -> e.hasPermissionLevel(2))
                    .then(literal("reload")

                        .requires(e -> e.hasPermissionLevel(2))
                        .executes(ctx -> run(ctx.getSource())))));
    }

    private static int run(CommandSource source) {

        try {

            ConfigRegister.registerCustomConfigs();

            if (source.getEntity() instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity) source.getEntity()).sendMessage(new StringTextComponent("Configs reloaded"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
}
