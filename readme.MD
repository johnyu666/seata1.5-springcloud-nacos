## springcloud+nacos+seata的整合
### 1. 版本情况如下：
[参见官网版本对照： ](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

```xml
        <spring.cloud.version>Hoxton.SR12</spring.cloud.version>
        <spring.boot.version>2.3.12.RELEASE</spring.boot.version>
        <spring.cloud.alibaba.version>2.2.9.RELEASE</spring.cloud.alibaba.version>
```
### 2. 包含了seata1.5.2配置文件
只需要复制到seata1.5.2的安装包即可。[下载](https://github.com/seata/seata/releases/download/v1.5.2/seata-server-1.5.2.zip)

### 3. Nacos版本 2.1.1
自行下载并启动