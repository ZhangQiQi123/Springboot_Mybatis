# Springboot_Mybatis

springboot+mybatis+mysql+thymeleaf
java启动
URL：http://localhost:8080/getAllRoles
tomcat启动
URL：http://localhost:8080/Springboot_Mybatis/getAllUser
#Apollo ApolloController2.java
官网：https://github.com/ctripcorp/apollo/wiki/Quick-Start#%E5%9B%9B%E4%BD%BF%E7%94%A8apollo%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83
apollo访问地址：http://localhost:8070/config.html
获取配置信息：http://localhost:8888/apollo/getServerPort



1.热部署
https://blog.csdn.net/little_skeleton/article/details/80935794
2.使用的是Mybatis插件：generator反向生成model、mapper层
命令：mvn mybatis-generator:generate
3.自动生成接口文档
http://localhost:8087/doc.html
4.mapper映射文件中传少数参数用${arg0},${arg1},....接收数据   由于版本问题导致

1.引入apollo运行
1.1先运行apolloRun目录中的三个jar包
    顺序：configservice,adminservice,portal