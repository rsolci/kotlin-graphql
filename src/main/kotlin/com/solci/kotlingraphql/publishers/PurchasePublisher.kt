package com.solci.kotlingraphql.publishers

import com.solci.kotlingraphql.entities.Purchase
import com.solci.kotlingraphql.repositories.PurchaseRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Component
class PurchasePublisher(
    private val purchaseRepository: PurchaseRepository
) {
    private lateinit var publisher: Flowable<List<Purchase>>

    init {
        val observable: Observable<List<Purchase>> = Observable.create<List<Purchase>> { emitter ->
            val newScheduledThreadPool = Executors.newScheduledThreadPool(1)
            newScheduledThreadPool.scheduleAtFixedRate(purchaseTick(emitter), 0, 2, TimeUnit.SECONDS)
        }

        val connectableObservable = observable.share().publish()
        connectableObservable.connect()

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER)
    }

    private fun purchaseTick(emitter: ObservableEmitter<List<Purchase>>): Runnable {
        return Runnable {
            val purchases = purchaseRepository.all()
            emitPurchases(emitter, purchases)
        }
    }

    private fun emitPurchases(emitter: ObservableEmitter<List<Purchase>>, purchases: List<Purchase>) {
        emitter.onNext(purchases)
    }

    fun getPublisher(): Flowable<List<Purchase>> {
        return publisher;
    }
}