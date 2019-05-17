/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
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

package io.helidon.atp.lab;

import java.util.Collections;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

import io.helidon.atp.lab.common.config.GlobalResourceConfig;

/**
 * Simple Application that produces a greeting message.
 */
@ApplicationScoped
@ApplicationPath("/")
public class GreetApplication extends GlobalResourceConfig {

	@Override
	public Set<Class<?>> getClasses() {
		if (super.cachedClassesView == null) {
			cachedClasses = _getClasses();
			cachedClasses.add(GreetResource.class);
			cachedClassesView = Collections.unmodifiableSet(cachedClasses);
		}
		return cachedClassesView;
	}

	public GreetApplication() {
		super();
		this.packages(GreetApplication.class.getPackage().getName())
				.property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/templates/mustache")
				.register(MustacheMvcFeature.class)
				.property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "/templates/freemarker")
				.register(FreemarkerMvcFeature.class);
	}
}