package com.solci.kotlingraphql.resolvers.purchase

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver
import com.solci.kotlingraphql.entities.Purchase
import com.solci.kotlingraphql.publishers.PurchasePublisher
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PurchaseSubscriptionResolver(
    private val purchasePublisher: PurchasePublisher
): GraphQLSubscriptionResolver {
    companion object {
        private val log = LoggerFactory.getLogger("purchase")
    }

    fun latestPurchases(): Publisher<List<Purchase>> {
        log.info("Subscribed")
        return purchasePublisher.getPublisher()
    }
}