package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a mathematical set of integers using an internal ArrayList.
 * Duplicate values are not allowed, and elements are maintained in a structured manner.
 * Provides methods for standard and advanced set operations.
 * 
 * @author Howard University - Large Scale Programming - Assignment 5
 */
public class IntegerSet {
    List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor to initialize an empty IntegerSet.
     */
    public IntegerSet() {
        set = new ArrayList<Integer>();
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another IntegerSet for equality.
     * Two sets are equal if they contain the exact same elements regardless of order.
     * 
     * @param b the IntegerSet to compare against
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }
        for (Integer item : set) {
            if (!b.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a specified value is present in the set.
     * 
     * @param value the integer value to check
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * 
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        int max = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) > max) {
                max = set.get(i);
            }
        }
        return max;
    }

    /**
     * Returns the smallest value in the set.
     * 
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        int min = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) < min) {
                min = set.get(i);
            }
        }
        return min;
    }

    /**
     * Adds an item to the set if it is not already present (duplicates are ignored).
     * 
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it is present. Has no effect if absent.
     * 
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements from both this set and set b (Union).
     * Does not mutate either input set.
     * 
     * @param b the other IntegerSet
     * @return a brand new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer item : set) {
            result.add(item);
        }
        if (b != null) {
            for (Integer item : b.set) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements shared by both this set and set b (Intersection).
     * Does not mutate either input set.
     * 
     * @param b the other IntegerSet
     * @return a brand new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        if (b != null) {
            for (Integer item : set) {
                if (b.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in this set but not in set b (Difference).
     * Does not mutate either input set.
     * 
     * @param b the other IntegerSet
     * @return a brand new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer item : set) {
            if (b == null || !b.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in set b but not in this set (Complement / Reverse Difference).
     * Does not mutate either input set.
     * 
     * @param b the other IntegerSet
     * @return a brand new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        if (b != null) {
            for (Integer item : b.set) {
                if (!this.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * Returns true if every element of this set is present in set b.
     * An empty set is a subset of every set.
     * 
     * @param b the other IntegerSet
     * @return true if this set is a subset of b, false otherwise
     */
    public boolean isSubsetOf(IntegerSet b) {
        if (set.isEmpty()) {
            return true;
        }
        if (b == null) {
            return false;
        }
        for (Integer item : set) {
            if (!b.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if this set and set b share no elements in common.
     * Empty sets are disjoint from all sets.
     * 
     * @param b the other IntegerSet
     * @return true if the two sets are disjoint, false otherwise
     */
    public boolean isDisjoint(IntegerSet b) {
        if (b == null) {
            return true;
        }
        for (Integer item : set) {
            if (b.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a new IntegerSet containing elements that occur in exactly one of the two sets (Symmetric Difference).
     * Does not mutate either input set.
     * 
     * @param b the other IntegerSet
     * @return a brand new IntegerSet representing the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer item : set) {
            if (b == null || !b.contains(item)) {
                result.add(item);
            }
        }
        if (b != null) {
            for (Integer item : b.set) {
                if (!this.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * Checks if the set contains no elements.
     * 
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set with elements in ascending numerical order,
     * separated by a comma and one space, enclosed in square brackets.
     * 
     * @return formatted string representation of the set
     */
    @Override
    public String toString() {
        List<Integer> sortedList = new ArrayList<Integer>(set);
        Collections.sort(sortedList);
        return sortedList.toString().replace(", ",", ");
    }
}