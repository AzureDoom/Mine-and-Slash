package com.robertx22.mine_and_slash.commands.dev.unique_dungeon;

import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DunExportData {

    public static HashMap<PlayerEntity, DunExportData> MAP = new HashMap<>();

    public static void init(PlayerEntity player) {
        if (!MAP.containsKey(player)) {
            MAP.put(player, new DunExportData());
        }
    }

    public enum PosType {
        ENTRANCE, FIRST, LAST
    }

    BlockPos entrancePos;

    BlockPos firstPos;
    BlockPos lastPos;

    public int getStartY() {

        if (firstPos.getY() < lastPos.getY()) {
            return firstPos.getY();
        } else {
            return lastPos.getY();
        }

    }

    public void save(ChunkPos cp, PlayerEntity player, String name) {
        ResourceLocation res = new ResourceLocation(Ref.MODID, name);

        BlockPos first = new BlockPos(cp.getXStart(), getStartY(), cp.getZStart());
        BlockPos size = new BlockPos(16, 32, 16);

        ServerWorld world = (ServerWorld) player.world;
        TemplateManager manager = world.getStructureTemplateManager();

        Template template = manager.getTemplateDefaulted(res);

        template.takeBlocksFromWorld(player.world, first, size, false, Blocks.STRUCTURE_VOID);
        template.setAuthor(Ref.MODID);

        manager.writeToFile(res);

    }

    public void exportStructureFiles(PlayerEntity player, String dungeonName) {
        List<ChunkPos> chunks = ChunkPos.getAllInBox(new ChunkPos(firstPos), new ChunkPos(lastPos))
            .collect(Collectors.toList());

        chunks.forEach(x -> {

            ChunkPos norm = getNormalizedChunkPos(chunks, x);

            String name = dungeonName + "/" + norm.x + "-" + norm.z + "";

            save(x, player, name);

        });

    }

    public int getSmallestX(List<ChunkPos> list) {
        return list.stream()
            .min(Comparator.comparingInt(c -> c.x))
            .get().x;
    }

    public int getSmallestZ(List<ChunkPos> list) {
        return list.stream()
            .min(Comparator.comparingInt(c -> c.z))
            .get().z;
    }

    public ChunkPos getNormalizedChunkPos(List<ChunkPos> list, ChunkPos pos) {

        List<ChunkPos> normalized = new ArrayList<>();

        int smallestX = getSmallestX(list);
        int smallestZ = getSmallestZ(list);

        return new ChunkPos(pos.x - smallestX, pos.z - smallestZ);

    }

    public void set(PosType type, BlockPos pos) {
        if (type == PosType.ENTRANCE) {
            this.entrancePos = pos;
        }
        if (type == PosType.FIRST) {
            this.firstPos = pos;
        }
        if (type == PosType.LAST) {
            this.lastPos = pos;
        }

    }

}
