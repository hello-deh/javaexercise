SerialGC: yong����old�����ǵ��߳��������գ�yong����Ǹ����㷨��old�������������㷨����������ʱSTW��ͣ�������ӳٸߣ��������͡�

ParallelGC: yong����old�����Ƕ��̲߳���ִ�У���yong����Ǹ����㷨��old�������������㷨����������ʱSTW��ͣ����ͣʱ���SerialGCҪ�ͣ������ӳٵ���SerialGC���������ߡ�

CMSGC: yong�����ղ��ö��̲߳��б�Ǹ����㷨������STW��old��������������㷨���Ͳ��е�������old���������պ�ҵ���̲߳���ִ�У��������֮�󲻶�old��������������ʹ�ÿ����б�
old���ı���������Ϊ����ʼ��ǣ�STW����������ǣ�����Ԥ�������ձ�ǣ�����������������á�CMS ���ӳ٣�����������

G1GC: �Ѳ��ٷ�Ϊ�����������������Ƿֳ����С�����ÿһ�������ʲô������ʱ�仯��G1GC���ص��ǿ��Կ���ÿ��gcʱ����һ����Χ�ڣ�����ͨ�����ֲ���ʵ�ֵģ�ÿ����������ֻ��������������ȫ�����գ������ֻ���ֻ��ա�

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