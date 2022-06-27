package com.skullper.mozambique_api

import com.skullper.mozambique_api.BuildConfig.API_KEY
import com.skullper.network_utils.api.ApiKeyProvider

class ApiKeyProviderImpl : ApiKeyProvider {

    override fun provide(): String = API_KEY
}
