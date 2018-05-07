package org.tis.tools.abf.module.sys.entity.enums;

import org.tis.tools.core.entity.enums.BaseEnum;

import java.io.Serializable;

/**
 * description:
 *
 * @author zhaoch
 * @date 2018/4/23
 **/
public enum DictType implements BaseEnum {

    APP("a", "应用级", "带业务含义的业务字典，应用开发时可扩展"),

    SYS("s", "系统级", "平台自己的业务字典");

    private final String value;

    private final String name;

    private final String desc;

    DictType(final String value, final String name, final String desc) {
        this.value = value;
        this.name = name;
        this.desc = desc;
    }


    @Override
    public Serializable deserialze() {
        return value;
    }

    @Override
    public Serializable getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
