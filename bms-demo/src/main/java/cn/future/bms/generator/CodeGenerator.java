package cn.future.bms.generator;

import freemarker.template.Template;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/30
 * @Description： 代码生成器:
 * 根据数据库生成：
 * 1.entity
 * 2.mapper
 * 3.service
 * 4.serviceImpl
 * 5.controller
 */
public class CodeGenerator {

    /**
     * 通过表名生成对应的代码
     */
    private final String tableName = "dictionary";
    /**
     * 代码生成目录
     */
    private final String diskPath = "E://code-generate//";
    /**
     * 数据库相关
     */
    private final String datasourceUrl = "jdbc:mysql://localhost:3306/bms";
    private final String datasourceUsername = "root";
    private final String datasourcePassword = "123456";
    private final String datasourceDriver = "com.mysql.jdbc.Driver";
    /**
     * java类所在的包名称
     */
    private final String packageName = "cn.future.bms.";
    /**
     * java注解相关
     */
    private final String author = "ygl";
    private final String date = DateFormatUtils.format(new Date(), "yyyy/MM/dd-HH:mm");
    /**
     * 具体java类所在的包名称
     */
    private final String entityPackageName = packageName + "entity";
    private final String dtoPackageName = entityPackageName+".dto";
    private final String mapperPackageName = packageName + "mapper";
    private final String servicePackageName = packageName + "service";
    private final String serviceImplPackageName = servicePackageName + ".impl";
    private final String controllerPackageName = packageName + "controller";
    /**
     * 具体文件生成目录
     */
    private final String entityPath = diskPath + "entity//";
    private final String mapperPath = diskPath + "mapper//";
    private final String servicePath = diskPath + "service//";
    private final String serviceImplPath = servicePath;
    private final String controllerPath = diskPath + "controller//";
    /**
     * 需要创建的目录
     */
    private final String[] dirCreated = new String[]{entityPath, mapperPath, servicePath, serviceImplPath, controllerPath};
    /**
     * 生成java实体需要忽略的字段
     */
    private final String[] columnIgnored = new String[]{"id", "created_date", "created_by", "updated_date", "updated_by", "is_deleted"};
    /**
     * 具体freemarker模板的名称
     */
    private final String entityTemplateName = "Entity.ftl";
    private final String className = camelCaseStartWithUpperCase(tableName);
    private String tableComment = "表的备注";

    public static void main(String[] args) throws Exception {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generate();
    }

    public void generate() throws Exception {
        ResultSet resultSet = getMetaData(tableName);
        generateEntity(resultSet);
        generateEntityDto();
        generateMapper();
        generateMapperXml();
        generateService();
        generateServiceImpl();
        generateController();
        System.out.println("***********生成成功**********");
    }

    /**
     * 获取数据库链接
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        Class.forName(datasourceDriver);
        Connection connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
        return connection;
    }

    /**
     * 获得数据元
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public ResultSet getMetaData(String tableName) throws Exception {
        Connection conn = getConnection();
        DatabaseMetaData databaseMetaData = conn.getMetaData();
        ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
        if (rs != null && rs.next()) {
            String createDDL = rs.getString(2);
            String tableComment = getTableComment(createDDL);
            this.tableComment = tableComment;
        }
        return resultSet;
    }

    /**
     * 生成实体
     *
     * @param resultSet
     * @throws Exception
     */
    public void generateEntity(ResultSet resultSet) throws Exception {
        final String suffix = ".java";
        final String path = entityPath + className + suffix;
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass;
        while (resultSet.next()) {
            //获取字段名称
            String columnName = resultSet.getString("COLUMN_NAME");
            System.out.println("字段名-----:" + columnName);
            //获取字段类型
            String typeName = resultSet.getString("TYPE_NAME");
            System.out.println("字段类型-----:" + typeName);
            //字段在数据库的注释
            String remarks = resultSet.getString("REMARKS");
            System.out.println("字段备注-----:" + remarks);
            // 配置字段略过
            if (!ArrayUtils.contains(columnIgnored, columnName)) {
                columnClass = new ColumnClass();
                //获取字段名称
                columnClass.setColumnName(columnName);
                //获取字段类型
                columnClass.setColumnType(typeName);
                //字段在数据库的注释
                columnClass.setColumnComment(remarks);
                //转换字段名称，如 sys_name 变成 SysName
                String camelCaseName = camelCase(columnName);
                columnClass.setFieldName(camelCaseName);
                columnClassList.add(columnClass);
            }
        }
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("columnClassList", columnClassList);
        dataMap.put("packageName", entityPackageName);
        generateFileByTemplate(entityTemplateName, mapperFile, dataMap);
    }

    /**
     *
     * @throws Exception
     */
    public void generateEntityDto() throws Exception {
        final String suffix = "DTO.java";
        final String path = entityPath + className + suffix;
        final String templateName = "EntityDto.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("packageName", dtoPackageName);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    public void generateMapper() throws Exception {
        final String suffix = "Mapper.java";
        final String path = mapperPath + className + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("packageName", mapperPackageName);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    public void generateMapperXml() throws Exception {
        final String suffix = "Mapper.xml";
        final String path = mapperPath + className + suffix;
        final String templateName = "MapperXml.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("mapperPackageName", mapperPackageName);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    public void generateService() throws Exception{
        final String prefix = "I";
        final String suffix = "Service.java";
        final String path = servicePath + prefix + className + suffix;
        final String templateName = "Service.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("packageName", servicePackageName);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    public void generateServiceImpl() throws Exception{
        final String suffix = "ServiceImpl.java";
        final String path = serviceImplPath + className + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(10);
        dataMap.put("packageName", serviceImplPackageName);
        dataMap.put("mapperPackageName", mapperPackageName);
        dataMap.put("servicePackageName", servicePackageName);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    public void generateController() throws Exception{
        final String suffix = "Controller.java";
        final String path = controllerPath + className + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>(10);
        dataMap.put("packageName", controllerPackageName);
        dataMap.put("servicePackageName", servicePackageName);
        dataMap.put("dtoPackageName", dtoPackageName);
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    /**
     * 通过ftl生成文件
     *
     * @param templateName
     * @param file
     * @param dataMap
     * @throws Exception
     */
    private void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        // 如果file路径不存在则，创建
        mkdirs();
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("tableComment", tableComment);
        dataMap.put("entityPackageName", entityPackageName);
        dataMap.put("tableName", tableName);
        dataMap.put("className", className);
        dataMap.put("author", author);
        dataMap.put("date", date);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

    /**
     * 下划线 转成 驼峰
     *
     * @param name
     * @return
     */
    public String camelCase(String name) {
        StringBuffer sb = new StringBuffer();
        sb.append(name);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return result;
    }

    /**
     * 返回表的注释信息
     * @param ddl 建表语句
     * @return
     */
    public static String getTableComment(String ddl) {
        String comment;
        int index = ddl.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = ddl.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }
    /**
     * 下划线 转成 驼峰 , 请首字母大写
     * @param name
     * @return
     */
    public String camelCaseStartWithUpperCase(String name) {
        String camelCaseName = camelCase(name);
        return StringUtils.capitalize(camelCaseName);
    }

    /**
     * 级联创建文件所在的路径
     */
    public void mkdirs() {
        File file;
        for (String path : dirCreated) {
            file = new File(path);
            if (!file.isDirectory() && !file.exists()) {
                file.mkdirs();
            }
        }
    }
}
