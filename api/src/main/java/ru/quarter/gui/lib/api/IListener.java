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

package ru.quarter.gui.lib.api;

/**
 * API for component listeners. Targeted to {@link IGraphicsComponent},
 * listener can get access to target component's properties to use or change it.
 * Please pay attention that component can implement many listeners with different target types.
 * @param <T> the type of target component
 * @since 1.1
 */
public interface IListener<T extends IGraphicsComponent> extends IGraphicsComponent {

    void setTarget(T target);

    T getTarget();

    default void listen() {
        listen(getTarget());
    }

    void listen(T target);
}
