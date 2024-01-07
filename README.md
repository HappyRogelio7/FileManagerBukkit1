# FileManagerBukkit1
FileManagerBukkit1

[My website](https://happyrogelio7.xyz), My website 

[Discord](https://discord.gg/3EebYUyeUX), Support My Server Discord

[Kaory Studios](https://kaorystudios.xyz), Support Kaoty Studios

[Kaory Studios Discord](https://discord.gg/Gw7m8kC), Support Kaoty Studios

## Using:
```java

package com.github.happyuky7.filemanagerbukkit1;

import com.github.happyrogelio7.filemanagerbukkit1.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class YourPluginMain extends JavaPlugin {

    /*Created 
    private FileManager yourconfignameorvalue;
    */
    
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
        /*Register your config
        this.yourconfignameorvalue = new FileManager(this, "yourconfignameorvalue");
        */
        
        this.config = new FileManager(this, "config");
        this.playerdata = new FileManager(this, "data/playerdata");
    }

    /*Created Method to call in another class
    public FileManager getYpurConfigNameORValue() {
        return this.yourconfignameorvalue;
    }
    */
    public FileManager getConfig() {
        return this.config;
    }


    public FileManager getPlayerData() {
        return this.playerdata;
    }
}


```


```java
package com.github.happyuky7.filemanagerbukkit1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationOptions;
import org.bukkit.configuration.MemoryConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileManager extends YamlConfiguration {

    /*
    FileManager Link: https://github.com/Happyuky7/FileManagerBukkit1
    */

    private final String fileName;

    private final JavaPlugin plugin;

    private final File folder;

    public FileManager(JavaPlugin plugin, String fileName, File folder) {
        this(plugin, fileName, ".yml", folder);
    }

    public FileManager(JavaPlugin plugin, String filename, String fileextension, File folder) {
        this.folder = folder;
        this.plugin = plugin;
        this.fileName = filename + (filename.endsWith(fileextension) ? "" : fileextension);
        createFile();
    }

    public FileManager(JavaPlugin plugin, String fileName) {
        this(plugin, fileName, ".yml");
    }

    public FileManager(JavaPlugin plugin, String fileName, String fileExtension) {
        this(plugin, fileName, fileExtension, plugin.getDataFolder());
    }

    public JavaPlugin getPlugin() {
        return this.plugin;
    }

    public String getColouredString(String path) {
        String getted;
        try {
            getted = getString(path);
        } catch (NullPointerException e) {
            getted = path;
        }
        return ChatColor.translateAlternateColorCodes('&', getted);
    }

    public List<String> getColouredStringList(String path) {
        List<String> f = new ArrayList<>();
        for (String l : getStringList(path))
            f.add(l.replace('&', '&'));
        return f;
    }

    public <T> T get(Class<T> clazz, String path) {
        Object obj = get(path);
        return clazz.cast(obj);
    }

    private void createFile() {
        try {
            File file = new File(this.folder, this.fileName);
            if (!file.exists()) {
                if (this.plugin.getResource(this.fileName) != null) {
                    this.plugin.saveResource(this.fileName, false);
                } else {
                    save(file);
                }
                load(file);
            } else {
                load(file);
                save(file);
            }
        } catch (Exception ex) {
            this.plugin.getLogger().log(Level.SEVERE, "error occurred creating the " + this.fileName + " file");
            this.plugin.getLogger().log(Level.SEVERE, "");
            this.plugin.getLogger().log(Level.SEVERE, "Error:" + ex.getMessage());
        }
    }

    public void save() {
        File folder = this.plugin.getDataFolder();
        try {
            save(new File(folder, this.fileName));
        } catch (Exception ex) {
            this.plugin.getLogger().log(Level.SEVERE, "error occurred while saving the " + this.fileName + " file");
            this.plugin.getLogger().log(Level.SEVERE, "");
            this.plugin.getLogger().log(Level.SEVERE, "Error:" + ex.getMessage());
        }
    }

    public void reload() {
        File folder = this.plugin.getDataFolder();
        File file = new File(folder, this.fileName);
        try {
            load(file);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
            this.plugin.getLogger().log(Level.SEVERE, "error occurred while reloading the " + this.fileName + " file");
            this.plugin.getLogger().log(Level.SEVERE, "");
            this.plugin.getLogger().log(Level.SEVERE, "Error:" + e.getMessage());
        }
    }
}




```

---

## Join us

* Feel free to open a PR! We accept contributions.
* [Discord](https://discord.gg/3EebYUyeUX)

## Special Thanks To

![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.png?size=100px)
![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA.png)
![Azul Java logo](https://www.azul.com/wp-content/themes/azul/dist/img/logo.svg)


[IntelliJ IDEA](https://www.jetbrains.com/idea/), Code editor for Java and other programming languages and programs.

[Azul Java](https://www.azul.com/) The world’s largest commercial provider of OpenJDK
