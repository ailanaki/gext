/*
 * Copyright 2022 Stanislav Batalenkov
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

package com.github.stannismod.gext.testapp;

import com.github.stannismod.gext.api.IGraphicsComponent;
import com.github.stannismod.gext.api.IGraphicsLayout;
import com.github.stannismod.gext.api.IRootLayout;
import com.github.stannismod.gext.components.Graphics;
import com.github.stannismod.gext.components.container.BasicLayout;
import org.jetbrains.annotations.NotNull;

public class TestGui implements IRootLayout {

    private final BasicLayout<IGraphicsComponent> layout = new BasicLayout<>(0, 0, 800, 600);

    @Override
    public @NotNull IGraphicsLayout<IGraphicsComponent> layout() {
        return layout;
    }

    @Override
    public void initLayout() {
        add(Graphics.background().size(200, 200).build());
    }

    public void draw(int mouseX, int mouseY, float partialTicks) {
        layout.draw(mouseX, mouseY, partialTicks);
    }
}
