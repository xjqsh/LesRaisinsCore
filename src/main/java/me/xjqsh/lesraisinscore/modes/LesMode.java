package me.xjqsh.lesraisinscore.modes;

import me.xjqsh.lesraisinscore.rooms.LesRoom;

public abstract class LesMode{
    protected LesRoom room;
    public abstract void end();
    public abstract boolean canStart();
    public abstract void start();
    protected void unregister(){room=null;}
}
