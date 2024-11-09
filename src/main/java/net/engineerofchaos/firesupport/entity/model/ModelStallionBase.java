package net.engineerofchaos.firesupport.entity.model;
// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStallionBase extends ModelBase {
	private final ModelRenderer engines;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer dorsal_fin;
	private final ModelRenderer wings;
	private final ModelRenderer body;
	private final ModelRenderer nose;
	private final ModelRenderer tail_fin;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public ModelStallionBase() {
		textureWidth = 512;
		textureHeight = 512;

		engines = new ModelRenderer(this);
		engines.setRotationPoint(0.0F, 24.0F, -3.0F);
		engines.cubeList.add(new ModelBox(engines, 168, 119, -12.0F, -22.0F, -11.0F, 4, 5, 8, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 198, 184, -12.0F, -22.0F, -3.0F, 4, 4, 6, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 140, 0, -13.0F, -23.0F, -15.0F, 5, 7, 4, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 0, 41, -12.0F, -22.0F, -18.0F, 4, 5, 3, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 0, 49, 8.0F, -22.0F, -18.0F, 4, 5, 3, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 88, 199, 8.0F, -23.0F, -15.0F, 5, 7, 4, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 32, 0, 8.0F, -22.0F, -11.0F, 4, 5, 8, 0.0F, false));
		engines.cubeList.add(new ModelBox(engines, 170, 184, 8.0F, -22.0F, -3.0F, 4, 4, 6, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(9.0F, -20.0F, 3.0F);
		engines.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1745F, 0.3491F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 195, 198, -1.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-9.0F, -20.0F, 3.0F);
		engines.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.1745F, -0.3491F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 173, 198, -3.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F, false));

		dorsal_fin = new ModelRenderer(this);
		dorsal_fin.setRotationPoint(0.0F, 24.0F, 0.0F);
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 80, 114, -4.0F, -25.0F, -4.0F, 8, 6, 8, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 124, 114, -4.0F, -24.0F, -12.0F, 8, 5, 8, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 0, 0, -4.0F, -24.0F, 4.0F, 8, 5, 16, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 0, 21, -3.0F, -23.0F, 20.0F, 6, 4, 16, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 0, 41, -3.0F, -21.0F, 36.0F, 6, 2, 16, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 124, 127, -4.0F, -23.0F, -20.0F, 8, 4, 8, 0.0F, false));
		dorsal_fin.cubeList.add(new ModelBox(dorsal_fin, 122, 196, -4.0F, -22.0F, -26.0F, 8, 3, 6, 0.0F, false));

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0.0F, 24.0F, 0.0F);
		wings.cubeList.add(new ModelBox(wings, 124, 119, -14.0F, -8.0F, -14.0F, 6, 5, 32, 0.0F, false));
		wings.cubeList.add(new ModelBox(wings, 168, 158, -14.0F, -10.0F, -10.0F, 6, 2, 24, 0.0F, false));
		wings.cubeList.add(new ModelBox(wings, 168, 114, 8.0F, -10.0F, -10.0F, 6, 2, 24, 0.0F, false));
		wings.cubeList.add(new ModelBox(wings, 80, 114, 8.0F, -8.0F, -14.0F, 6, 5, 32, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 114, -8.0F, -19.0F, -24.0F, 16, 16, 48, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 92, -8.0F, -9.0F, 24.0F, 16, 4, 8, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 128, 156, -8.0F, -19.0F, 24.0F, 16, 10, 16, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 77, -7.0F, -19.0F, 40.0F, 14, 6, 9, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 59, -5.0F, -19.0F, 49.0F, 10, 6, 12, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 118, -3.0F, -19.0F, 61.0F, 6, 6, 12, 0.0F, false));

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 24.0F, 0.0F);
		nose.cubeList.add(new ModelBox(nose, 0, 104, -8.0F, -11.0F, -30.0F, 16, 8, 6, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 114, 182, -8.0F, -17.0F, -30.0F, 16, 6, 2, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 0, 136, -5.0F, -5.0F, -40.0F, 10, 2, 10, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 24, 187, -5.0F, -13.0F, -39.0F, 10, 2, 6, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 0, 196, -5.0F, -11.0F, -41.0F, 10, 6, 4, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 0, 178, -8.0F, -11.0F, -33.0F, 16, 6, 3, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 0, 158, -8.0F, -13.0F, -32.0F, 16, 2, 2, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 168, 140, -7.0F, -19.0F, -30.0F, 14, 2, 6, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 124, 139, -5.0F, -19.0F, -33.0F, 10, 2, 3, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 0, 148, -8.0F, -17.0F, -28.0F, 16, 6, 4, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 38, 178, -7.0F, -17.0F, -35.0F, 14, 4, 5, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 76, 178, -7.0F, -13.0F, -37.0F, 14, 2, 5, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 80, 151, -7.0F, -11.0F, -38.0F, 14, 5, 5, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 148, 114, -7.0F, -6.0F, -37.0F, 14, 1, 4, 0.0F, false));
		nose.cubeList.add(new ModelBox(nose, 24, 125, -5.0F, -16.0F, -37.0F, 10, 3, 2, 0.0F, false));

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, 24.0F, 0.0F);
		tail_fin.cubeList.add(new ModelBox(tail_fin, 94, 194, -18.75F, -33.75F, 69.0F, 14, 2, 3, 0.0F, false));
		tail_fin.cubeList.add(new ModelBox(tail_fin, 66, 185, 3.0F, -35.0F, 70.0F, 4, 4, 10, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-0.5F, -19.0F, 60.5F);
		tail_fin.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.5236F, 0.0F, 0.3491F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 44, 55, 0.0F, -19.0F, 0.0F, 1, 19, 5, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-5.75F, -32.25F, 75.0F);
		tail_fin.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.2182F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 116, 190, -13.0F, -1.0F, -3.0F, 14, 1, 3, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(2.0F, -29.0F, 69.0F);
		tail_fin.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.3491F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 194, 150, -8.0F, -2.0F, 0.0F, 9, 2, 6, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -19.0F, 66.0F);
		tail_fin.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3491F, 0.0F, 0.3491F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 50, 189, -1.0F, -16.0F, 0.0F, 2, 16, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		engines.render(f5);
		dorsal_fin.render(f5);
		wings.render(f5);
		body.render(f5);
		nose.render(f5);
		tail_fin.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}