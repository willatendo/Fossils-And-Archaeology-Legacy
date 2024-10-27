package willatendo.fossilslegacy.client.toasts;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class CoatTypeToast implements Toast {
    private static final ResourceLocation BACKGROUND_SPRITE = ResourceLocation.withDefaultNamespace("toast/recipe");
    private final List<Holder<CoatType>> coatTypes = Lists.newArrayList();
    private long lastChanged;
    private boolean changed;

    public CoatTypeToast(List<Holder<CoatType>> coatTypes) {
        this.coatTypes.addAll(coatTypes);
    }

    @Override
    public Toast.Visibility render(GuiGraphics guiGraphics, ToastComponent toastComponent, long timeSinceLastVisible) {
        if (this.changed) {
            this.lastChanged = timeSinceLastVisible;
            this.changed = false;
        }

        if (this.coatTypes.isEmpty()) {
            return Toast.Visibility.HIDE;
        } else {
            Holder<CoatType> coatTypeHolder = this.coatTypes.get((int) ((double) timeSinceLastVisible / Math.max(1.0, 5000.0 * toastComponent.getNotificationDisplayTimeMultiplier() / (double) this.coatTypes.size()) % (double) this.coatTypes.size()));

            guiGraphics.blitSprite(BACKGROUND_SPRITE, 0, 0, this.width(), this.height());
            guiGraphics.drawString(toastComponent.getMinecraft().font, FossilsLegacyUtils.fullTranslation("coat_type.toast.title"), 5, 7, -11534256, false);
            guiGraphics.drawString(Minecraft.getInstance().font, coatTypeHolder.value().displayInfo().name(), 5, 18, -16777215, false);
            return (double) (timeSinceLastVisible - this.lastChanged) >= 5000.0 * toastComponent.getNotificationDisplayTimeMultiplier() ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
        }
    }

    private void addItem(List<Holder<CoatType>> coatTypes) {
        this.coatTypes.addAll(coatTypes);
        this.changed = true;
    }

    public static void addOrUpdate(ToastComponent toastComponent, List<Holder<CoatType>> coatTypes) {
        CoatTypeToast coatTypeToast = toastComponent.getToast(CoatTypeToast.class, NO_TOKEN);
        if (coatTypeToast == null) {
            toastComponent.addToast(new CoatTypeToast(coatTypes));
        } else {
            coatTypeToast.addItem(coatTypes);
        }
    }
}
