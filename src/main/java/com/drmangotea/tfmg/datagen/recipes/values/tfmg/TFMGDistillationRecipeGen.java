package com.drmangotea.tfmg.datagen.recipes.values.tfmg;

import com.drmangotea.tfmg.TFMG;
import com.drmangotea.tfmg.datagen.recipes.builder.DistillationRecipeGen;
import com.drmangotea.tfmg.registry.TFMGRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.concurrent.CompletableFuture;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.*;

public class TFMGDistillationRecipeGen extends DistillationRecipeGen {

	GeneratedRecipe

	CRUDE_OIL = create(TFMG.asResource("crude_oil_no_naphtha"), b ->b
			.require(SizedFluidIngredient.of(crudeOil(),240))
			.output(heavyOil(), 125)
			.output(diesel(), 65)
			.output(kerosene(), 40)
			.output(gasoline(), 60)
			.output(lpg(), 60)
            .output(naturalgas(), 20)),
	CRUDE_OIL_LIGHT_DISTILLATION = create(TFMG.asResource("crude_oil_light_distillation"), b ->b
			.require(SizedFluidIngredient.of(crudeOil(),100))
			.output(heavyOil(), 150)
            .output(lpg(), 60)
            .output(naturalgas(), 20)),


	HEAVY_OIL = create(TFMG.asResource("heavy_oil"), b ->b
			.require(SizedFluidIngredient.of(heavyOil(),200))
            .output(heavyOil(), 50)
			.output(lubricationOil(), 25)
			.output(diesel(), 40)
			.output(kerosene(), 60)
			.output(naphtha(), 50)
			.output(gasoline(), 80)),


	HEAVY_OIL_NO_NAPHTHA = create(TFMG.asResource("heavy_oil_no_naphtha"), b ->b
			.require(SizedFluidIngredient.of(heavyOil(),200))
			.output(heavyOil(), 100)
			.output(lubricationOil(), 30)
			.output(diesel(), 50)
			.output(kerosene(), 70)
            .output(gasoline(), 80)),

	HEAVY_OIL_LIGHT_DISTILLATION = create(TFMG.asResource("heavy_oil_light_distillation"), b ->b
			.require(SizedFluidIngredient.of(heavyOil(),200))
			.output(heavyOil(), 120)
            .output(lubricationOil(), 50)
			.output(diesel(), 70)
			.output(kerosene(), 80)),

    LUBRICATION_OIL_DISTILLATION = create(TFMG.asResource("lubrication_oil_light_distillation"), b ->b
            .require(SizedFluidIngredient.of(heavyOil(),20))
            .output(diesel(), 10)
            .output(kerosene(), 20)
            .output(naphtha(), 15)),

    LPG_DISTILLATION = create(TFMG.asResource("lpg_distillation"), b ->b
            .require(SizedFluidIngredient.of(lpg(),340))
            .output(propylene(), 10)
            .output(propane(), 35)
            .output(butane(), 120)
            .output(ethylene(), 120)),

    LPG_DISTILLATION_LIGHT_DISTILLATION = create(TFMG.asResource("lpg_light_distillation"), b ->b
            .require(SizedFluidIngredient.of(lpg(),340))
            .output(propane(), 45)
            .output(butane(), 50)),

    MOLTEN_MAGMA_DISTILLATION_DISTILLATION = create(TFMG.asResource("molten_magma_distillation"), b ->b
            .require(SizedFluidIngredient.of(moltenMagma(),340))
            .output(lava(), 40)
            .output(sulfuricAcid(), 55));

	public TFMGDistillationRecipeGen(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
		super(generator, registries,TFMG.MOD_ID);
	}

	@Override
	protected TFMGRecipeTypes getRecipeType() {
		return TFMGRecipeTypes.DISTILLATION;
	}

}