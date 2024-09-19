package net.engineerofchaos.init;

import net.engineerofchaos.Main;
import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.EntityHeli;
import net.engineerofchaos.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("heli", EntityHeli.class, Reference.ENTITY_HELI, 50, 10240, 0);
        registerEntity("big_heli", EntityBigHeli.class, Reference.ENTITY_BIG_HELI, 50, 3126738, 0);
    }

    private static void registerEntity(String name, Class <? extends Entity> entity, int id, int range, int colour1, int colour2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID + ":" + name), entity, name, id,
                Main.instance, range, 1, true, colour1, colour2);
    }
}
