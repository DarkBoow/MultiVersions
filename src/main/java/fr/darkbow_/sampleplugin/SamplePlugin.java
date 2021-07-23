package fr.darkbow_.sampleplugin;

import fr.darkbow_.sampleplugin.versions.SamplePluginEvents_1_16_R1;
import fr.darkbow_.sampleplugin.versions.SamplePluginEvents_1_17_R1;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SamplePlugin extends JavaPlugin {

    private SamplePlugin instance;

    public SamplePlugin getInstance() {
        return instance;
    }

    public String sversion;

    @Override
    public void onEnable() {
        if(!setupManager()){
            getLogger().severe("Failed to setup SamplePlugin! Running non-compatible version!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        instance = this;

        if(sversion.equals("v1_16_R1") || sversion.equals("v1_16_R2") || sversion.equals("v1_16_R3")){
            getServer().getPluginManager().registerEvents(new SamplePluginEvents_1_16_R1(this), this);
        }

        if(sversion.equals("v1_17_R1")){
            getServer().getPluginManager().registerEvents(new SamplePluginEvents_1_17_R1(this), this);
        }

        System.out.println("[SamplePlugin] Plugin ON!");
    }

    @Override
    public void onDisable() {
        System.out.println("[SamplePlugin] Plugin OFF!");
    }

    private boolean setupManager(){
        sversion = "N/A";

        try{
            sversion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

        return (sversion.equals("v1_16_R1") || sversion.equals("v1_16_R2") || sversion.equals("v1_16_R3") || sversion.equals("v1_17_R1"));
    }
}