package azuazu3939.elevatora;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class ElevatorAListener implements Listener {

    private final ElevatorA elevatorA;

    public ElevatorAListener(ElevatorA elevatorA) {
        this.elevatorA = elevatorA;
    }

    @EventHandler
    public void onDown(PlayerToggleSneakEvent event) {

        Player player = event.getPlayer();

        if (player.isSneaking() || !(player.isOnGround())) return;

        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (block.getType() == elevatorA.material) {

            int i = elevatorA.minint;
            int i2 = elevatorA.maxint;
            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();
            while (i < i2) {
                i++;
                Material locM = player.getWorld().getType(x, y - i, z);
                Material locM1 = player.getWorld().getType(x, y - i + 1, z);
                Material locM2 = player.getWorld().getType(x, y - i + 2, z);

                if (locM == elevatorA.material && locM1 == Material.AIR && locM2 == Material.AIR) {

                    Location location1 = player.getLocation().subtract(0, i - 1, 0);
                    player.teleport(location1);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onUp(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getVelocity().getY() <= 0D) return;

        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (block.getType() == elevatorA.material) {

            int i = elevatorA.minint;
            int i2 = elevatorA.maxint;
            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();
            while (i < i2) {
                i++;
                Material locM = player.getWorld().getType(x, y + i, z);
                Material locM1 = player.getWorld().getType(x, y + i + 1, z);
                Material locM2 = player.getWorld().getType(x, y + i + 2, z);

                if (locM == elevatorA.material && locM1 == Material.AIR && locM2 == Material.AIR) {

                    Location location1 = player.getLocation().add(0, i + 1, 0);
                    player.teleport(location1);
                    break;
                }
            }
        }
    }
}
