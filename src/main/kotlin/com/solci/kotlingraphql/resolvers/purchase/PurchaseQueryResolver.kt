package com.solci.kotlingraphql.resolvers.purchase

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.solci.kotlingraphql.entities.Purchase
import com.solci.kotlingraphql.repositories.PurchaseRepository
import org.springframework.stereotype.Component

@Component
class PurchaseQueryResolver(
    private val purchaseRepository: PurchaseRepository
): GraphQLQueryResolver {

    fun purchases(): List<Purchase> {
        return purchaseRepository.all()
    }
}