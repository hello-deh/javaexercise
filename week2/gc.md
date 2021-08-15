SerialGC: yong区和old区都是单线程垃圾回收，yong区标记复制算法，old区标记清整理除算法，垃圾回收时STW暂停。回收延迟高，吞吐量低。

ParallelGC: yong区和old区都是读线程并行执行，，yong区标记复制算法，old区标记清整理除算法，垃圾回收时STW暂停。暂停时间比SerialGC要低，所以延迟低于SerialGC，吞吐量高。

CMSGC: yong区回收采用多线程并行标记复制算法，会有STW，old区并发标记整理算法。和并行的区别是old区垃圾回收和业务线程并发执行，而且清除之后不对old区进行整理，而是使用空闲列表。
old区的标记清除过程为：初始标记（STW），并发标记，并发预清理，最终标记，并发清除，并发重置。CMS 低延迟，高吞吐量。

G1GC: 堆不再分为年轻代和老年代，而是分成许多小块儿，每一块儿属于什么代会随时变化。G1GC的特点是可以控制每次gc时间在一个范围内，这是通过这种策略实现的：每次垃圾回收只对年轻代垃圾块儿全部回收，老年代只部分回收。

wrk -c40 -d30s http://localhost:8088
Running 30s test @ http://localhost:8088
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.42ms   14.63ms 255.41ms   97.64%
    Req/Sec     7.44k     2.36k   11.23k    70.34%
  439529 requests in 30.06s, 109.06MB read
  Non-2xx or 3xx responses: 439529
Requests/sec:  14622.15
Transfer/sec:      3.63MB

wrk -t4 -c40 -d30s http://localhost:8088
Running 30s test @ http://localhost:8088
  4 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.19ms   14.21ms 227.19ms   97.37%
    Req/Sec     4.28k   776.10     5.65k    85.55%
  507321 requests in 30.05s, 125.88MB read
  Non-2xx or 3xx responses: 507321
Requests/sec:  16881.52
Transfer/sec:      4.19MB