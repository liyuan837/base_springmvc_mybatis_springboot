这是一个使用springboot搭建springmvc+mybatis的基础框架

包含如下基本配置：
1、mysql
2、c3p0连接池
3、mybatis
4、Redis：注意运行前先启动服务器上的redis服务，或者将项目中的redis配置关掉
5、swagger：在Controller的接口上通过添加API注解，进行接口注册，然后通过访问/swagger-ui.html调试接口
6、lombok：采用该依赖，简化Bean开发，可以用@Data注解取代getter和setter方法

高级配置：
1、采用JWT登录验证，涉及到的配置：JwtUtil工具类 + JwtInterceptor拦截器 + NotToken注解接口
2、提供几种常用工具：包括多文件上传下载的前后端示例代码：前端在HTML文件夹下，后端UtilsController
3、自定义各种字符串校验规则注解：手机号、身份证、邮箱等
    注解使用方式：在字段上面：@EqualLength(regexp = ValidUtil.IDNO,isBlank = true,message = "请输入正确的身份证号")

