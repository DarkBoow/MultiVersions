package fr.darkbow_.sampleplugin.versions;

import fr.darkbow_.sampleplugin.SamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SamplePluginEvents_1_16_R1 implements Listener, SamplePluginEvents {
    private SamplePlugin main;

    public SamplePluginEvents_1_16_R1(SamplePlugin sampleplugin){main = sampleplugin;}

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if(event.getItem() != null){
            if(event.getItem().getType() == Material.STICK){
                Bukkit.broadcastMessage("Stick");
            }
        }
    }
}