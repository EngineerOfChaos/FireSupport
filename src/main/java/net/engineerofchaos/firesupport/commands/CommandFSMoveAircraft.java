package net.engineerofchaos.firesupport.commands;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.pathfinding.Waypoint;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CommandFSMoveAircraft extends CommandBase {
    @Override
    public String getName() {
        return "fsmoveaircraft";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "fsmoveaircraft <x> <y> <z>";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 3) {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Needs 3 coordinates"));
            return;
        }

        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < 3; ++i) {
            String s = args[i];
            int coord;
            try {
                coord = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                sender.sendMessage(new TextComponentString(TextFormatting.RED + "Not a number!"));
                return;
            }
            if (i == 0) {x = coord;}
            if (i == 1) {y = coord;}
            if (i == 2) {z = coord;}
        }

        Entity senderEntity = sender.getCommandSenderEntity();
        if (senderEntity != null) {
            World world = server.getWorld(0);
            AxisAlignedBB aabb = new AxisAlignedBB(senderEntity.posX + 50, senderEntity.posY + 50, senderEntity.posZ + 50,
                    senderEntity.posX - 50, senderEntity.posY - 50, senderEntity.posZ - 50);
            EntityBigHeli aircraft = (EntityBigHeli) world.findNearestEntityWithinAABB(EntityBigHeli.class, aabb, senderEntity);
            if (aircraft != null) {
                aircraft.setNextWP(new Waypoint(x, y, z));
                sender.sendMessage(new TextComponentString(TextFormatting.ITALIC + "Sending waypoint!"));
            }
        }
    }
}
