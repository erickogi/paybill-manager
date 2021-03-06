package com.thomaskioko.paybillmanager.data.test.store.mpesapush

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.thomaskioko.paybillmanager.data.model.MpesaPushResponseEntity
import com.thomaskioko.paybillmanager.data.repository.mpesapush.MpesaPushRemote
import com.thomaskioko.paybillmanager.data.store.mpesapush.MpesaPushRemoteDataStore
import com.thomaskioko.paybillmanager.data.test.factory.DataFactory
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MpesaPushRemoteDataStoreTest {

    private val remote = mock<MpesaPushRemote>()
    private val store = MpesaPushRemoteDataStore(remote)

    @Test
    fun createMpesaPushRequestCompletes(){

        stubGetMpesaStkPushRequest(Flowable.just(DataFactory.makeMpesaPushResponseEntity()))

        val pushRequest = DataFactory.makeMpesaPushRequest()

        val testObserver = store.getMpesaStkPushRequest(
                "Bearer: ", "signaturePayload", pushRequest).test()
        testObserver.assertComplete()

    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveMpesaPushResponseThrowsException(){
       store.saveMpesaPushResponse(DataFactory.makeMpesaPushResponseEntity()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun getMpesaStkPushRequests() {
        store.getMpesaStkPushRequests()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearMpesaPushRequests() {
        store.clearMpesaPushRequests()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun isStkResponseCached() {
        store.isStkResponseCached("234")
    }

    private fun stubGetMpesaStkPushRequest(observer: Flowable<MpesaPushResponseEntity>){
        whenever(remote.getMpesaStkPushRequest(any(), any(), any()))
                .thenReturn(observer)
    }
}