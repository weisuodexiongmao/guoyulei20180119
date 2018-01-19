package bwe.com.bawei.guoyulei20180119.utlis;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
@Override
public Response intercept(Chain chain) throws IOException {
Request request = chain.request();
HttpUrl httpUrl = request
.url().newBuilder().addQueryParameter("source", "android").build();Request requestNew = request.newBuilder()
.url(httpUrl)
.build();
return chain.proceed(requestNew);
}
}