package exnihilocreatio.registries.manager;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import exnihilocreatio.ModItems;
import exnihilocreatio.blocks.BlockSieve.MeshType;
import exnihilocreatio.items.EnumPebbleSubtype;
import exnihilocreatio.items.ItemPebble;
import exnihilocreatio.items.ItemResource;
import exnihilocreatio.items.ore.ItemOre;
import exnihilocreatio.items.seeds.ItemSeedBase;
import exnihilocreatio.registries.*;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import exnihilocreatio.util.Util;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ExNihiloDefaultRecipes implements ISieveDefaultRegistryProvider, IHammerDefaultRegistryProvider,
        ICompostDefaultRegistryProvider, ICrookDefaultRegistryProvider, ICrucibleDefaultRegistryProvider, IFluidBlockDefaultRegistryProvider,
        IFluidTransformDefaultRegistryProvider, IFluidOnTopDefaultRegistryProvider, IHeatDefaultRegistryProvider, IOreDefaultRegistryProvider {

    public ExNihiloDefaultRecipes() {
        ExNihiloRegistryManager.registerSieveDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerHammerDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerCompostDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerCrookDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerCrucibleDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerFluidBlockDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerFluidTransformDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerFluidOnTopDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerHeatDefaultRecipeHandler(this);
        ExNihiloRegistryManager.registerOreDefaultRecipeHandler(this);
    }

    @Override
    public void registerSieveRecipeDefaults() {
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 1f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 1f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 0.5f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 0.5f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 0.1f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("stone"), 0.1f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("granite"), 0.5f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("granite"), 0.1f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("diorite"), 0.5f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("diorite"), 0.1f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("andesite"), 0.5f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemPebble.getPebbleStack("andesite"), 0.1f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.DIRT.getDefaultState(), new ItemInfo(Items.WHEAT_SEEDS, 0), 0.7f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), new ItemInfo(Items.MELON_SEEDS, 0), 0.35f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), new ItemInfo(Items.PUMPKIN_SEEDS, 0), 0.35f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.SAND.getDefaultState(), new ItemInfo(Items.DYE, 3), 0.03f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.FLINT, 0), 0.25f, MeshType.FLINT.getID());
        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.COAL, 0), 0.125f, MeshType.FLINT.getID());
        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.DYE, 4), 0.05f, MeshType.FLINT.getID());

        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.DIAMOND, 0), 0.008f, MeshType.IRON.getID());
        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.EMERALD, 0), 0.008f, MeshType.IRON.getID());

        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.DIAMOND, 0), 0.016f, MeshType.DIAMOND.getID());
        SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemInfo(Items.EMERALD, 0), 0.016f, MeshType.DIAMOND.getID());

        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.QUARTZ, 0), 1f, MeshType.FLINT.getID());
        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.QUARTZ, 0), 0.33f, MeshType.FLINT.getID());

        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.NETHER_WART, 0), 0.1f, MeshType.STRING.getID());

        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.GHAST_TEAR, 0), 0.02f, MeshType.DIAMOND.getID());
        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.QUARTZ, 0), 1f, MeshType.DIAMOND.getID());
        SieveRegistry.register(Blocks.SOUL_SAND.getDefaultState(), new ItemInfo(Items.QUARTZ, 0), 0.8f, MeshType.DIAMOND.getID());

        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.DYE, 15), 0.2f, MeshType.STRING.getID());
        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.GUNPOWDER, 0), 0.07f, MeshType.STRING.getID());

        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.REDSTONE, 0), 0.125f, MeshType.IRON.getID());
        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.REDSTONE, 0), 0.25f, MeshType.DIAMOND.getID());

        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.GLOWSTONE_DUST, 0), 0.0625f, MeshType.IRON.getID());
        SieveRegistry.register(ModBlocks.dust.getDefaultState(), new ItemInfo(Items.BLAZE_POWDER, 0), 0.05f, MeshType.IRON.getID());

        // Ores
        for (ItemOre ore : OreRegistry.getItemOreRegistry()) {
            SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemStack(ore, 1, 0), 0.2f, MeshType.FLINT.getID());
            SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemStack(ore, 1, 0), 0.2f, MeshType.IRON.getID());
            SieveRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemStack(ore, 1, 0), 0.1f, MeshType.DIAMOND.getID());
        }

        // Seeds
        for (ItemSeedBase seed : ModItems.itemSeeds) {
            SieveRegistry.register(Blocks.DIRT.getDefaultState(), new ItemStack(seed), 0.05f, MeshType.STRING.getID());
        }

        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemResource.getResourceStack(ItemResource.ANCIENT_SPORES), 0.05f, MeshType.STRING.getID());
        SieveRegistry.register(Blocks.DIRT.getDefaultState(), ItemResource.getResourceStack(ItemResource.GRASS_SEEDS), 0.05f, MeshType.STRING.getID());
    }


    @Override
    public void registerHammerRecipeDefaults() {
        HammerRegistry.register(Blocks.COBBLESTONE.getDefaultState(), new ItemStack(Blocks.GRAVEL, 1), 0, 1.0F, 0.0F);
        HammerRegistry.register(Blocks.GRAVEL.getDefaultState(), new ItemStack(Blocks.SAND, 1), 0, 1.0F, 0.0F);
        HammerRegistry.register(Blocks.SAND.getDefaultState(), new ItemStack(ModBlocks.dust, 1), 0, 1.0F, 0.0F);
        HammerRegistry.register(Blocks.NETHERRACK.getDefaultState(), new ItemStack(ModBlocks.netherrackCrushed, 1), 0, 1.0F, 0.0F);
        HammerRegistry.register(Blocks.END_STONE.getDefaultState(), new ItemStack(ModBlocks.endstoneCrushed, 1), 0, 1.0F, 0.0F);

        // Hammering Logs gives planks
        HammerRegistry.register(Blocks.LOG.getDefaultState(), new ItemStack(Blocks.PLANKS), 0, 1.0F, 0.0F, true);

        // Hammering stone into pebbles (no idea why anyone should do that, but hey :P)
        HammerRegistry.register(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), new ItemStack(ModItems.pebbles, 1, EnumPebbleSubtype.STONE.getMeta()), 1, 3F, 1.25F);
        HammerRegistry.register(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), new ItemStack(ModItems.pebbles, 1, EnumPebbleSubtype.ANDESITE.getMeta()), 1, 3F, 1.25F);
        HammerRegistry.register(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), new ItemStack(ModItems.pebbles, 1, EnumPebbleSubtype.GRANITE.getMeta()), 1, 3F, 1.25F);
        HammerRegistry.register(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), new ItemStack(ModItems.pebbles, 1, EnumPebbleSubtype.DIORITE.getMeta()), 1, 3F, 1.25F);
    }

    public void registerCompostRecipeDefaults() {
        IBlockState dirtState = Blocks.DIRT.getDefaultState();

        CompostRegistry.register(Items.ROTTEN_FLESH, 0, 0.1f, dirtState, new Color("C45631"));

        CompostRegistry.register(Blocks.SAPLING, 0, 0.125f, dirtState, new Color("35A82A"));
        CompostRegistry.register(Blocks.SAPLING, 1, 0.125f, dirtState, new Color("2E8042"));
        CompostRegistry.register(Blocks.SAPLING, 2, 0.125f, dirtState, new Color("6CC449"));
        CompostRegistry.register(Blocks.SAPLING, 3, 0.125f, dirtState, new Color("22A116"));
        CompostRegistry.register(Blocks.SAPLING, 4, 0.125f, dirtState, new Color("B8C754"));
        CompostRegistry.register(Blocks.SAPLING, 5, 0.125f, dirtState, new Color("378030"));

        CompostRegistry.register(Blocks.LEAVES, 0, 0.125f, dirtState, new Color("35A82A"));
        CompostRegistry.register(Blocks.LEAVES, 1, 0.125f, dirtState, new Color("2E8042"));
        CompostRegistry.register(Blocks.LEAVES, 2, 0.125f, dirtState, new Color("6CC449"));
        CompostRegistry.register(Blocks.LEAVES, 3, 0.125f, dirtState, new Color("22A116"));
        CompostRegistry.register(Blocks.LEAVES2, 0, 0.125f, dirtState, new Color("B8C754"));
        CompostRegistry.register(Blocks.LEAVES2, 1, 0.125f, dirtState, new Color("378030"));

        CompostRegistry.register(Items.SPIDER_EYE, 0, 0.08f, dirtState, new Color("963E44"));

        CompostRegistry.register(Items.WHEAT, 0, 0.08f, dirtState, new Color("E3E162"));
        CompostRegistry.register(Items.WHEAT_SEEDS, 0, 0.08f, dirtState, new Color("35A82A"));
        CompostRegistry.register(Items.BREAD, 0, 0.16f, dirtState, new Color("D1AF60"));

        CompostRegistry.register(Blocks.YELLOW_FLOWER, 0, 0.10f, dirtState, new Color("FFF461"));
        CompostRegistry.register(Blocks.RED_FLOWER, 0, 0.10f, dirtState, new Color("FF1212"));
        CompostRegistry.register(Blocks.RED_FLOWER, 1, 0.10f, dirtState, new Color("33CFFF"));
        CompostRegistry.register(Blocks.RED_FLOWER, 2, 0.10f, dirtState, new Color("F59DFA"));
        CompostRegistry.register(Blocks.RED_FLOWER, 3, 0.10f, dirtState, new Color("E3E3E3"));
        CompostRegistry.register(Blocks.RED_FLOWER, 4, 0.10f, dirtState, new Color("FF3D12"));
        CompostRegistry.register(Blocks.RED_FLOWER, 5, 0.10f, dirtState, new Color("FF7E29"));
        CompostRegistry.register(Blocks.RED_FLOWER, 6, 0.10f, dirtState, new Color("FFFFFF"));
        CompostRegistry.register(Blocks.RED_FLOWER, 7, 0.10f, dirtState, new Color("F5C4FF"));
        CompostRegistry.register(Blocks.RED_FLOWER, 8, 0.10f, dirtState, new Color("E9E9E9"));

        CompostRegistry.register(Blocks.DOUBLE_PLANT, 0, 0.10f, dirtState, new Color("FFDD00"));
        CompostRegistry.register(Blocks.DOUBLE_PLANT, 1, 0.10f, dirtState, new Color("FCC7F0"));
        CompostRegistry.register(Blocks.DOUBLE_PLANT, 4, 0.10f, dirtState, new Color("FF1212"));
        CompostRegistry.register(Blocks.DOUBLE_PLANT, 5, 0.10f, dirtState, new Color("F3D2FC"));

        CompostRegistry.register(Blocks.BROWN_MUSHROOM, 0, 0.10f, dirtState, new Color("CFBFB6"));
        CompostRegistry.register(Blocks.RED_MUSHROOM, 0, 0.10f, dirtState, new Color("D6A8A5"));

        CompostRegistry.register(Items.PUMPKIN_PIE, 0, 0.16f, dirtState, new Color("E39A6D"));

        CompostRegistry.register(Items.PORKCHOP, 0, 0.2f, dirtState, new Color("FFA091"));
        CompostRegistry.register(Items.COOKED_PORKCHOP, 0, 0.2f, dirtState, new Color("FFFDBD"));

        CompostRegistry.register(Items.BEEF, 0, 0.2f, dirtState, new Color("FF4242"));
        CompostRegistry.register(Items.COOKED_BEEF, 0, 0.2f, dirtState, new Color("80543D"));

        CompostRegistry.register(Items.CHICKEN, 0, 0.2f, dirtState, new Color("FFE8E8"));
        CompostRegistry.register(Items.COOKED_CHICKEN, 0, 0.2f, dirtState, new Color("FA955F"));

        CompostRegistry.register(Items.FISH, 0, 0.15f, dirtState, new Color("6DCFB3"));
        CompostRegistry.register(Items.COOKED_FISH, 0, 0.15f, dirtState, new Color("D8EBE5"));

        CompostRegistry.register(Items.FISH, 1, 0.15f, dirtState, new Color("FF2E4A"));
        CompostRegistry.register(Items.COOKED_FISH, 1, 0.15f, dirtState, new Color("E87A3F"));

        CompostRegistry.register(Items.FISH, 2, 0.15f, dirtState, new Color("FF771C"));
        CompostRegistry.register(Items.FISH, 3, 0.15f, dirtState, new Color("DBFAFF"));

        CompostRegistry.register(ModItems.resources, ItemResource.getMetaFromName(ItemResource.SILKWORM), 0.04f, dirtState, new Color("ff9966"));
        CompostRegistry.register(ModItems.cookedSilkworm, 0, 0.04f, dirtState, new Color("cc6600"));

        CompostRegistry.register(Items.APPLE, 0, 0.10f, dirtState, new Color("FFF68F"));
        CompostRegistry.register(Items.MELON, 0, 0.04f, dirtState, new Color("FF443B"));
        CompostRegistry.register(Blocks.MELON_BLOCK, 0, 1.0f / 6, dirtState, new Color("FF443B"));
        CompostRegistry.register(Blocks.PUMPKIN, 0, 1.0f / 6, dirtState, new Color("FFDB66"));
        CompostRegistry.register(Blocks.LIT_PUMPKIN, 0, 1.0f / 6, dirtState, new Color("FFDB66"));

        CompostRegistry.register(Blocks.CACTUS, 0, 0.10f, dirtState, new Color("DEFFB5"));

        CompostRegistry.register(Items.CARROT, 0, 0.08f, dirtState, new Color("FF9B0F"));
        CompostRegistry.register(Items.POTATO, 0, 0.08f, dirtState, new Color("FFF1B5"));
        CompostRegistry.register(Items.BAKED_POTATO, 0, 0.08f, dirtState, new Color("FFF1B5"));
        CompostRegistry.register(Items.POISONOUS_POTATO, 0, 0.08f, dirtState, new Color("E0FF8A"));

        CompostRegistry.register(Blocks.WATERLILY, 0, 0.10f, dirtState, new Color("269900"));
        CompostRegistry.register(Blocks.VINE, 0, 0.10f, dirtState, new Color("23630E"));
        CompostRegistry.register(Blocks.TALLGRASS, 1, 0.08f, dirtState, new Color("23630E"));
        CompostRegistry.register(Items.EGG, 0, 0.08f, dirtState, new Color("FFFA66"));
        CompostRegistry.register(Items.NETHER_WART, 0, 0.10f, dirtState, new Color("FF2B52"));
        CompostRegistry.register(Items.REEDS, 0, 0.08f, dirtState, new Color("9BFF8A"));
        CompostRegistry.register(Items.STRING, 0, 0.04f, dirtState, Util.whiteColor);
    }

    @Override
    public void registerCrookRecipeDefaults() {
        CrookRegistry.register(new BlockInfo(Blocks.LEAVES, -1), ItemResource.getResourceStack(ItemResource.SILKWORM), 0.1f, 0f);
        CrookRegistry.register(new BlockInfo(Blocks.LEAVES2, -1), ItemResource.getResourceStack(ItemResource.SILKWORM), 0.1f, 0f);
    }

    @Override
    public void registerCrucibleRecipeDefaults() {
        CrucibleRegistry.register(new ItemStack(Blocks.COBBLESTONE), FluidRegistry.LAVA, 250);
    }

    @Override
    public void registerFluidBlockRecipeDefaults() {
        FluidBlockTransformerRegistry.register(FluidRegistry.WATER, new ItemInfo(new ItemStack(ModBlocks.dust)), new ItemInfo(new ItemStack(Blocks.CLAY)));
        FluidBlockTransformerRegistry.register(FluidRegistry.LAVA, new ItemInfo(new ItemStack(Items.REDSTONE)), new ItemInfo(new ItemStack(Blocks.NETHERRACK)));
        FluidBlockTransformerRegistry.register(FluidRegistry.LAVA, new ItemInfo(new ItemStack(Items.GLOWSTONE_DUST)), new ItemInfo(new ItemStack(Blocks.END_STONE)));
        FluidBlockTransformerRegistry.register(ModFluids.fluidWitchwater, new ItemInfo(new ItemStack(Blocks.SAND)), new ItemInfo(new ItemStack(Blocks.SOUL_SAND)));
    }

    @Override
    public void registerFluidTransformRecipeDefaults() {
        FluidTransformRegistry.register("water", "witchwater", 12000, new BlockInfo[]{new BlockInfo(Blocks.MYCELIUM.getDefaultState())}, new BlockInfo[]{new BlockInfo(Blocks.BROWN_MUSHROOM.getDefaultState()), new BlockInfo(Blocks.RED_MUSHROOM.getDefaultState())});
    }

    @Override
    public void registerFluidOnTopRecipeDefaults() {
        FluidOnTopRegistry.register(FluidRegistry.LAVA, FluidRegistry.WATER, new ItemInfo(Blocks.OBSIDIAN.getDefaultState()));
        FluidOnTopRegistry.register(FluidRegistry.WATER, FluidRegistry.LAVA, new ItemInfo(Blocks.COBBLESTONE.getDefaultState()));
    }

    @Override
    public void registerHeatRecipeDefaults() {
        // Vanilla fluids are weird, the "flowing" variant is simply a temporary state of checking if it can flow.
        // So, once the lava has spread out all the way, it will all actually be "still" lava.
        // Thanks Mojang <3
        HeatRegistry.register(new BlockInfo(Blocks.FLOWING_LAVA, -1), 3);
        HeatRegistry.register(new BlockInfo(Blocks.LAVA, -1), 3);
        HeatRegistry.register(new BlockInfo(Blocks.FIRE, -1), 4);
        HeatRegistry.register(new BlockInfo(Blocks.TORCH, -1), 1);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void registerOreRecipeDefaults() {
        OreRegistry.register("gold", new Color("FFFF00"), new ItemInfo(Items.GOLD_INGOT, 0));
        OreRegistry.register("iron", new Color("BF8040"), new ItemInfo(Items.IRON_INGOT, 0));

        //TODO: Better way, will most likely never grab as it is just called before many mods init their oredict
        if (OreDictionary.getOres("oreCopper").size() > 0) {
            OreRegistry.register("copper", new Color("FF9933"), null);
        }

        if (OreDictionary.getOres("oreTin").size() > 0) {
            OreRegistry.register("tin", new Color("E6FFF2"), null);
        }

        if (OreDictionary.getOres("oreAluminium").size() > 0 || OreDictionary.getOres("oreAluminum").size() > 0) {
            OreRegistry.register("aluminium", new Color("BFBFBF"), null);
        }

        if (OreDictionary.getOres("oreLead").size() > 0) {
            OreRegistry.register("lead", new Color("330066"), null);
        }

        if (OreDictionary.getOres("oreSilver").size() > 0) {
            OreRegistry.register("silver", new Color("F2F2F2"), null);
        }

        if (OreDictionary.getOres("oreNickel").size() > 0) {
            OreRegistry.register("nickel", new Color("FFFFCC"), null);
        }

        if (OreDictionary.getOres("oreArdite").size() > 0) {
            OreRegistry.register("ardite", new Color("FF751A"), null);
        }

        if (OreDictionary.getOres("oreCobalt").size() > 0) {
            OreRegistry.register("cobalt", new Color("3333FF"), null);
        }

    }
}
