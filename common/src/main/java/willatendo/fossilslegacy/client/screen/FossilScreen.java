package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.serverbound.ServerboundDamageHammerPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartPositionsPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartRotationsPacket;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class FossilScreen extends Screen {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/fossil.png");
    private static final ResourceLocation X_SPOT_SPRITE = FAUtils.resource("container/fossil/x_spot");
    private Fossil fossil;
    private final int id;
    private final FossilRotations fossilRotations;
    private final FossilPositions fossilPositions;
    private final Holder<FossilVariant> fossilVariant;
    protected int imageWidth = 176;
    protected int imageHeight = 168;
    protected int titleLabelX = 8;
    protected int titleLabelY = 6;
    protected int leftPos;
    protected int topPos;
    private String part;
    private float partXRot;
    private float partYRot;
    private float partZRot;
    private float partX;
    private float partY;
    private float partZ;
    private boolean sliders = true;
    private EditBox xRotEditBox;
    private EditBox yRotEditBox;
    private EditBox zRotEditBox;
    private boolean shiftDown = false;
    private boolean controlDown = false;

    public FossilScreen(int id, FossilRotations fossilRotations, FossilPositions fossilPositions, Holder<FossilVariant> fossilVariant, Component title) {
        super(title);
        this.id = id;
        this.fossilRotations = fossilRotations;
        this.fossilPositions = fossilPositions;
        this.fossilVariant = fossilVariant;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.minecraft.player.getMainHandItem().is(FAItemTags.HAMMERS)) {
            this.onClose();
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return switch (keyCode) {
            case 340, 344 -> {
                this.shiftDown = true;
                yield true;
            }
            case 341, 345 -> {
                this.controlDown = true;
                yield true;
            }
            default -> super.keyPressed(keyCode, scanCode, modifiers);
        };
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return switch (keyCode) {
            case 340, 344 -> {
                this.shiftDown = false;
                yield true;
            }
            case 341, 345 -> {
                this.controlDown = false;
                yield true;
            }
            default -> super.keyReleased(keyCode, scanCode, modifiers);
        };
    }

    @Override
    protected void init() {
        this.fossil = new Fossil(FAEntityTypes.FOSSIL.get(), this.minecraft.level);
        this.fossil.setFossilRotations(this.fossilRotations);
        this.fossil.setFossilPositions(this.fossilPositions);
        this.fossil.setFossilVariant(this.fossilVariant);
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
        boolean canArticulate = this.fossilVariant.value().canArticulate();

        if (canArticulate) {
            JsonTypeModel<?> jsonTypeModel = JsonModelLoader.getModel(this.fossilVariant.value().model());
            List<ModelPart> modelParts = jsonTypeModel.getLoadedParts().getModelParts();
            for (int i = 0; i < modelParts.size(); i++) {
                String name = jsonTypeModel.getLoadedParts().getNames().get(i);
                int x = (int) Math.floor((double) i / (double) 5);
                int y = i - (x * 5);
                Button partButton = this.addRenderableWidget(Button.builder(FAUtils.translation("entity", "fossil.screen." + name), button -> {
                    this.part = name;
                    if (this.fossilRotations.contains(this.part)) {
                        FossilRotations.Rotations rotations = this.fossilRotations.get(this.part);
                        this.partXRot = rotations.xRot();
                        this.partYRot = rotations.yRot();
                        this.partZRot = rotations.zRot();
                    } else {
                        this.partXRot = 0.0F;
                        this.partYRot = 0.0F;
                        this.partZRot = 0.0F;
                    }
                    if (this.fossilPositions.contains(this.part)) {
                        FossilPositions.Positions positions = this.fossilPositions.get(this.part);
                        this.partX = positions.x();
                        this.partY = positions.y();
                        this.partZ = positions.z();
                    } else {
                        this.partX = 0.0F;
                        this.partY = 0.0F;
                        this.partZ = 0.0F;
                    }
                    this.clearWidgets();
                    this.init();
                }).bounds(this.leftPos - 75 - (x * 80), this.topPos + (y * 25), 75, 20).build());
                partButton.active = this.part == null || !this.part.equals(name);
            }
        }

        this.addRenderableWidget(Button.builder(Component.literal("\u2194"), button -> {
            this.sliders = !this.sliders;
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 173, this.topPos + 17, 20, 20).build());

        Button up = this.addRenderableWidget(Button.builder(Component.literal("\u2191"), button -> {
            this.partY -= this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 221, this.topPos + 93, 20, 20).build());
        up.active = this.part != null && canArticulate;

        Button down = this.addRenderableWidget(Button.builder(Component.literal("\u2193"), button -> {
            this.partY += this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 221, this.topPos + 141, 20, 20).build());
        down.active = this.part != null && canArticulate;

        Button left = this.addRenderableWidget(Button.builder(Component.literal("\u2190"), button -> {
            this.partX += this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 197, this.topPos + 117, 20, 20).build());
        left.active = this.part != null && canArticulate;

        Button right = this.addRenderableWidget(Button.builder(Component.literal("\u2192"), button -> {
            this.partX -= this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 245, this.topPos + 117, 20, 20).build());
        right.active = this.part != null && canArticulate;

        Button forward = this.addRenderableWidget(Button.builder(Component.literal("\u25BC"), button -> {
            this.partZ -= this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 197, this.topPos + 93, 20, 20).build());
        forward.active = this.part != null && canArticulate;

        Button backward = this.addRenderableWidget(Button.builder(Component.literal("\u25B2"), button -> {
            this.partZ += this.amount();
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 245, this.topPos + 93, 20, 20).build());
        backward.active = this.part != null && canArticulate;

        Button resetPos = this.addRenderableWidget(Button.builder(Component.literal("X"), button -> {
            this.partX = 0.0F;
            this.partY = 0.0F;
            this.partZ = 0.0F;
            this.setPos(this.partX, this.partY, this.partZ);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 221, this.topPos + 117, 20, 20).build());
        resetPos.active = this.part != null && canArticulate;

        Button zeroXRot = this.addRenderableWidget(Button.builder(Component.literal("0"), button -> {
            this.partXRot = 0.0F;
            this.setRot(this.partXRot, this.partYRot, this.partZRot);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 173, this.topPos + 93, 20, 20).build());
        zeroXRot.active = this.part != null && this.partXRot != 0.0F && canArticulate;

        Button zeroYRot = this.addRenderableWidget(Button.builder(Component.literal("0"), button -> {
            this.partYRot = 0.0F;
            this.setRot(this.partXRot, this.partYRot, this.partZRot);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 173, this.topPos + 117, 20, 20).build());
        zeroYRot.active = this.part != null && this.partYRot != 0.0F && canArticulate;

        Button zeroZRot = this.addRenderableWidget(Button.builder(Component.literal("0"), button -> {
            this.partZRot = 0.0F;
            this.setRot(this.partXRot, this.partYRot, this.partZRot);
            this.clearWidgets();
            this.init();
        }).bounds(this.leftPos + 173, this.topPos + 141, 20, 20).build());
        zeroZRot.active = this.part != null && this.partZRot != 0.0F && canArticulate;

        if (this.sliders) {
            AbstractSliderButton xRot = this.addRenderableWidget(new AbstractSliderButton(this.leftPos + 7, this.topPos + 93, 162, 20, CommonComponents.EMPTY, this.partXRot != 0.0F ? ((this.partXRot / 180.0F) / 2.0F) + 0.5F : 0.5F) {
                {
                    this.updateMessage();
                }

                @Override
                protected void updateMessage() {
                    this.setMessage(FAUtils.translation("entity", "fossil.screen.x_rot", Math.round(FossilScreen.this.partXRot)));
                }

                @Override
                protected void applyValue() {
                    FossilScreen.this.partXRot = Mth.floor(Mth.clampedLerp(-180.0, 180.0F, this.value));
                    FossilScreen.this.setRot(FossilScreen.this.partXRot, FossilScreen.this.partYRot, FossilScreen.this.partZRot);
                    FossilScreen.this.clearWidgets();
                    FossilScreen.this.init();
                }
            });
            xRot.active = this.part != null && canArticulate;
            AbstractSliderButton yRot = this.addRenderableWidget(new AbstractSliderButton(this.leftPos + 7, this.topPos + 117, 162, 20, CommonComponents.EMPTY, this.partYRot != 0.0F ? ((this.partYRot / 180.0F) / 2.0F) + 0.5F : 0.5F) {
                {
                    this.updateMessage();
                }

                @Override
                protected void updateMessage() {
                    this.setMessage(FAUtils.translation("entity", "fossil.screen.y_rot", Math.round(FossilScreen.this.partYRot)));
                }

                @Override
                protected void applyValue() {
                    FossilScreen.this.partYRot = Mth.floor(Mth.clampedLerp(-180.0, 180.0F, this.value));
                    FossilScreen.this.setRot(FossilScreen.this.partXRot, FossilScreen.this.partYRot, FossilScreen.this.partZRot);
                    FossilScreen.this.clearWidgets();
                    FossilScreen.this.init();
                }
            });
            yRot.active = this.part != null && canArticulate;
            AbstractSliderButton zRot = this.addRenderableWidget(new AbstractSliderButton(this.leftPos + 7, this.topPos + 141, 162, 20, CommonComponents.EMPTY, this.partZRot != 0.0F ? ((this.partZRot / 180.0F) / 2.0F) + 0.5F : 0.5F) {
                {
                    this.updateMessage();
                }

                @Override
                protected void updateMessage() {
                    this.setMessage(FAUtils.translation("entity", "fossil.screen.z_rot", Math.round(FossilScreen.this.partZRot)));
                }

                @Override
                protected void applyValue() {
                    FossilScreen.this.partZRot = Mth.floor(Mth.clampedLerp(-180.0, 180.0F, this.value));
                    FossilScreen.this.setRot(FossilScreen.this.partXRot, FossilScreen.this.partYRot, FossilScreen.this.partZRot);
                    FossilScreen.this.clearWidgets();
                    FossilScreen.this.init();
                }
            });
            zRot.active = this.part != null && canArticulate;
        } else {
            this.xRotEditBox = new EditBox(this.font, this.leftPos + 7, this.topPos + 93, 162, 20, CommonComponents.EMPTY) {
                @Override
                public boolean charTyped(char codePoint, int modifiers) {
                    return FossilScreen.this.isValidCharacterForName(this.getValue(), codePoint, this.getCursorPosition()) && super.charTyped(codePoint, modifiers);
                }
            };
            this.xRotEditBox.setMaxLength(6);
            this.xRotEditBox.setValue("" + Math.round(this.partXRot));
            this.xRotEditBox.setFilter(newValueString -> {
                try {
                    Integer.decode(newValueString);
                    return true;
                } catch (final NumberFormatException e) {
                    return isPartialNumber(newValueString, true);
                }
            });
            this.xRotEditBox.setResponder(s -> {
                this.partXRot = s.isEmpty() ? 0.0F : Integer.parseInt(s);
                this.setRot(this.partXRot, this.partYRot, this.partZRot);
                this.clearWidgets();
                this.init();
            });
            this.xRotEditBox.active = this.part != null && canArticulate;
            this.addWidget(this.xRotEditBox);
            this.yRotEditBox = new EditBox(this.font, this.leftPos + 7, this.topPos + 117, 162, 20, CommonComponents.EMPTY) {
                @Override
                public boolean charTyped(char codePoint, int modifiers) {
                    return FossilScreen.this.isValidCharacterForName(this.getValue(), codePoint, this.getCursorPosition()) && super.charTyped(codePoint, modifiers);
                }
            };
            this.yRotEditBox.setMaxLength(3);
            this.yRotEditBox.setValue("" + Math.round(this.partYRot));
            this.yRotEditBox.setFilter(newValueString -> {
                try {
                    Integer.decode(newValueString);
                    return true;
                } catch (final NumberFormatException e) {
                    return isPartialNumber(newValueString, true);
                }
            });
            this.yRotEditBox.setResponder(s -> {
                this.partYRot = s.isEmpty() ? 0.0F : Integer.parseInt(s);
                this.setRot(this.partXRot, this.partYRot, this.partZRot);
                this.clearWidgets();
                this.init();
            });
            this.yRotEditBox.active = this.part != null && canArticulate;
            this.addWidget(this.yRotEditBox);
            this.zRotEditBox = new EditBox(this.font, this.leftPos + 7, this.topPos + 141, 162, 20, CommonComponents.EMPTY) {
                @Override
                public boolean charTyped(char codePoint, int modifiers) {
                    return FossilScreen.this.isValidCharacterForName(this.getValue(), codePoint, this.getCursorPosition()) && super.charTyped(codePoint, modifiers);
                }
            };
            this.zRotEditBox.setMaxLength(3);
            this.zRotEditBox.setValue("" + Math.round(this.partZRot));
            this.zRotEditBox.setFilter(newValueString -> {
                try {
                    Integer.decode(newValueString);
                    return true;
                } catch (final NumberFormatException e) {
                    return isPartialNumber(newValueString, true);
                }
            });
            this.zRotEditBox.setResponder(s -> {
                this.partZRot = s.isEmpty() ? 0.0F : Integer.parseInt(s);
                this.setRot(this.partXRot, this.partYRot, this.partZRot);
                this.clearWidgets();
                this.init();
            });
            this.zRotEditBox.active = this.part != null && canArticulate;
            this.addWidget(this.zRotEditBox);
        }
    }

    private float amount() {
        return this.controlDown && this.shiftDown ? 0.25F : this.shiftDown ? 0.5F : 1.0F;
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        String xRotText = "";
        String yRotText = "";
        String zRotText = "";
        if (this.xRotEditBox != null) {
            xRotText = "" + this.xRotEditBox;
        }
        if (this.yRotEditBox != null) {
            yRotText = "" + this.yRotEditBox;
        }
        if (this.zRotEditBox != null) {
            zRotText = "" + this.zRotEditBox;
        }
        this.init(minecraft, width, height);
        if (this.xRotEditBox != null) {
            this.xRotEditBox.setValue(xRotText);
        }
        if (this.yRotEditBox != null) {
            this.yRotEditBox.setValue(yRotText);
        }
        if (this.zRotEditBox != null) {
            this.zRotEditBox.setValue(zRotText);
        }
    }

    private void setRot(float xRot, float yRot, float zRot) {
        NetworkUtils.sendToServer(new ServerboundSetFossilPartRotationsPacket(this.id, this.part, xRot, yRot, zRot));
        Entity entity = this.minecraft.level.getEntity(this.id);
        if (entity instanceof Fossil fossil) {
            fossil.getFossilRotations().setRotation(this.part, xRot, yRot, zRot);
        }
        this.fossil.getFossilRotations().setRotation(this.part, xRot, yRot, zRot);
        this.damageHammer();
    }

    private void setPos(float x, float y, float z) {
        NetworkUtils.sendToServer(new ServerboundSetFossilPartPositionsPacket(this.id, this.part, x, y, z));
        Entity entity = this.minecraft.level.getEntity(this.id);
        if (entity instanceof Fossil fossil) {
            fossil.getFossilPositions().setPosition(this.part, x, y, z);
        }
        this.fossil.getFossilPositions().setPosition(this.part, x, y, z);
        this.damageHammer();
    }

    private void damageHammer() {
        if (this.minecraft.player.getRandom().nextInt(10) == 0) {
            NetworkUtils.sendToServer(new ServerboundDamageHammerPacket(this.minecraft.player.getId()));
        }
    }

    protected boolean isPartialNumber(String value, boolean allowNegative) {
        return switch (value) {
            case "" -> true;
            case "0" -> true;
            case "0x" -> true;
            case "0X" -> true;
            case "#" -> true;
            case "-" -> allowNegative;
            case "-0" -> allowNegative;
            case "-0x" -> allowNegative;
            case "-0X" -> allowNegative;
            default -> false;
        };
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        int i = this.leftPos;
        int j = this.topPos;
        super.render(guiGraphics, mouseX, mouseX, partialTicks);
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float) i, (float) j, 0.0F);

        this.renderLabels(guiGraphics, mouseX, mouseY);

        guiGraphics.pose().popPose();
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderTransparentBackground(guiGraphics);
        this.renderBg(guiGraphics, partialTick, mouseX, mouseY);
    }

    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
    }

    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        guiGraphics.blitSprite(RenderType::guiTextured, X_SPOT_SPRITE, this.leftPos + 173, this.topPos, 99, this.imageHeight);
        InventoryScreen.renderEntityInInventory(guiGraphics, this.leftPos + 88, this.topPos + 78 + this.fossilVariant.value().yOffset(), this.fossilVariant.value().scale(), new Vector3f(), new Quaternionf().rotationXYZ(0.43633232F, 180.0F, (float) Math.PI), null, fossil);
        if (!this.sliders) {
            this.xRotEditBox.render(guiGraphics, mouseX, mouseY, partialTick);
            this.yRotEditBox.render(guiGraphics, mouseX, mouseY, partialTick);
            this.zRotEditBox.render(guiGraphics, mouseX, mouseY, partialTick);
        }
    }
}
