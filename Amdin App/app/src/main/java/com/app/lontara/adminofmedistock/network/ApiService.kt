package com.app.lontara.adminofmedistock.network

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiService {


    @GET("getAllUsers")
    suspend fun getAllUsers(): List<UserGetResponse>


    @FormUrlEncoded
    @PATCH("updateUserAllDetails")
    suspend fun updateUserAllDetails(
        @Field("name") name: String?,
        @Field("password") password: String?,
        @Field("level") level: String?,
        @Field("date_of_account_creation") date_of_account_creation: String?,
        @Field("isApproved") approved: Int?,
        @Field("block") block: Int?,
        @Field("address") address: String?,
        @Field("email") email: String?,
        @Field("number") number: String?,
        @Field("pinCode") pinCode: String?,
        @Field("user_id") userId: String?
    ) : UpdateUserResponse



    @FormUrlEncoded
    @POST("addProduct")
    suspend fun addProduct(
        @Field("name") name: String?,
        @Field("price") price: String?,
        @Field("stock") stock: String?,
        @Field("certified") certified: Int?,
        @Field("category") category: String?

    ) : Response<UpdateUserResponse?>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "deleteSpacficUser", hasBody = true)
    suspend fun deleteSpacficUser(
        @Field("user_id") userId: String?
    ) : UpdateUserResponse



    @GET("getAllOrdersDetail")
    suspend fun getAllOrdersDetail() : List<OrderGetResponse?>


    @FormUrlEncoded
    @PATCH("updateOrderDetails")
    suspend fun updateOrderDetails(
        @Field("order_id") orderId : String,
        @Field("isApproved") isApproved : String
    ) : UpdateUserResponse?



    @FormUrlEncoded
    @POST("addToAvailableProducts")
    suspend fun addToAvailableProducts(
        @Field("product_name")productName : String,
        @Field("category") category : String,
        @Field("certified") certified: String,
        @Field("price") price: String,
        @Field("stock") stock : String,
        @Field("user_name") userName: String,
        @Field("user_id") userId: String
    ) : Response<UpdateUserResponse?>


    @GET("getAllProduct")
    suspend fun getAllProduct() : List<GetAllProductsRes?>


    @FormUrlEncoded
    @POST("createUser")
    suspend fun createUser(
        @Field("name") name : String,
        @Field("password") password : String,
        @Field("email") email : String,
        @Field("phone_info") phoneInfo : String,
        @Field("address") address : String,
        @Field("phone_number") phoneNumber : String,
        @Field("pinCode") pinCode : String

    ) : CreateUserResponse?
}