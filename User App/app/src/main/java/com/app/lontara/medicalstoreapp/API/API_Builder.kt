package com.app.lontara.medicalstoreapp.API

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST


interface API_Builder {


    @GET("getAllProduct")
    suspend fun  getAllProducts() : List<GetProductRes>

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


    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email : String,
        @Field("password") password : String
    ) : CreateUserResponse?


    @FormUrlEncoded
    @POST("addOrderDetails")
    suspend fun addOrderDetails(
        @Field("product_id")product_id : String,
        @Field("user_id")user_id : String,
        @Field("product_name")product_name : String,
        @Field("user_name")user_name: String,
        @Field("total_amount")total_amount: Double,
        @Field("price")price: Double,
        @Field("quantity") quantity : Int,
        @Field("message")message : String,
        @Field("certified")certified : String,
        @Field("category")category : String
    ) : CreateUserResponse?



    @FormUrlEncoded
    @POST("getOrderDetailsByFilter")
    suspend fun getOrderDetailsByFilter(
        @Field("user_id") userId : String,
        @Field("isApproved") isApproved : String
    ) : List<GetOrderDetailsRes?>



    @FormUrlEncoded
    @POST("getAvailableProductsByUserId")
    suspend fun getAvailableProductsByUserId(
        @Field("user_id") userId : String
    ) : List<GetAvailableProductRes>


    @FormUrlEncoded
    @HTTP(method = "PATCH", path = "updateAvailableProducts", hasBody = true)
    suspend fun updateAvailableProducts(
        @Field("product_id") productId :String,
        @Field("stock") stock : Int
    ) : CreateUserResponse?


    @FormUrlEncoded
    @POST("craeteSellHistory")
    suspend fun createSellHistory(
        @Field("product_id") productId : String,
        @Field("quantity") quantity : String,
        @Field("remaining_stock") remainingStock : String,
        @Field("total_amount") totalAmount : String,
        @Field("price") price : String,
        @Field("product_name") productName : String,
        @Field("user_name") userName : String,
        @Field("user_id") userId : String
    ) : CreateUserResponse?


    @FormUrlEncoded
    @POST("getSellHistoryByUserId")
    suspend fun getSellHistoryByUserId(
        @Field("user_id") userId : String
    ) : List<GetSellHistoryRes?>



    @FormUrlEncoded
    @POST("getSpacificUser")
    suspend fun getSpacificUser(
        @Field("user_id") userId : String
    ) : List<GetUserRes?>



    @FormUrlEncoded
    @HTTP(method = "PATCH", path = "updateUserAllDetails", hasBody = true)
    suspend fun updateUserAllDetails(

        @Field("user_id") userId: String,
        @Field("name") name: String? = null,
        @Field("password") password: String? = null,
        @Field("address") address: String? = null,
        @Field("email") email: String? = null,
        @Field("pinCode") pinCode: String? = null,
        @Field("phone_number") phoneNumber: String? = null
    ) : UpdateUserRes?

}