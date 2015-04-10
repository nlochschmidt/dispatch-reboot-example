import dispatch.{Http, url}
import dispatch.Defaults._

import scala.concurrent.Await
import scala.concurrent.duration._

object DispatchRebootExample extends App {

  val google = url("https://www.google.com/").setFollowRedirects(true)

  val request = Http(google GET)

  Await.ready(request, 2.seconds)

  for (response <- request) {
    if (response.getStatusCode == 200) {
      println("Google is up")
    } else {
      println(s"Strange Google responded ${response.getStatusCode}")
    }
  }
}
