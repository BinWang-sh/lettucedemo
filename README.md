# lettucedemo

##### <1>Load redis configuration

##### <2>Set jackson2JsonRedisSerializer as value serializer
* Serialize object as json string. 
* Serialized object does not need to implement serializable interface
* Good performance and serialized result readable

##### <3>Set stringRedisSerializer as key serializer

##### <4>Enable connection pool by setting
* lettuceConnectionFactory.setValidateConnection(false);
* lettuceConnectionFactory.setShareNativeConnection(false);

##### redis-cli
Using command "info clients" can confirm the number of connected clients



PS

As for serializer there are multi selection. 
* GenericToStringSerializer
* Jackson2JsonRedisSerializer
* JacksonJsonRedisSerializer
* JdkSerializationRedisSerializer
* StringRedisSerializer


GenericToStringSerializer：可以将任何对象泛化为字符创并序列化
* Jackson2JsonRedisSerializer：序列化Object对象为json字符创（与JacksonJsonRedisSerializer相同）
* JdkSerializationRedisSerializer：序列化java对象
* StringRedisSerializer：简单的字符串序列化
* JdkSerializationRedisSerializer序列化
JDK自带的序列化方式，被序列化对象必须实现Serializable接口，被序列化除属性内容还有其他内容，长度长且不易阅读
存储内容如下：

\xac\xed\x00\x05sr\x00!com.oreilly.springdata.redis.User\xb1\x1c \n\xcd\xed%\xd8\x02\x00\x02I\x00\x03ageL\x00\buserNamet\x00\x12Ljava/lang/String;xp\x00\x00\x00\x14t\x00\x05user1


Jackson2JsonRedisSerializer序列化
被序列化对象不需要实现Serializable接口，被序列化的结果清晰，容易阅读，而且存储字节少，速度快
存储内容如下：

{\"userName\":\"user1\",\"age\":20}


StringRedisSerializer
通过String.getBytes()来实现的。而且在Redis中，所有存储的值都是字符串类型的。所以这种方法保存后，通过Redis-cli控制台，是可以清楚的查看到我们保存了什么key,value就是是什么
