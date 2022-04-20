package rocks.shumyk.functional.scala.higher.order.functions.sets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets:
    val s1 : FunSet = singletonSet(1)
    val s2: FunSet = singletonSet(2)
    val s3 : FunSet = singletonSet(3)
    val evenNumbers: FunSet = set(x => x % 2 == 0)

  test("singleton set one contains one") {
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets:
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
  }

  test("set of even numbers") {
    new TestSets:
      assert(evenNumbers(2), "Even numbers - 2")
      assert(evenNumbers(4), "Even numbers - 4")
      assert(evenNumbers(6), "Even numbers - 6")
      assert(evenNumbers(16), "Even numbers - 16")
      assert(!evenNumbers(3), "Even numbers - 3")
      assert(!evenNumbers(5), "Even numbers - 5")
      assert(!evenNumbers(155), "Even numbers - 155")
      assert(!evenNumbers(77), "Even numbers - 77")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s: FunSet = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
      assert(!contains(s, 0), "Union 0")

      val evenAnd1: FunSet = union(s1, evenNumbers)
      assert(contains(evenAnd1, 1), "Union Even 1")
      assert(contains(evenAnd1, 2), "Union Even 2")
      assert(!contains(evenAnd1, 3), "Union Even 3")
      assert(contains(evenAnd1, 4), "Union Even 4")
      assert(!contains(evenAnd1, 5), "Union Even 5")
  }

  test("intersect contains only common elements") {
    new TestSets:
      val only2: FunSet = intersect(evenNumbers, s2)
      assert(!contains(only2, 1), "intersect only 2: 1")
      assert(contains(only2, 2), "intersect only 2: 2")
      assert(!contains(only2, 3), "intersect only 2: 3")
      assert(!contains(only2, 4), "intersect only 2: 4")

      val nothing: FunSet = intersect(evenNumbers, s1)
      assert(!contains(nothing, 1), "intersect nothing: 1")
      assert(!contains(nothing, 2), "intersect nothing: 2")
      assert(!contains(nothing, 3), "intersect nothing: 3")
      assert(!contains(nothing, 4), "intersect nothing: 4")
  }



  import scala.concurrent.duration.*
  override val munitTimeout: FiniteDuration = 10.seconds

