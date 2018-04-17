# tool-validation

根据指定配置，校验参数是否合法。

# Quick start
1.添加tool的github的repository
```xml
<repositories>
    <repository>
        <id>tool-maven-repository</id>
        <url>https://raw.github.com/afmobi-QSee/tool-maven-repository/master/releases</url>
    </repository>
</repositories>
```

2.添加依赖
```xml
<dependency>
    <groupId>com.tool</groupId>
    <artifactId>tool-validation</artifactId>
    <version>0.0.1</version>
</dependency>
```

3.添加包
```java
import com.tool.validation.ParamBeanValidator;
```

4.参数对象定义格式，如不能为空
```java
public class Param {
    @NotNull
    private String abc;
}
```

5.使用方式1,如传入对象,返回bool合法或不合法
```java
ParamBeanValidator.isValid(requestParam)
```

6.使用方式2,如传入对象,返回bool和具体哪个字段不合法
```java
ParamBeanValidator.valid(request)
```
