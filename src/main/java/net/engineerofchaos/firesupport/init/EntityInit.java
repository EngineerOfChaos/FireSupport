package net.engineerofchaos.firesupport.init;

import net.engineerofchaos.firesupport.Main;
import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.EntityHeli;
import net.engineerofchaos.firesupport.entity.projectile.EntityBullet;
import net.engineerofchaos.firesupport.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("heli", EntityHeli.class, Reference.ENTITY_HELI, 50, 10240, 0);
        registerEntity("big_heli", EntityBigHeli.class, Reference.ENTITY_BIG_HELI, 120, 3126738, 0);
        registerProjectile("bullet", Reference.BULLET, EntityBullet.class, ItemInit.BULLET);
    }

    private static void registerEntity(String name, Class <? extends Entity> entity, int id, int range, int colour1, int colour2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID + ":" + name), entity, name, id,
                Main.instance, range, 1, true, colour1, colour2);
    }

    private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item) {
        EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, Main.instance, 120, 1, true);
    }
}
