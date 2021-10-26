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

package com.github.quarter.gui.lib.forge112;

import com.github.quarter.gui.lib.api.IGraphicsComponent;
import com.github.quarter.gui.lib.components.Graphics;
import com.github.quarter.gui.lib.components.container.GPanel;

public class GuiTest extends ExtendedGuiScreen {

    @Override
    public void initLayout() {
        this.add(Graphics.label().text("Hello, world!").placeAt(50, 50).build());
        this.add(Graphics.label().text("Hello, world!").scale(2.0F).placeAt(100, 100).build());
        this.add(Graphics.label().text("Hello, world!").scale(4.0F).placeAt(150, 150).build());
        this.add(Graphics.link().text("GuiLib original source").url("https://github.com/StannisMod/guilib").color(0xffffff, 0x121212).scale(2.0F).placeAt(250, 200).setCentered().build());

        final GPanel<IGraphicsComponent> panel = Graphics.panel().size(500, 500).placeAt(100, 100).build();
        this.add(panel);

        this.add(Graphics.label().text("The first perfect text should be here").placeAt(300, 100).setCentered().build());
        this.add(Graphics.label().text("The second perfect text should be here").placeAt(800, 100).setCentered().build());
        //panel.addComponent(Graphics.background().size(400, 200).build());
        panel.addComponent(10, Graphics.label().text("This text should be rendered", 0xffffff).placeAt(200, 200).setCentered().build());
        panel.addComponent(Graphics.label().text("But this shouldn't, because it's out of bounds", 0xffffff).placeAt(800, 200).setCentered().build());

        this.add(100, Graphics.button()
                .label(Graphics.label().text("Primary text", 0xffffff).scale(2.0F).setCentered().build())
                .action(button -> {
                    if (button.getLabel().getText().startsWith("P")) {
                        button.getLabel().setText("SecondaryText");
                    } else {
                        button.getLabel().setText("PrimaryText");
                    }
                })
                .size(150, 60)
                .placeAt(800, 400)
                .build());
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
//        GL11.glPushMatrix();
//        GL11.glScaled(2.0F, 2.0F, 1.0F);
//        GL11.glEnable(GL11.GL_SCISSOR_TEST);
//        GraphicsHelper.glScissor(50, 50, 10, 8);
//        StyleMap.current().drawGUIBackground(25, 25, 10, 4);
//        GL11.glDisable(GL11.GL_SCISSOR_TEST);
//        GL11.glPopMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
