package com.solci.kotlingraphql.resolvers.purchase

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.solci.kotlingraphql.entities.Payout
import com.solci.kotlingraphql.entities.PayoutStatus
import com.solci.kotlingraphql.repositories.PayoutRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PayoutMutationResolver(
    private val payoutRepository: PayoutRepository
): GraphQLMutationResolver {

    fun createPayout(amount: Long, merchantId: String, status: PayoutStatus?): Payout {
        val payout = Payout(
            id = UUID.randomUUID(),
            status = status ?: PayoutStatus.SCHEDULED,
            amount = amount,
            merchantId = merchantId
        )
        payoutRepository.insert(payout.id, payout)
        return payout
    }
}
