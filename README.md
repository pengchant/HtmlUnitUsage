**使用前须知**

	1.本工具基于windows操作系统;
	2.需要电脑安装配置好java环境;
	3.如果您有自己的服务器，可以直接拷贝该文件夹下的just_autofill.jar包文件，部署到linux服务器中: nohup java -jar just_autofill.jar 学号 密码 & 
	4.该工具由java编程语言实现，使用了HtmlUnit实现模拟登录功能，不会泄露您的学号，密码等隐私信息 
	5.由于该软件功能点的特殊性需要保持电脑开启，工具根据时间点（每天早上八点半）帮助您自动提交表单

******************************************************************************************************************************************************

**windows下使用操作步骤**

	1.修改自己的学号和密码，在配置文件my_config.ini中；
	2.将start.bat创建快捷方式，然后将快捷方式复制到windows系统下C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp
	3.双击运行start.bat文件启动该服务(初次解压需要手动双击运行，之后关机后系统会自动加载该服务)。



 
