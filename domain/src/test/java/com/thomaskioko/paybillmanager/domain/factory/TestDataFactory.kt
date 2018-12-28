package com.thomaskioko.paybillmanager.domain.factory

import com.thomaskioko.paybillmanager.domain.model.Bill
import com.thomaskioko.paybillmanager.domain.model.BillCategory
import com.thomaskioko.paybillmanager.domain.model.Category
import com.thomaskioko.paybillmanager.domain.model.JengaToken
import java.util.*

object TestDataFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return Math.random().toInt()
    }

    fun randomLong(): Long {
        return Math.random().toLong()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeBill(): Bill {
        return Bill(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(),
                randomLong())
    }

    fun makeJengaToken(): JengaToken {
        return JengaToken("bearer", "1544517293525", "3599", "EJ4CSPoMBIYAj8KLUp45d5CUflvm9lz")
    }

    fun makeBillCategory(): BillCategory {
        return BillCategory(randomUuid(), randomUuid())
    }

    fun makeProjectList(count: Int): List<Bill> {
        val projects = mutableListOf<Bill>()
        repeat(count) {
            projects.add(makeBill())
        }
        return projects
    }

    fun makeCategory(): Category {
        return Category(randomUuid(), randomUuid(), randomInt())
    }

    fun makeCategoriesList(count: Int): List<Category> {
        val projects = mutableListOf<Category>()
        repeat(count) {
            projects.add(makeCategory())
        }
        return projects
    }
}