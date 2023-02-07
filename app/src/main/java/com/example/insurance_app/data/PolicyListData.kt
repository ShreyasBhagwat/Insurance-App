package com.example.insurance_app.data

import com.example.insurance_app.data.entity.Policy

class PolicyListData {
    var list:List<Policy> = ArrayList<Policy>()
    get() = field

    // setter
    set(value) {
        field = value
    }

}