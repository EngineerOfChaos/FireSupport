package net.engineerofchaos.firesupport.proxy;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.EntityHeli;
import net.engineerofchaos.firesupport.entity.projectile.EntityBullet;
import net.engineerofchaos.firesupport.entity.render.RenderBigHeli;
import net.engineerofchaos.firesupport.entity.render.RenderHeli;
import net.engineerofchaos.firesupport.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBigHeli.class, m -> new RenderBigHeli(m));
        RenderingRegistry.registerEntityRenderingHandler(EntityHeli.class, manager -> new RenderHeli(manager));
    }
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderSnowball<EntityBullet>(Minecraft.getMinecraft().getRenderManager(), ItemInit.BULLET, Minecraft.getMinecraft().getRenderItem()));
    }
    public void registerItemRenderer(Item item, int meta, String id)  {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
