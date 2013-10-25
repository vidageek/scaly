package vidageek.scaly.example

import vidageek.scaly.TypeSafeRendering
import vidageek.scaly.ViewData
import vidageek.scaly.UnsafeRendering

class TypeSafeRenderDeclarations extends TypeSafeRendering {

  val a : ViewData[Unit] = render
  val b : ViewData[(Int)] = render(1)
  val c : ViewData[(Int, Int)] = render(1, 2)
  val d : ViewData[(Int, Int, Int)] = render(1, 2, 3)
  val e : ViewData[(Int, Int, Int, Int)] = render(1, 2, 3, 4)
  val f : ViewData[(Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5)
  val g : ViewData[(Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6)
  val h : ViewData[(Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7)
  val i : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8)
  val j : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val k : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val l : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
  val m : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
  val n : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
  val o : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
  val p : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
  val q : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
  val r : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
  val s : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
  val t : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
  val u : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  val v : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
  val w : ViewData[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)] = render(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)

}

class UnsafeRenderDeclarations extends UnsafeRendering {
  val a : ViewData[Seq[(String, Any)]] = renderUnsafe
  val b : ViewData[Seq[(String, Any)]] = renderUnsafe()
  val c : ViewData[Seq[(String, Any)]] = renderUnsafe("" -> ())
  val d : ViewData[Seq[(String, Any)]] = renderUnsafe("" -> (), "" -> 1)
}