package net.engineerofchaos.firesupport.entity.model;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHeli extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer wing1_r1;
	private final ModelRenderer wing2_r1;
	private final ModelRenderer tail_rotor_r1;
	private final ModelRenderer stab_vertical_r1;

	public ModelHeli() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 12, 31, -9.0F, -3.0F, -1.0F, 3, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 30, 20, -6.0F, -4.0F, -1.0F, 3, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 16, -6.0F, -2.0F, -2.0F, 9, 3, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 10, 25, -9.0F, -1.0F, -2.0F, 3, 2, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 34, 25, -11.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 23, -3.0F, -4.0F, -2.0F, 3, 2, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 30, 16, 0.0F, -4.0F, -1.0F, 3, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 8, 3.0F, -1.0F, -2.0F, 3, 2, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 29, 3.0F, -3.0F, -1.0F, 3, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 29, 6.0F, -2.0F, -1.0F, 4, 3, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 20, 25, 10.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -9.25F, -4.5F, -8.0F, 16, 0, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 20, 33, -2.25F, -5.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 8, 13.25F, -4.0F, -0.5F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 16, 12.5F, -0.75F, -4.0F, 2, 1, 8, 0.0F, false));

		wing1_r1 = new ModelRenderer(this);
		wing1_r1.setRotationPoint(0.0F, -1.0F, -2.0F);
		bb_main.addChild(wing1_r1);
		setRotationAngle(wing1_r1, 0.2618F, 0.0F, 0.0F);
		wing1_r1.cubeList.add(new ModelBox(wing1_r1, 0, 0, -3.0F, 0.0F, -3.0F, 5, 1, 3, 0.0F, false));

		wing2_r1 = new ModelRenderer(this);
		wing2_r1.setRotationPoint(0.0F, -1.0F, 2.0F);
		bb_main.addChild(wing2_r1);
		setRotationAngle(wing2_r1, -0.2618F, 0.0F, 0.0F);
		wing2_r1.cubeList.add(new ModelBox(wing2_r1, 0, 4, -3.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F, false));

		tail_rotor_r1 = new ModelRenderer(this);
		tail_rotor_r1.setRotationPoint(13.75F, -3.5F, 0.75F);
		bb_main.addChild(tail_rotor_r1);
		setRotationAngle(tail_rotor_r1, 0.0F, 0.0F, 2.3562F);
		tail_rotor_r1.cubeList.add(new ModelBox(tail_rotor_r1, 0, 34, -2.0F, -2.0F, -1.0F, 4, 4, 0, 0.0F, false));

		stab_vertical_r1 = new ModelRenderer(this);
		stab_vertical_r1.setRotationPoint(13.75F, -0.25F, 1.0F);
		bb_main.addChild(stab_vertical_r1);
		setRotationAngle(stab_vertical_r1, 0.0F, 0.0F, 0.3927F);
		stab_vertical_r1.cubeList.add(new ModelBox(stab_vertical_r1, 32, 29, -2.0F, -4.0F, -1.0F, 3, 4, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}