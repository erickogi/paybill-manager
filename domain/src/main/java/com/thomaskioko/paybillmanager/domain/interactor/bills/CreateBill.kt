package com.thomaskioko.paybillmanager.domain.interactor.bills

import com.thomaskioko.paybillmanager.domain.executor.PostExecutionThread
import com.thomaskioko.paybillmanager.domain.executor.ThreadExecutor
import com.thomaskioko.paybillmanager.domain.model.Bill
import com.thomaskioko.paybillmanager.domain.repository.BillsRepository
import com.thomaskioko.paybillmanager.domain.usecase.CompletableUseCase
import io.reactivex.Completable
import javax.inject.Inject

open class CreateBill @Inject constructor(
        private val billsRepository: BillsRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
) : CompletableUseCase<CreateBill.Params>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return billsRepository.createBill(params.bill)
    }

    data class Params constructor(val bill: Bill) {
        companion object {
            fun forBill(bill: Bill): Params {
                return Params(bill)
            }
        }
    }
}