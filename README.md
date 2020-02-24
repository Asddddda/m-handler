# m-handler
着是一个简化版的安卓handler机制，可以实现简单的线程间通信
### 知识点：
安卓handler，ThreadLocal,线程的操作方法，锁

### 目标：
理解安卓的handler机制。
将looper类中的ArrayDeque<Message>替换为自己实现的MessageQueue；
目前message里只能带有runable对象，扩展message，使其可以传递不同类型的消息而不仅仅是runable；
扩展现有功能。

### tips：
可以参考Android handler相关文章，也可以直接查看安卓handler有关源代码，但本例有一些实现不太一致。
禁止cv代码，可以参考实现原理，但是请关掉博客之后再写代码。
