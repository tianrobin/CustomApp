package com.custom.common.exception;

import com.custom.common.BaseEnum;

/**
 * Created by admin on 2015/12/24.
 */
public interface Errorcode extends BaseEnum {


    /**
     * 获取错误码的中文描述
     * @return
     */
    String getDesc();
}
