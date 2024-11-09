package net.engineerofchaos.firesupport.entity.model;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBigHeli extends ModelBiped {
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
	private final ModelRenderer rotor;
	private final ModelRenderer rotor1;
	private final ModelRenderer cube_r7;
	private final ModelRenderer rotor2;
	private final ModelRenderer cube_r8;
	private final ModelRenderer rotor3;
	private final ModelRenderer cube_r9;
	private final ModelRenderer rotor4;
	private final ModelRenderer cube_r10;
	private final ModelRenderer rotor5;
	private final ModelRenderer cube_r11;
	private final ModelRenderer rotor6;
	private final ModelRenderer cube_r12;
	private final ModelRenderer planes;
	private final ModelRenderer plane_r1;
	private final ModelRenderer plane_r2;
	private final ModelRenderer plane_r3;
	private final ModelRenderer plane_r4;
	private final ModelRenderer plane_r5;
//	private final ModelRenderer blades;
//	private final ModelRenderer cube_r13;
//	private final ModelRenderer cube_r14;
//	private final ModelRenderer cube_r15;
//	private final ModelRenderer cube_r16;
//	private final ModelRenderer cube_r17;
	private final ModelRenderer tail_rotor;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
//	private final ModelRenderer tail_blades;
//	private final ModelRenderer cube_r21;
//	private final ModelRenderer cube_r22;
//	private final ModelRenderer cube_r23;
	private final ModelRenderer tail_planes;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;

	public ModelBigHeli() {
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

		rotor = new ModelRenderer(this);
		rotor.setRotationPoint(0.0F, 24.0F, 0.0F);
		rotor.cubeList.add(new ModelBox(rotor, 0, 187, -4.0F, -26.5F, -4.0F, 8, 1, 8, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 84, 185, -4.0F, -28.5F, -4.0F, 8, 1, 8, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 143, 198, -3.5F, -29.5F, -3.5F, 7, 1, 7, 0.0F, false));
		rotor.cubeList.add(new ModelBox(rotor, 24, 118, -3.0F, -27.5F, -3.0F, 6, 1, 6, 0.0F, false));

		rotor1 = new ModelRenderer(this);
		rotor1.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor1);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor1.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 3.1416F, 0.0F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 182, 184, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 44, 47, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 48, 0, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor2 = new ModelRenderer(this);
		rotor2.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor2);
		setRotationAngle(rotor2, 0.0F, -1.0472F, 0.0F);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 3.1416F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 154, 184, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r8.cubeList.add(new ModelBox(cube_r8, 44, 43, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r8.cubeList.add(new ModelBox(cube_r8, 28, 45, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor3 = new ModelRenderer(this);
		rotor3.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor3);
		setRotationAngle(rotor3, 0.0F, -2.0944F, 0.0F);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor3.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 3.1416F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 138, 182, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 44, 35, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 44, 39, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor4 = new ModelRenderer(this);
		rotor4.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor4);
		setRotationAngle(rotor4, 0.0F, 3.1416F, 0.0F);
		

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor4.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 3.1416F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 80, 128, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 44, 25, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 44, 29, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor5 = new ModelRenderer(this);
		rotor5.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor5);
		setRotationAngle(rotor5, 0.0F, 2.0944F, 0.0F);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor5.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 3.1416F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 28, 41, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 28, 41, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 44, 21, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

		rotor6 = new ModelRenderer(this);
		rotor6.setRotationPoint(0.0F, -27.0F, 0.0F);
		rotor.addChild(rotor6);
		setRotationAngle(rotor6, 0.0F, 1.0472F, 0.0F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor6.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 3.1416F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 28, 21, -1.0F, -1.0F, 3.0F, 2, 2, 12, 0.0F, false));
		cube_r12.cubeList.add(new ModelBox(cube_r12, 32, 0, -1.5F, -1.5F, 5.0F, 3, 3, 1, 0.0F, false));
		cube_r12.cubeList.add(new ModelBox(cube_r12, 32, 4, -1.5F, -1.5F, 9.0F, 3, 3, 1, 0.0F, false));

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

