package net.engineerofchaos.firesupport.entity.model;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ModelStallionBlades extends ModelBase {
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
	private final ModelRenderer blades;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer tail_rotor;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer tail_blades;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;

	private float velocity = 1.0F;
	private float rotorAngle = 0.0F;
	private float lastRenderAge = 0.0F;

	public ModelStallionBlades() {
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

		blades = new ModelRenderer(this);
		blades.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor.addChild(blades);
		blades.cubeList.add(new ModelBox(blades, 63, 51, -2.25F, -27.5F, 11.0F, 3, 1, 48, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -27.5F, 0.0F);
		blades.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.0472F, 0.0F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, -27.5F, 0.0F);
		blades.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 2.0944F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, -27.5F, 0.0F);
		blades.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 3.1416F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, -27.5F, 0.0F);
		blades.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, -2.0944F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, -27.5F, 0.0F);
		blades.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -1.0472F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

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

		tail_blades = new ModelRenderer(this);
		tail_blades.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail_rotor.addChild(tail_blades);
		tail_blades.cubeList.add(new ModelBox(tail_blades, 28, 195, 5.5F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(5.5F, 0.0F, 0.0F);
		tail_blades.addChild(cube_r15);
		setRotationAngle(cube_r15, 1.5708F, 0.0F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(5.5F, 0.0F, 0.0F);
		tail_blades.addChild(cube_r16);
		setRotationAngle(cube_r16, 3.1416F, 0.0F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(5.5F, 0.0F, 0.0F);
		tail_blades.addChild(cube_r17);
		setRotationAngle(cube_r17, -1.5708F, 0.0F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		EntityBigHeli heli = (EntityBigHeli) entity;

//		float dt = ageInTicks - heli.ticksExisted;

//		if (heli.getRotorState() == 0) {
//			velocity = 1F;
//		}
//		if (heli.getRotorState() == 1) {
//			velocity = Math.max(velocity - (0.003F * dt), 0F);
//		}
//		if (heli.getRotorState() == 2) {
//			velocity = 0F;
//		}
//		if (heli.getRotorState() == 3) {
//			velocity = Math.min(velocity + (0.003F * dt), 1F);
//		}

		//this.rotorAngle = heli.getRotorAngle();// + (heli.getRotorSpeed() * 0.005F * dt);

		//EntityPlayer nearestPlayer = heli.world.<EntityPlayer>getClosestPlayerToEntity(heli, 100);
		//nearestPlayer.sendMessage(new TextComponentString("Rendering AgeInTicks = "+ageInTicks));
		//nearestPlayer.sendMessage(new TextComponentString("Entity AgeInTicks = "+heli.ticksExisted));


		//setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		rotor.render(scaleFactor);
		tail_rotor.render(scaleFactor);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		EntityBigHeli heli = (EntityBigHeli) entitylivingbaseIn;
		this.rotorAngle = heli.getBladeAngle(partialTickTime);
		this.rotor.rotateAngleY = this.rotorAngle;
		this.tail_rotor.rotateAngleX = this.rotorAngle;
		EntityPlayer nearestPlayer = heli.world.<EntityPlayer>getClosestPlayerToEntity(heli, 100);
		//nearestPlayer.sendMessage(new TextComponentString("Rendering - getBladeAngle output: "+heli.getBladeAngle(partialTickTime)));

	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//EntityBigHeli heli = (EntityBigHeli) entityIn;


	}
}