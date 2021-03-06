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
package io.micronaut.docs.server.endpoints

//tag::endpointImport[]
import io.micronaut.management.endpoint.annotation.Endpoint
//end::endpointImport[]

//tag::readImport[]
import io.micronaut.management.endpoint.annotation.Read
//end::readImport[]

//tag::mediaTypeImport[]
import io.micronaut.http.MediaType
import io.micronaut.management.endpoint.annotation.Selector

//end::mediaTypeImport[]

//tag::writeImport[]
import io.micronaut.management.endpoint.annotation.Write
//end::writeImport[]

import javax.annotation.PostConstruct

//tag::endpointClassBegin[]
@Endpoint(id = "date",
        prefix = "custom",
        defaultEnabled = true,
        defaultSensitive = false)
class CurrentDateEndpoint {
//end::endpointClassBegin[]

    //tag::currentDate[]
    Date currentDate
    //end::currentDate[]

    @PostConstruct
    void init() {
        currentDate = new Date()
    }

    //tag::simpleRead[]
    @Read
    Date currentDate() {
        return currentDate
    }
    //end::simpleRead[]

    //tag::readArg[]
    @Read(produces = MediaType.TEXT_PLAIN) //<1>
    String currentDatePrefix(@Selector String prefix) {
        return "${prefix}: ${currentDate}"
    }
    //end::readArg[]

    //tag::simpleWrite[]
    @Write
    String reset() {
        currentDate = new Date()

        return "Current date reset"
    }
    //end::simpleWrite[]
//tag::endpointClassEnd[]
}
//end::endpointClassEnd[]

