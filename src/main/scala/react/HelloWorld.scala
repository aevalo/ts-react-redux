package react

import io.circe._
import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.dsl._
import java.io.File
import fs2.Task

object HelloWorld {
  def jarFile(file: String, request: Request) =
    StaticFile.fromResource("/public/" + file, Some(request)).map(Task.now).getOrElse(NotFound())
  def staticFile(file: String, request: Request) =
    StaticFile.fromFile(new File(s"extra-resources/public/$file"), Some(request)).map(Task.now).getOrElse(NotFound())
  def staticLibFile(file: String, request: Request) =
    StaticFile.fromFile(new File(s"node_modules/$file"), Some(request)).map(Task.now).getOrElse(NotFound())
  
  val service = HttpService {
    case request @ GET -> Root =>
      jarFile("index.html", request)
    case request @ GET -> Root / "js" / path if List(".js", ".js.map").exists(path.endsWith) =>
      jarFile(s"js/$path", request)
    case request @ GET -> Root / "css" / path if List(".css", ".css.map").exists(path.endsWith) =>
      jarFile(s"css/$path", request)
    case request @ GET -> Root / path if List(".html").exists(path.endsWith) =>
      jarFile(path, request)
  }
}
