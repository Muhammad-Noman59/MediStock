package com.app.lontara.medicalstoreapp.repo

import com.app.lontara.medicalstoreapp.API.CreateUserResponse
import com.app.lontara.medicalstoreapp.API.GetAvailableProductRes
import com.app.lontara.medicalstoreapp.API.GetOrderDetailsRes
import com.app.lontara.medicalstoreapp.API.GetProductRes
import com.app.lontara.medicalstoreapp.API.GetSellHistoryRes
import com.app.lontara.medicalstoreapp.API.GetUserRes
import com.app.lontara.medicalstoreapp.API.RetrofitInstance
import com.app.lontara.medicalstoreapp.API.UpdateUserRes
import retrofit2.http.Field

class Repo() {

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
        return RetrofitInstance.api.createUser(
            name = name,
            password = password,
            email = email,
            phoneInfo = phoneInfo,
            address = address,
            phoneNumber = phoneNumber,
            pinCode = pinCode
        )
    }


    // Login User
    suspend fun login(email: String, password: String): CreateUserResponse? {
     return RetrofitInstance.api.login(email = email, password = password)
    }

    // Get All Products
    suspend fun getAllProducts(): List<GetProductRes> {
        return RetrofitInstance.api.getAllProducts()
    }


    // Add Order Details

    suspend fun addOrderDetails(
        product_id: String,
        user_id: String,
        product_name: String,
        user_name: String,
        total_amount: Double,
        price: Double,
        quantity: Int,
        message: String,
        certified: String,
        category: String
    ): CreateUserResponse? {
        return RetrofitInstance.api.addOrderDetails(
            product_id = product_id,
            user_id = user_id,
            product_name = product_name,
            user_name = user_name,
            total_amount = total_amount,
            price = price,
            quantity = quantity,
            message = message,
            certified = certified,
            category = category
        )
    }


    //  Get order details by user_id and isApproved

    suspend fun getOrderDetailsByFilter(
        userId: String,
        isApproved: String
    ): List<GetOrderDetailsRes?> {
        return RetrofitInstance.api.getOrderDetailsByFilter(
            userId = userId,
            isApproved = isApproved
        )
    }


    // Get Available Products By UserId
    suspend fun getAvailableProductsByUserId(userId: String): List<GetAvailableProductRes> {
        return RetrofitInstance.api.getAvailableProductsByUserId(userId = userId)
    }


    // Update Available Products
    suspend fun updateAvailableProducts(productId: String, stock: Int): CreateUserResponse? {
        return RetrofitInstance.api.updateAvailableProducts(productId = productId, stock = stock)
    }


    // Create Sell History
    suspend fun createSellHistory(

        productId: String,
        quantity: String,
        remainingStock: String,
        totalAmount: String,
        price: String,
        productName: String,
        userName: String,
        userId: String
    ): CreateUserResponse? {
        return RetrofitInstance.api.createSellHistory(
            productId = productId,
            quantity = quantity,
            remainingStock = remainingStock,
            totalAmount = totalAmount,
            price = price,
            productName = productName,
            userName = userName,
            userId = userId
        )
    }


    // Get Sell History By UserId
    suspend fun getSellHistoryByUserId(userId: String): List<GetSellHistoryRes?> {
        return RetrofitInstance.api.getSellHistoryByUserId(userId = userId)
    }


    // Get Spacific User
    suspend fun getSpacificUser(userId: String): List<GetUserRes?> {
        return RetrofitInstance.api.getSpacificUser(userId = userId)
    }


    // update User Details

    suspend fun updateUserDetails(
        name: String? = null,
        password: String? = null,
        address: String? = null,
        email: String? = null,
        pinCode: String? = null,
        phoneNumber: String? = null,
        userId: String
    ): UpdateUserRes? {

        return RetrofitInstance.api.updateUserAllDetails(
            name = name,
            password = password,
            address = address,
            email = email,
            pinCode = pinCode,
            phoneNumber = phoneNumber,
            userId = userId
        )
    }

}