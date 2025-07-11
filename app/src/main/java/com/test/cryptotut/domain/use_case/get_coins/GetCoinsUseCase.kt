package com.test.cryptotut.domain.use_case.get_coins

import com.test.cryptotut.common.Resource
import com.test.cryptotut.data.remote.dto.toCoin
import com.test.cryptotut.domain.model.Coin
import com.test.cryptotut.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(data = coins))

        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "Error"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "Error"))
        }
    }
}