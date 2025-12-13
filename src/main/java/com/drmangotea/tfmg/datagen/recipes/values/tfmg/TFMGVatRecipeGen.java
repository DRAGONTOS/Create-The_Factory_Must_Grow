package com.drmangotea.tfmg.datagen.recipes.values.tfmg;


import blusunrize.immersiveengineering.common.register.IEFluids;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.drmangotea.tfmg.TFMG;
import com.drmangotea.tfmg.datagen.recipes.builder.VatRecipeGen;
import com.drmangotea.tfmg.recipes.VatMachineRecipe;
import com.drmangotea.tfmg.registry.TFMGFluids;
import com.drmangotea.tfmg.registry.TFMGItems;
import com.drmangotea.tfmg.registry.TFMGTags;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import mekanism.common.registries.MekanismChemicals;
import mekanism.common.registries.MekanismItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.F.*;
import static com.drmangotea.tfmg.datagen.recipes.TFMGRecipeProvider.I.*;

public class TFMGVatRecipeGen extends VatRecipeGen {
    public TFMGVatRecipeGen(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator, registries, TFMG.MOD_ID);
    }

    GeneratedRecipe
            CONCRETE = create("concrete", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(Blocks.SAND.asItem())
                    .require(Blocks.GRAVEL.asItem())
                    .require(TFMGItems.LIMESAND)
                    .require(Fluids.WATER, 250)
                    .require(Fluids.WATER, 250)
                    .output(TFMGFluids.LIQUID_CONCRETE.get(), 1000)
                    .values(mixing())
            ),
            ARC_FURNACE_STEEL = create("arc_furnace_steel", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGItems.IRON_DUST.get(),1)
                    .require(TFMGTags.TFMGItemTags.FLUX.tag)
                    .require(TFMGItems.COAL_COKE_DUST)
                    .output(0.9f,TFMGItems.COAL_COKE_DUST)
                    .output(TFMGFluids.MOLTEN_STEEL.get(), 144)
                    .output(TFMGFluids.MOLTEN_SLAG.get(), 288)
                    .duration(20)
                    .values(arcBlasting())),
            CARBON_MONOXIDE_REDOX = create("carbon_monoxide_redox", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(Blocks.COAL_BLOCK.asItem(), 7)
                    .require(TFMGFluids.AIR.get(), 2000)                 // 1st fluid
                    .output(TFMGFluids.CARBON_MONOXIDE.get(), 700)
                    .output(IEItems.Ingredients.CATALYST_PLATINUM.get(), 1)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            AMMONIUM_NITRATE_GRANULATION = create("ammonium_nitrate_granulation", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.AMMONIA.get(),1000)
                    .require(TFMGFluids.FUMING_NITRIC_ACID.get(), 1300)
                    .output(IEItems.Misc.FERTILIZER.get(), 9)
                    .values(mixing())),
            NAPHTHA_CATALYST_REFORMING = create("naphtha_catalyst_reforming", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.NAPHTHA.get(),4000)
                    .require(IEFluids.ETHANOL.getStill(),140)
                    .require(IEItems.Ingredients.CATALYST_PLATINUM.get(),1)
                    .output(IEItems.Ingredients.CATALYST_PLATINUM.get(),1)
                    .output(TFMGFluids.HIGH_OCTANE_GASOLINE.get(), 2800)
                    .values(mixing())),
            GASOLINE_CATALYST_REFORMING = create("gasoline_catalyst_reforming", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.NAPHTHA.get(),4000)
                    .require(TFMGFluids.GASOLINE.get(),1000)
                    .require(IEFluids.ETHANOL.getStill(),190)
                    .require(IEItems.Ingredients.CATALYST_PLATINUM.get(),1)
                    .output(IEItems.Ingredients.CATALYST_PLATINUM.get(),1)
                    .output(TFMGFluids.HIGH_OCTANE_GASOLINE.get(), 3850)
                    .values(mixing())),
            OSTWALD_PROCESS = create("ostwald_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(oxygen(), 4000))
                    .require(TFMGFluids.AMMONIA.get(), 1000)
                    .require(IEItems.Ingredients.CATALYST_PLATINUM.get(), 1)
                    .output(IEItems.Ingredients.CATALYST_PLATINUM.get(), 1)
                    .output(TFMGFluids.NITRIC_ACID.get(), 2500)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            CUPRIC_CHLORIDE_PRODUCTION = create("cupric_chloride_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGItems.COPPER_DUST.get(), 12)
                    .require(TFMGFluids.HYDROCHLORIC_ACID.get(), 3000)
                    .require(TFMGItems.SODIUM_BICARBONATE.get(), 27)
                    .output(TFMGItems.CUPRIC_CHLORIDE.get(), 32)
                    .output(TFMGFluids.CARBON_DIOXIDE.get(),1200)
                    .values(mixing())),
            HYDROCHLORIC_ACID_PRODUCTION = create("hydrochloric_acid_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(chlorine(), 1000))
                    .require(SizedFluidIngredient.of(hydrogen(), 3000))
                    .output(TFMGFluids.HYDROCHLORIC_ACID.get(), 3500)
                    .values(mixing())),
            SOLWAY_PROCESS = create("solway_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(brine(), 4000))
                    .require(TFMGFluids.AMMONIA.get(), 400)
                    .require(TFMGFluids.CARBON_DIOXIDE.get(), 1800)
                    .output(TFMGItems.SODIUM_BICARBONATE.get(), 9)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            SOLWAY_PROCESS_SODIUM = create("solway_process_sodium", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(sodium(), 18))
                    .require(TFMGFluids.AMMONIA.get(), 400)
                    .require(TFMGFluids.CARBON_DIOXIDE.get(), 1800)
                    .output(TFMGItems.SODIUM_BICARBONATE.get(), 9)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            WACKER_PROCESS = create("wacker_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.ETHYLENE.get(), 2500)
                    .require(SizedFluidIngredient.of(oxygen(), 1250))
                    .require(IEItems.Ingredients.CATALYST_CUPRIC_CHLORIDE.get(), 1) //copper catalyst
                    .output(IEItems.Ingredients.CATALYST_CUPRIC_CHLORIDE.get(), 1) //copper catalyst
                    .output(TFMGFluids.ACETALDEHYDE.get(), 2600)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            HYDROFORMYLATION_PROCESS = create("hydroformylation_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.PROPYLENE.get(), 1250)
                    .require(TFMGFluids.CARBON_MONOXIDE.get(), 1250)
                    .require(SizedFluidIngredient.of(hydrogen(), 1250))
                    .require(IEItems.Ingredients.CATALYST_CUPRIC_CHLORIDE.get(), 1) //copper catalyst
                    .output(IEItems.Ingredients.CATALYST_CUPRIC_CHLORIDE.get(), 1) //copper catalyst
                    .output(TFMGFluids.BUTYRALDEHYDE.get(), 1250)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            ETHYL_CONDENSATE_PROCESS = create("ethyl_condensate_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.BUTYRALDEHYDE.get(), 2500)
                    .require(SizedFluidIngredient.of(hydrogen(), 1250))
                    .require(IEItems.Ingredients.CATALYST_PLATINUM.get(), 1)
                    .output(IEItems.Ingredients.CATALYST_PLATINUM.get(), 1)
                    .output(TFMGFluids.ETHYLHEXANOL.get(), 1500)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            CETANE_IMPROVER_PRODUCTION = create("cetane_improver_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.ETHYLHEXANOL.get(), 1250)
                    .require(TFMGFluids.NITRIC_ACID.get(), 1250)
                    .require(TFMGFluids.SULFURIC_ACID.get(), 125)
                    .output(TFMGFluids.CETANE_IMPROVER.get(), 1250)
                    .values(mixing())),
            HIGH_CETANE_DIESEL_PRODUCTION = create("high_cetane_diesel_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.DIESEL.get(), 1250)
                    .require(TFMGFluids.CETANE_IMPROVER.get(), 2)
                    .output(TFMGFluids.HIGH_CETANE_DIESEL.get(), 1250)
                    .values(mixing())),
            GUNCOTTON_WOOD_PRODUCTION = create("guncotton_wood_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.FUMING_NITRIC_ACID.get(), 100)
                    .require(TFMGFluids.SULFURIC_ACID.get(), 315)
                    .require(IEFluids.ETHANOL.getStill(), 125)
                    .require(IEItems.Ingredients.DUST_WOOD.asItem(), 64)
                    .output(Items.GUNPOWDER.asItem(), 19)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            GUNCOTTON_COTTON_PRODUCTION = create("guncotton_cotton_production", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(TFMGFluids.FUMING_NITRIC_ACID.get(), 100)
                    .require(TFMGFluids.SULFURIC_ACID.get(), 315)
                    .require(IEFluids.ETHANOL.getStill(), 125)
                    .require(IEItems.Ingredients.COTTON_BALL.asItem(), 64)
                    .output(Items.GUNPOWDER.asItem(), 58)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            AMMONIA_HABER_PROCESS = create("ammonia_haber_process", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(hydrogen(), 735))
                    .require(SizedFluidIngredient.of(air(), 285))
                    .require(MekanismItems.STEEL_DUST.get(), 10)
                    .output(TFMGFluids.AMMONIA.get(), 1000)
                    .output(MekanismItems.STEEL_DUST.get(), 10)
                    .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
//            NEON = create("neon", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
//                            .require(TFMGFluids.AIR.get(), 1000)
//                            .output(TFMGFluids.NEON.get(), 1)
//                    .values(centrifuge())),
            SULFURIC_ACID = create("sulfuric_acid", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                    .require(SizedFluidIngredient.of(water(), 1000))
                    .require(nitrateDust())
                    .output(sulfuricAcid(), 500)
                    .values(mixing())),

            RUBBER = create("rubber", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(SizedFluidIngredient.of(heavyOil(), 250))
                    .require(TFMGItems.SULFUR_DUST.get(), 3)

                            .output(rubber())
                            .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),

            NAPHTHA = create("naphtha", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(SizedFluidIngredient.of(naphtha(), 500))
                            .output(ethylene(), 250)
                            .output(propylene(), 250)
                            .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),

            PLASTIC_FROM_ETHYLENE = create("plastic_from_ethylene", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(SizedFluidIngredient.of(ethylene(), 500))
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            PLASTIC_FROM_PROPYLENE = create("plastic_from_propylene", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(SizedFluidIngredient.of(propylene(), 500))
                            .output(liquidPlastic(), 500)
                            .requiresHeat(HeatCondition.HEATED)
                    .values(mixing())),
            ETCHED_CIRCUIT_BOARD = create("etched_circuit_board", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(TFMGItems.COATED_CIRCUIT_BOARD)
                            .require(TFMGFluids.SULFURIC_ACID.getSource(), 250)
                            .output(TFMGItems.ETCHED_CIRCUIT_BOARD)
                            .duration(100)
                    .values(noMachines())),
            ALUMINUM = create("aluminum", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
                            .require(TFMGItems.BAUXITE_POWDER.get(), 4)
                            .output(TFMGItems.ALUMINUM_INGOT)
                            .output(.5f, TFMGItems.ALUMINUM_NUGGET, 4)
                            .output(.25f, TFMGItems.ALUMINUM_NUGGET, 2)
                            .output(TFMGFluids.CARBON_DIOXIDE.get(), 500)
                            .duration(100)
                            .requiresHeat(HeatCondition.HEATED)
                    .values(electrolysis()));
            //DEBUG_5 = createVatRecipe("debug_5", b -> ((VatMachineRecipe.Builder<VatMachineRecipe>) b)
            //                .require(Blocks.GOLD_BLOCK.asItem())
            //                .require(Blocks.DIAMOND_BLOCK.asItem())
            //                .require(Blocks.IRON_BLOCK.asItem())
            //                .require(Blocks.COAL_BLOCK.asItem())
            //                .require(TFMGFluids.LIQUID_CONCRETE.getSource(), 1)
            //                .require(TFMGFluids.HEAVY_OIL.getSource(), 1)
            //                .require(TFMGFluids.COOLING_FLUID.getSource(), 1)
            //                .require(TFMGFluids.CRUDE_OIL.getSource(), 1)
            //                .output(TFMGFluids.LIQUID_CONCRETE.get(), 1)
            //                .output(TFMGFluids.HEAVY_OIL.get(), 1)
            //                .output(TFMGFluids.COOLING_FLUID.get(), 1)
            //                .output(TFMGFluids.CRUDE_OIL.get(), 1)
            //                .output(Items.EGG)
            //                .output(Items.ARROW)
            //                .output(Items.DIAMOND)
            //                .output(Items.STRING)
            //        , mixing());
;

    /// ////
    public VatRecipeValues electrolysis() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:electrode");
        params.machines.add("tfmg:electrode");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeValues mixing() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:mixing");
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }

    public VatRecipeValues centrifuge() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:centrifuge");
        return params;
    }

    public VatRecipeValues noMachines() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines = new ArrayList<>();
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:steel_vat");
        params.allowedVatTypes.add("tfmg:cast_iron_vat");
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        params.minSize = 0;
        return params;
    }

    public VatRecipeValues freezing() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeValues intenseFreezing() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        params.machines.add("tfmg:freezing");
        return params;
    }

    public VatRecipeValues arcBlasting() {
        VatRecipeValues params = new VatRecipeValues();
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.machines.add("tfmg:graphite_electrode");
        params.minSize = 9;
        params.allowedVatTypes = new ArrayList<>();
        params.allowedVatTypes.add("tfmg:firebrick_lined_vat");
        return params;
    }
    public static class VatRecipeValues{

        public List<String> machines;
        public int minSize;
        public List<String> allowedVatTypes;

        public VatRecipeValues(){
            machines = new ArrayList<>();
            minSize = 1;
            allowedVatTypes = new ArrayList<>();
            allowedVatTypes.add("tfmg:steel_vat");
            allowedVatTypes.add("tfmg:cast_iron_vat");
            allowedVatTypes.add("tfmg:firebrick_lined_vat");
        }


    }
}
