package com.solci.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.solci.kotlingraphql.entities.Snack
import com.solci.kotlingraphql.repositories.SnackRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SnackMutationResolver(
    private val snackRepository: SnackRepository
) : GraphQLMutationResolver {

    fun newSnack(name: String, amount: Long): Snack {
        val snack = Snack(UUID.randomUUID(), name, amount)
        snackRepository.insert(snack)
        return snack
    }

    fun deleteSnack(id: String): Boolean {
        return true
    }

    fun updateSnack(id: String, amount: Float): Snack {
        TODO()
    }
}