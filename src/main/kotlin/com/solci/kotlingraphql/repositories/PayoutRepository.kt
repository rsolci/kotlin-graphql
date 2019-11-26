package com.solci.kotlingraphql.repositories

import com.solci.kotlingraphql.entities.Payout
import com.solci.kotlingraphql.entities.PayoutStatus
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PayoutRepository: BaseRepository<UUID, Payout>() {

    fun filter(payoutStatus: List<PayoutStatus>): List<Payout> {
        if (payoutStatus.isEmpty()) {
            return db.values.toList()
        }
        return db.values.filter { payoutStatus.contains(it.status) }.toList()
    }
}
