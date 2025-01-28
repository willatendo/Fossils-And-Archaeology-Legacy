package willatendo.fossilslegacy.server.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FAJEITextures {
    private static final String PATH = "textures/gui/icons/";
    private final IGuiHelper iGuiHelper;
    private final IDrawableStatic analyzationArrow;
    private final IDrawableStatic analyzationArrowFilled;
    private final IDrawableStatic archaeologyArrow;
    private final IDrawableStatic archaeologyArrowFilled;
    private final IDrawableStatic cultivationArrow;
    private final IDrawableStatic cultivationArrowFilled;
    private final IDrawableStatic vatIcon;
    private final IDrawableStatic vatOutline;
    private final IDrawableStatic vat;
    private final IDrawableStatic hammerIcon;
    private final IDrawableStatic hammerOutline;
    private final IDrawableStatic hammer;
    private final IDrawableStatic arrow;
    private final IDrawableStatic geneModification;

    public FAJEITextures(IGuiHelper iGuiHelper) {
        this.iGuiHelper = iGuiHelper;

        this.analyzationArrow = this.createIcon("analyzation_arrow", 22, 9);
        this.analyzationArrowFilled = this.createIcon("analyzation_arrow_filled", 22, 9);
        this.archaeologyArrow = this.createIcon("archaeology_arrow", 24, 14);
        this.archaeologyArrowFilled = this.createIcon("archaeology_arrow_filled", 24, 14);
        this.cultivationArrow = this.createIcon("cultivation_arrow", 21, 9);
        this.cultivationArrowFilled = this.createIcon("cultivation_arrow_filled", 21, 9);

        this.vatIcon = this.createIcon("vat_icon", 14, 14);
        this.vatOutline = this.createIcon("empty_vat", 14, 14);
        this.vat = this.createIcon("vat", 14, 14);
        this.hammerIcon = this.createIcon("hammer_icon", 14, 14);
        this.hammerOutline = this.createIcon("empty_hammer", 14, 14);
        this.hammer = this.createIcon("hammer", 14, 14);
        this.arrow = this.createIcon("arrow", 22, 15);
        this.geneModification = this.createIcon("gene_modification", 44, 16);
    }

    public IDrawableStatic getAnalyzationArrow() {
        return this.analyzationArrow;
    }

    public IDrawableStatic getArchaeologyArrow() {
        return this.archaeologyArrow;
    }

    public IDrawableStatic getCultivationArrow() {
        return this.cultivationArrow;
    }

    public IDrawableStatic getVatIcon() {
        return this.vatIcon;
    }

    public IDrawableStatic getVatOutline() {
        return this.vatOutline;
    }

    public IDrawableStatic getHammerIcon() {
        return this.hammerIcon;
    }

    public IDrawableStatic getHammerOutline() {
        return this.hammerOutline;
    }

    public IDrawableStatic getArrow() {
        return this.arrow;
    }

    public IDrawableStatic getGeneModification() {
        return this.geneModification;
    }

    public LoadingCache<Integer, IDrawableAnimated> createAnalyzationBar() {
        return this.createProgressBar(25, this.analyzationArrowFilled, IDrawableAnimated.StartDirection.LEFT);
    }

    public LoadingCache<Integer, IDrawableAnimated> createArchaeologyBar() {
        return this.createProgressBar(25, this.archaeologyArrowFilled, IDrawableAnimated.StartDirection.LEFT);
    }

    public LoadingCache<Integer, IDrawableAnimated> createCultivationBar() {
        return this.createProgressBar(25, this.cultivationArrowFilled, IDrawableAnimated.StartDirection.LEFT);
    }

    public LoadingCache<Integer, IDrawableAnimated> createBiomatterBar() {
        return this.createProgressBar(25, this.vat, IDrawableAnimated.StartDirection.TOP, true);
    }

    public LoadingCache<Integer, IDrawableAnimated> createHammerBar() {
        return this.createProgressBar(25, this.hammer, IDrawableAnimated.StartDirection.TOP, true);
    }

    public IDrawableAnimated createHammer() {
        return this.iGuiHelper.createAnimatedDrawable(this.hammer, 300, IDrawableAnimated.StartDirection.TOP, true);
    }

    public IDrawableAnimated createVat() {
        return this.iGuiHelper.createAnimatedDrawable(this.vat, 300, IDrawableAnimated.StartDirection.TOP, true);
    }

    private IDrawableStatic createIcon(String path, int width, int height) {
        return this.iGuiHelper.drawableBuilder(FossilsLegacyUtils.resource(PATH + path + ".png"), 0, 0, width, height).setTextureSize(width, height).build();
    }

    public IDrawable getIconFromItemLike(ItemLike itemLike) {
        return this.iGuiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(itemLike));
    }

    private LoadingCache<Integer, IDrawableAnimated> createProgressBar(long size, IDrawableStatic bar, IDrawableAnimated.StartDirection startDirection, boolean inverted) {
        return CacheBuilder.newBuilder().maximumSize(size).build(new CacheLoader<>() {
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return FAJEITextures.this.iGuiHelper.createAnimatedDrawable(bar, cookTime, startDirection, inverted);
            }
        });
    }

    private LoadingCache<Integer, IDrawableAnimated> createProgressBar(long size, IDrawableStatic bar, IDrawableAnimated.StartDirection startDirection) {
        return this.createProgressBar(size, bar, startDirection, false);
    }
}
