package org.tis.tools.abf.module.sys.entity.enums;

import org.tis.tools.core.entity.enums.BaseEnum;

import java.io.Serializable;

/**
 * description:
 *
 * @author zhaoch
 * @date 2018/4/23
 **/
public enum DictFromType implements BaseEnum {

    DICT_ITEM("0", "字典项"),

    SINGLE_TABLE("1", "单表"),

    TABLES_OR_VIEW("2", "多表或视图");

    private final String value;

    private final String name;

    DictFromType(final String value, final String name) {
        this.value = value;
        this.name = name;
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
