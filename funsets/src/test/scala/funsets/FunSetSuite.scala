package funsets

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

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = (test: Int) => (test == 1 || test == 2)

  /**
   * This test is currently disabled (by using .ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */

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

      assert(!contains(s1, 2), "Singleton not contains")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("intersect contains all elements of intersection") {
    new TestSets:
      val i = intersect(s1, s2)
      assert(!contains(i, 1), "Intersect 1")
      assert(!contains(i, 2), "Intersect 2")
  }

  test("diff contains the difference of the sets") {
    new TestSets:
      val d = diff(s1, s4)
      assert(!contains(d, 1), "Diff 1")
  }

  test("filter filter out elements in the set") {
    new TestSets:
      assert(!contains(filter(s4, (test: Int) => test != 1), 1), "filter 1")
      assert(contains(filter(s4, (test: Int) => test != 1), 2), "filter not 2")
  }

  test("forall test a set contains all") {
    new TestSets:
      assert(forall((test: Int) => test >= 0 && test <= 10, (test: Int) => test >= 0 && test <= 100), "contains all")
      assert(!forall((test: Int) => test >= 0 && test <= 10, (test: Int) => test > 1), "contains 0 and 1 that does not satisify p")
  }

  test("exsits test set contains given elem") {
    new TestSets:
      assert(exists((test: Int) => test >= 0 && test <= 10, (test: Int) => test == 1), "exists 1")
      assert(!exists((test: Int) => test >= 0 && test <= 10, (test: Int) => test == 100), "exists not 100")
  }

  test("map set to another") {
    new TestSets:
      assert(contains(map(s4, (test) => test + 10), 11), "map 1 to 11")
      assert(contains(map(s4, (test) => test + 10), 12), "map 2 to 12")
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
