package com.robertx22.mine_and_slash.database.talent_tree.csv_parser;

import com.robertx22.mine_and_slash.registry.SlashRegistry;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.SerializationUtils;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class TalentParser {

    public static void parse() {

        try {
            String path = SerializationUtils.CONFIG_PATH + "talents.csv";

            InputStream input = TalentParser.class.getClassLoader()
                .getResourceAsStream("assets\\mmorpg\\talents.csv");

            String s = IOUtils.toString(input, "utf-8");

            PerkGrid grid = new PerkGrid(s);

            grid.createAndRegisterAll();

            grid.createConnections();

            System.out.println("Registered all " + SlashRegistry.Perks()
                .getSize() + " perks to the talent tree!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
