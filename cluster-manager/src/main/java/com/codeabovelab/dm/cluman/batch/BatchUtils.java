/*
 * Copyright 2016 Code Above Lab LLC
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

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ResultCode;
import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;

/**
 * Some utilities
 */
public class BatchUtils {

    /**
     * Target version of image after operation
     */
    public static final String JP_IMAGE_TARGET_VERSION = "createContainer.image.version";
    // common job parameters
    public static final String JP_CLUSTER = "cluster";
    public static final String JP_ROLLBACK_ENABLE = "rollbackEnable";
    public static final String FILTER = "Filter";

    /**
     * If result is not an OK then construct and throw exception.
     * @param res
     */
    public static void checkThatIsOk(ServiceCallResult res) {
        ResultCode code = res.getCode();
        if(code != ResultCode.OK) {
            throw new RuntimeException(code + " " + res.getMessage());
        }
    }

    /**
     * If result is not an OK and not an NOT_MODIFIED then construct and throw exception.
     * @param res
     */
    public static void checkThatIsOkOrNotModified(ServiceCallResult res) {
        ResultCode code = res.getCode();
        if(code != ResultCode.OK && code != ResultCode.NOT_MODIFIED) {
            throw new RuntimeException(code + " " + res.getMessage());
        }
    }

}
