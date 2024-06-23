package com.app.lontara.adminofmedistock.repo

import android.util.Log
import com.app.lontara.adminofmedistock.network.ApiBuilder
import com.app.lontara.adminofmedistock.network.CreateUserResponse
import com.app.lontara.adminofmedistock.network.GetAllProductsRes
import com.app.lontara.adminofmedistock.network.OrderGetResponse
import com.app.lontara.adminofmedistock.network.UpdateUserResponse
import com.app.lontara.adminofmedistock.network.UserGetResponse
import retrofit2.Response
import retrofit2.http.Field


class Repo {

    // Get All Users
    suspend fun getAllUsers(): List<UserGetResponse> {
        return ApiBuilder.provedApi.getAllUsers()
    }

    // Update User Details
    suspend fun updateUserAllDetails(
        name: String? = null,
        password: String? = null,
        level: String? = null,
        date_of_account_creation: String? = null,
        approved: Int? = null,
        block: Int? = null,
        address: String? = null,
        email: String? = null,
        number: String? = null,
        pinCode: String? = null,
        userId: String?
    ): UpdateUserResponse? {
        return ApiBuilder.provedApi.updateUserAllDetails(
            name = name,
            password = password,
            level = level,
            date_of_account_creation = date_of_account_creation,
            approved = approved,
            block = block,
            address = address,
            email = email,
            number = number,
            pinCode = pinCode,
            userId = userId
        )
    }


    // Add Products
    suspend fun addProduct(
        name: String?,
        price: String?,
        stock: String?,
        certified: Int?,
        category: String?
    ): Response<UpdateUserResponse?> {

        return ApiBuilder.provedApi.addProduct(
            name = name,
            price = price,
            stock = stock,
            certified = certified,
            category = category
        )
    }


    // Delete Spacfic User

    suspend fun deleteSpacficUser(userId: String?): UpdateUserResponse? {
        return ApiBuilder.provedApi.deleteSpacficUser(userId = userId)
    }


    // Get all orders details
    suspend fun getAllOrdersDetail(): List<OrderGetResponse?> {
        return ApiBuilder.provedApi.getAllOrdersDetail()
    }


    // Update Order Details
    suspend fun updateOrderDetails(
        orderId: String,
        isApproved: String
    ): UpdateUserResponse? {
        return ApiBuilder.provedApi.updateOrderDetails(
            orderId = orderId,
            isApproved = isApproved
        )
    }


    // Add Product To Available Products in user database
    suspend fun addToAvailableProducts(
        productName: String,
        category: String,
        certified: String,
        price: String,
        stock: String,
        userName: String,
        userId: String
    ): Response<UpdateUserResponse?> {

        return ApiBuilder.provedApi.addToAvailableProducts(
            productName = productName,
            category = category,
            certified = certified,
            price = price,
            stock = stock,
            userName = userName,
            userId = userId
        )
    }


    // Get All Product
    suspend fun getAllProduct():List<GetAllProductsRes?>{
        return ApiBuilder.provedApi.getAllProduct()
    }


    // Create User Fun
    suspend fun create(
        name: String,
        password: String,
        email: String,
        phoneInfo: String,
        address: String,
        phoneNumber: String,
        pinCode: String
    ): CreateUserResponse? {
        return ApiBuilder.provedApi.createUser(
            name = name,
            password = password,
            email = email,
            phoneInfo = phoneInfo,
            address = address,
            phoneNumber = phoneNumber,
            pinCode = pinCode
        )
    }
}