package com.solci.kotlingraphql.resolvers.purchase

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.solci.kotlingraphql.entities.Payout
import com.solci.kotlingraphql.entities.PayoutStatus
import com.solci.kotlingraphql.repositories.PayoutRepository
import org.springframework.stereotype.Component

@Component
class PayoutQueryResolver(
    private val payoutRepository: PayoutRepository
): GraphQLQueryResolver {

    fun payouts(size: Int = 10, offset: Int = 0, status: List<PayoutStatus>?): List<Payout> {
        return payoutRepository.filter(status ?: emptyList())
    }
}
