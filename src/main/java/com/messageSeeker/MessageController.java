package com.messageSeeker;




import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import java.util.List;

public class MessageController implements Callback<List<Message>> {

    public final String base_URL="http://localhost:8080/";

    public void start()
    {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(base_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        MessageAPI msgAPI=retrofit.create(MessageAPI.class);
        Call<List<Message>> call=msgAPI.getMessages();
        call.enqueue(this);
        System.out.println("call.enqueue done ");
    }

    @Override
    public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {

        System.out.println("onreponse got called");
        if(response.isSuccessful()) {

            List<Message> allMessages = response.body();
            allMessages.forEach(msg -> System.out.println("msgcode" + msg.getMessageCode()+ " Today's message " + msg.getTodaysMessage()));
        }
        else
            System.out.println(response.errorBody());

    }

    @Override
    public void onFailure(Call<List<Message>> call, Throwable t) {
        System.out.println("failure got called");
        t.printStackTrace();

    }
}
