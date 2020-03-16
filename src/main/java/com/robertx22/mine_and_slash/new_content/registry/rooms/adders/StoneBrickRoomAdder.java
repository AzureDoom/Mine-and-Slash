package com.robertx22.mine_and_slash.new_content.registry.rooms.adders;

import com.robertx22.mine_and_slash.new_content.enums.RoomGroup;
import com.robertx22.mine_and_slash.new_content.enums.RoomType;
import com.robertx22.mine_and_slash.new_content.registry.rooms.base.BaseRoomAdder;

public class StoneBrickRoomAdder extends BaseRoomAdder {

    public StoneBrickRoomAdder() {
        super(RoomGroup.STONE_BRICK);
    }

    @Override
    public void addAllRooms() {

        add("drowned_puzzle", RoomType.CURVED_HALLWAY);

        add("dark_lever", RoomType.FOUR_WAY);
        add("hidden_ceiling", RoomType.FOUR_WAY);

        add("crypt", RoomType.STRAIGHT_HALLWAY);
        add("fast_or_slow", RoomType.STRAIGHT_HALLWAY);

    }
}