package com.robertx22.mine_and_slash.data_generation.compatible_items;

import com.robertx22.mine_and_slash.database.compatible_item.CompatibleItem;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.onevent.data_gen.providers.SlashDataProvider;
import net.minecraft.data.DataGenerator;

import java.nio.file.Path;
import java.util.List;

public class CompatibleItemProvider extends SlashDataProvider<CompatibleItem> {

    public CompatibleItemProvider(DataGenerator gen, List<CompatibleItem> list, String category) {
        super(gen, list, category);
    }

    @Override
    public Path resolve(Path path, CompatibleItem object) {
        return path.resolve(
            "data/" + Ref.MODID + "/" + category + "/" + object.datapackFolder() + object.getFileName() +
                ".json");
    }

}
