package com.example.vkclient.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge

fun <T> Flow<T>.mergeWith(another : Flow<T>) : Flow<T> = merge(this,another)