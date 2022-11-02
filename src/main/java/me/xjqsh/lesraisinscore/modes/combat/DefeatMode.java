package me.xjqsh.lesraisinscore.modes.combat;

import me.xjqsh.lesraisinscore.rooms.LesRoom;

public class DefeatMode extends CombatMode{
    public DefeatMode(LesRoom room) {
        super(room);
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean end() {
        return false;
    }

    @Override
    public boolean canStart() {
        return false;
    }
}
