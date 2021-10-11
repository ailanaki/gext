/*
 * Copyright 2020 Stanislav Batalenkov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.quarter.gui.lib.forge111;

import com.github.quarter.gui.lib.GuiLib;
import com.github.quarter.gui.lib.api.IGraphicsComponent;
import com.github.quarter.gui.lib.api.IGraphicsLayout;
import com.github.quarter.gui.lib.api.IRootLayout;
import com.github.quarter.gui.lib.api.adapter.IScaledResolution;
import com.github.quarter.gui.lib.components.container.BasicLayout;
import com.github.quarter.gui.lib.utils.FrameStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.IOException;

public abstract class ExtendedGui extends Gui implements IRootLayout {

    private final BasicLayout<IGraphicsComponent> layout;

    public ExtendedGui() {
        IScaledResolution res = GuiLib.getResourceManager().scaled();
        this.layout = new BasicLayout<>(0, 0, res.getScaledWidth(), res.getScaledHeight());
    }

    @Override
    public IGraphicsLayout<IGraphicsComponent> layout() {
        return layout;
    }

    public void initGui() {
        initLayout();
        layout.init();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        FrameStack.getInstance().apply(new Rectangle(0, 0, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight));
        layout.render(mouseX, mouseY);
        FrameStack.getInstance().flush();
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        layout.onKeyPressed(typedChar, keyCode);
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        layout.onMousePressed(mouseX, mouseY, mouseButton);
    }

    public void onResize(@Nonnull Minecraft mc, int w, int h) {
        layout.onResize(w, h);
    }

    public void onGuiClosed() {
        layout.onClosed();
    }
}
