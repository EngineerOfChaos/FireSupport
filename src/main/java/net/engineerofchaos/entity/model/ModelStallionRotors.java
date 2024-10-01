package net.engineerofchaos.entity.model;
// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStallionRotors extends ModelBase {
	private final ModelRenderer rotor;
	private final ModelRenderer rotor1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer rotor2;
	private final ModelRenderer cube_r2;
	private final ModelRenderer rotor3;
	private final ModelRenderer cube_r3;
	private final ModelRenderer rotor4;
	private final ModelRenderer cube_r4;
	private final ModelRenderer rotor5;
	private final ModelRenderer cube_r5;
	private final ModelRenderer rotor6;
	private final ModelRenderer cube_r6;
	private final ModelRenderer planes;
	private final ModelRenderer plane_r1;
	private final ModelRenderer plane_r2;
	private final ModelRenderer plane_r3;
	private final ModelRenderer plane_r4;
	private final ModelRenderer plane_r5;
	private final ModelRenderer tail_rotor;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer tail_planes;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;

	public ModelStallionRotors() {
		textureWidth = 512;
		textureHeight = 512;

		rotor = new ModelRenderer(this);
		rotor.setRotationPoint(0.0F, 24.0F, 0.0F);
		rotor.cubeList.add(new ModelBox(rotor, 0, 187, -4.0F, -26.5F, -4.0F, 8, 1, 8, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 84, 185, -4.0F, -28.5F, -4.0F, 8, 1, 8, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 143, 198, -3.5F, -29.5F, -3.5F, 7, 1, 7, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 24, 118, -3.0F, -27.5F, -3.0F, 6, 1, 6, 0.0F, false));

		rotor1 = new ModelRenderer(this);
		rotor1.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor1);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 3.1416F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 182, 184, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 44, 47, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 48, 0, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor2 = new ModelRenderer(this);
		rotor2.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor2);
		setRotationAngle(rotor2, 0.0F, -1.0472F, 0.0F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 154, 184, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 44, 43, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 28, 45, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor3 = new ModelRenderer(this);
		rotor3.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor3);
		setRotationAngle(rotor3, 0.0F, -2.0944F, 0.0F);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor3.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 138, 182, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 44, 35, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 44, 39, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor4 = new ModelRenderer(this);
		rotor4.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor4);
		setRotationAngle(rotor4, 0.0F, 3.1416F, 0.0F);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor4.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 3.1416F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 80, 128, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 44, 25, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 44, 29, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor5 = new ModelRenderer(this);
		rotor5.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor5);
		setRotationAngle(rotor5, 0.0F, 2.0944F, 0.0F);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor5.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 3.1416F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 28, 41, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 28, 41, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 44, 21, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor6 = new ModelRenderer(this);
		rotor6.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor6);
		setRotationAngle(rotor6, 0.0F, 1.0472F, 0.0F);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor6.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 28, 21, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 32, 0, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 32, 4, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		planes = new ModelRenderer(this);
		planes.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor.addChild(planes);
		planes.cubeList.add(new ModelBox(planes, 0, 0, -12.5F, -27.0F, 4.0F, 24, 0, 57, 0.0F, false));

		plane_r1 = new ModelRenderer(this);
		plane_r1.setRotationPoint(0.0F, -28.0F, 0.0F);
		planes.addChild(plane_r1);
		setRotationAngle(plane_r1, 0.0F, 1.0472F, 0.0F);
		plane_r1.cubeList.add(new ModelBox(plane_r1, 0, 0, -12.5F, 1.0F, 4.0F, 24, 0, 57, 0.0F, false));

		plane_r2 = new ModelRenderer(this);
		plane_r2.setRotationPoint(0.0F, -28.0F, 0.0F);
		planes.addChild(plane_r2);
		setRotationAngle(plane_r2, 0.0F, 2.0944F, 0.0F);
		plane_r2.cubeList.add(new ModelBox(plane_r2, 0, 0, -12.5F, 1.0F, 4.0F, 24, 0, 57, 0.0F, false));

		plane_r3 = new ModelRenderer(this);
		plane_r3.setRotationPoint(0.0F, -28.0F, 0.0F);
		planes.addChild(plane_r3);
		setRotationAngle(plane_r3, 0.0F, 3.1416F, 0.0F);
		plane_r3.cubeList.add(new ModelBox(plane_r3, 0, 0, -12.5F, 1.0F, 4.0F, 24, 0, 57, 0.0F, false));

		plane_r4 = new ModelRenderer(this);
		plane_r4.setRotationPoint(0.0F, -28.0F, 0.0F);
		planes.addChild(plane_r4);
		setRotationAngle(plane_r4, 0.0F, -2.0944F, 0.0F);
		plane_r4.cubeList.add(new ModelBox(plane_r4, 0, 0, -12.5F, 1.0F, 4.0F, 24, 0, 57, 0.0F, false));

		plane_r5 = new ModelRenderer(this);
		plane_r5.setRotationPoint(0.0F, -28.0F, 0.0F);
		planes.addChild(plane_r5);
		setRotationAngle(plane_r5, 0.0F, -1.0472F, 0.0F);
		plane_r5.cubeList.add(new ModelBox(plane_r5, 0, 0, -12.5F, 1.0F, 4.0F, 24, 0, 57, 0.0F, false));

		tail_rotor = new ModelRenderer(this);
		tail_rotor.setRotationPoint(6.0F, -9.0F, 77.0F);
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 28, 27, 1.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F, false));
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 28, 21, 4.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F, false));
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 0, 29, 5.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r12);
		setRotationAngle(cube_r12, 1.5708F, 0.0F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 0, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r13);
		setRotationAngle(cube_r13, 3.1416F, 0.0F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 0, 8, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r14);
		setRotationAngle(cube_r14, -1.5708F, 0.0F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 0, 21, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		tail_planes = new ModelRenderer(this);
		tail_planes.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail_rotor.addChild(tail_planes);
		tail_planes.cubeList.add(new ModelBox(tail_planes, 99, -15, 6.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r18);
		setRotationAngle(cube_r18, 1.5708F, 0.0F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r19);
		setRotationAngle(cube_r19, 3.1416F, 0.0F, 0.0F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r20);
		setRotationAngle(cube_r20, -1.5708F, 0.0F, 0.0F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		rotor.render(f5);
		tail_rotor.render(f5);
		//this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float ageInSeconds = ageInTicks/20;
		float rotationAngle = (ageInSeconds * 2.0f * (float) Math.PI) % (2 * (float) Math.PI);
		this.rotor.rotateAngleY = rotationAngle;
		this.tail_rotor.rotateAngleX = rotationAngle;
	}
}