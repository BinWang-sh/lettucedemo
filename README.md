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
Using command "info clients" can confirm current the number of connected clients

