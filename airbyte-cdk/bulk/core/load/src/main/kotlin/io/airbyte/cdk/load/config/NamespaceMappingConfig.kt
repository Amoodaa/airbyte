package io.airbyte.cdk.load.config

import com.fasterxml.jackson.annotation.JsonCreator

enum class NamespaceDefinitionType(val value: String) {
    SOURCE("source"),
    DESTINATION("destination"),
    CUSTOM_FORMAT("customformat");

    companion object {
        @JvmStatic
        @JsonCreator
        fun fromValue(value: String): NamespaceDefinitionType =
            entries.find { it.value == value }
                ?: throw IllegalArgumentException("Unknown value: $value")
    }
}

data class NamespaceMappingConfig(
    val namespaceDefinitionType: NamespaceDefinitionType,
    val namespaceFormat: String? = null,
    val streamPrefix: String? = null
)
