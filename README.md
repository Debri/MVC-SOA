##  将MVC架构的应用转化为SOA的应用

### Spring JPA，Spring MVC

#### 此项目仅仅将MVC的项目拆分为SOA，将一个电商平台分成了用户，产品，订单，交易服务模块，但仅仅还是在一台机器上面运行，因此写了一个[dubbo分布式的版本](https://github.com/Debri/dubbo-soa)


### SOA的优点
1. 更易维护
   > 服务提供者和服务使用者的松散耦合关系及对开放标准的采用确保了该特性的实现。建立在SOA基础上的信息系统，当需求发生变化的时候，不需要修改提供服务的接口，只需要调整业务服务流程或者修改操作即可，整个应用也更容易被维
2. 更高的可用性
    >　该特性在服务提供者和服务使用者的松散耦合关系上得以体现。使用者无须了解提供者的实现细节
3. 更高的伸缩性
    > 依靠服务设计、开发和部署所采用的架构模型实现伸缩性。服务提供者可以彼此独立调整，以满足服务需求


#### 遇到的奇怪的问题
1. 使用JPA的时候，数据表的名称不能设置成“order”，order会被当成关键字处理。改成“orders”以后就不会报sql语法错误了
2. dubbo的依赖包含spring 2.5.6的版本，在添加dubbo依赖的时候把spring排除掉，不然报class not found错误
3. org.hibernate.HibernateException: Access to DialectResolutionInfo cannot be null when 'hibernate.dialect' not set 设置连接的数据库方言
 



