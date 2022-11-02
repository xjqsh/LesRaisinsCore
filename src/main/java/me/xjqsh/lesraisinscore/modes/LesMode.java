package me.xjqsh.lesraisinscore.modes;

/**游戏模式，作为游戏流程控制器*/
public abstract class LesMode {

    public String mapType;

    public abstract boolean start();

    public abstract boolean end();

    public abstract boolean canStart();

}
