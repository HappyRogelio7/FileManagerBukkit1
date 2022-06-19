package com.github.happyrogelio7.filemanagerbukkit1;

import com.github.happyrogelio7.filemanagerbukkit1;
import org.bukkit.plugin.java.JavaPlugin;

public class YourPluginMain extends JavaPlugin {

    private FileManager config;


    private FileManager playerdata;

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerConfigs();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerConfigs() {
        this.config = new FileManager(this, "config");
        this.playerdata = new FileManager(this, "data/playerdata");
    }

    public FileManager getConfig() {
        return this.config;
    }


    public FileManager getPlayerData() {
        return this.playerdata;
    }
}
