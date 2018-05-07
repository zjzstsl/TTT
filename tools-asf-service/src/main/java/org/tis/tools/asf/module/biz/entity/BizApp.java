package org.tis.tools.asf.module.biz.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.tis.tools.core.validation.AddValidateGroup;
import org.tis.tools.core.validation.UpdateValidateGroup;

import javax.validation.constraints.Null;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BizApp {

    @Null(groups = {AddValidateGroup.class}, message = "新增时ID由系统指定")
    @NotBlank(groups = {UpdateValidateGroup.class}, message = "修改时ID不能为空")
    @TableId
    private String id;

    @NotBlank(groups = {AddValidateGroup.class}, message = "名称不能为空")
    private String name;

    private String desc;

    @TableField(exist = false)
    private List<BizModule> moduleList;

    @TableField(exist = false)
    private List<BizModel> modelList;

    @TableField(exist = false)
    private List<BizField> fieldList;

}
