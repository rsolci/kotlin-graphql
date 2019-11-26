package com.solci.kotlingraphql.entities

import java.util.UUID

data class Payout(
    val id: UUID,
    val amount: Long,
    val merchantId: String,
    val status: PayoutStatus
)
