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

package com.github.stannismod.gext.api;

import org.jetbrains.annotations.Nullable;

/**
 * API for scroll handlers. This instances handles mouse and keyboard input and controls the scrolling process.
 * Scroll handlers can be added to implementations of {@link IScrollable}.
 * @since 1.1
 */
public interface IGraphicsComponentScroll extends IGraphicsComponent {

    void setTarget(@Nullable IScrollable target);

    @Nullable IScrollable getTarget();
}
