/*
 * Copyright 2020-2022 Stanislav Batalenkov
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

package com.github.stannismod.gext.components;

import com.github.stannismod.gext.api.IGraphicsComponent;
import org.jetbrains.annotations.Nullable;

public class Tooltip extends GTooltip {

    private String labelId;

    @Override
    public void initTooltip() {
        labelId = addComponent(0, Graphics.label().text("Primary text").placeAt(0, 0).build(), GLink.class);
    }

    @Override
    public void listen(@Nullable IGraphicsComponent target) {
        if (target == null) {
            setVisible(false);
            return;
        }
        ((GLabel) getParent().getComponent(labelId)).text = "Secondary text";
        setVisible(true);
    }
}
