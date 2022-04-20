package rocks.shumyk.functional.scala.introduction

import munit.FunSuite

class ListsUtilTest extends munit.FunSuite :

  import ListsUtil.*

  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */
  test("sum of a few numbers (10pts)") {
    assert(sum(List(1, 2, 0)) == 3)
  }

  test("max of a few numbers (10pts)") {
    assert(max(List(3, 7, 2)) == 7)
  }

  import scala.concurrent.duration.*

  override val munitTimeout: FiniteDuration = 1.seconds