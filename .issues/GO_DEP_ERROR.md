# 关于goBuild任务执行错误
## 原因
由于`golang.org`被国内墙了导置的。
## 解决方法
执行下列命令行
```
# 当前目录为shadowsocks-android的目录
git clone https://github.com/golang/net.git core/src/overture/go/src/golang.org/x/net
```