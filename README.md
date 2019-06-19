工作之余先来写了一个不算规范的简单架子

基于spring mvc + spring + mybatis + Spring shrio 基于redis的集群方案

系统权限部分，分成多个机构，其中每个机构也有自己的子机构，子机构继承的部分权限，其中每个机构拥有自己的角色和用户，角色的权限是机构中的权限，用户选择角色只能从对应机构中的角色进行选择，机构中的用户创建子机构对子机构进行授权，创建角色对角色进行授权，创建用户对用户设置角色，系统有一个超级管理员，对机构角色和用户拥有删除功能，其他机构中的管理员只有授权，创建等功能，实现了分级授权的功能，并且每个机构拥有自己的小组，机构下的用户所属其中的小组，从而对小组中的用户进行消息下发，短信下发，邮件下发等提供快捷操作， 集中对应关系是  用户----角色------机构 ，角色-----权限，机构-----权限，机构----子机构，用户----小组-----机构

基于数据库表的spring 定时任务 支持集群部署 可制定执行任务和执行时间,删除添加操作等等，使用方式，下载之后clena install，tomcat7 -run直接可以运行，或者打war包部署到tomcat中，sql文件在resources里面。超级管理员账户:admin,密码123456
![输入图片说明](https://images.gitee.com/uploads/images/2019/0614/182051_0a76e930_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130516_894032dd_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130536_804b37c6_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130550_f1a35217_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130630_cae1851a_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130651_fa3b8ca0_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130705_a7c75ced_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130717_54da181d_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130740_1376a076_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130751_59af17ed_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130802_6dca37e2_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130821_884ae1f3_536094.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0619/130850_bfdf8e1a_536094.png "屏幕截图.png")