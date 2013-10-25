package vidageek.scaly

case class ViewData[T](data : T)

trait UnsafeRendering {
  def renderUnsafe = new ViewData(Seq[(String, Any)]())
  def renderUnsafe(data : (String, Any)*) = new ViewData(data.toSeq)
}

trait TypeSafeRendering {
  def render = new ViewData[Unit]()
  def render[A](data : A) = new ViewData[(A)]((data))
  def render[A, B](data : (A, B)) = new ViewData(data)
  def render[A, B, C](data : (A, B, C)) = new ViewData(data)
  def render[A, B, C, D](data : (A, B, C, D)) = new ViewData(data)
  def render[A, B, C, D, E](data : (A, B, C, D, E)) = new ViewData(data)
  def render[A, B, C, D, E, F](data : (A, B, C, D, E, F)) = new ViewData(data)
  def render[A, B, C, D, E, F, G](data : (A, B, C, D, E, F, G)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H](data : (A, B, C, D, E, F, G, H)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I](data : (A, B, C, D, E, F, G, H, I)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J](data : (A, B, C, D, E, F, G, H, I, J)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K](data : (A, B, C, D, E, F, G, H, I, J, K)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L](data : (A, B, C, D, E, F, G, H, I, J, K, L)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M](data : (A, B, C, D, E, F, G, H, I, J, K, L, M)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)) = new ViewData(data)
  def render[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V](data : (A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)) = new ViewData(data)
}