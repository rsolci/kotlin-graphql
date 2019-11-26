package com.solci.kotlingraphql.repositories

import com.solci.kotlingraphql.entities.Payout
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PayoutRepository: BaseRepository<UUID, Payout>() {

}
