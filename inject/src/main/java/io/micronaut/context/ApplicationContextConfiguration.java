/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.context;

import io.micronaut.core.convert.ConversionService;
import io.micronaut.core.io.scan.ClassPathResourceLoader;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * An interface for configuring an application context.
 *
 * @author Zachary Klein
 * @author graemerocher
 * @since 1.0
 */
public interface ApplicationContextConfiguration extends BeanContextConfiguration {

    /**
     * @return The environment names
     */
    @Nonnull List<String> getEnvironments();

    /**
     * @return True if the environments should be deduced
     */
    default Optional<Boolean> getDeduceEnvironments() {
        return Optional.empty();
    }

    /**
     * The default conversion service to use.
     *
     * @return The conversion service
     */
    default @Nonnull ConversionService<?> getConversionService() {
        return ConversionService.SHARED;
    }

    /**
     * The class path resource loader to use.
     *
     * @return The classpath resource loader
     */
    default @Nonnull ClassPathResourceLoader getResourceLoader() {
        return ClassPathResourceLoader.defaultLoader(getClassLoader());
    }

}
