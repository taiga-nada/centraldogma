/*
 * Copyright 2020 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.centraldogma.it;

import java.util.function.Function;

import com.linecorp.centraldogma.client.CentralDogma;
import com.linecorp.centraldogma.testing.junit.CentralDogmaExtension;

enum ClientType {
    @SuppressWarnings("unused")
    DEFAULT(CentralDogmaExtension::client),
    LEGACY(CentralDogmaExtension::legacyClient);

    private final Function<CentralDogmaExtension, CentralDogma> clientFactory;

    ClientType(Function<CentralDogmaExtension, CentralDogma> clientFactory) {
        this.clientFactory = clientFactory;
    }

    CentralDogma client(CentralDogmaExtension extension) {
        return clientFactory.apply(extension);
    }
}
