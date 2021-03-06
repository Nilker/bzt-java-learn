package com.eastfair.bztapi.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"/bzt-spring-api";//聚合项目 有不同的模块
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);              //是否覆蓋已有文件 默认值：false
        gc.setAuthor("lhl");                    //作者
        gc.setOpen(false);                      //是否打开输出目录 默认值:true
        gc.setSwagger2(true);                   //开启 swagger2 模式 默认false
        gc.setBaseColumnList(false);            //开启 baseColumnList 默认false
        gc.setBaseResultMap(false);             //开启 BaseResultMap 默认false
        gc.setEntityName("%sEntity");           //实体命名方式  默认值：null 例如：%sEntity 生成 UserEntity
        gc.setMapperName("%sDao");              //com.qiao.itmc.com 命名方式 默认值：null 例如：%sDao 生成 UserDao
        gc.setXmlName("%sMapper");              //Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        gc.setServiceName("I%sService");         //service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl"); //service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setControllerName("%sController");   //controller 命名方式    默认值：null 例如：%sAction 生成 UserAction

        gc.setDateType(DateType.ONLY_DATE);//https://mp.baomidou.com/guide/faq.html#error-attempting-to-get-column-create-time-from-result-set-cause-java-sql-sqlfeaturenotsupportedexception
        mpg.setGlobalConfig(gc);

        // 数据源配置
        com.baomidou.mybatisplus.generator.config.DataSourceConfig dsc = new com.baomidou.mybatisplus.generator.config.DataSourceConfig();
        //dsc.setDbType(DbType.SQL_SERVER);
        //dsc.setUrl("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test");
        //dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //dsc.setUsername("sa");
        //dsc.setPassword("123");

        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");

        mpg.setDataSource(dsc);

        // 包配置·     1
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.eastfair");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {        //注入自定义 Map 对象
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         //String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper" //+ pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
//        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/java/com/eastfair/bztapi/mapper/mysql/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
//            }
//        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity2.java");
        templateConfig.setServiceImpl("templates/serviceImpl2.java");
         templateConfig.setController("templates/controller2.java");
        //templateConfig.setXml(null);

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);                          //表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);                    //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        //strategy.setCapitalMode(true);			                                    // 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix("prefix");		                                    //表前缀
        strategy.setSuperEntityClass("com.eastfair.bztapi.common.BaseEntity");          //自定义继承的Entity类全称，带包名
        strategy.setEntityLombokModel(true);                                            //【实体】是否为lombok模型（默认 false）
        strategy.setRestControllerStyle(true);                                          //生成 @RestController 控制器
        strategy.setSuperControllerClass("com.eastfair.bztapi.common.BaseController");  //自定义继承的Controller类全称，带包名
        // 写于父类中的公共字段isCapitalMode
        //strategy.setSuperEntityColumns("id");                                         //表实体Id字段，使用父类的
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setInclude(new String[] { "user" });                                 // 需要生成的表可以多张表
        //strategy.setExclude(new String[]{"test"});                                    // 排除生成的表
        strategy.setControllerMappingHyphenStyle(true);                                 //驼峰转连字符
        //strategy.setTablePrefix(pc.getModuleName() + "_");                              //是否生成实体时，生成字段注解
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());// 选择 freemarker 引擎，默认 Veloctiy
        mpg.execute();
    }

}
