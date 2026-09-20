package com.pirateseas.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class PirateHatModel extends HumanoidModel<LivingEntity> {
    public PirateHatModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createPirateLayer() {
        return createLayer(false);
    }

    public static LayerDefinition createCaptainLayer() {
        return createLayer(true);
    }

    private static LayerDefinition createLayer(boolean captain) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

        head.addOrReplaceChild("crown",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.65F, -11.45F, -3.65F, 7.3F, 3.6F, 7.3F,
                                new CubeDeformation(0.06F)),
                PartPose.ZERO);

        head.addOrReplaceChild("front_brim",
                CubeListBuilder.create().texOffs(0, 12)
                        .addBox(-5.1F, -0.45F, -1.55F, 10.2F, 0.9F, 3.1F),
                PartPose.offsetAndRotation(0.0F, -8.15F, -3.65F, -0.18F, 0.0F, 0.0F));

        head.addOrReplaceChild("back_brim",
                CubeListBuilder.create().texOffs(0, 16)
                        .addBox(-4.7F, -0.4F, -1.3F, 9.4F, 0.8F, 2.6F),
                PartPose.offsetAndRotation(0.0F, -8.05F, 3.55F, 0.12F, 0.0F, 0.0F));

        head.addOrReplaceChild("left_brim",
                CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-1.4F, -0.42F, -4.2F, 2.8F, 0.84F, 8.4F),
                PartPose.offsetAndRotation(-4.15F, -8.0F, 0.0F, 0.0F, 0.0F, -0.27F));

        head.addOrReplaceChild("right_brim",
                CubeListBuilder.create().texOffs(22, 20)
                        .addBox(-1.4F, -0.42F, -4.2F, 2.8F, 0.84F, 8.4F),
                PartPose.offsetAndRotation(4.15F, -8.0F, 0.0F, 0.0F, 0.0F, 0.27F));

        head.addOrReplaceChild("band_front",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.72F, -9.25F, -3.78F, 7.44F, 0.75F, 0.55F),
                PartPose.ZERO);
        head.addOrReplaceChild("band_back",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.72F, -9.25F, 3.23F, 7.44F, 0.75F, 0.55F),
                PartPose.ZERO);

        if (captain) {
            head.addOrReplaceChild("feather_a",
                    CubeListBuilder.create().texOffs(0, 0)
                            .addBox(-0.45F, -4.8F, -0.35F, 0.9F, 5.0F, 0.7F),
                    PartPose.offsetAndRotation(3.0F, -11.0F, 0.8F, 0.0F, 0.0F, -0.38F));
            head.addOrReplaceChild("feather_b",
                    CubeListBuilder.create().texOffs(0, 0)
                            .addBox(-0.35F, -3.8F, -0.3F, 0.7F, 4.0F, 0.6F),
                    PartPose.offsetAndRotation(4.05F, -13.9F, 0.8F, 0.0F, 0.0F, -0.62F));
        }

        return LayerDefinition.create(mesh, 64, 32);
    }
}
