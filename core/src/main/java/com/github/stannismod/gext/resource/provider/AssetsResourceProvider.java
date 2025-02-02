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

package com.github.stannismod.gext.resource.provider;

import com.github.stannismod.gext.api.resource.IResource;

import java.io.InputStream;

public class AssetsResourceProvider extends BasicResourceProvider {

    public AssetsResourceProvider(final String name) {
        super(name);
    }

    @Override
    public InputStream getInputStream(final IResource resource) {
        return this.getClass().getClassLoader().getResourceAsStream(
                String.format("assets/%s/%s", resource.getDomain(), resource.getPath()));
    }

    @Override
    public void setCachingEnabled(final boolean enabled) {
        throw new UnsupportedOperationException("AssetsResourceProvider doesn't support caching");
    }

    @Override
    public boolean isCachingEnabled() {
        return false;
    }

    @Override
    public boolean supportCaching() {
        return false;
    }
}
