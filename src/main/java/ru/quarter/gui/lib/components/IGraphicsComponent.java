package ru.quarter.gui.lib.components;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.quarter.gui.lib.components.container.IGraphicsLayout;
import ru.quarter.gui.lib.utils.OffsetProperties;

public interface IGraphicsComponent {

    /**
     * Gets the component ID in it's container
     * @return the local area ID
     */
    int getID();

    /**
     * Sets the component ID in it's container to specified value
     * ONLY for internal use
     * @param id specified ID
     */
    void setID(int id);
    /**
     * Return HTML-like margin
     * Should be included in GuiLib 1.1
     * @return the outer offset of the element
     */
    OffsetProperties getMargin();

    /**
     * Return HTML-like padding
     * Should be included in GuiLib 1.1
     * @return the inner offset of the element
     */
    OffsetProperties getPadding();

    /**
     *
     * @return texture of the element
     */
    ResourceLocation getTexture();

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    /**
     * Updating state when needed(see {@link IGraphicsComponent#needUpdate()})
     */
    void update();

    /**
     * Initializes component. Must be called once in root GUI container init.
     */
    void init();

    /**
     * Called when root container is closed
     */
    void onClosed();

    IGraphicsLayout getParent();

    void setParent(IGraphicsLayout parent);

    /**
     * Gets the actual relative binding of the element. Now is equal to {@link IGraphicsComponent#getParent()}.
     * Should be included in GuiLib 1.1
     * @return the actual binding of the element
     */
    default IGraphicsComponent getBinding() {
        return getParent();
    }

    /**
     * Main drawing method
     */
    void draw();

    /**
     * Standard render method
     * ONLY FOR INTERNAL USE - Do not override!
     */
    default void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(getX(), getY(), getDepth());
        draw();
        GL11.glPopMatrix();
    }

    /**
     * Processes hover event
     */
    void onHover(int mouseX, int mouseY);

    /**
     * Processes mouse event
     * @param mouseX scaled relative X mouse coordinate
     * @param mouseY scaled relative Y mouse coordinate
     * @param mouseButton pressed button
     */
    void onMousePressed(int mouseX, int mouseY, int mouseButton);

    /**
     * Processes keyboard event
     * @param typedChar
     * @param keyCode
     */
    void onKeyPressed(char typedChar, int keyCode);

    /**
     * Set component to 'need update' state
     */
    void markDirty();

    boolean needUpdate();

    int getDepth();

    void setDepth(int depth);

    /**
     * Called when GUI was resized
     * @param mc Minecraft instance
     * @param w new width
     * @param h new height
     */
    void onResize(Minecraft mc, int w, int h);

    /**
     * Intersects given coordinates with this component
     * @param mouseX x point for intersect
     * @param mouseY y point for intersect
     * @return {@code true} if intersects
     */
    default boolean intersects(int mouseX, int mouseY) {
        return getX() <= mouseX && mouseX <= getX() + getWidth() && getY() <= mouseY && mouseY <= getY() + getHeight();
    }
}
