package com.app.lontara.adminofmedistock.screens.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.lontara.adminofmedistock.network.ApiBuilder
import com.app.lontara.adminofmedistock.network.CreateUserResponse
import com.app.lontara.adminofmedistock.network.GetAllProductsRes
import com.app.lontara.adminofmedistock.network.OrderGetResponse
import com.app.lontara.adminofmedistock.network.UpdateUserResponse
import com.app.lontara.adminofmedistock.network.UserGetResponse
import com.app.lontara.adminofmedistock.repo.Repo
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Field

class ViewModel() : ViewModel() {

    val res = mutableStateOf<List<UserGetResponse>?>(emptyList())


    val updateRes = mutableStateOf<UpdateUserResponse?>(null)
    val response = mutableStateOf<CreateUserResponse?>(null)
    val deleteSpacficUserRes = mutableStateOf<UpdateUserResponse?>(null)
    val addProductRes = mutableStateOf<Response<UpdateUserResponse?>?>(null)
    val getAllOrdersDetailRes = mutableStateOf<List<OrderGetResponse?>?>(emptyList())
    val updateOrderDetailsRes = mutableStateOf<UpdateUserResponse?>(null)
    val addToAvailableProductRes = mutableStateOf<Response<UpdateUserResponse?>?>(null)
    val getAllProductRes = mutableStateOf<List<GetAllProductsRes?>>(emptyList())

    init {
        fetch()
        viewModelScope.launch {
            getAllOrdersDetailRes.value = getAllOrdersDetail(repo = Repo())
            getAllProductRes.value = getAllProduct(repo = Repo())
        }
    }

    // Get All Users
    private suspend fun getUsers(repo: Repo): List<UserGetResponse> {
        return repo.getAllUsers()
    }

    fun fetch() {
        viewModelScope.launch {
            res.value = getUsers(Repo())
        }
    }


    // Update User Details
    private suspend fun updateUserAllDetails(
        repo: Repo,
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
        return repo.updateUserAllDetails(
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

    fun updateUser(
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
    ) {
        viewModelScope.launch {
            updateRes.value = updateUserAllDetails(
                Repo(),
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
    }


    // Add Products
    private suspend fun addProduct(
        repo: Repo,
        name: String?,
        price: String?,
        stock: String?,
        certified: Int?,
        category: String?
    ): Response<UpdateUserResponse?> {
        return repo.addProduct(
            name = name,
            price = price,
            stock = stock,
            certified = certified,
            category = category
        )
    }

    fun addPro(
        name: String?,
        price: String?,
        stock: String?,
        certified: Int?,
        category: String?
    ) {

        viewModelScope.launch {
            addProductRes.value = addProduct(
                repo = Repo(),
                name = name,
                price = price,
                stock = stock,
                certified = certified,
                category = category
            )
        }

    }


    // Delete Spacfic User

    private suspend fun deleteSpacficUser(userId: String?, repo: Repo): UpdateUserResponse? {
        return repo.deleteSpacficUser(userId = userId)
    }

    fun deleteSpacficUser(userId: String?) {
        viewModelScope.launch {
            deleteSpacficUserRes.value = deleteSpacficUser(userId = userId, repo = Repo())
        }
    }


    // Get All Orders Details
    private suspend fun getAllOrdersDetail(repo: Repo): List<OrderGetResponse?> {
        return repo.getAllOrdersDetail()
    }


    // Update Order Details
    private suspend fun updateOrderDetails(

        repo: Repo,
        orderId: String,
        isApproved: String
    ): UpdateUserResponse? {
        return repo.updateOrderDetails(
            orderId = orderId,
            isApproved = isApproved
        )
    }

    fun updateOrderDetail(
        orderId: String,
        isApproved: String
    ) {
        viewModelScope.launch {
            updateOrderDetailsRes.value = updateOrderDetails(
                repo = Repo(),
                orderId = orderId,
                isApproved = isApproved
            )
        }
    }


    // Add Product To Available Products in user database
    private suspend fun addToAvailableProduct(
        repo: Repo,
        productName: String,
        category: String,
        certified: String,
        price: String,
        stock: String,
        userName: String,
        userId: String
    ): Response<UpdateUserResponse?> {
        return repo.addToAvailableProducts(
            productName = productName,
            category = category,
            certified = certified,
            price = price,
            stock = stock,
            userName = userName,
            userId = userId
        )
    }

    fun addToAvailableProducts(
        productName: String,
        category: String,
        certified: String,
        price: String,
        stock: String,
        userName: String,
        userId: String
    ) {
        viewModelScope.launch {
            addToAvailableProductRes.value = addToAvailableProduct(
                repo = Repo(),
                productName = productName,
                category = category,
                certified = certified,
                price = price,
                stock = stock,
                userName = userName,
                userId = userId
            )
        }
    }


    // Get All Product
    private suspend fun getAllProduct(repo: Repo): List<GetAllProductsRes?> {
        return repo.getAllProduct()
    }


    // Create User
   private suspend fun userCreate(
        repo: Repo,
        name: String,
        password: String,
        email: String,
        phoneInfo: String,
        address: String,
        phoneNumber: String,
        pinCode: String
    ) : CreateUserResponse? {

       return  repo.create(
            name = name,
            password = password,
            email = email,
            phoneInfo = phoneInfo,
            address = address,
            phoneNumber = phoneNumber,
            pinCode = pinCode
        )
    }


    fun userCreateRes(
        name: String,
        password: String,
        email: String,
        phoneInfo: String,
        address: String,
        phoneNumber: String,
        pinCode: String
    ) {
        viewModelScope.launch {
            response.value =  userCreate(
                repo = Repo(),
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

}