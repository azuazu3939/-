package azuazu3939.elevatora;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElevatorA extends JavaPlugin {

    Material material;
    Integer minint;
    Integer maxint;

    @Override
    public void onEnable() {
        ElevatorA elevatorA = this;
        getServer().getPluginManager().registerEvents(new ElevatorAListener(elevatorA), this);
        saveDefaultConfig();
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onLoad() {
        material = Material.valueOf(getConfig().getString("Block", ""));
        minint = Integer.valueOf(getConfig().getString("MinInt", ""));
        maxint = Integer.valueOf(getConfig().getString("MaxInt", ""));
    }
}
