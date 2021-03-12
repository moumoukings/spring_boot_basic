package com.mark85.basic.config.mybatis_plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 *
 * @author zhangzichen
 * @date 2021/03/10 12:57
 */
public class CodeGenerator {
    /**
     * 数据库链接地址 todo zzc 根据实际修改
     */
    private static final String URL = "jdbc:mysql://218.244.150.165:3306/spring_boot_basic?useUnicode=true&useSSL=false&characterEncoding=utf8";

    /**
     * 驱动
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 用户名 todo zzc 根据实际修改
     */
    private static final String USERNAME = "root";

    /**
     * 密码 todo zzc 根据实际修改
     */
    private static final String PASSWORD = "root";

    /**
     * 作者
     */
    private static final String AUTHOR = "zhangzichen";

    /**
     * 父包名
     */
    private static final String PACKAGE_PARENT = "com.mark85.basic";

    /**
     * 全局配置
     *
     * @return 返回 GlobalConfig
     */
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        gc.setAuthor(AUTHOR);
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成时文件是否覆盖
        gc.setFileOverride(true);
        //生成java mysql字段映射
        // XML columList
        gc.setBaseColumnList(true);
        //生成result map
        // XML ResultMap
        gc.setBaseResultMap(true);
        // 去掉Service接口的首字母I
        //gc.setServiceName("%sService");
        gc.setEntityName("%sDo");
        gc.setMapperName("%sDoMapper");
        //gc.setXmlName("%sDoMapper");
        gc.setControllerName("%sDoController");
        //去掉Service接口的首字母I
        gc.setServiceName("%sDoService");
        gc.setServiceImplName("%sDoServiceImpl");
        // 主键策略
        //gc.setIdType(IdType.AUTO);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //开启Swagger2模式
        gc.setSwagger2(true);
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return 返回 getDataSourceConfig
     */
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        dsc.setDbType(DbType.MYSQL);
        return dsc;
    }

    /**
     * 包名配置
     *
     * @return 返回 PackageConfig
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PARENT);
        //包下模块名
        //pc.setModuleName("spring_boot_basic");
        //模块下包名
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mybatis");
        return pc;
    }

    /**
     * 模板引擎配置
     *
     * @return 返回 TemplateConfig
     */
    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名称
     * strategy.setInclude(tableNames) 传入需要 "生成" 的表名
     * strategy.setExclude(tableNames) 传入需要 "过滤" 的表名
     * strategy.setSuperEntityColumns("id");
     * @return 返回 getStrategyConfig
     */
    private static StrategyConfig getStrategyConfig(String... tableNames) {
        StrategyConfig strategy = new StrategyConfig();
        //表名 todo 每次需要修改表名
        strategy.setInclude(tableNames);
        ////数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //生成实体时去掉表前缀
        strategy.setTablePrefix("_");
        //strategy.setTablePrefix(getPackageConfig().getModuleName() + "_");
        //实体默认继承BaseDo
        strategy.setSuperEntityClass("com.mark85.basic.base.BaseDo");
        // 自定义 service 父类
        //strategy.setSuperServiceClass("com.mark85.basic.base.BaseService");
        // 自定义 service 实现类父类
        //strategy.setSuperServiceImplClass("com.mark85.basic.base.BaseServiceImpl");
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }

    /**
     * 自定义配置
     *
     * @return 返回 InjectionConfig
     */
    private static InjectionConfig getInjectionConfig() {

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        final String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/src/main/resources/mybatis/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);

        return cfg;
    }


    /**
     * 获取代码生成器
     *
     * @return 返回代码生成器
     */
    private static AutoGenerator getAutoGenerator(String... tableNames) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());

        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());

        // 包配置
        mpg.setPackageInfo(getPackageConfig());

        // 自定义配置
        mpg.setCfg(getInjectionConfig());

        // 配置模板
        mpg.setTemplate(getTemplateConfig());

        // 策略配置
        mpg.setStrategy(getStrategyConfig(tableNames));

        // 设置模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        return mpg;
    }

    /**
     * 生产代码
     *
     * @param args args
     */
    public static void main(String[] args) {
        // 执行
        getAutoGenerator("user").execute();
    }
}
