package com.example.islandofhvar

import androidx.lifecycle.*
import com.example.islandofhvar.data.Product
import com.example.islandofhvar.data.ProductRepository

class SharedViewModel : ViewModel() {

    var productRepository: ProductRepository = ProductRepository()

    val selectedProduct: MutableLiveData<Product> = MutableLiveData()

    val products: LiveData<List<Product>> = liveData {
        val data = productRepository.getProducts()
        emit(data)
    }
}