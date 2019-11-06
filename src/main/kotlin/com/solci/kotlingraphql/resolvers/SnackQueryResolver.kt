package com.solci.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.solci.kotlingraphql.entities.Snack
import com.solci.kotlingraphql.repositories.SnackRepository
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver(
    private val snackRepository: SnackRepository
) : GraphQLQueryResolver {

    fun snacks(): List<Snack> {
        return snackRepository.all()
    }
}