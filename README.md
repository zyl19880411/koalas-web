
基于spring mvc + spring + mybatis + Spring shrio 基于redis的集群方案

系统权限部分，分成多个机构，其中每个机构也有自己的子机构，子机构继承的部分权限，其中每个机构拥有自己的角色和用户，角色的权限是机构中的权限，用户选择角色只能从对应机构中的角色进行选择，机构中的用户创建子机构对子机构进行授权，创建角色对角色进行授权，创建用户对用户设置角色，系统有一个超级管理员，对机构角色和用户拥有删除功能，其他机构中的管理员只有授权，创建等功能，实现了分级授权的功能，并且每个机构拥有自己的小组，机构下的用户所属其中的小组，从而对小组中的用户进行消息下发，短信下发，邮件下发等提供快捷操作， 集中对应关系是  用户----角色------机构 ，角色-----权限，机构-----权限，机构----子机构，用户----小组-----机构

基于数据库表的spring 定时任务 支持集群部署 可制定执行任务和执行时间,删除添加操作等等，使用方式，下载之后clena install，tomcat7 -run直接可以运行，或者打war包部署到tomcat中，sql文件在resources里面。超级管理员账户:admin,密码123456

主页面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150716_694facf8_536094.png "屏幕截图.png")
用户管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150743_35bff318_536094.png "屏幕截图.png")
用户添加
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150813_5e4be1c7_536094.png "屏幕截图.png")
用户角色
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/150957_cfed169d_536094.png "屏幕截图.png")
角色管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151026_aa36addb_536094.png "屏幕截图.png")
角色添加
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151041_944797f2_536094.png "屏幕截图.png")
角色授权界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151103_958af8b4_536094.png "屏幕截图.png")
菜单管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151225_0c721ffb_536094.png "屏幕截图.png")
菜单修改界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151312_cd1efa79_536094.png "屏幕截图.png")
机构管理界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151337_038bfdff_536094.png "屏幕截图.png")
机构授权界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151413_f84f2bef_536094.png "屏幕截图.png")
团队查询界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151435_d7d1c1b0_536094.png "屏幕截图.png")
系统监控界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151510_b3518a2b_536094.png "屏幕截图.png")
定时任务界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151535_ad0ccc38_536094.png "屏幕截图.png")
任务添加界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151556_57aa3968_536094.png "屏幕截图.png")
表达式生成界面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151619_a9373b5b_536094.png "屏幕截图.png")
定时任务执行结果页面
![输入图片说明](https://images.gitee.com/uploads/images/2020/0521/151652_c14a4722_536094.png "屏幕截图.png")