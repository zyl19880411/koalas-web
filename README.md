 <p align="center">
  <img src="https://images.gitee.com/uploads/images/2020/1214/160547_0ff80ac0_536094.png" width="300">
  <br><br><br><br><br>
  <a href="https://www.apache.org/licenses/LICENSE-2.0" align="center">
    <img alt="code style" src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square">
  </a>
  <a href="https://github.com/996icu/996.ICU/blob/master/LICENSE" align="center">
    <img alt="996icu" src="https://img.shields.io/badge/license-NPL%20(The%20996%20Prohibited%20License)-blue.svg">
  </a>
</p>

# 一：项目介绍
基于spring mvc + spring + mybatis + Spring shrio 基于redis的集群方案

系统权限部分，分成多个机构，其中每个机构也有自己的子机构，子机构继承的部分权限，其中每个机构拥有自己的角色和用户，角色的权限是机构中的权限，用户选择角色只能从对应机构中的角色进行选择，机构中的用户创建子机构对子机构进行授权，创建角色对角色进行授权，创建用户对用户设置角色，系统有一个超级管理员，对机构角色和用户拥有删除功能，其他机构中的管理员只有授权，创建等功能，实现了分级授权的功能，并且每个机构拥有自己的小组，机构下的用户所属其中的小组，从而对小组中的用户进行消息下发，短信下发，邮件下发等提供快捷操作， 集中对应关系是  用户----角色------机构 ，角色-----权限，机构-----权限，机构----子机构，用户----小组-----机构

基于数据库表的spring 定时任务 支持集群部署 可制定执行任务和执行时间,删除添加操作等等，使用方式，下载之后clena install，tomcat7 -run直接可以运行，或者打war包部署到tomcat中，sql文件在resources里面。超级管理员账户:admin,密码123456

##### 1：为什么要写这个web框架
市面上常见的web框架很多，但是随着越来越多的元素加入，复杂的架构设计等因素似使得这些框架和spring一样，虽然号称是轻量级，但是用起来却是让我们很蹩脚，大量的配置，繁杂的API设计，其实，我们根本用不上这些东西！！！ 我也算得上是在很多个互联网企业厮杀过，见过很多很多的内部RPC框架，有些优秀的设计让我非常赞赏，有一天我突然想着，为什么不对这些设计原型进行聚合归类，自己搞一套【轻量级】web框架呢，碍于工作原因，一直没有时间倒腾出空，十一期间工作闲暇，说搞就搞吧，落地不易，希望源码对大家对认识web框架起到推进的作用。东西越写越多，有各种问题欢迎随时拍砖

##### 2：为什么叫koalas
树袋熊英文翻译，希望考拉 web给那些不太喜欢动手自己去造轮子的人提供可靠的web使用环境

##### 3：技术栈
- [x] spring-core-4.2.5，spring-context-4.2.5，spring-beans-4.2.5等spring源码
- [x] log4j，slf4j
- [x] io.netty4
- [x] fastJson
- [x] spring shrio
- [x] zookeeper
- [x] AOP，反射代理等
- [x] spring mybatis

# 二：如何安装项目
将项目下载到本地，如果顺利的话直接直接可以编译通过，在本地先clean install之后 通过tomcat或者jetty脚本来启动koalas-web，脚本在pom文件中已经写好
在启动之前首先把sql文件执行到mysql中，文件路径src/main/resources/koalasweb.sql

# 三：相关页面以及功能展示
##### 1：主页面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150716_694facf8_536094.png "屏幕截图.png")

##### 2：用户管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150743_35bff318_536094.png "屏幕截图.png")

##### 3：用户添加界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150813_5e4be1c7_536094.png "屏幕截图.png")

##### 4：用户角色界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150957_cfed169d_536094.png "屏幕截图.png")

##### 5：角色管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151026_aa36addb_536094.png "屏幕截图.png")

##### 6：角色添加界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151041_944797f2_536094.png "屏幕截图.png")

##### 7：角色授权界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151103_958af8b4_536094.png "屏幕截图.png")

##### 8：菜单管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151225_0c721ffb_536094.png "屏幕截图.png")

##### 9：菜单修改界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151312_cd1efa79_536094.png "屏幕截图.png")

##### 10：机构管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151337_038bfdff_536094.png "屏幕截图.png")

##### 11：机构授权界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151413_f84f2bef_536094.png "屏幕截图.png")

##### 12：团队查询界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151435_d7d1c1b0_536094.png "屏幕截图.png")

##### 13：系统监控界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151510_b3518a2b_536094.png "屏幕截图.png")

##### 14：定时任务界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151535_ad0ccc38_536094.png "屏幕截图.png")

##### 15：任务添加界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151556_57aa3968_536094.png "屏幕截图.png")

##### 16：表达式生成界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151619_a9373b5b_536094.png "屏幕截图.png")

##### 17：定时任务执行结果页面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151652_c14a4722_536094.png "屏幕截图.png")