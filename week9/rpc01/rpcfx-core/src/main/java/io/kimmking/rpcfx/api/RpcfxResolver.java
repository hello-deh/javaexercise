package io.kimmking.rpcfx.api;

public interface RpcfxResolver {

    Object resolve(Class<?> klass);

    Object resolve(String serviceClass);

}
