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

package ru.quarter.gui.lib.minecraft.adapter;

import net.minecraft.client.gui.FontRenderer;
import ru.quarter.gui.lib.api.adapter.IFontRenderer;

import java.util.List;

public class MinecraftFontRenderer implements IFontRenderer {

    private final FontRenderer instance;

    public MinecraftFontRenderer(FontRenderer instance) {
        this.instance = instance;
    }

    @Override
    public void drawString(String text, int x, int y, int color) {
        instance.drawString(text, x, y, color);
    }

    @Override
    public int getStringWidth(String text) {
        return instance.getStringWidth(text);
    }

    @Override
    public int getFontHeight() {
        return instance.FONT_HEIGHT;
    }

    @Override
    public List<String> listTextToWidth(String text, int width) {
        return instance.listFormattedStringToWidth(text, width);
    }
}
