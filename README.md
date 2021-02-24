# Grape

## 介绍
葡萄翻译 , 一个java命令行的单词查询工具 , 启动快速 , 适合不爱用鼠标的程序猿。

使用 Sqlite 轻量级数据库，无需安装，直接使用。

最近在看文档的时候，总是会碰到一个单词咋都想不起来意思，捉急！通常情况下，我会使用手机有道，谷歌翻译，或使用IDEA自带的翻译等，（虽然也很方便）但启动这些东西可得花一些时间，况且我可不想把IDEA当字典来用，于是花了一下午设计了个简单的Java英语字典，毕竟我的需求只是知道翻译就可以啦，（最关键的是不需要联网！！）

## 安装教程
由于本项目在终端运行，因此只能确保 `Win10` 环境的运行，不支持苹果（原因 : 没有MAC 》-《！)

部署环境：
* JDK 1.8
* Maven 3.X (也可直接使用我已打包好的 `jar` 包)

在Windows环境下，克隆项目代码，命令行进入根目录，运行 `start.bat` 文件即可。

在 C:\system 下新建一个批处理文件 ge.bat，输入(注意填写你自己的jar路径)
```shell
java -jar D:\code\java\Grape\jar\grape-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```
保存退出，然后下次使用，只需要快捷键 `Win + R` 然后输入 `ge` 即可快速运行程序，美滋滋

<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape07.png" alt="权限管理模块说明"/>
</div>

注：不想编译源码的小伙伴，我直接提供了编译好的 jar 包，在文件夹jar中，直接运行 java -jar XXX.jar即可

## 命令讲解
单词的查询提供了几个小命令，这里简单讲解一下（只支持单命令或无命令使用）

* -c   清空
        
* -q   退出
        
* -h   帮助
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape01.png" alt="权限管理模块说明"/>
</div>

* 无命令查询，默认在所有地方查询
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape02.png" alt="权限管理模块说明"/>
</div>

* -a   与该字符串全匹配的单词
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape03.png" alt="权限管理模块说明"/>
</div>

* -s   以字符串开始的单词
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape04.png" alt="权限管理模块说明"/>
</div>

* -e   以字符串结尾的单词
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape05.png" alt="权限管理模块说明"/>
</div>

* -p   在单词解释中搜索该字符串
<div align="center">
<img src="https://gitee.com/qiu-qian/Grape/raw/master/img/grape06.png" alt="权限管理模块说明"/>
</div>

## 结尾

可fork本仓库参与贡献
有啥问题可在评论区留言，我努力回复，努力帮忙！
多多fork多多star多多支持!!!😁

## 捐赠

可以请作者喝一瓶哇哈哈：

<div align="center">
<img src="https://gitee.com/qiu-qian/sky/raw/master/img/pay.png"  width="200px" height="200px" />
</div>