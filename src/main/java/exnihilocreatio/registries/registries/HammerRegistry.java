package exnihilocreatio.registries.registries;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import exnihilocreatio.api.registries.IHammerRegistry;
import exnihilocreatio.compatibility.jei.hammer.HammerRecipe;
import exnihilocreatio.json.CustomHammerRewardJson;
import exnihilocreatio.json.CustomIngredientJson;
import exnihilocreatio.json.CustomItemStackJson;
import exnihilocreatio.registries.ingredient.IngredientUtil;
import exnihilocreatio.registries.ingredient.OreIngredientStoring;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.registries.prefab.BaseRegistryMap;
import exnihilocreatio.registries.types.HammerReward;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemUtil;
import exnihilocreatio.util.StackInfo;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class HammerRegistry extends BaseRegistryMap<Ingredient, List<HammerReward>> implements IHammerRegistry {

    public HammerRegistry() {
        super(
                new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(ItemStack.class,  CustomItemStackJson.INSTANCE)
                        .registerTypeAdapter(Ingredient.class,  CustomIngredientJson.INSTANCE)
                        .registerTypeAdapter(OreIngredientStoring.class,  CustomIngredientJson.INSTANCE)
                        .registerTypeAdapter(HammerReward.class,  CustomHammerRewardJson.INSTANCE)
                        .enableComplexMapKeySerialization()
                        .create(),
                new com.google.gson.reflect.TypeToken<Map<Ingredient, List<HammerReward>>>() {}.getType(),
                ExNihiloRegistryManager.HAMMER_DEFAULT_REGISTRY_PROVIDERS
        );
    }

    @Override
    public void registerEntriesFromJSON(FileReader fr) {
        HashMap<String, ArrayList<HammerReward>> gsonInput = gson.fromJson(fr, new TypeToken<HashMap<String, ArrayList<HammerReward>>>() {
        }.getType());

        for (Map.Entry<String, ArrayList<HammerReward>> s : gsonInput.entrySet()) {
            Ingredient ingredient = IngredientUtil.parseFromString(s.getKey());


            Ingredient search = registry.keySet().stream().filter(entry -> IngredientUtil.ingredientEquals(ingredient, entry)).findAny().orElse(null);
            if (search != null) {
                registry.get(search).addAll(s.getValue());
            } else {
                NonNullList<HammerReward> drops = NonNullList.create();
                drops.addAll(s.getValue());
                registry.put(ingredient, drops);
            }
        }
    }

    /**
     * Adds a new Hammer recipe for use with Ex Nihilo hammers.
     *
     * @param state         The blocks state to add
     * @param reward        Reward
     * @param miningLevel   Mining level of hammer. 0 = Wood/Gold, 1 = Stone, 2 = Iron, 3 = Diamond. Can be higher, but will need corresponding tool material.
     * @param chance        Chance of drop
     * @param fortuneChance Chance of drop per level of fortune
     */
    public void register(@NotNull IBlockState state, @NotNull ItemStack reward, int miningLevel, float chance, float fortuneChance) {
        register(new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)), new HammerReward(reward, miningLevel, chance, fortuneChance));
    }

    public void register(@NotNull Block block, int meta, @NotNull ItemStack reward, int miningLevel, float chance, float fortuneChance) {
        register(new ItemStack(block, 1, meta), new HammerReward(reward, miningLevel, chance, fortuneChance));
    }

    public void register(@NotNull StackInfo stackInfo, @NotNull ItemStack reward, int miningLevel, float chance, float fortuneChance) {
        register(stackInfo.getItemStack(), new HammerReward(reward, miningLevel, chance, fortuneChance));
    }

    public void register(@NotNull ItemStack stack, @NotNull HammerReward reward) {
        if (stack.isEmpty())
            return;
        Ingredient ingredient = CraftingHelper.getIngredient(stack);
        register(ingredient, reward);
    }

    public void register(@NotNull String name, @NotNull ItemStack reward, int miningLevel, float chance, float fortuneChance) {
        Ingredient ingredient = new OreIngredientStoring(name);
        register(ingredient, new HammerReward(reward, miningLevel, chance, fortuneChance));
    }

    public void register(@NotNull Ingredient ingredient, @NotNull HammerReward reward) {
        Ingredient search = registry.keySet().stream().filter(entry -> IngredientUtil.ingredientEquals(ingredient, entry)).findAny().orElse(null);

        if (search != null) {
            registry.get(search).add(reward);
        } else {
            NonNullList<HammerReward> drops = NonNullList.create();
            drops.add(reward);
            registry.put(ingredient, drops);
        }
    }

    @NotNull
    public NonNullList<ItemStack> getRewardDrops(@NotNull Random random, @NotNull IBlockState block, int miningLevel, int fortuneLevel) {
        NonNullList<ItemStack> rewards = NonNullList.create();

        for (HammerReward reward : getRewards(block)) {
            if (miningLevel >= reward.getMiningLevel()) {
                if (random.nextFloat() <= reward.getChance() + (reward.getFortuneChance() * fortuneLevel)) {
                    rewards.add(reward.getStack().copy());
                }
            }
        }

        return rewards;
    }

    @NotNull
    public NonNullList<HammerReward> getRewards(@NotNull IBlockState block) {
        return getRewards(new BlockInfo(block));
    }

    @NotNull
    public NonNullList<HammerReward> getRewards(@NotNull Block block, int meta) {
        return getRewards(new BlockInfo(block, meta));
    }

    @NotNull
    public NonNullList<HammerReward> getRewards(@NotNull BlockInfo stackInfo) {
        NonNullList<HammerReward> drops = NonNullList.create();
        if (stackInfo.isValid())
            registry.entrySet().stream().filter(entry -> entry.getKey().test(stackInfo.getItemStack())).forEach(entry -> drops.addAll(entry.getValue()));
        return drops;
    }

    @NotNull
    public NonNullList<HammerReward> getRewards(@NotNull Ingredient ingredient) {
        NonNullList<HammerReward> drops = NonNullList.create();
        registry.entrySet().stream().filter(entry -> entry.getKey() == ingredient).forEach(entry -> drops.addAll(entry.getValue()));
        return drops;
    }

    public boolean isRegistered(@NotNull IBlockState block) {
        return isRegistered(new BlockInfo(block));
    }

    public boolean isRegistered(@NotNull Block block) {
        return isRegistered(new BlockInfo(block.getDefaultState()));
    }

    /**
     * Just so that tinkers complement doesn't crash
     */
    @Deprecated
    public boolean registered(Block block) {
        return isRegistered(new BlockInfo(block.getDefaultState()));
    }

    public boolean isRegistered(@NotNull BlockInfo stackInfo) {
        return registry.keySet().stream().anyMatch(ingredient -> ingredient.test(stackInfo.getItemStack()));
    }

    // Legacy TODO: REMOVE if it works with ex compressum
    @Deprecated
    public List<HammerReward> getRewards(IBlockState state, int miningLevel) {
        NonNullList<HammerReward> drops = NonNullList.create();
        BlockInfo block = new BlockInfo(state);

        registry.entrySet().stream().filter(entry -> entry.getKey().test(block.getItemStack()))
                .forEach(entry -> entry.getValue().stream().filter(value -> value.getMiningLevel() <= miningLevel).forEach(drops::add));

        return drops;
    }

    @Override
    public List<HammerRecipe> getRecipeList() {
        List<HammerRecipe> hammerRecipes = Lists.newLinkedList();
        for(Ingredient ingredient : getRegistry().keySet()){
            if(ingredient == null)
                continue;
            List<ItemStack> rawOutputs = getRewards(ingredient).stream().map(HammerReward::getStack).collect(Collectors.toList());
            List<ItemStack> allOutputs = new ArrayList<>();
            for(ItemStack raw : rawOutputs){
                boolean alreadyexists = false;
                for(ItemStack all : allOutputs){
                    if(ItemUtil.areStacksEquivalent(all, raw)){
                        alreadyexists = true;
                        break;
                    }
                }
                if(!alreadyexists)
                    allOutputs.add(raw);
            }
            List<ItemStack> inputs = Arrays.asList(ingredient.getMatchingStacks());
            for(int i = 0; i < allOutputs.size(); i+=21){
                final List<ItemStack> outputs = allOutputs.subList(i, Math.min(i+21, allOutputs.size()));
                hammerRecipes.add(new HammerRecipe(inputs, outputs));
            }
        }
        return hammerRecipes;
    }
}