//		blades = new ModelRenderer(this);
//		blades.setRotationPoint(0.0F, 0.0F, 0.0F);
//		rotor.addChild(blades);
//		blades.cubeList.add(new ModelBox(blades, 63, 51, -2.25F, -27.5F, 11.0F, 3, 1, 48, 0.0F, false));
//
//		cube_r13 = new ModelRenderer(this);
//		cube_r13.setRotationPoint(0.0F, -27.5F, 0.0F);
//		blades.addChild(cube_r13);
//		setRotationAngle(cube_r13, 0.0F, 1.0472F, 0.0F);
//		cube_r13.cubeList.add(new ModelBox(cube_r13, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));
//
//		cube_r14 = new ModelRenderer(this);
//		cube_r14.setRotationPoint(0.0F, -27.5F, 0.0F);
//		blades.addChild(cube_r14);
//		setRotationAngle(cube_r14, 0.0F, 2.0944F, 0.0F);
//		cube_r14.cubeList.add(new ModelBox(cube_r14, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));
//
//		cube_r15 = new ModelRenderer(this);
//		cube_r15.setRotationPoint(0.0F, -27.5F, 0.0F);
//		blades.addChild(cube_r15);
//		setRotationAngle(cube_r15, 0.0F, 3.1416F, 0.0F);
//		cube_r15.cubeList.add(new ModelBox(cube_r15, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));
//
//		cube_r16 = new ModelRenderer(this);
//		cube_r16.setRotationPoint(0.0F, -27.5F, 0.0F);
//		blades.addChild(cube_r16);
//		setRotationAngle(cube_r16, 0.0F, -2.0944F, 0.0F);
//		cube_r16.cubeList.add(new ModelBox(cube_r16, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));
//
//		cube_r17 = new ModelRenderer(this);
//		cube_r17.setRotationPoint(0.0F, -27.5F, 0.0F);
//		blades.addChild(cube_r17);
//		setRotationAngle(cube_r17, 0.0F, -1.0472F, 0.0F);
//		cube_r17.cubeList.add(new ModelBox(cube_r17, 63, 51, -2.25F, 0.0F, 11.0F, 3, 1, 48, 0.0F, false));

		tail_rotor = new ModelRenderer(this);
		tail_rotor.setRotationPoint(6.0F, -9.0F, 77.0F);
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 28, 27, 1.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F, false));
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 28, 21, 4.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F, false));
		tail_rotor.cubeList.add(new ModelBox(tail_rotor, 0, 29, 5.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r18);
		setRotationAngle(cube_r18, 1.5708F, 0.0F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 0, 0, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r19);
		setRotationAngle(cube_r19, 3.1416F, 0.0F, 0.0F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 0, 8, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(6.0F, 0.0F, 0.0F);
		tail_rotor.addChild(cube_r20);
		setRotationAngle(cube_r20, -1.5708F, 0.0F, 0.0F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 0, 21, -1.0F, -1.0F, -7.5F, 2, 2, 6, 0.0F, false));

//		tail_blades = new ModelRenderer(this);
//		tail_blades.setRotationPoint(0.0F, 0.0F, 0.0F);
//		tail_rotor.addChild(tail_blades);
//		tail_blades.cubeList.add(new ModelBox(tail_blades, 28, 195, 5.5F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));
//
//		cube_r21 = new ModelRenderer(this);
//		cube_r21.setRotationPoint(5.5F, 0.0F, 0.0F);
//		tail_blades.addChild(cube_r21);
//		setRotationAngle(cube_r21, 1.5708F, 0.0F, 0.0F);
//		cube_r21.cubeList.add(new ModelBox(cube_r21, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));
//
//		cube_r22 = new ModelRenderer(this);
//		cube_r22.setRotationPoint(5.5F, 0.0F, 0.0F);
//		tail_blades.addChild(cube_r22);
//		setRotationAngle(cube_r22, 3.1416F, 0.0F, 0.0F);
//		cube_r22.cubeList.add(new ModelBox(cube_r22, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));
//
//		cube_r23 = new ModelRenderer(this);
//		cube_r23.setRotationPoint(5.5F, 0.0F, 0.0F);
//		tail_blades.addChild(cube_r23);
//		setRotationAngle(cube_r23, -1.5708F, 0.0F, 0.0F);
//		cube_r23.cubeList.add(new ModelBox(cube_r23, 28, 195, 0.0F, -2.25F, -14.5F, 1, 3, 10, 0.0F, false));

		tail_planes = new ModelRenderer(this);
		tail_planes.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail_rotor.addChild(tail_planes);
		tail_planes.cubeList.add(new ModelBox(tail_planes, 99, -15, 6.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r24);
		setRotationAngle(cube_r24, 1.5708F, 0.0F, 0.0F);
		cube_r24.cubeList.add(new ModelBox(cube_r24, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r25);
		setRotationAngle(cube_r25, 3.1416F, 0.0F, 0.0F);
		cube_r25.cubeList.add(new ModelBox(cube_r25, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(5.0F, 0.0F, 0.0F);
		tail_planes.addChild(cube_r26);
		setRotationAngle(cube_r26, -1.5708F, 0.0F, 0.0F);
		cube_r26.cubeList.add(new ModelBox(cube_r26, 99, -15, 1.0F, -15.0F, -8.0F, 0, 15, 15, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		engines.render(scale);
		dorsal_fin.render(scale);
		wings.render(scale);
		body.render(scale);
		nose.render(scale);
		tail_fin.render(scale);
		rotor.render(scale);
		tail_rotor.render(scale);
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		float ageInSeconds = ageInTicks/20;
		float rotationAngle = (ageInSeconds * 2.0f * (float) Math.PI) % (2 * (float) Math.PI);
		this.rotor.rotateAngleY = rotationAngle;
		this.tail_rotor.rotateAngleX = rotationAngle;
	}
}