package net.engineerofchaos.firesupport.init;

import net.engineerofchaos.firesupport.objects.items.ItemBase;
import net.engineerofchaos.firesupport.objects.items.ItemBullet;
import net.engineerofchaos.firesupport.objects.items.ItemDebugGun;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item DEBUG_GUN = new ItemDebugGun("debug_gun");
    public static final Item BULLET = new ItemBullet("bullet");
}
