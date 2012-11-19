package vidageek.scaly

class ViewData[T](data : T)

trait Rendering {
  def render[T](data : T) = new ViewData[(T)]((data))
  def render[T, E](data : (T, E)) = new ViewData(data)
}