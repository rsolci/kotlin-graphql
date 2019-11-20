package com.solci.kotlingraphql.resolvers.purchase

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.solci.kotlingraphql.entities.Purchase
import com.solci.kotlingraphql.repositories.PurchaseRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PurchaseMutationResolver(
    private val purchaseRepository: PurchaseRepository
): GraphQLMutationResolver {

    fun createPurchase(amount: Long, customerId: UUID, merchantUUID: UUID) : Purchase {
        val purchase = Purchase(
            id = UUID.randomUUID(),
            amount = amount,
            customerId = customerId,
            merchantId = merchantUUID
        )
        purchaseRepository.insert(purchase.id, purchase)
        return purchase
    }
}