package com.drmangotea.tfmg.worldgen;


import com.drmangotea.tfmg.TFMG;
import com.drmangotea.tfmg.worldgen.deposits.MagmaDepositFeature;
import com.drmangotea.tfmg.worldgen.deposits.MagmaWellFeature;
import com.drmangotea.tfmg.worldgen.deposits.OilDepositFeature;
import com.drmangotea.tfmg.worldgen.deposits.OilWellFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class TFMGFeatures {


    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, TFMG.MOD_ID);

    public static final DeferredHolder<Feature<?>, OilDepositFeature> OIL_DEPOSIT =
            FEATURES.register("oil_deposit", () -> new OilDepositFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, OilWellFeature> OIL_WELL =
            FEATURES.register("oil_well", () -> new OilWellFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, MagmaDepositFeature> MAGMA_DEPOSIT =
            FEATURES.register("magma_deposit", () -> new MagmaDepositFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, MagmaWellFeature> MAGMA_WELL =
            FEATURES.register("magma_well", () -> new MagmaWellFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}
