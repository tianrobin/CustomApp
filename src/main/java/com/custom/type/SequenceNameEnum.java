package com.custom.type;

import com.custom.common.BaseEnum;
import org.apache.commons.lang.StringUtils;

/**
 * Created by robin.tian on 16-3-31.
 */
public enum SequenceNameEnum implements BaseEnum {
    ;


    private String code;

    private String desc;

    private SequenceNameEnum getFromCode(String code) {
        for (SequenceNameEnum nameEnum : values()) {
            if (StringUtils.equals(code, nameEnum.getCode())) {
                return nameEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public SequenceNameEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public SequenceNameEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
