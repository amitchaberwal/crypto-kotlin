package com.test.cryptotut.domain.use_case.get_coin

import com.test.cryptotut.common.Resource
import com.test.cryptotut.data.remote.dto.CoinDto
import com.test.cryptotut.data.remote.dto.toCoinDetail
import com.test.cryptotut.domain.model.CoinDetail
import com.test.cryptotut.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(id: String):Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(id).toCoinDetail()
            emit(Resource.Success<CoinDetail>(data = coinDetail))
        }
        catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Http Error"))
        }
        catch (e: IOException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?: "IO Error"))
        }
    }
}