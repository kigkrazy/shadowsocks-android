# shadowsocks-android代码简要说明

本代码基于`shadowsocks-android-4.5.7`版本的源码进行剖析。

## 几个重要类说明
### ProfileConfigActivity & ProfileConfigFragment
这两个界面组成`配置文件设置`界面，即用来修改服务器配置的界面。

### com.github.shadowsocks.database.ProfileManager
配置管理类，用于配置的添加删除等操作。

### com.github.shadowsocks.App
* `switchProfile`选择配置
* `startService`启动服务 
* `stopService`停止服务 


#### 函数说明
* ProfileConfigFragment#saveAndExit  保存配置

### [ProfileManager](../mobile/src/main/java/com/github/shadowsocks/database/ProfileManager.kt)
服务器配置管理类，这个类用于修改&创建&查询服务器配置情况。

#### 函数说明


### VpnService
这是一个继承安卓VpnService的类，用于数据包的转发。

#### 解惑
```java
...
import android.net.VpnService as BaseVpnService

class VpnService : BaseVpnService(), LocalDnsService.Interface {
...
```
代码中的`BaseVpnService`表示的是`android.net.VpnService`并非源码代的`BaseVpnService`。
## 重要流程分析
### 启动服务流程
`BaseService#buildShadowsocksConfig`创建服务端配置文件。
### 增加配置分析

## `Profile`配置说明
### 例子
```json
{
    "bypass": true,
    "proxyApps": true,
    "individual": "com.reizx.ares.faker\ncom.reizx.ares.mgr\n",
    "date": "Aug 9, 2018 11:22:45 PM",
    "dirty": false,
    "host": "198.199.101.152",
    "ipv6": true,
    "method": "aes-256-cfb",
    "name": "",
    "password": "u1rRWTssNv0p",
    "plugin": "",
    "remoteDns": "8.8.8.8",
    "remotePort": 8388,
    "route": "bypass-lan",
    "rx": 0,
    "tx": 0,
    "udpdns": false,
    "userOrder": 1
}
```
### 绕行APP模式
当`bypass`,`proxyApps`,都为`true`的时候`individual`中的包请求不经过代理。