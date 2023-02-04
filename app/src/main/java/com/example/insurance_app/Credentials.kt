package com.example.insurance_app

class Credentials {
    private val credentialMapper = HashMap<String, String>()

    fun addCredentials(username: String, password: String) {
        credentialMapper.put(username,password)
    }

    fun checkUsername(username: String): Boolean {
        return credentialMapper.containsKey(username)
    }

    fun checkCredentials(username: String, password: String): Boolean {
       if(credentialMapper.containsKey(username))
           return password.equals(credentialMapper.get(username))
        else
            return false
    }

    fun loadCredentials(preferencesMap: Map<String, *>) {
        for (entries in preferencesMap) {
            if (entries.key != "RememberMeCheckbox" || entries.key != "LastSavedUsername" ||
                entries.key != "LastSavedPassword"
            ) {
                credentialMapper[entries.key] = entries.value.toString()
            }
        }
    }
}