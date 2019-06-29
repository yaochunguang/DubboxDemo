# DubboxDemo
Dubbox入门案例

- <a href="#jianjie">Dubbox简介</a>
- <a href="#zhuce">注册中心Zookeeper</a>
- <a href="#jieshao">Zookeeper 介绍</a>
- <a href="#anzhuang">Zookeeper 在Linux系统的安装</a>
- <a href="#qidong">Zookeeper 服务启动</a>
- <a href="#demo">入门小Demo</a>
- <a href="#fuwu">服务提供者开发</a>
- <a href="#xiaofei">服务消费者开发</a>

<a name="jianjie">Dubbox简介</a>
Dubbox 是一个分布式服务框架，其前身是阿里巴巴开源项目Dubbo ，被国内电商及互联网项目中使用，后期阿里巴巴停止了该项目的维护，当当网便在Dubbo基础上进行优化，并继续维护，为了与原有的Dubbo区分，故将其命名为Dubbox。

Dubbox 致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。简单的说，dubbox就是个服务框架，如果没有分布式的需求，其实是不需要用的，只有在分布式的时候，才有dubbox这样的分布式服务框架的需求，并且本质上是个服务调用的东东，说白了就是个远程服务调用的分布式框架。
![](https://i.imgur.com/QL785HB.png)


**节点角色说明：**
• Provider: 暴露服务的服务提供方。
• Consumer: 调用远程服务的服务消费方。
• Registry: 服务注册与发现的注册中心。
• Monitor: 统计服务的调用次调和调用时间的监控中心。
• Container: 服务运行容器。
**调用关系说明：**
• 0. 服务容器负责启动，加载，运行服务提供者。
• 1. 服务提供者在启动时，向注册中心注册自己提供的服务。
• 2. 服务消费者在启动时，向注册中心订阅自己所需的服务。
• 3. 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推
送变更数据给消费者。
• 4. 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，
如果调用失败，再选另一台调用。
• 5. 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计
数据到监控中心。

<a name="zhuce">注册中心Zookeeper</a>
<a name="jieshao">Zookeeper 介绍</a>
官方推荐使用 zookeeper 注册中心。注册中心负责服务地址的注册与查找，相当于目录服务，服务提供者和消费者只在启动时与注册中心交互，注册中心不转发请求，压力较小。
Zookeeper 是 Apacahe Hadoop 的子项目，是一个树型的目录服务，支持变更推送，适合作为Dubbox 服务的注册中心，工业强度较高，可用于生产环境。
<a name="anzhuang">Zookeeper 在Linux系统的安装</a>
Zookeeper 在Linux系统的安装
安装步骤：
第一步：安装 jdk
第二步：把 zookeeper 的压缩包（zookeeper-3.4.6.tar.gz）上传到 linux 系统。
Alt+P 进入SFTP ，输入put d:\zookeeper-3.4.6.tar.gz 上传
第三步：解压缩压缩包
tar -zxvf zookeeper-3.4.6.tar.gz
第四步：进入 zookeeper-3.4.6 目录，创建 data 文件夹。
mkdir data
第五步：进入conf目录 ，把 zoo_sample.cfg 改名为 zoo.cfg
cd conf
mv zoo_sample.cfg zoo.cfg
第六步：打开zoo.cfg ,  修改 data 属性：dataDir=/root/zookeeper-3.4.6/data
<a name="qidong">Zookeeper 服务启动</a>
进入bin目录，启动服务输入命令
     ./zkServer.sh start
输出以下内容表示启动成功
![](https://i.imgur.com/ZnsvqZ5.png)
关闭服务输入命令
    ./zkServer.sh stop
输出以下提示信息
![](https://i.imgur.com/Df4YoL3.png)
查看状态：
    ./zkServer.sh status
如果启动状态，提示
![](https://i.imgur.com/Ns06uU7.png)
如果未启动状态，提示：
![](https://i.imgur.com/FgByWJX.png)

<a name="demo">入门小Demo</a>
入门案例包含服务提供者和服务消费者
<a name="fuwu">服务提供者开发</a>
对应项目DubboxDemoService 

<a name="xiaofei">服务消费者开发</a>
>对应项目DubboxDemoWeb