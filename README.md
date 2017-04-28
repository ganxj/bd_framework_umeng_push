# bd_framework_umeng_push

#maven
[![](https://jitpack.io/v/ganxj/bd_framework_umeng_push.svg)](https://jitpack.io/#ganxj/bd_framework_umeng_push)

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  
  
	<dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
	</dependency>

#使用方法

1、把spring_umeng-push.xml复制到工程的资源目录下。
2、在工程的配置文件中增加配置
        umeng.appkey= your appke
        umeng.app_master_secret= your app_master_secret
        umeng.backurl=http://msg.umeng.com/api/send
3、在spring.xml中引一下spring_umeng-push.xml
4、注入就能使用
    @Autowired
      private Push push;