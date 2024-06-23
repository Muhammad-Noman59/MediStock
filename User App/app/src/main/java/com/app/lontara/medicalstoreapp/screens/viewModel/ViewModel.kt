package com.app.lontara.medicalstoreapp.screens.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.lontara.medicalstoreapp.API.CreateUserResponse
import com.app.lontara.medicalstoreapp.API.GetAvailableProductRes
import com.app.lontara.medicalstoreapp.API.GetOrderDetailsRes
import com.app.lontara.medicalstoreapp.API.GetProductRes
import com.app.lontara.medicalstoreapp.API.GetSellHistoryRes
import com.app.lontara.medicalstoreapp.API.GetUserRes
import com.app.lontara.medicalstoreapp.API.UpdateUserRes
import com.app.lontara.medicalstoreapp.pref.UserData
import com.app.lontara.medicalstoreapp.pref.UserPrefImpl
import com.app.lontara.medicalstoreapp.repo.Repo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Response

// ViewModel to manage data for the user interface
class ViewModel(context: Context, private val repo: Repo) : ViewModel() {


    val dataStore = PreferenceDataStoreFactory.create(
        corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }
        ),

        produceFile = { context.preferencesDataStoreFile("user_data") }
    )

    val userPref = UserPrefImpl(dataStore = dataStore)

    val userListState = userPref.getUserData().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    val state = mutableStateOf<String?>(null)
    val loading = mutableStateOf(false)
    val goHome = mutableStateOf(false)
    val failed = mutableStateOf(false)
    val response = mutableStateOf<CreateUserResponse?>(null)
    val orderCreateRes = mutableStateOf<CreateUserResponse?>(null)
    var getProductRes = mutableStateOf<List<GetProductRes?>?>(emptyList())
    val pendingOrders = mutableStateOf<List<GetOrderDetailsRes?>?>(emptyList())
    val approvedOrders = mutableStateOf<List<GetOrderDetailsRes?>?>(emptyList())
    val disApprovedOrders = mutableStateOf<List<GetOrderDetailsRes?>?>(emptyList())
    val getAvailableProductsByUserIdRes = mutableStateOf<List<GetAvailableProductRes>>(emptyList())
    val updateAvailableProductRes = mutableStateOf<CreateUserResponse?>(null)
    val createSellHistoryRes = mutableStateOf<CreateUserResponse?>(null)
    val getSellHistoryRes = mutableStateOf<List<GetSellHistoryRes?>?>(emptyList())
    val getUserRes = mutableStateOf<List<GetUserRes?>>(emptyList())
    val updateUserRes = mutableStateOf<UpdateUserRes?>(null)

    init {
        viewModelScope.launch {

            getProductRes.value = getAllProducts()

            userPref.getUserData().collect {

                it.map { user ->

                    pendingOrders.value =
                        getOrderDetailsByFilter(userId = user.userId!!, isApproved = "2")
                    approvedOrders.value =
                        getOrderDetailsByFilter(userId = user.userId, isApproved = "1")
                    disApprovedOrders.value =
                        getOrderDetailsByFilter(userId = user.userId, isApproved = "0")

                    getAvailableProductsByUserIdRes.value =
                        getAvailableProductsByUserId(userId = user.userId)

                    getSellHistoryRes.value = getSellHistoryByUserId(userId = user.userId)

                    getUserRes.value = getSpacificUser(userId = user.userId)
                }
            }
        }
    }


    fun setUserData(userDataList: List<UserData>) {
        viewModelScope.launch {
            userPref.setUserData(userData = userDataList)
        }
    }


    // Create User
    suspend fun userCreate(
        name: String,
        password: String,
        email: String,
        phoneInfo: String,
        address: String,
        phoneNumber: String,
        pinCode: String
    ) {
        state.value = StateMange.LOADING.name


        response.value = repo.create(
            name = name,
            password = password,
            email = email,
            phoneInfo = phoneInfo,
            address = address,
            phoneNumber = phoneNumber,
            pinCode = pinCode
        )


        Log.d("PasswordAgys", "loginUser: ${response.value!!.status}")
        if (response.value != null) {
            if (response.value!!.status == 200) {
                state.value = StateMange.SUCCESS.name
                Log.d("PasswordAgys", "loginUser: StateMange.SUCCESS")

            } else {
                state.value = StateMange.FAILED.name
                loading.value = false
                Log.d("PasswordAgys", "loginUser: StateMange.FAILED")
            }
        } else {
            state.value = StateMange.FAILED.name
            loading.value = false
            Log.d("PasswordAgys", "loginUser: StateMange.FAILED02")

        }

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
            userCreate(
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



    // Login User
    private suspend fun loginUser(repo: Repo, email: String, password: String): CreateUserResponse? {
        return repo.login(
            email = email,
            password = password
        )
    }

    fun loginUser(email: String, password: String) {

        state.value = StateMange.LOADING.name

        viewModelScope.launch {
            response.value = loginUser(repo = repo, email = email, password = password)
            if (response.value != null) {
                if (response.value!!.status == 200) {
                    state.value = StateMange.SUCCESS.name
                    Log.d("PasswordAgys", "loginUser: StateMange.SUCCESS")

                } else {
                    state.value = StateMange.FAILED.name
                    loading.value = false
                    Log.d("PasswordAgys", "loginUser: StateMange.FAILED")
                }
            } else {
                state.value = StateMange.FAILED.name
                loading.value = true
                Log.d("PasswordAgys", "loginUser: StateMange.FAILED02")

            }
        }
    }


    fun StatesNo(
        viewModel: com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
    ) {

        val state = viewModel.state.value

        when (state) {
            StateMange.FAILED.name -> {
                failed.value = true
            }

            StateMange.SUCCESS.name -> {
                goHome.value = true
            }

            StateMange.LOADING.name -> {
                loading.value = true
            }

        }
    }

    // Get All Products

    private suspend fun getAllProducts(): List<GetProductRes> {
        return repo.getAllProducts()
    }

    // Add Order Details

    fun addOrderDetails(
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
    ) {
        viewModelScope.launch {
            orderCreateRes.value = repo.addOrderDetails(
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
    }


    //  Get order details by user_id and isApproved

    private suspend fun getOrderDetailsByFilter(
        userId: String,
        isApproved: String
    ): List<GetOrderDetailsRes?> {
        return repo.getOrderDetailsByFilter(userId = userId, isApproved = isApproved)
    }


    // Get Available Products By UserId
    private suspend fun getAvailableProductsByUserId(userId: String): List<GetAvailableProductRes> {
        return repo.getAvailableProductsByUserId(userId = userId)
    }


    // Update Available Products
    private suspend fun updateAvailableProducts(
        productId: String,
        stock: Int
    ): CreateUserResponse? {
        return repo.updateAvailableProducts(productId = productId, stock = stock)
    }

    fun updateAvailableProduct(productId: String, stock: Int) {
        viewModelScope.launch {

            updateAvailableProductRes.value =
                updateAvailableProducts(productId = productId, stock = stock)
        }
    }


    // Create Sell History
    private suspend fun createSellHistory(
        productId: String,
        quantity: String,
        remainingStock: String,
        totalAmount: String,
        price: String,
        productName: String,
        userName: String,
        userId: String
    ): CreateUserResponse? {

        return repo.createSellHistory(
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

    fun createSellHistories(
        productId: String,
        quantity: String,
        remainingStock: String,
        totalAmount: String,
        price: String,
        productName: String,
        userName: String,
        userId: String
    ) {

        viewModelScope.launch {

            createSellHistoryRes.value = createSellHistory(
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
    }


    // Get Sell History By UserId
    private suspend fun getSellHistoryByUserId(userId: String): List<GetSellHistoryRes?> {
        return repo.getSellHistoryByUserId(userId = userId)
    }


    // Get Spacific User
    private suspend fun getSpacificUser(userId: String): List<GetUserRes?> {
        return repo.getSpacificUser(userId = userId)
    }


    // update User Details

    private suspend fun updateUserDetails(

        name: String? = null,
        password: String? = null,
        address: String? = null,
        email: String? = null,
        pinCode: String? = null,
        phoneNumber: String? = null,
        userId: String
    ): UpdateUserRes? {

        return repo.updateUserDetails(
            name = name,
            password = password,
            address = address,
            email = email,
            pinCode = pinCode,
            phoneNumber = phoneNumber,
            userId = userId
        )
    }


    fun updateUserDetail(
        name: String,
        password: String,
        address: String,
        email: String,
        pinCode: String,
        phoneNumber: String,
        userId : String
    ){

        viewModelScope.launch {
         updateUserRes.value = updateUserDetails(
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

}