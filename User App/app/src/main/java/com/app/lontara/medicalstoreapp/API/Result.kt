package com.app.lontara.medicalstoreapp.API

 sealed  class Result<T> (

     val data : T? = null,
     val message : String? = null

 ){

     class Success <T>(data : T?) : Result<T>(data= data)
     class Loading (message: String?) : Result<String>(message = message)
     class Error <T>(data : T? = null, message : String) : Result<T>(data = data, message = message)
     
}