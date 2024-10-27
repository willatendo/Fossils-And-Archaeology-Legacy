package willatendo.fossilslegacy.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import willatendo.fossilslegacy.server.entity.PersistentDataEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@Mixin(Entity.class)
public abstract class EntityMixin implements PersistentDataEntity {
    private CompoundTag persistentData;

    @Override
    public CompoundTag getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new CompoundTag();
        }
        return persistentData;
    }

    @Inject(method = "saveWithoutId", at = @At("HEAD"))
    private void fossilslegacy_savePersistentData(CompoundTag compoundTag, CallbackInfoReturnable<CompoundTag> compoundTagCallbackInfoReturnable) {
        if (this.persistentData != null) {
            compoundTag.put(FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG, this.persistentData);
        }
    }

    @Inject(method = "load", at = @At("HEAD"))
    private void fossilslegacy_readPersistentData(CompoundTag compoundTag, CallbackInfo callbackInfo) {
        if (compoundTag.contains(FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG, 10)) {
            this.persistentData = compoundTag.getCompound(FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG);
        }
    }
}
