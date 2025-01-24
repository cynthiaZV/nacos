/*
 * Copyright 1999-$toady.year Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.config.server.service.query.handler;

import com.alibaba.nacos.common.utils.StringUtils;
import com.alibaba.nacos.config.server.service.query.model.ConfigQueryChainRequest;
import com.alibaba.nacos.config.server.service.query.model.ConfigQueryChainResponse;

import java.io.IOException;

/**
 * SpecialTagNotFound Handler.
 * This class represents special tag not found handler in the configuration query processing chain.
 *
 * @author Nacos
 */
public class SpecialTagNotFoundHandler extends AbstractConfigQueryHandler {
    
    private static final String SPECIAL_TAG_NOT_FOUND_HANDLER = "specialTagNotFoundHandler";
    
    @Override
    public String getName() {
        return SPECIAL_TAG_NOT_FOUND_HANDLER;
    }
    
    @Override
    public ConfigQueryChainResponse handle(ConfigQueryChainRequest request) throws IOException {
        if (StringUtils.isNotBlank(request.getTag())) {
            ConfigQueryChainResponse response = new ConfigQueryChainResponse();
            response.setStatus(ConfigQueryChainResponse.ConfigQueryStatus.SPECIAL_TAG_CONFIG_NOT_FOUND);
            return response;
        } else {
            return nextHandler.handle(request);
        }
    }
}