/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.test;


import com.google.inject.Injector;
import com.navercorp.pinpoint.profiler.context.module.DefaultApplicationContext;

import com.navercorp.pinpoint.bootstrap.AgentOption;
import com.navercorp.pinpoint.profiler.context.module.ModuleFactory;
import com.navercorp.pinpoint.profiler.interceptor.registry.InterceptorRegistryBinder;

/**
 * @author emeroad
 * @author koo.taejin
 * @author hyungil.jeong
 */
public class MockApplicationContext extends DefaultApplicationContext {

    public MockApplicationContext(AgentOption agentOption, ModuleFactory moduleFactory) {
        super(agentOption, moduleFactory);
    }

    @Override
    public void close() {
        super.close();

        final Injector injector = this.getInjector();
        InterceptorRegistryBinder binder = injector.getInstance(InterceptorRegistryBinder.class);
        binder.unbind();
    }
}
