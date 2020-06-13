package com.example.retrofitexample;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<Post>> getPosts();//it will convert whole json to list
    //when we implement it we will provide a body later it

    @GET("posts")             // it auto put ? after post and = after userId making url posts?userId=2
    Call<List<Post>> getPosts(@Query("userId") int userId);//it will convert whole json to list
    //when we implement it we will provide a body later it

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);//it will convert whole json to list
    //when we implement it we will provide a body later it

    @GET
    Call<List<Comment>> getComments(@Url String url);


//    @POST("posts")
//    Call<Post> createPost(@Body Post post);//in this way we can encapsulate what we send to server

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String,String> fields);


    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);//put will update all fields in Post
    //in put we send full object sever will replace whole object
    //retrofit will generate implementation for us

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);//patch only update 1 field
//    patch request will not replace whole object but only the field which we send in object.
//    for this we use @formUrlEncoded and instead of @Body use @FieldMap

    @DELETE("posts/{id}")
    Call<Void> delPost(@Path("id") int id);
}
