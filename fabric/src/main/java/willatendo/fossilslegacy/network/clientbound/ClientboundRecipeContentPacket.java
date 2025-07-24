package willatendo.fossilslegacy.network.clientbound;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record ClientboundRecipeContentPacket(Set<RecipeType<?>> recipeTypes, List<RecipeHolder<?>> recipes) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundRecipeContentPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("neoforge", "recipe_content"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundRecipeContentPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.registry(Registries.RECIPE_TYPE).apply(ByteBufCodecs.collection(HashSet::new)), ClientboundRecipeContentPacket::recipeTypes, RecipeHolder.STREAM_CODEC.apply(ByteBufCodecs.list()), ClientboundRecipeContentPacket::recipes, ClientboundRecipeContentPacket::new);

    public static ClientboundRecipeContentPacket create(Collection<RecipeType<?>> recipeTypes, RecipeMap recipes) {
        Set<RecipeType<?>> recipeTypeSet = Set.copyOf(recipeTypes);
        if (recipeTypeSet.isEmpty()) {
            return new ClientboundRecipeContentPacket(recipeTypeSet, List.of());
        } else {
            List<RecipeHolder<?>> recipeSubset = recipes.values().stream().filter(recipeHolder -> recipeTypeSet.contains(recipeHolder.value().getType())).toList();
            return new ClientboundRecipeContentPacket(recipeTypeSet, recipeSubset);
        }
    }

    public CustomPacketPayload.Type<ClientboundRecipeContentPacket> type() {
        return TYPE;
    }

    public Set<RecipeType<?>> recipeTypes() {
        return this.recipeTypes;
    }

    public List<RecipeHolder<?>> recipes() {
        return this.recipes;
    }
}
