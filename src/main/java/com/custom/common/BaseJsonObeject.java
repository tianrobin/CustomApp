package com.custom.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by admin on 2015/12/24.
 */
public class BaseJsonObeject extends BaseObject {

    public String toJsonString() {
        ObjectMapper om = new ObjectMapper();
        String str = "";
        try {
            str = om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
        }
        return str;
    }
}
