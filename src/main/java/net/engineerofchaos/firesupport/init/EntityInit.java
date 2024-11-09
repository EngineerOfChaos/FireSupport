package net.engineerofchaos.firesupport.init;

import net.engineerofchaos.firesupport.Main;
import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.EntityHeli;
import net.engineerofchaos.firesupport.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("heli", EntityHeli.class, Reference.ENTITY_HELI, 50, 10240, 0);
        registerEntity("big_heli", EntityBigHeli.class, Reference.ENTITY_BIG_HELI, 120, 3126738, 0);
    }

    private static void registerEntity(String name, Class <? extends Entity> entity, int id, int range, int colour1, int colour2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID + ":" + name), entity, name, id,
                Main.instance, range, 1, true, colour1, colour2);
    }
}
