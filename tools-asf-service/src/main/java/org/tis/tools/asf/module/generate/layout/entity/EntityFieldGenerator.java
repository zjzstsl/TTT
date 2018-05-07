package org.tis.tools.asf.module.generate.layout.entity;

import org.apache.commons.lang3.StringUtils;
import org.tis.tools.asf.module.biz.entity.BizField;
import org.tis.tools.asf.module.generate.engine.metadata.java.annoation.AnnotationBase;
import org.tis.tools.asf.module.generate.engine.metadata.java.annoation.AnnotationField;
import org.tis.tools.asf.module.generate.engine.metadata.java.doc.JavadocBase;
import org.tis.tools.asf.module.generate.engine.metadata.java.field.FieldBase;
import org.tis.tools.asf.module.generate.tools.GenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author zhaoch
 * @date 2018/4/10
 **/
public class EntityFieldGenerator {

    /**
     * 生成实体类属性对应表字段静态常量
     * 如: employee 中的empName属性对应的表字段为emp_name,则生成
     * public static final String COLUMN_EMP_NAME = "emp_name";
     * @param field
     * @return
     */
    public static FieldBase columnField(BizField field) {
        String desc = field.getPhysicalName() + "对应表字段";
        String value = GenerateUtils.camel2Underline(field.getPhysicalName()).toLowerCase();
        String fieldName = "COLUMN_" + value.toUpperCase();
        return FieldBase.genPSFS(desc, fieldName, value);
    }

    public static FieldBase generalField(BizField field) {
        String desc = field.getLogicalName() + (StringUtils.isBlank(field.getDesc()) ? "" :  ":" + field.getDesc());
        FieldBase f = new FieldBase();
        f.setDoc(new JavadocBase(desc.replace("\n", "\n     * ")));
        f.setDeclaration("public");
        if (field.getPrimaryKey()) {
            List<AnnotationField> af1 = new ArrayList<>();
//            af1.add(new AnnotationField("value", field.getPhysicalName().toLowerCase()));
            AnnotationBase annotationBase = new AnnotationBase("TableId", af1,
                    "com.baomidou.mybatisplus.annotations.TableId");
            f.addAnno(annotationBase);
        }
        f.setType(field.getType().value());
        if (field.getType().getImports() != null) {
            f.setImportClassName(new String[] {field.getType().getImports()});
        }
        f.setName(field.getPhysicalName());
        return f;
    }

}
