# shadowsocks-android代码简要说明

本代码基于`shadowsocks-android-4.5.7`版本的源码进行剖析。

## 几个重要类说明
### ProfileConfigActivity & ProfileConfigFragment
这两个界面组成`配置文件设置`界面，即用来修改服务器配置的界面。

#### 函数说明
* ProfileConfigFragment#saveAndExit  保存配置

### [ProfileManager](../mobile/src/main/java/com/github/shadowsocks/database/ProfileManager.kt)
服务器配置管理类，这个类用于修改&创建&查询服务器配置情况。

#### 函数说明


## 重要流程分析
### 启动服务流程

### 增加配置分析
