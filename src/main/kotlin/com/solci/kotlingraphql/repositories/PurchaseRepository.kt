package com.solci.kotlingraphql.repositories

import com.solci.kotlingraphql.entities.Purchase
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PurchaseRepository: BaseRepository<UUID, Purchase>()