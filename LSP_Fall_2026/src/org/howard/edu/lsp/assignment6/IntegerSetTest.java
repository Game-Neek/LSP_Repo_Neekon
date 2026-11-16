package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Complete every TODO. Do not remove, rename, or disable test methods.
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {

    // ===== clear() =====

    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        
        // Act
        set.clear();
        
        // Assert
        assertTrue(set.isEmpty(), "Set should be empty after clear()");
        assertEquals(0, set.length(), "Length should be 0 after clear()");
    }

    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        set.clear();
        
        // Assert
        assertTrue(set.isEmpty(), "Set should remain empty");
        assertEquals(0, set.length(), "Length should remain 0");
    }

    // ===== length() =====

    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        set.add(1);
        set.add(1); // duplicate
        set.add(2);
        
        // Assert
        assertEquals(2, set.length(), "Length should only count unique elements");
    }

    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        int length = set.length();
        
        // Assert
        assertEquals(0, length, "New set should have length 0");
    }

    // ===== equals() =====

    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(1);
        
        // Act
        boolean isEqual = set1.equals(set2);
        
        // Assert
        assertTrue(isEqual, "Sets with same elements in different order should be equal");
    }

    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        
        // Act
        boolean isEqual = set1.equals(set2);
        
        // Assert
        assertFalse(isEqual, "Sets with different elements should not be equal");
    }

    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        
        // Act
        boolean isEqual = set1.equals(set2);
        
        // Assert
        assertTrue(isEqual, "Two empty sets should be equal");
    }

    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        
        // Act
        boolean selfEqual = set1.equals(set1);
        boolean differentSizeEqual = set1.equals(set2);
        
        // Assert
        assertTrue(selfEqual, "A set should equal itself");
        assertFalse(differentSizeEqual, "Sets of different sizes cannot be equal");
    }

    // ===== contains() =====

    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(5);
        
        // Act
        boolean hasPresent = set.contains(5);
        boolean hasAbsent = set.contains(10);
        
        // Assert
        assertTrue(hasPresent, "Should return true for an existing element");
        assertFalse(hasAbsent, "Should return false for an absent element");
    }

    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        boolean contains = set.contains(1);
        
        // Assert
        assertFalse(contains, "Empty set should not contain any elements");
    }

    // ===== largest() =====

    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(-10);
        set.add(0);
        set.add(5);
        
        // Act
        int largest = set.largest();
        
        // Assert
        assertEquals(5, largest, "largest() should return the maximum value in the set");
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            set.largest();
        }, "largest() on empty set should throw IllegalStateException");
    }

    // ===== smallest() =====

    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(-10);
        set.add(0);
        set.add(5);
        
        // Act
        int smallest = set.smallest();
        
        // Assert
        assertEquals(-10, smallest, "smallest() should return the minimum value in the set");
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            set.smallest();
        }, "smallest() on empty set should throw IllegalStateException");
    }

    // ===== add() =====

    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        set.add(5);
        set.add(5);
        
        // Assert
        assertEquals(1, set.length(), "Duplicates should be ignored during add()");
    }

    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        set.add(Integer.MIN_VALUE);
        set.add(Integer.MAX_VALUE);
        set.add(0);
        
        // Assert
        assertEquals(3, set.length(), "Length should be 3 after adding boundary values");
        assertTrue(set.contains(Integer.MIN_VALUE));
        assertTrue(set.contains(Integer.MAX_VALUE));
        assertTrue(set.contains(0));
    }

    // ===== remove() =====

    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        
        // Act
        set.remove(1);
        
        // Assert
        assertFalse(set.contains(1), "Element 1 should be removed");
        assertTrue(set.contains(2), "Element 2 should remain");
        assertEquals(1, set.length());
    }

    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        
        // Act
        set.remove(2);
        
        // Assert
        assertEquals(1, set.length(), "Length should remain unchanged");
        assertTrue(set.contains(1), "Existing element should remain");
    }

    // ===== union() =====

    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet result = set1.union(set2);
        
        // Assert
        assertEquals(3, result.length(), "Union should have exactly 3 distinct elements");
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        IntegerSet empty = new IntegerSet();
        
        // Act
        IntegerSet resultEmpty = set1.union(empty);
        IntegerSet resultSame = set1.union(set1);
        
        // Assert
        assertEquals(1, resultEmpty.length());
        assertTrue(resultEmpty.contains(1));
        
        assertEquals(1, resultSame.length());
        assertTrue(resultSame.contains(1));
    }

    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        
        // Act
        IntegerSet result = set1.union(set2);
        result.add(3); // mutate result
        
        // Assert
        assertEquals(1, set1.length(), "Input set1 should remain unchanged");
        assertFalse(set1.contains(3), "Mutation to result should not affect set1");
        
        assertEquals(1, set2.length(), "Input set2 should remain unchanged");
        assertFalse(set2.contains(3), "Mutation to result should not affect set2");
    }

    // ===== intersect() =====

    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet result = set1.intersect(set2);
        
        // Assert
        assertEquals(1, result.length(), "Intersection should have 1 element");
        assertTrue(result.contains(2), "Intersection should contain the shared element");
    }

    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        
        // Act
        IntegerSet disjointResult = set1.intersect(set2);
        IntegerSet sameResult = set1.intersect(set1);
        
        // Assert
        assertTrue(disjointResult.isEmpty(), "Intersection of disjoint sets should be empty");
        
        assertEquals(1, sameResult.length(), "Self-intersection should remain identical");
        assertTrue(sameResult.contains(1));
    }

    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet result = set1.intersect(set2); // result has [2]
        result.clear(); // mutate result
        
        // Assert
        assertEquals(2, set1.length(), "Input set1 should remain unchanged");
        assertTrue(set1.contains(2), "set1 should still contain 2");
        
        assertEquals(2, set2.length(), "Input set2 should remain unchanged");
        assertTrue(set2.contains(2), "set2 should still contain 2");
    }

    // ===== diff() =====

    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet diff1 = set1.diff(set2);
        IntegerSet diff2 = set2.diff(set1);
        
        // Assert
        assertEquals(1, diff1.length(), "set1.diff(set2) should have 1 element");
        assertTrue(diff1.contains(1), "Should contain element in set1 but not set2");
        
        assertEquals(1, diff2.length(), "set2.diff(set1) should have 1 element");
        assertTrue(diff2.contains(3), "Should contain element in set2 but not set1");
    }

    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        IntegerSet empty = new IntegerSet();
        
        // Act
        IntegerSet diffEmpty = set1.diff(empty);
        IntegerSet diffSame = set1.diff(set1);
        
        // Assert
        assertEquals(1, diffEmpty.length(), "Diff with empty set returns the original set's elements");
        assertTrue(diffEmpty.contains(1));
        
        assertTrue(diffSame.isEmpty(), "Diff with itself should return an empty set");
    }

    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        
        // Act
        IntegerSet result = set1.diff(set2); // result has [1]
        result.remove(1); // mutate result
        
        // Assert
        assertTrue(set1.contains(1), "Mutation to result should not alter set1");
        assertEquals(2, set1.length());
        
        assertEquals(1, set2.length(), "Mutation to result should not alter set2");
    }

    // ===== complement() =====

    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        // Arrange
        IntegerSet setA = new IntegerSet();
        setA.add(1); 
        setA.add(2);
        
        IntegerSet setB = new IntegerSet();
        setB.add(2); 
        setB.add(3);
        
        // Act
        IntegerSet result = setA.complement(setB);
        
        // Assert
        assertEquals(1, result.length(), "Complement should have exactly 1 element");
        assertTrue(result.contains(3), "Should return elements in B that are not in A");
    }

    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        // Arrange
        IntegerSet empty1 = new IntegerSet();
        IntegerSet empty2 = new IntegerSet();
        IntegerSet populated = new IntegerSet();
        populated.add(1);
        
        // Act
        IntegerSet resultBothEmpty = empty1.complement(empty2);
        IntegerSet resultEmptyReceiver = empty1.complement(populated);
        
        // Assert
        assertTrue(resultBothEmpty.isEmpty(), "Complement of empty with empty should be empty");
        
        assertEquals(1, resultEmptyReceiver.length());
        assertTrue(resultEmptyReceiver.contains(1), "Empty receiver returns all elements in argument set");
    }

    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        // Arrange
        IntegerSet setA = new IntegerSet();
        setA.add(1);
        
        IntegerSet setB = new IntegerSet();
        setB.add(1); 
        setB.add(2);
        
        // Act
        IntegerSet result = setA.complement(setB); // result has [2]
        result.remove(2); // mutate result
        
        // Assert
        assertTrue(setB.contains(2), "setB must not be mutated");
        assertEquals(2, setB.length());
        
        assertEquals(1, setA.length(), "setA must not be mutated");
    }

    // ===== isSubsetOf() =====

    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1); 
        set2.add(2);
        
        // Act
        boolean isProperSubset = set1.isSubsetOf(set2);
        boolean isNotSubset = set2.isSubsetOf(set1);
        
        // Assert
        assertTrue(isProperSubset, "set1 should be a subset of set2");
        assertFalse(isNotSubset, "set2 should not be a subset of set1");
    }

    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1); 
        set2.add(2);
        
        // Act
        boolean isSubset = set1.isSubsetOf(set2);
        
        // Assert
        assertFalse(isSubset, "Set containing elements not present in parameter cannot be a subset");
    }

    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        
        // Act
        boolean subset1 = set1.isSubsetOf(set2);
        boolean subset2 = set2.isSubsetOf(set1);
        
        // Assert
        assertTrue(subset1, "Equal sets are subsets of each other");
        assertTrue(subset2, "Equal sets are subsets of each other");
    }

    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        // Arrange
        IntegerSet empty = new IntegerSet();
        IntegerSet populated = new IntegerSet();
        populated.add(1);
        
        // Act
        boolean emptyIsSubset = empty.isSubsetOf(populated);
        boolean populatedIsSubset = populated.isSubsetOf(empty);
        
        // Assert
        assertTrue(emptyIsSubset, "Empty set is a subset of any set");
        assertFalse(populatedIsSubset, "Populated set cannot be a subset of an empty set");
    }

    // ===== isDisjoint() =====

    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        
        // Act
        boolean disjoint = set1.isDisjoint(set2);
        
        // Assert
        assertTrue(disjoint, "Sets with no overlapping elements should return true for disjoint");
    }

    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        boolean disjoint = set1.isDisjoint(set2);
        
        // Assert
        assertFalse(disjoint, "Sets with overlapping elements should return false for disjoint");
    }

    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        IntegerSet empty = new IntegerSet();
        
        // Act
        boolean disjointWithEmpty = set1.isDisjoint(empty);
        boolean disjointWithSelf = set1.isDisjoint(set1);
        
        // Assert
        assertTrue(disjointWithEmpty, "Any set is disjoint with the empty set");
        assertFalse(disjointWithSelf, "A non-empty set cannot be disjoint with itself");
    }

    // ===== symmetricDiff() =====

    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet result = set1.symmetricDiff(set2);
        
        // Assert
        assertEquals(2, result.length(), "Symmetric difference should have 2 elements");
        assertTrue(result.contains(1), "Should contain element unique to set1");
        assertTrue(result.contains(3), "Should contain element unique to set2");
    }

    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        // Act
        IntegerSet result = set1.symmetricDiff(set1);
        
        // Assert
        assertTrue(result.isEmpty(), "Symmetric diff of identical sets should be empty");
    }

    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        
        IntegerSet empty = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        
        // Act
        IntegerSet resultEmpty = set1.symmetricDiff(empty);
        IntegerSet resultDisjoint = set1.symmetricDiff(set2);
        
        // Assert
        assertEquals(1, resultEmpty.length(), "Symmetric diff with empty set returns original elements");
        assertTrue(resultEmpty.contains(1));
        
        assertEquals(2, resultDisjoint.length(), "Symmetric diff of disjoint sets returns all elements");
        assertTrue(resultDisjoint.contains(1));
        assertTrue(resultDisjoint.contains(2));
    }

    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1); 
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(2); 
        set2.add(3);
        
        // Act
        IntegerSet result = set1.symmetricDiff(set2); // result has [1, 3]
        result.clear(); // mutate result
        
        // Assert
        assertEquals(2, set1.length(), "set1 must remain unmutated");
        assertTrue(set1.contains(1));
        
        assertEquals(2, set2.length(), "set2 must remain unmutated");
        assertTrue(set2.contains(3));
    }

    // ===== isEmpty() =====

    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        boolean empty = set.isEmpty();
        
        // Assert
        assertTrue(empty, "Newly created set should be empty");
    }

    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        set.add(1);
        
        // Assert
        assertFalse(set.isEmpty(), "Set with elements should not be empty");
    }

    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        
        // Act
        set.clear();
        
        // Assert
        assertTrue(set.isEmpty(), "Set should be empty after clear()");
    }

    // ===== toString() =====

    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        
        // Act
        String str = set.toString();
        
        // Assert
        assertEquals("[1, 2, 3]", str, "Elements should be sorted in ascending order");
    }

    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        // Arrange
        IntegerSet set = new IntegerSet();
        
        // Act
        String str = set.toString();
        
        // Assert
        assertEquals("[]", str, "Empty set should format exactly as []");
    }

    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(2);
        set.add(1);
        set.add(2); // duplicate addition
        set.add(3);
        
        // Act
        String str = set.toString();
        
        // Assert
        assertEquals("[1, 2, 3]", str, "Duplicates should be omitted and exact comma-space format kept");
    }
}