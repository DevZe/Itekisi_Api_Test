package itekisi_api;

import kotlin.reflect.jvm.internal.impl.load.java.Constant;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface IAPIClient {

        HttpRequest request = null;
        HttpResponse<String> response= null;
}
