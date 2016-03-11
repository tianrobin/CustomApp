package com.custom.type.custom;

import com.custom.common.BaseEnum;
import org.apache.commons.lang.StringUtils;

/**
 * Created by robin.tian on 16-3-10.
 */
public enum GenderEnum implements BaseEnum {


    F("F", "女"),
    M("M", "男"),;

    private String code;

    private String desc;

    private GenderEnum(String code, String desc) {
        this.code = code;

        this.desc = desc;
    }

    public static GenderEnum getGrenderFromCode(String code) {
        for (GenderEnum genderEnum : values()) {
            if (StringUtils.equals(code, genderEnum.code)) {
                return genderEnum;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
