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
`BaseService#buildShadowsocksConfig`创建服务端配置。
### 增加配置分析
