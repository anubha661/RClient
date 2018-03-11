package com.messageSeeker;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface MessageAPI {

    @GET("allmessages")

    Call<List<Message>> getMessages();
}
