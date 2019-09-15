package ie.otormaigh.blank.api

import ie.otormaigh.blank.data.User
import retrofit2.http.GET

interface ApiService {
  @GET("user/")
  suspend fun getUser(
  ): User
}