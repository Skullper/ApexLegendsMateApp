package com.skullper.mozambique_api

import com.skullper.network_utils.ServiceBuilder

class MozambiqueApiHelper(serviceBuilder: ServiceBuilder) {

    private val api: MozambiqueApi = serviceBuilder.build("https://api.mozambiquehe.re/")
}
