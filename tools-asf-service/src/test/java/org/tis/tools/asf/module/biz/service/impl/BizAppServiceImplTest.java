package org.tis.tools.asf.module.biz.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.asf.base.BaseTest;
import org.tis.tools.asf.module.biz.entity.BizApp;
import org.tis.tools.asf.module.biz.service.IBizAppService;
import org.tis.tools.asf.module.biz.service.IBizModelService;
import org.tis.tools.asf.module.er.service.IERAppService;
import org.tis.tools.asf.module.generate.layout.controller.CommonController;

public class BizAppServiceImplTest extends BaseTest {

    @Autowired
    private IBizAppService bizAppService;

    @Autowired
    private IBizModelService bizModelService;

    @Autowired
    private IERAppService appService;

    @Test
    public void importErApp() {
        // 2。将ER模型转换为BIZ模型
        bizAppService.importErApp("988311750804713474");
    }

    @Test
    public void test() {
        // 测试单个文件生成
        BizApp bizApp = bizAppService.queryBizAppDetailById("983621665538658305");
//        CommonEntity.instance("com.keppel.test", bizApp.getModelList().get(0));
//        CommonMapper.instance("com.keppel.test.dao", bizApp.getModelList().get(0));
//        CommonService.instance("com.keppel.test.dao", bizApp.getModelList().get(0));
//        CommonServiceImpl.instance("com.keppel.test.dao", bizApp.getModelList().get(0));
        CommonController.instance("com.keppel.test.dao", bizApp.getModelList().get(0));

    }
}