package com.study.template.shared.domain.exception

import org.springframework.util.ClassUtils
import java.net.URI

/**
 * FIXME: fix prefix to project name ( CustomException -> XXXException )
 */
abstract class CustomException(val status: Int, val reason: String?, override val cause: Throwable?) :
    RuntimeException(cause) {
    constructor(status: Int) : this(status, null, null) {}
    constructor(status: Int, cause: Throwable) : this(status, null, cause)
    constructor(status: Int, reason: String) : this(status, reason, null)

    fun type(): URI {
        return URI.create("exception:" + ClassUtils.getShortName(javaClass))
    }

}